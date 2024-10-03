package com.joonhee.moneygate.mentor.application.repository;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.repository.MentorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@Slf4j
@Repository
public class MentorRepositoryImpl implements MentorRepository {
    private final DataSource dataSource;

    public MentorRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Mentor save(Mentor mentor) {
        String sql = "insert into mentor(email, nick_name, profile_image, created_at) values (?, ?, ?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            // Use Statement.RETURN_GENERATED_KEYS to retrieve the generated ID
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, mentor.getEmail());
            pstmt.setString(2, mentor.getNickName());
            pstmt.setString(3, mentor.getProfileImage());
            pstmt.setTimestamp(4, Timestamp.from(mentor.getCreatedAt().toInstant()));

            int affectedRows = pstmt.executeUpdate();  // Execute the insert
            if (affectedRows > 0) {
                rs = pstmt.getGeneratedKeys();  // Retrieve the generated keys (ID)
                if (rs.next()) {
                    mentor.setId(rs.getLong(1));  // Set the generated ID
                }
            }
            return mentor;  // Return the mentor object with the ID set
        } catch (SQLException e) {
            log.error("db error", e);
            throw new RuntimeException(e);
        } finally {
            close(con, pstmt, rs);  // Ensure all resources are closed
        }
    }

    @Override
    public Mentor findById(Long id) {
        String sql = "select * from mentor where mentor_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                Mentor member = new Mentor(
                    rs.getLong("mentor_id"),
                    rs.getString("email"),
                    rs.getString("nick_name"),
                    rs.getString("profile_image"),
                    ZonedDateTime.ofInstant(rs.getTimestamp("created_at").toInstant(), ZoneId.systemDefault()),
                    getTimeStamp(rs.getTimestamp("updated_at"))
                );
                return member;
            } else {
                throw new NoSuchElementException("mentor not found mentor_id=" + id);
            }

        } catch (SQLException e) {
            log.error("db error", e);
            throw new RuntimeException(e);
        } finally {
            close(con, pstmt, rs);
        }
    }

    private ZonedDateTime getTimeStamp(Timestamp timeStamp) {
        if (timeStamp == null) {
            return null;
        }
        return ZonedDateTime.ofInstant(timeStamp.toInstant(), ZoneId.systemDefault());
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);
    }


    private Connection getConnection() throws SQLException {
        Connection con = DataSourceUtils.getConnection(dataSource);
        return con;
    }
}
