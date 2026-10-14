package biblioteca.biblioteca.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.LivroRepository;

@Service
public class LivroCrudPadraoService implements LivroCrudService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository livroRepository;


    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {
        Livro livro = modelMapper.map(livroPostPutDto, Livro.class);
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }


    @Override
    public List<LivroResponseDto> buscarTodosLivros() {
        return livroRepository.findAll()
                .stream()
                .map(livro -> modelMapper.map(livro, LivroResponseDto.class))
                .toList();
    }


    @Override
    public LivroResponseDto buscarLivro(Long isbn) {
        Livro livro = livroRepository.findById(isbn)
        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        return modelMapper.map(livro, LivroResponseDto.class);
    }


    @Override
    public LivroResponseDto atualizarLivro(Long isbn, LivroPostPutDto livroPostPutDto) {
        Livro livro = livroRepository.findById(isbn)
        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setTitulo(livroPostPutDto.getTitulo());
        livro.setEdicao(livroPostPutDto.getEdicao());

        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }


    @Override
    public void removerLivro(Long isbn) {
        Livro livro = livroRepository.findById(isbn)
        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livroRepository.delete(livro);
    }

    
    
}
