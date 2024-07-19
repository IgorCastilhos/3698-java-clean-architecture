package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivos {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();

        repositorio.cadastrarUsuario(new Usuario("456.789.888-88", "Maria", LocalDate.parse("2000-01-01"), "maria@email.com"));

        repositorio.cadastrarUsuario(new Usuario("456.789.888-87", "Vitor", LocalDate.parse("2000-01-01"), "vitor@email.com"));

        repositorio.cadastrarUsuario(new Usuario("456.789.888-86", "Goku", LocalDate.parse("2000-01-01"), "goku@email.com"));

        repositorio.cadastrarUsuario(new Usuario("456.789.888-85", "Vegeta", LocalDate.parse("2000-01-01"), "vegeta@email.com"));

//        repositorio.listarTodos().forEach(System.out::println);
        repositorio.gravaEmArquivo("usuarios.txt");
    }
}
