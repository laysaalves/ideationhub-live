package dev.layseiras.IdeationHub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class GithubWebClientConfig {

    @Value("${github.token}")
    private String githubToken;

    @Bean
    public HttpServiceProxyFactory getHttpServiceProxyFactory() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.github.com")
                .defaultHeader("Authorization", "Bearer " + githubToken)
                .defaultHeader("X-GitHub-Api-Version", "2022-11-28")
                .defaultHeader("Accept", "application/vnd.github+json")
                .build();

        return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
    }

    @Bean
    public GithubApi githubApi(HttpServiceProxyFactory proxyFactory) {
        return proxyFactory.createClient(GithubApi.class);
    }
}
