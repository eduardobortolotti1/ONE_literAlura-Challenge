package com.alura.literalura.literalura;

import com.alura.literalura.literalura.models.Livro;
import com.alura.literalura.literalura.principal.Principal;
import com.alura.literalura.literalura.repository.AutorRepository;
import com.alura.literalura.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	private LivroRepository livroRepository;
	private AutorRepository	autorRepository;

	// Injetando ambos os repositórios no construtor
	@Autowired
	public LiteraluraApplication(LivroRepository livroRepository, AutorRepository autorRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.main(livroRepository, autorRepository);
	}
}
