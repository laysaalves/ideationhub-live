package dev.layseiras.IdeationHub.model;

public class Ideia {
    private String categoria; // backend - frontend

    private String tecnologia; // java, spring - react, tailwind

    private String tema; // financas, universitario, educativo/educacional

    private String senioridade; // pleno, senior, junior, estagiario, trainee

    public Ideia() {
    }

    public Ideia(String categoria, String tecnologia, String tema, String senioridade) {
        this.categoria = categoria;
        this.tecnologia = tecnologia;
        this.tema = tema;
        this.senioridade = senioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getSenioridade() {
        return senioridade;
    }

    public void setSenioridade(String senioridade) {
        this.senioridade = senioridade;
    }
}
