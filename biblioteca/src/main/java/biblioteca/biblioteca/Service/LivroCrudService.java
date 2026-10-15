package biblioteca.biblioteca.Service;

import java.util.List;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    List<LivroResponseDto> buscarTodosLivros();

    LivroResponseDto buscarLivroISBN(Long isbn);

    List<LivroResponseDto> buscarLivroTitulo(String titulo);

    LivroResponseDto atualizarLivro(Long isbn, LivroPostPutDto livroPostPutDto);

    void removerLivro(Long isbn);

    
}
