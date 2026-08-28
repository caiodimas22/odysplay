# OdysPlay - Mapeamento de Entidades e Banco de Dados (JPA)

Este é um projeto acadêmico desenvolvido em **Java** com **Spring Boot** e **MySQL** para a disciplina de Desenvolvimento de Sistemas de Informação. 

O projeto **OdysPlay** é uma plataforma focada no ecossistema de jogos digitais, projetada para conectar gamers, desenvolvedores e estúdios/empresas, permitindo interação social, fóruns, postagem de notícias e organização de Game Jams.

---

## 🛠️ Tecnologias Utilizadas

*   **Java 21**
*   **Spring Boot 3.3.2**
    *   Spring Data JPA (Persistência)
    *   Spring Boot Starter Validation (Validação de dados)
    *   Spring Web (Construção de APIs)
*   **MySQL** (Banco de dados relacional)
*   **Lombok** (Otimização de código boilerplate)
*   **Maven** (Gerenciador de dependências)

---

## 📁 Estrutura do Projeto

O mapeamento objeto-relacional foi estruturado no pacote `com.aluno.projetoPro01.models`:

```text
src/main/java/com/aluno/projetoPro01/
├── ProjetoPro01Application.java   # Classe principal (Inicialização)
├── models/                         # Camada de Entidades (JPA)
│   ├── User.java                   # Usuários da plataforma
│   ├── Dev.java                    # Perfis de desenvolvedores
│   ├── Empresa.java                # Perfis de estúdios/empresas
│   ├── Noticia.java                # Artigos e notícias publicadas
│   ├── Game.java                   # Informações de Game Jams
│   ├── Comunidade.java             # Fóruns e grupos sociais
│   ├── Autor.java                  # Entidade de Autores (Atividade 2)
│   ├── Editora.java                # Entidade de Editoras (Atividade 2)
│   ├── Categoria.java              # Entidade de Categorias (Atividade 2)
│   └── Livro.java                  # Entidade de Livros com FKs (Atividade 2)
└── repositories/                   # Camada de Persistência (Spring Data)
    ├── UserRepository.java
    ├── DevRepository.java
    ├── EmpresaRepository.java
    ├── NoticiaRepository.java
    ├── GameRepository.java
    ├── ComunidadeRepository.java
    ├── AutorRepository.java
    ├── EditoraRepository.java
    ├── CategoriaRepository.java
    └── LivroRepository.java
```

---

## 🗄️ Modelagem das Entidades e Atributos

Cada entidade foi anotada com `@Entity` e `@Table` para ser mapeada como tabela física no MySQL, contendo no mínimo 6 atributos e regras de validação aplicadas (comprimento, obrigatoriedade e valores únicos):

### 1. User (`users`)
*   `id`: Identificador único (Auto-incremento)
*   `nome`: Nome completo do usuário
*   `username`: Nickname de identificação pública (Único)
*   `email`: E-mail de cadastro (Único)
*   `password`: Senha segura (Somente gravação)
*   `biografia`: Apresentação curta do perfil
*   `dataCriacao`: Registro de data e hora do cadastro

### 2. Dev (`devs`)
*   `id`: Identificador único
*   `especialidade`: Área de atuação do dev (ex: Unity Programmer)
*   `dataNascimento`: Data de nascimento (`LocalDate`)
*   `status`: Disponibilidade (ex: Open to Work)
*   `githubUrl`: Link do perfil do GitHub
*   `biografia`: Resumo de habilidades e portfólio

### 3. Empresa (`empresas`)
*   `id`: Identificador único
*   `nomeEmpresa`: Nome oficial do estúdio de games (Único)
*   `descricao`: Resumo das atividades e histórico
*   `cnpj`: Cadastro de pessoa jurídica (Único)
*   `websiteUrl`: Link oficial da empresa
*   `setor`: Ramo de atuação (ex: Publisher, Indie Studio)

### 4. Noticia (`noticias`)
*   `id`: Identificador único
*   `titulo`: Título chamativo da matéria
*   `autor`: Identificação do criador do conteúdo
*   `conteudo`: Corpo completo da notícia (`TEXT` no banco)
*   `dataPublicacao`: Data e hora da publicação
*   `categoria`: Gênero do artigo (ex: Novidades, Atualizações)

### 5. Game (`games` - Game Jam)
*   `id`: Identificador único
*   `nomeGameJam`: Nome oficial do evento de criação de jogos
*   `tema`: Conceito delimitado para a Jam
*   `regras`: Regulamentos e limitações do evento (`TEXT` no banco)
*   `descricaoGameJam`: Descrição detalhada da Jam (`TEXT` no banco)
*   `premios`: Recompensas ofertadas aos vencedores
*   `dataInicio` / `dataFim`: Cronograma temporal do evento

### 6. Comunidade (`comunidades`)
*   `id`: Identificador único
*   `nome`: Nome da comunidade (Único)
*   `regras`: Normas de convivência (`TEXT` no banco)
*   `descricao`: Propósito do grupo
*   `dataCriacao`: Data de fundação da comunidade
*   `topicoPrincipal`: Assunto em foco (ex: Pixel Art)

---

## 📚 Entidades Adicionais (Atividade Livraria)

Mapeamento com chaves estrangeiras utilizando `@ManyToOne` e `@JoinColumn`:
*   **Autor**: Representa o autor dos livros.
*   **Editora**: Representa a editora publicadora.
*   **Categoria**: Categoria temática literária.
*   **Livro**: Agrega as informações com chaves estrangeiras (`autor_id`, `editora_id`, `categoria_id`) no banco de dados.

---

## 🚀 Como Executar o Projeto

1.  **Pré-requisitos**:
    *   Java JDK 21 instalado.
    *   MySQL instalado e rodando.
2.  **Configuração de Acesso ao Banco**:
    *   Abra o arquivo `src/main/resources/application.properties` e atualize as propriedades `spring.datasource.username` e `spring.datasource.password` com suas credenciais do MySQL.
3.  **Execução**:
    *   No VS Code, abra a classe `ProjetoPro01Application.java` e execute-a.
    *   O Spring Boot inicializará o Hibernate que criará a base de dados `odysplay` e gerará automaticamente todas as tabelas descritas acima.
    *   Durante a inicialização, a classe principal executará um `CommandLineRunner` inserindo registros de teste das entidades da biblioteca no banco para verificação.
