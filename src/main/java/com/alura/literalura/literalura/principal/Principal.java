package com.alura.literalura.literalura.principal;

import com.alura.literalura.literalura.models.Autor;
import com.alura.literalura.literalura.models.Livro;
import com.alura.literalura.literalura.models.ResponseWrapper;
import com.alura.literalura.literalura.repository.AutorRepository;
import com.alura.literalura.literalura.repository.LivroRepository;
import com.alura.literalura.literalura.service.ConsumoAPI;
import com.alura.literalura.literalura.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private String API = "https://gutendex.com/books/";
    private Scanner sc = new Scanner(System.in);

    public void main(LivroRepository livroRepository, AutorRepository autorRepository) {
        ConsumoAPI consumo = new ConsumoAPI();
        ConverteDados converteDados = new ConverteDados();
        int opt = -1;
        String json;
        String pesquisa;
        List<Autor> resultadosAutores;
        List<Livro> resultadosLivros;

        while (opt != 0) {
            // Exibindo as opções do menu
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Buscar livros pelo título");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado ano");
            System.out.println("5 - Listar livros em um determinado idioma");
            System.out.println("0 - Sair");
            System.out.print("Número de sua opção: ");

            // Captura da opção
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    pesquisa = (sc.nextLine()).replace(" ", "+");
                    json = consumo.obterDados(API + "?search=" + pesquisa);
                    ResponseWrapper responseWrapper = converteDados.obterDados(json, ResponseWrapper.class);
                    // Exibindo o primeiro resultado ou uma mensagem caso não haja resultados
                    if (responseWrapper != null && !responseWrapper.getResults().isEmpty()) {
                        List<Livro> pesquisaResultados = responseWrapper.getResults();

                        // Iterando sobre os livros
                        for (Livro livro : pesquisaResultados) {
                            Autor autor = livro.getAutor();
                            if (autor != null) {
                                // Verifique se o autor já existe no banco
                                Autor autorExistente = autorRepository.findByNome(autor.getNome());

                                // Se o autor não existir, salve-o
                                if (autorExistente == null) {
                                    autorExistente = autorRepository.save(autor);
                                }

                                // Associar o autor encontrado ao livro
                                livro.setAutor(autorExistente);
                                livroRepository.save(livro);  // Salva o livro com o autor associado
                            } else {
                                livroRepository.save(livro);  // Salva o livro sem autor
                            }


                        }

                        System.out.println("Resultados:");
                        for (Livro livro : pesquisaResultados) {
                            System.out.println(livro.getTitulo());
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }
                    break;
                case 2:
                    resultadosLivros = livroRepository.findAll();
                    if (!resultadosLivros.isEmpty()) {
                        System.out.println("Listando livros:");
                        for (Livro livro : resultadosLivros) {
                            System.out.println(livro.getTitulo());
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }
                    break;
                case 3:
                    resultadosAutores = autorRepository.findAll();
                    if (!resultadosAutores.isEmpty()) {
                        System.out.println("Listando autores:");
                        for (Autor autor : resultadosAutores) {
                            System.out.println(autor.getNome());
                        }
                    } else {
                        System.out.println("Nenhum autor encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite a data de nascimento do autor:");
                    int ano_nascimento = sc.nextInt();
                    System.out.println("Digite a data de morte do autor:");
                    int ano_falecimento = sc.nextInt();

                    resultadosAutores = autorRepository.findAutorLivingBetweenDates(ano_nascimento, ano_falecimento);
                    if (!resultadosAutores.isEmpty()) {
                        System.out.println("Listando autores que viveram de " + ano_nascimento + " até " + ano_falecimento);
                        for (Autor autor : resultadosAutores) {
                            System.out.println("(" + autor.getAno_nascimento() + "-" + autor.getAno_falecimento() + ") " + autor.getNome());
                        }
                    } else {
                        System.out.println("Nenhum autor encontrado.");
                    }

                    break;
                case 5:
                    System.out.println("Digite a abreviação do idioma e.g. (en, pt, ru, etc.)");
                    String idiomaPesquisa = sc.nextLine();
                    resultadosLivros = livroRepository.findByIdioma(idiomaPesquisa);
                    if (!resultadosLivros.isEmpty()) {
                        System.out.println("Listando livros:");
                        for (Livro livro : resultadosLivros) {
                            System.out.println(livro.getIdioma() + " - " + livro.getTitulo());
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Insira um valor válido!");
                    break;
            }
        }
        sc.close();  // Fechar o Scanner no final para evitar vazamento de recursos
    }
}
