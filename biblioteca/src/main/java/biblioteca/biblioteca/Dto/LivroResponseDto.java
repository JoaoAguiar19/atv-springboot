package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroResponseDto {
    
    @JsonProperty("isbn")
    private Long isbn;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("ano")
    private String ano;

    @JsonProperty("autor")
    private Long autor;

    @JsonProperty("edicao")
    private String edicao;
}
