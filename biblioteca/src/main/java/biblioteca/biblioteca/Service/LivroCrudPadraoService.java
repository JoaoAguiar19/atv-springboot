package biblioteca.biblioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.AutorRepository;
import biblioteca.biblioteca.Repository.LivroRepository;

@Service
public class LivroCrudPadraoService implements LivroCrudService{

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;


    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {
        Autor autor = autorRepository.findById(livroPostPutDto.getAutor())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));

        Livro livro = Livro.builder()
        .isbn(livroPostPutDto.getIsbn())
        .titulo(livroPostPutDto.getTitulo())
        .ano(livroPostPutDto.getAno())
        .edicao(livroPostPutDto.getEdicao())
        .autor(autor)
        .build();


        return converterParaResponseDto(livroRepository.save(livro));
    }

    @Override
    public List<LivroResponseDto> buscarTodosLivros() {
        return livroRepository.findAll()
                .stream()
                .map(this::converterParaResponseDto)
                .toList();
    }

    @Override
    public LivroResponseDto buscarLivroISBN(Long isbn) {
        Livro livro = livroRepository.findById(isbn)
        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        return converterParaResponseDto(livro);
    }

    @Override
    public List<LivroResponseDto> buscarLivroTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo)
            .stream()
            .map(this::converterParaResponseDto)
            .toList();
    }

    @Override
    public LivroResponseDto atualizarLivro(Long isbn, LivroPostPutDto livroPostPutDto) {
        Livro livro = livroRepository.findById(isbn)
        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setTitulo(livroPostPutDto.getTitulo());
        livro.setEdicao(livroPostPutDto.getEdicao());

        return converterParaResponseDto(livroRepository.save(livro));
    }


    @Override
    public void removerLivro(Long isbn) {
        Livro livro = livroRepository.findById(isbn)
        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livroRepository.delete(livro);
    }

    private LivroResponseDto converterParaResponseDto(Livro livro) {
    return LivroResponseDto.builder()
        .isbn(livro.getIsbn())
        .titulo(livro.getTitulo())
        .ano(livro.getAno())
        .edicao(livro.getEdicao())
        .autor(livro.getAutor().getId())
        .build();
    }
    
}
