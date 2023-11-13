package net.gestao.gestaoprodutos.modal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private Integer estoque;
    private Date dataValidade;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Long codigoBarras;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private double medida;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Fabricante fabricante;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Categoria categoria;
}
