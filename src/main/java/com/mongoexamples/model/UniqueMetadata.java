package com.mongoexamples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class UniqueMetadata {

  @Indexed
  private String key;
  @Indexed
  private Object value;

  /**
   * Constructor.
   *
   * @param uniqueMetadata metadata.
   */
  public UniqueMetadata(Map<String, Object> uniqueMetadata) {
    if (uniqueMetadata.size() == 1) {
      Map.Entry<String, Object> entry = uniqueMetadata.entrySet().iterator().next();
      this.key = entry.getKey();
      this.value = entry.getValue();
    } else {
      log.error("Not valid metadata.");
      throw new IllegalArgumentException("Not valid metadata.");
    }
  }
}
