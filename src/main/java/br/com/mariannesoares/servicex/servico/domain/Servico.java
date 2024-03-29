package br.com.mariannesoares.servicex.servico.domain;

import br.com.mariannesoares.servicex.categoria.domain.Categoria;
import br.com.mariannesoares.servicex.ordemservico.domain.OrdemServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long idServico;

    @Column(name = "NOME_SERVICO")
    private String nomeServico;

    @Column(name="VALOR_SERVICO")
    private Double valorServico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria categoria;

    @JsonIgnore
    @ManyToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<OrdemServico> ordemServicos;


    }

