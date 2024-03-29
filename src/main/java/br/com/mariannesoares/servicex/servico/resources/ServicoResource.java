package br.com.mariannesoares.servicex.servico.resources;


import br.com.mariannesoares.servicex.servico.domain.Servico;
import br.com.mariannesoares.servicex.servico.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/servico")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico){

        Servico novoServico = servicoService.criarServico(servico);
        return new ResponseEntity<Servico>(novoServico, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos(){
        return new ResponseEntity<List<Servico>>(servicoService.listarServico(), HttpStatus.FOUND);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Servico>> listarServicosPorId(@PathVariable Long id){
        return servicoService.buscarServico(id)
                .map(servico -> new ResponseEntity(servico, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirServico(@PathVariable Long id){
        servicoService.deletarServico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable Long id, @RequestBody Servico servico){
        if (!servicoService.buscarServico(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servico.setIdServico(id);
        Servico novoServico = servicoService.atualizarServico(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.OK);
    }
}
