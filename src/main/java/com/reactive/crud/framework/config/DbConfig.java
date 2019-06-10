package com.reactive.crud.framework.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = DbConfig.DbConfigBuilder.class)
public class DbConfig {

    private String databaseUrl;

    private String dbUserName;

    private String dbPassword;
}
