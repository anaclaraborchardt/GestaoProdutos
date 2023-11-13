package net.gestao.gestaoprodutos.modal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gestao.gestaoprodutos.modal.Entity.Categoria;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoEdicaoDTO {

    private Integer id;
    private Double preco;
    private Integer estoque;
    private String descricao;
    private Categoria categoria;

}
