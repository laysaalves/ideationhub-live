package dev.layseiras.IdeationHub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Repository(String id,
                         @JsonProperty("login") String user,
                         @JsonProperty("name") String repo,
                         @JsonProperty("description") String desc,
                         @JsonProperty("topics") String topics,
                         @JsonProperty("private") boolean isPrivate,
                         @JsonProperty("language") String language) {
}
