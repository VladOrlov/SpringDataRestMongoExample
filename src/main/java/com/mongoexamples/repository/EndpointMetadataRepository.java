package com.mongoexamples.repository;

import com.mongoexamples.model.EndpointMetadata;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface EndpointMetadataRepository extends MongoRepository<EndpointMetadata, String> {

  @RestResource
  List<EndpointMetadata> findByApplicationVersionName(@Param("name") String applicationName);

}
