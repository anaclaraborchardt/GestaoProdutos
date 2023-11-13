package net.gestao.gestaoprodutos.service;

import lombok.AllArgsConstructor;
import net.gestao.gestaoprodutos.modal.DTO.CategoriaDTO;
import net.gestao.gestaoprodutos.modal.Entity.Categoria;
import net.gestao.gestaoprodutos.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria save(CategoriaDTO categoriaDTO) throws Exception {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDTO, categoria);
        try{
            validacoes(categoria);
            return categoriaRepository.save(categoria);
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Categoria findById(Integer id){
        return categoriaRepository.findById(id).get();
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public void deleteById(Integer id){
        categoriaRepository.deleteById(id);
    }

    private void validacoes(Categoria categoria){
        if(categoria.getNome() == null){
            throw new RuntimeException("O nome deve ser preenchido");
        }else if(categoria.getNome().equals("")){
            throw new RuntimeException("O nome deve ser preenchido");
        }
    }
}
