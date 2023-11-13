package net.gestao.gestaoprodutos.repository;


import net.gestao.gestaoprodutos.modal.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    boolean existsByCodigoBarras(Long codigoBarras);
}
