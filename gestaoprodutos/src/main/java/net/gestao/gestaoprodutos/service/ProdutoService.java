package net.gestao.gestaoprodutos.service;

import lombok.AllArgsConstructor;
import net.gestao.gestaoprodutos.modal.DTO.ProdutoDTO;
import net.gestao.gestaoprodutos.modal.DTO.ProdutoEdicaoDTO;
import net.gestao.gestaoprodutos.modal.Entity.Produto;
import net.gestao.gestaoprodutos.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto save (ProdutoDTO produtoDTO) throws Exception {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        try{
            validacoes(produto);
            return produtoRepository.save(produto);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Produto findById (Integer id){
        return produtoRepository.findById(id).get();
    }

    public List<Produto> findAll (){
        return produtoRepository.findAll();
    }

    public void deleteById (Integer id) {
        produtoRepository.deleteById(id);
    }

    public Produto put (ProdutoEdicaoDTO produtoEDTO){
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoEDTO, produto);
        try{
            validacoes(produtoEDTO);
            return produtoRepository.save(produto);
        }catch(RuntimeException e){
            throw new RuntimeException();
        }
    }

    public void validacoes(Produto produto){
        if(produto.getEstoque() < 0) {
            throw new RuntimeException("O estoque não pode ser menor que 0");
        }else if(produto.getPreco() <= 0) {
            throw new RuntimeException("O preço não pode ser menor que 0");
        }else if(produto.getNome() == null){
            throw new RuntimeException("O nome deve ser preenchido");
        }else if(produto.getDescricao() == null){
            throw new RuntimeException("A descrição deve ser preenchido");
        }else if(produtoRepository.existsById(produto.getId())){
            throw new RuntimeException("Não pode haver id igual");
        }
    }
    public void validacoes(ProdutoEdicaoDTO produtoDTO){
        if(produtoDTO.getId() == null){
            throw new RuntimeException("O id deve ser preenchido");
        }
        else if(produtoDTO.getEstoque() < 0) {
            throw new RuntimeException("O estoque não pode ser menor que 0");
        }else if(produtoDTO.getPreco() <= 0) {
            throw new RuntimeException("O preço não pode ser menor que 0");
        }
    }
}
