package com.mongoexamples.utils.converters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;


public class UniqueMetadataSerializer extends JsonSerializer {
  @Override
  public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException, JsonProcessingException {
    System.out.println(value);
  }
}
