package com.joonhee.moneygate.configure;

import com.joonhee.moneygate.configure.uuidconverter.BytesToUUIDConverter;
import com.joonhee.moneygate.configure.uuidconverter.UUIDToBytesConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(new ArrayList<>(Arrays.asList(
            new UUIDToBytesConverter(),
            new BytesToUUIDConverter()
        )));
    }
}
