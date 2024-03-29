package br.com.mariannesoares.servicex.servico.repositores;

import br.com.mariannesoares.servicex.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {


}
