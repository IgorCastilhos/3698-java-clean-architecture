package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    private String name;
    private LocalDate birthDate;
    private String email;

//    @ParameterizedTest
//    @ValueSource(strings = {"", " ", "1234567890", "12345678-90", "123.45678-90", "123.456.78-90", "111.111.111-11", "111.111.111-1a", "111.111.111-12"})
//    public void naoDeveCadastrarUsuarioComCpfInvalido(String cpfInvalido) {
//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> new Usuario(cpfInvalido, "Fulano", LocalDate.parse("2000-01-01"), "email@gmail.com"));
//    }

    @BeforeEach
    public void setUp() {
        name = "Fulano";
        birthDate = LocalDate.parse("2000-01-01");
        email = "email@gmail.com";
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfVazio() {
        String cpfInvalido = "";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF não pode ser vazio");
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfEspacoEmBranco() {
        String cpfInvalido = " ";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF não pode ser um espaço em branco");
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfFormatoInvalido1() {
        String cpfInvalido = "1234567890";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF no padrão errado");
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfFormatoInvalido2() {
        String cpfInvalido = "12345678-90";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF no padrão errado");
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfFormatoInvalido3() {
        String cpfInvalido = "123.45678-90";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF no padrão errado");
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfFormatoInvalido4() {
        String cpfInvalido = "123.456.78-90";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF no padrão errado");
    }

    //    Antigo ->

    @Test
    public void naoDeveCadastrarUsuarioComCpfTodosDigitosIguais() {
        String cpfInvalido = "111.111.111-11";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF com todos os dígitos iguais não é válido");
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfCaracteresNaoNumericos() {
        String cpfInvalido = "111.111.111-1a";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF com caracteres não numéricos não é válido");
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfDigitosVerificadoresIncorretos() {
        String cpfInvalido = "111.111.111-12"; // CPF inválido
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfInvalido, name, birthDate, email), "CPF com dígitos verificadores incorretos não é válido");
    }

    @Test
    public void naoDeveCadastrarUsuarioMenorDeIdade() {
        LocalDate birthDate = LocalDate.now().minusYears(17);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456.789-99", name, birthDate, email), "Usuário menor de 18 anos não pode se cadastrar");
    }
}
