package com.joonhee.moneygate.configure;


import com.joonhee.moneygate.jdbcconverter.account.JsonToRolesReadingConverter;
import com.joonhee.moneygate.jdbcconverter.account.RolesToJsonWritingConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;

import java.util.Arrays;

@Configuration
public class JdbcConfig {

    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(
            Arrays.asList(
                new JsonToRolesReadingConverter(),
                new RolesToJsonWritingConverter()
            )
        );
    }
}