package br.com.mariannesoares.servicex.servico.domain;

import br.com.mariannesoares.servicex.categoria.domain.Categoria;
import br.com.mariannesoares.servicex.ordemservico.domain.OrdemServico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="SERVICOS")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_SERVICO")
    private Integer IdServico;

    @Column(name = "NOME_SERVICO")
    private String nome;

    @Column(name="VALOR_SERVICO")
    private Double valor;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria categoria;

    @Column(name = "ORDEM_SERVICO")
    @OneToMany(mappedBy = "servico")
    private List<OrdemServico> ordemServicos;


    }
}
