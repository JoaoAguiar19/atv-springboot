package biblioteca.biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_livro")
public class Livro {

    @Id
    @JsonProperty("isbn")
    private Long isbn;

    @Column(name = "titulo", nullable = false)
    @JsonProperty("titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    @JsonProperty("autor")
    private Autor autor;

    @Column(name = "ano")
    @JsonProperty("ano")
    private String ano;

    @Column(name = "edicao")
    @JsonProperty("edicao")
    private String edicao;
}