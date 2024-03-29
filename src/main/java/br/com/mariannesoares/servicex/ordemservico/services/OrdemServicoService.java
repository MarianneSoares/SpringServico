package br.com.mariannesoares.servicex.ordemservico.services;

import br.com.mariannesoares.servicex.ordemservico.repositores.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

}
