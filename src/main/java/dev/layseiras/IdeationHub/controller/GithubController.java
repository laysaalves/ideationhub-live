package dev.layseiras.IdeationHub.controller;

import dev.layseiras.IdeationHub.config.GithubApi;
import dev.layseiras.IdeationHub.model.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repos")
public class GithubController {

    private final GithubApi githubApi;

    public GithubController(GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @GetMapping// http://localhost:8080/repos
    public List<Repository> getRepos(@RequestHeader(value = "token") String githubToken) {
        return githubApi.getRepositories(
                "Bearer " + githubToken,
                null,
                "public"
                );
    }
}
