package br.com.mariannesoares.servicex.categoria.repositores;

import br.com.mariannesoares.servicex.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
