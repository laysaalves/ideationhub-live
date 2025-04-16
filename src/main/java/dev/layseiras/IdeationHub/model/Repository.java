package dev.layseiras.IdeationHub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Repository(String id,
                         @JsonProperty("login") String user,
                         @JsonProperty("name") String repo,
                         @JsonProperty("description") String desc,
                         @JsonProperty("topics") List<String> topics,
                         @JsonProperty("private") boolean isPrivate,
                         @JsonProperty("language") String language) {
}
