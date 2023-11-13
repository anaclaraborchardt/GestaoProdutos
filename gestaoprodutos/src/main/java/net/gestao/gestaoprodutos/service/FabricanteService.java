package net.gestao.gestaoprodutos.service;

import lombok.AllArgsConstructor;
import net.gestao.gestaoprodutos.modal.DTO.FabricanteDTO;
import net.gestao.gestaoprodutos.modal.DTO.ProdutoDTO;
import net.gestao.gestaoprodutos.modal.Entity.Fabricante;
import net.gestao.gestaoprodutos.repository.FabricanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    public Fabricante save(FabricanteDTO fabricanteDTO) throws Exception {
        Fabricante fabricante = new Fabricante();
        BeanUtils.copyProperties(fabricanteDTO, fabricante);
        try{
            validacoes(fabricante);
            return fabricanteRepository.save(fabricante);
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Fabricante findById(Integer id){
        return fabricanteRepository.findById(id).get();
    }

    public List<Fabricante> findAll(){
        return fabricanteRepository.findAll();
    }

    public void deleteById(Integer id){
        fabricanteRepository.deleteById(id);
    }

    private void validacoes(Fabricante fabricante){
        if(fabricante.getNome() == null){
           throw new RuntimeException("O nome deve ser preenchido");
        }else if(fabricante.getNome().equals("")){
            throw new RuntimeException("O nome deve ser preenchido");
        }
    }
}
