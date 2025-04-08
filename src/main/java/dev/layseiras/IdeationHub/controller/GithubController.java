package dev.layseiras.IdeationHub.controller;

import dev.layseiras.IdeationHub.config.GithubApi;
import dev.layseiras.IdeationHub.model.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repos")
public class GithubController {

    private final GithubApi githubApi;

    public GithubController(GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @GetMapping("/{username}") // http://localhost:8080/repos/{username}
    public List<Repository> getRepos(@PathVariable String username) {
        return githubApi.getRepositories("public", username);
    }
}
