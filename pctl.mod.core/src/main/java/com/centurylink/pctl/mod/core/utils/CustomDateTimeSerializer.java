package com.centurylink.pctl.mod.core.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;

/**
 * CustomDateTimeSerializer class
 * @author  Begin
 * Custom Jackson serializer for transforming a Joda DateTime object to JSON.
 */
public class CustomDateTimeSerializer extends JsonSerializer<DateTime> {

    public static final CustomDateTimeSerializer INSTANCE = new CustomDateTimeSerializer();

    /**
     * CustomDateTimeSerializer() constructor
     */
    private CustomDateTimeSerializer() {
    }

    /**
     * formatter
     */
    private static DateTimeFormatter formatter = ISODateTimeFormat.dateTime();

    /**
     * overridden serialize method
     * @param value
     * @param generator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(DateTime value, JsonGenerator generator,
                          SerializerProvider serializerProvider)
        throws IOException {

        generator.writeString(formatter.print(value));
        // This will work too
        //generator.writeString(value.toString());
    }

}
