package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FabricaDeUsuarioTest {
    private String name;
    private LocalDate birthDate;
    private String email;
    private String cpf;

    @BeforeEach
    public void setUp() {
        name = "Fulano";
        birthDate = LocalDate.parse("2000-01-01");
        email = "email@gmail.com";
        cpf = "123.456.789-99";
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabricaDeUsuario = new FabricaDeUsuario();
        Usuario usuario = fabricaDeUsuario.comNomeCpfNascimento(name, cpf, birthDate);

        Assertions.assertEquals("Fulano", usuario.getNome());

        usuario = fabricaDeUsuario.incluiEndereco("12345-678", 123, "casa");

        Assertions.assertEquals("casa", usuario.getEndereco().getComplemento());
    }
}
