package dev.layseiras.IdeationHub.config;

import dev.layseiras.IdeationHub.model.Repository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@Component
public interface GithubApi {

    @GetExchange(value = "/user/repos")
    List<Repository> getRepositories(@RequestHeader("Authorization") String token,
                                     @RequestHeader(value = "X-GitHub-Api-Version", defaultValue = "2022-11-28")
                                     String githubApiVersion,
                                     @RequestParam(value = "visibility", defaultValue = "public") String visibility);

    /*      curl -L \
            -H "Accept: application/vnd.github+json" \
            -H "Authorization: Bearer <YOUR-TOKEN>" \
            -H "X-GitHub-Api-Version: 2022-11-28" \
                https://api.github.com/user/repos   */
}
