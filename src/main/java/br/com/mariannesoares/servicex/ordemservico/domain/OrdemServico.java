package br.com.mariannesoares.servicex.ordemservico.domain;

import br.com.mariannesoares.servicex.servico.domain.Servico;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "ORDEMDESERVICO")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_ORDEM_SERVICO")
    private Long idOrdemServico;

    @Column(name = "DATA")
    private Date data;

    @Column(name = "VALOR_ORDEM_SERVICO")
    private Double valorOrdemServico;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICO")
    private Servico servico;
}
