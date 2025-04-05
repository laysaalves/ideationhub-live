package dev.layseiras.IdeationHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class GithubWebClientConfig {

    @Bean
    public HttpServiceProxyFactory getHttpServiceProxyFactory() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.github.com")
                .build();

        return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
    }

    @Bean
    public GithubApi githubApi(HttpServiceProxyFactory proxyFactory) {
        return proxyFactory.createClient(GithubApi.class);
    }
}
