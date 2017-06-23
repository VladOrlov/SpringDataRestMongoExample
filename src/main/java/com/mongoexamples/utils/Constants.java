package com.mongoexamples.utils;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class Constants {

  @NoArgsConstructor(access = PRIVATE)
  public static class Common {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String ENDPOINT_NOT_FOUND_MSG = "Endpoint with ID [%s] is not found";
  }

  @NoArgsConstructor(access = PRIVATE)
  public static class Web {
    public static final String BASE_URI = "/api";
    public static final String VERSION = "v1";
    public static final String BASE_VERSION_URI = BASE_URI + "/" + VERSION;

    public static final String CORRELATION_ID_HEADER = "Correlation-ID";

    public static final String ENDPOINTS = "/endpoints";
    public static final String ENDPOINT_REGISTRATION_URI = BASE_VERSION_URI + ENDPOINTS;

    public static final String ENDPOINTS_ID_PART_URI = "/{endpointId}";
    public static final String ENDPOINTS_METADATA = "/metadata";
    public static final String ENDPOINTS_METADATA_KEY_PART_URI = "/{metadataKey}";
    public static final String ENDPOINTS_METADATA_KEYS = "/metadata-keys";

    public static final String ENDPOINTS_METADATA_URI = ENDPOINT_REGISTRATION_URI + ENDPOINTS_ID_PART_URI + ENDPOINTS_METADATA;
    public static final String ENDPOINTS_METADATA_KEY_URI = ENDPOINTS_METADATA_URI + ENDPOINTS_METADATA_KEY_PART_URI;
    public static final String ENDPOINTS_METADATA_KEYS_URI = ENDPOINT_REGISTRATION_URI + ENDPOINTS_ID_PART_URI + ENDPOINTS_METADATA_KEYS;
    public static final String ENDPOINTS_METADATA_MAC_AREAID_KEYS = ENDPOINTS_METADATA_URI + "?include=macAddress&include=areaID";
    // Params
    public static final String INCLUDE_PARAM = "include";
    // Headers
    public static final String LAST_UPDATE_DATE = "Last-Update-Date";
    // Media type
    public static final String APPLICATION_JSON_PATCH = "application/json-patch+json";
  }
}
