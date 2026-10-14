package biblioteca.biblioteca.Service;

import java.util.List;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import jakarta.validation.Valid;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    List<LivroResponseDto> buscarTodosLivros();

    LivroResponseDto buscarLivro(Long isbn);

    LivroResponseDto atualizarLivro(Long isbn, LivroPostPutDto livroPostPutDto);

    void removerLivro(Long isbn);
    
}
