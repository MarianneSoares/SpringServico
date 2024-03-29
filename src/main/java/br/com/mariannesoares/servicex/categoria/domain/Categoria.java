package br.com.mariannesoares.servicex.categoria.domain;

import br.com.mariannesoares.servicex.servico.domain.Servico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import java.util.List;
@Data
@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CATEGORIA")
    private Long idCategoria;

    @Column(name= "NOME_CATEGORIA")
    private String nomeCategoria;

    @JsonIgnore
    @OneToMany(mappedBy = "idServico")
    private List<Servico> servicos;

    public Categoria(){

    }



}
