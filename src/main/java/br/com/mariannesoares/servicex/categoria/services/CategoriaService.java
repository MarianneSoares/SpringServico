package br.com.mariannesoares.servicex.categoria.services;

import br.com.mariannesoares.servicex.categoria.domain.Categoria;
import br.com.mariannesoares.servicex.categoria.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> ListarCategoria(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoria(Long idCategoria){
        return categoriaRepository.findById(idCategoria);
    }

    public Categoria atualizarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}
