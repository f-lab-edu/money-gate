package com.joonhee.moneygate.configure;


import com.joonhee.moneygate.jdbcconverter.account.roles.JsonToRolesReadingConverter;
import com.joonhee.moneygate.jdbcconverter.account.roles.RolesToJsonWritingConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class JdbcConfig extends AbstractJdbcConfiguration {
    private final JsonToRolesReadingConverter jsonToRolesReadingConverter;
    private final RolesToJsonWritingConverter rolesToJsonWritingConverter;

    public JdbcConfig(
        JsonToRolesReadingConverter jsonToRolesReadingConverter,
        RolesToJsonWritingConverter rolesToJsonWritingConverter) {
        this.jsonToRolesReadingConverter = jsonToRolesReadingConverter;
        this.rolesToJsonWritingConverter = rolesToJsonWritingConverter;
    }
    @Override
    protected List<?> userConverters() {
        return Arrays.asList(
            jsonToRolesReadingConverter,
            rolesToJsonWritingConverter
        );
    }
}