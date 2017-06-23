package com.mongoexamples.utils;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class PersistenceConstants {
  // tables
  public static final String ENDPOINT_METADATA_TABLE_NAME = "endpoint_metadata";
  public static final String ENDPOINT_APPLICATION_VERSION_REGISTRATION_TABLE_NAME = "endpoint_app_version_registration";

  // columns
  public static final String ENDPOINT_CREATED_DATE = "endpoint_created_date";
  public static final String CREATED_DATE = "created_date";
  public static final String UPDATED_DATE = "updated_date";
  public static final String LAST_REGISTRATION_DATE = "last_registration_date";
  public static final String REGISTRATION_DATE = "registration_date";
  public static final String APPLICATION_VERSION_NAME = "application_version_name";

  public static final String METADATA = "metadata";
}
