package net.gestao.gestaoprodutos.modal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gestao.gestaoprodutos.modal.ENUM.Categorias;

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
    @Column(nullable = false)
    private String fabricante;
    @Column(nullable = false)
    @Enumerated
    private Categorias categoria;
}
