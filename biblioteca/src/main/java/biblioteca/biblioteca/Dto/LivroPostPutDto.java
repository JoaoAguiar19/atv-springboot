package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroPostPutDto {
    
    @JsonProperty("isbn")
    @NotBlank(message = "ISBN não encontrado")
    private Long isbn;

    @JsonProperty("titulo")
    @NotBlank(message = "Título não encontrado")
    private String titulo;

    @JsonProperty("ano")
    @NotBlank(message = "Ano inválido")
    private String ano;

    @JsonProperty("autor")
    @NotBlank(message = "Autor não encontrado")
    private Long autor;

    @JsonProperty("edicao")
    @NotBlank(message = "Edição inválida")
    private String edicao;
}
