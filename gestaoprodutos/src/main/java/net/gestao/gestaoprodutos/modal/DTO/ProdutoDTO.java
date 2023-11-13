package net.gestao.gestaoprodutos.modal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.gestao.gestaoprodutos.modal.Entity.Categoria;
import net.gestao.gestaoprodutos.modal.Entity.Fabricante;

import java.util.Date;

@AllArgsConstructor
@Data
public class ProdutoDTO {

    private String nome;
    private Double preco;
    private Integer estoque;
    private Date dataValidade;
    private String descricao;
    private Long codigoBarras;
    private Double peso;
    private double medida;
    private Fabricante fabricante;
    private Categoria categoria;

}
