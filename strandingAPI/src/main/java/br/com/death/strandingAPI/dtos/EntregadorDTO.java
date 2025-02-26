package br.com.death.strandingAPI.dtos;

import br.com.death.strandingAPI.enums.Empresa;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EntregadorDTO(
        UUID id,

        @NotBlank(message = "O nome não pode estar em branco")
        String nome,

        @NotBlank(message = "O email não pode estar em branco")
        @Email(message = "Formato de email inválido")
        String email,

        @NotBlank(message = "A senha não pode estar em branco")
        String senha,

        @NotNull(message = "O nível não pode ser nulo")
        Integer nivel,

        @NotNull(message = "A experiência não pode ser nula")
        Integer experiencia,

        @NotNull(message = "O peso atual não pode ser nulo")
        Double pesoAtual,

        String fotoUrl,

        @NotNull(message = "A empresa não pode ser nula")
        Empresa empresa
) {
}