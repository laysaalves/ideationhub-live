# Ideation Hub

Uma plataforma para geração de ideias personalizadas para portfólios de desenvolvedores, integrando IA generativa com GitHub. O projeto foi desenvolvido em live coding na [twitch.tv/layseiras](https://twitch.tv/layseiras), com foco em praticar integração de IA com Java e engenharia de prompts.

---

## Features
- **Geração de Ideias**: Criação de sugestões de projetos personalizadas para desenvolvedores.
- **Integração com GitHub**: Análise de repositórios públicos para geração de ideias baseada no perfil do usuário.
- **Integração com IA Generativa**: Comunicação com a API Gemini AI para elaborar prompts inteligentes.
- **Controle Assíncrono**: Utilização de WebClient e Mono para requisições.
- **Organização Prática**: Estruturado em MVC para agilidade e foco conceitual.

---

## Destaques Técnicos
- Integração com APIs externas como Gemini AI, utilizando **WebClient** e controle assíncrono com **Mono**.
- Aplicação de **injeção de dependência** e uso de **Streams** para maior fluidez e legibilidade do código.
- Organização de versionamento com fluxo de branches no **Git**.
- Adoção de **boas práticas** de código e conformidade com convenções Java.
- Foco em conceitos de **engenharia de prompt**, **tokenização** e **integração de APIs externas**.
- **Sem banco de dados** — o principal objetivo foi a integração de IA com Spring no ecossistema Java.

---

## Tech Stack
- **Java 21**: Aproveitando os recursos mais modernos da linguagem.
- **Spring Boot**: Desenvolvimento ágil e robusto.
- **WebClient + Project Reactor**: Comunicação reativa e eficiente.
- **Git**: Controle de versão com fluxo de branches.
- **Gemini AI**: Integração com inteligência artificial generativa.
- **GitHub API**: Consulta de repositórios públicos para análise de perfis.

---

## Arquitetura
O projeto foi estruturado seguindo o padrão **MVC (Model-View-Controller)**, priorizando:

- **Separação de responsabilidades**: Facilita manutenção e evolução do sistema.
- **Simplicidade prática**: Organização pensada para maximizar o aprendizado em conceitos de IA e integrações externas.

### Estrutura de Pastas
```plaintext
src
├── main
│   ├── java
│   │   └── com.ideationhub
│   │       ├── controller    # Endpoints REST
│   │       ├── service       # Regras de negócio
│   │       ├── model         # Modelos de dados (DTOs)
│   │       └── config        # Comunicação com APIs externas (Gemini, GitHub)
│   └── resources
│       └── application.yml   # Configurações da aplicação (Secret Keys)
└── test
    └── java                  # Testes unitários e de integração
   ```
---

## Endpoints da API

### Ideias
- **POST /ideationhub**: Gera uma ideia personalizada a partir dos dados fornecidos.

### GitHub e Ideias com Perfil
- **GET /repos/{username}**: Retorna a lista de repositórios públicos de um usuário do GitHub.
- **GET /repos/ideia/{username}**: Gera uma ideia personalizada baseada nos repositórios do GitHub de um usuário.

---

## Contribuindo
Você pode contribuir seguindo os passos:
1. Fork do repositório.
2. Crie uma brach para a feature: `git checkout -b feature-name`
3. Commit suas alterações: `git commit -m 'Add new feature'`
4. Dê push para a branch: `git push origin feature-name`
5. Envie um pull request.

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Contact
For questions or feedback, please contact us at [your-email@example.com](mailto:contato@java10x.dev).