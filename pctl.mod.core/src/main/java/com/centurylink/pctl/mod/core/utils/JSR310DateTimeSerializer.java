package com.centurylink.pctl.mod.core.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * JSR310DateTimeSerializer class
 * @author Begin
 */
public final class JSR310DateTimeSerializer extends JsonSerializer<TemporalAccessor> {

    public static final JSR310DateTimeSerializer INSTANCE = new JSR310DateTimeSerializer();
    private static final DateTimeFormatter ISOFormatter =
        DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of("Z"));

    private JSR310DateTimeSerializer() {
    }

    /**
     * serialize() method overrided
     * @param value
     * @param generator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(TemporalAccessor value, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
        generator.writeString(ISOFormatter.format(value));
    }
}
