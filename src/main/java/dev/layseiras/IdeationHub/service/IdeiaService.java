package dev.layseiras.IdeationHub.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.layseiras.IdeationHub.config.GeminiApi;
import dev.layseiras.IdeationHub.config.GithubApi;
import dev.layseiras.IdeationHub.model.Ideia;
import dev.layseiras.IdeationHub.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IdeiaService {

    private final String API_URL;
    private final String API_KEY;

    private WebClient webClient;

    @Autowired
    public IdeiaService(GeminiApi gemini) {
        this.API_KEY = gemini.getApiKey();
        this.API_URL = gemini.getApiUrl() + API_KEY;

        this.webClient = WebClient.builder()
                .baseUrl(API_URL)
                .defaultHeader("content-type", "application/json")
                .build();
    }


    public String generateIdeia(Ideia ideia) {
        return """
                {
                  "contents": [
                        {
                        "parts": [
                        {
                            "text": "Sou desenvolvedor %s e quero em 6 linhas, de forma objetiva e simples apenas uma ideia de projeto de nivel %s com o tema %s, utilizando %s."
                        }
                      ]
                    }
                  ],
                      "generationConfig": {
                        "maxOutputTokens": 220
                      }
                }
                """.formatted(ideia.getCategoria(), ideia.getSenioridade(), ideia.getTema(), ideia.getTecnologia());
    }

    public Mono<String> ideiaGerada(Ideia ideia) {
        String requestBody = generateIdeia(ideia);

        return webClient.post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono((String.class))
                .map(response -> {
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode jsonNode = mapper.readTree(response);
                        JsonNode candidates = jsonNode.path("candidates");

                        if (candidates.isArray() && !candidates.isEmpty()) {
                            JsonNode content = candidates.get(0).path("content");
                            if (content.has("parts")) {
                                return content.get("parts").get(0).path("text").asText();
                            }
                        }
                        return "Não foi possivel gerar uma ideia de projeto";

                    } catch (Exception e) {
                        e.printStackTrace();
                        return "A api não funcionou " + e.getMessage();
                    }
                });
    }

    public Mono<String> gerarIdeiaComGithub(String username, GithubApi githubApi) {
        return Mono.fromCallable(() -> githubApi.getRepositories("public", username))
                .map(this::filtroDeRepositorios)
                .flatMap(this::ideiaGerada);
    }

    private Ideia filtroDeRepositorios(List<Repository> repos) {
        String linguagemMaisUsada = repos.stream()
                .filter(repo -> repo.language() != null)
                .collect(Collectors.groupingBy(Repository::language, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("não foi possivel escolher uma linguagem");

        String temaDoProjeto = repos.stream()
                .filter(repo -> repo.desc() != null && !repo.desc().isEmpty())
                .map(Repository::desc)
                .max(Comparator.comparingInt(String::length)).orElse("não foi possivel escolher um tema");

        System.out.println(linguagemMaisUsada);
        System.out.println(temaDoProjeto);
        return new Ideia(linguagemMaisUsada, temaDoProjeto);
    }
}
