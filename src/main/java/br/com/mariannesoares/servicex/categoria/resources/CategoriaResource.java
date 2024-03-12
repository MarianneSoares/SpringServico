package br.com.mariannesoares.servicex.categoria.resources;

import br.com.mariannesoares.servicex.categoria.domain.Categoria;
import br.com.mariannesoares.servicex.categoria.repositores.CategoriaRepository;
import br.com.mariannesoares.servicex.categoria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){

        Categoria novaCategoria = categoriaService.criarCategoria(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return new ResponseEntity<List<Categoria>>(categoriaService.listarCategoria(), HttpStatus.FOUND);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Categoria>> listarCategoriasPorId(@PathVariable Long id){
        return categoriaService.buscarCategoria(id)
                .map(categoria -> new ResponseEntity(categoria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        if (!categoriaService.buscarCategoria(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoria.setIdCategoria(id);
        Categoria novaCategoria = categoriaService.atualizarCategoria(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.OK);
    }

}
