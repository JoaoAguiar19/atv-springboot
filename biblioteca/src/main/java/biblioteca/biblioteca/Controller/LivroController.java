package biblioteca.biblioteca.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Service.LivroCrudService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping(value = "/v1/livro", produces = MediaType.APPLICATION_JSON_VALUE)
public class LivroController {
    
    @Autowired
    LivroCrudService livroCrudService;

    @PostMapping("")
    public ResponseEntity<LivroResponseDto> criarLivro(@RequestBody @Valid LivroPostPutDto livroPostPutDto) {
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(livroCrudService.criarLivro(livroPostPutDto));
    }

    @GetMapping("")
    public ResponseEntity<List<LivroResponseDto>> buscarTodosLivros() {
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(livroCrudService.buscarTodosLivros());
    }
    
    @GetMapping("/{isbn}")
    public ResponseEntity<LivroResponseDto> buscarLivro(@RequestParam Long isbn) {
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(livroCrudService.buscarLivro(isbn));
    }
    
    @PutMapping("/{isbn}")
    public ResponseEntity<LivroResponseDto> atualizarLivro(@PathVariable Long isbn, @RequestBody @Valid LivroPostPutDto livroPostPutDto) {
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(livroCrudService.atualizarLivro(isbn, livroPostPutDto));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> removerLivro(@PathVariable Long isbn) {
        livroCrudService.removerLivro(isbn);
        return ResponseEntity
        .status(HttpStatus.NO_CONTENT)
        .build();
    }
}
