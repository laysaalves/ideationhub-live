package dev.layseiras.IdeationHub.controller;

import dev.layseiras.IdeationHub.model.Ideia;
import dev.layseiras.IdeationHub.service.IdeiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ideationhub") // http://localhost:8080/ideationhub
public class IdeiaController {

    private final IdeiaService service;

    @Autowired
    public IdeiaController(IdeiaService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<String> ideiaGerada(@RequestBody Ideia ideia) {
        return service.ideiaGerada(ideia);
    }
}
