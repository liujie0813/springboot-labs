package com.timberliu.springboot.springmvc.message.converter.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * created by Timber in 2020/7/9
 */
public class MyJsonSerializer extends JsonSerializer<Double> {

    @Override
    public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            jsonGenerator.writeString(
                    BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).toString());
        }
    }
}
