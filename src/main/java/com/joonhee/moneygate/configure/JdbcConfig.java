package com.joonhee.moneygate.configure;


import com.joonhee.moneygate.jdbcconverter.account.JsonToRolesReadingConverter;
import com.joonhee.moneygate.jdbcconverter.account.RolesToJsonWritingConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class JdbcConfig extends AbstractJdbcConfiguration {
    @Override
    protected List<?> userConverters() {
        return Arrays.asList(
            new JsonToRolesReadingConverter(),
            new RolesToJsonWritingConverter()
        );
    }
}