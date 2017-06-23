package com.mongoexamples.utils.converters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongoexamples.model.UniqueMetadata;

import lombok.Getter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


public class UniqueMetadataDeserializer extends JsonDeserializer<List<UniqueMetadata>> {

  private static ObjectNode objectNode;

  @Override
  public List<UniqueMetadata> deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException, JsonProcessingException {

    objectNode = jsonParser.readValueAsTree();
    MetadataKeysConsumer metadataKeysConsumer = new MetadataKeysConsumer();
    objectNode.fieldNames().forEachRemaining(metadataKeysConsumer);

    new metadataKeysConsumer.getMetadataKeys()
    System.out.println(objectNode);
    return null;
  }

  @Getter
  private static class MetadataKeysConsumer implements Consumer<String> {

    Map<String, Object> metadataKeys = new HashMap<>();

    @Override
    public void accept(String keyName) {
      JsonNode jsonNode = objectNode.get(keyName);
      JsonNodeType nodeType = jsonNode.getNodeType();
      if (nodeType == JsonNodeType.NUMBER) {
        metadataKeys.put(keyName, jsonNode.numberValue());
      } else if (nodeType == JsonNodeType.STRING) {
        metadataKeys.put(keyName, jsonNode.textValue());
      }
    }

  }

}



