package com.aluno.projetoPro01;

import com.aluno.projetoPro01.models.Autor;
import com.aluno.projetoPro01.models.Categoria;
import com.aluno.projetoPro01.models.Editora;
import com.aluno.projetoPro01.models.Livro;
import com.aluno.projetoPro01.repositories.AutorRepository;
import com.aluno.projetoPro01.repositories.CategoriaRepository;
import com.aluno.projetoPro01.repositories.EditoraRepository;
import com.aluno.projetoPro01.repositories.LivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetoPro01Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPro01Application.class, args);
	}

	@Bean
	public CommandLineRunner testDatabase(
			AutorRepository autorRepository,
			EditoraRepository editoraRepository,
			CategoriaRepository categoriaRepository,
			LivroRepository livroRepository) {
		return args -> {
			System.out.println("========== INICIANDO GRAVAÇÃO DE DADOS DE TESTE ==========");

			// 1. Criar e salvar Autor
			Autor autor = new Autor(null, "J.R.R. Tolkien", "tolkien@email.com");
			autor = autorRepository.save(autor);
			System.out.println("Autor salvo com sucesso! ID: " + autor.getId());

			// 2. Criar e salvar Editora
			Editora editora = new Editora(null, "HarperCollins", "Rua das Letras, 123, Rio de Janeiro - RJ");
			editora = editoraRepository.save(editora);
			System.out.println("Editora salva com sucesso! ID: " + editora.getId());

			// 3. Criar e salvar Categoria
			Categoria categoria = new Categoria(null, "Fantasia", "Livros de fantasia e aventura medieval");
			categoria = categoriaRepository.save(categoria);
			System.out.println("Categoria salva com sucesso! ID: " + categoria.getId());

			// 4. Criar e salvar Livro (com relacionamentos)
			Livro livro = new Livro(null, "O Senhor dos Anéis", "9788595086357", autor, editora, categoria);
			livro = livroRepository.save(livro);
			System.out.println("Livro salvo com sucesso! ID: " + livro.getId() + " - Título: " + livro.getTitulo());

			System.out.println("========== GRAVAÇÃO DE TESTE CONCLUÍDA COM SUCESSO ==========");
		};
	}
}
