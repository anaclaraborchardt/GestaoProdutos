package net.gestao.gestaoprodutos.modal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gestao.gestaoprodutos.modal.ENUM.Categorias;
import net.gestao.gestaoprodutos.modal.Entity.Fabricante;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoEdicaoDTO {

    private Integer id;
    private Double preco;
    private Integer estoque;
    private String descricao;
    private Categorias categoria;

}
