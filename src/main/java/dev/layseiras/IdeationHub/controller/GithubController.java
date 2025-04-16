package dev.layseiras.IdeationHub.controller;

import dev.layseiras.IdeationHub.config.GithubApi;
import dev.layseiras.IdeationHub.model.Repository;
import dev.layseiras.IdeationHub.service.IdeiaService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/repos")
public class GithubController {

    private final GithubApi githubApi;
    private final IdeiaService service;

    public GithubController(GithubApi githubApi, IdeiaService service) {
        this.githubApi = githubApi;
        this.service = service;
    }

    @GetMapping("/{username}") // http://localhost:8080/repos/{username}
    public List<Repository> getRepos(@PathVariable String username) {
        return githubApi.getRepositories("public", username);
    }

    @GetMapping("/ideia/{username}") // http://localhost:8080/repos/ideia/laysaalves
    public Mono<String> gerarIdeiaComGithub(@PathVariable String username) {

        return service.gerarIdeiaComGithub(username, githubApi);
    }
}
