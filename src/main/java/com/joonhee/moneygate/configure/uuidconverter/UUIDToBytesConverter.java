package com.joonhee.moneygate.configure.uuidconverter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.nio.ByteBuffer;
import java.util.UUID;

@WritingConverter
public class UUIDToBytesConverter implements Converter<UUID, byte[]> {
    @Override
    public byte[] convert(UUID source) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(source.getMostSignificantBits());
        byteBuffer.putLong(source.getLeastSignificantBits());
        return byteBuffer.array();
    }
}