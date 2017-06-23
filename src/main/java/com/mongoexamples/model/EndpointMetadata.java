package com.mongoexamples.model;

import static com.mongoexamples.utils.PersistenceConstants.APPLICATION_VERSION_NAME;
import static com.mongoexamples.utils.PersistenceConstants.CREATED_DATE;
import static com.mongoexamples.utils.PersistenceConstants.ENDPOINT_METADATA_TABLE_NAME;
import static com.mongoexamples.utils.PersistenceConstants.METADATA;
import static com.mongoexamples.utils.PersistenceConstants.UPDATED_DATE;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.mongoexamples.utils.converters.UniqueMetadataDeserializer;
import com.mongoexamples.utils.converters.UniqueMetadataSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(of = {"endpointId", "applicationVersionName", "createdDate", "updatedDate"})
@NoArgsConstructor
@AllArgsConstructor
@CompoundIndex(name = "metadata_1_application_version_name_1", def = "{'metadata' : 1, 'application_version_name' : 1}")
@Document(collection = ENDPOINT_METADATA_TABLE_NAME)
public class EndpointMetadata {

  @Id
  private String endpointId;

  @Field(APPLICATION_VERSION_NAME)
  private String applicationVersionName;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @Field(CREATED_DATE)
  private LocalDateTime createdDate;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @Field(UPDATED_DATE)
  private LocalDateTime updatedDate;

  @JsonDeserialize(using = UniqueMetadataDeserializer.class)
  @JsonSerialize(using = UniqueMetadataSerializer.class)
  @Field(METADATA)
  private List<UniqueMetadata> metadata;

  /**
   * Constructor without <code>appVersionName</code>.
   */
  public EndpointMetadata(String endpointId, LocalDateTime createdDate, LocalDateTime updatedDate, List<UniqueMetadata> metadata) {
    this.endpointId = endpointId;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.metadata = metadata;
  }

}
