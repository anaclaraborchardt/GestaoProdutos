package net.gestao.gestaoprodutos.repository;

import net.gestao.gestaoprodutos.modal.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
