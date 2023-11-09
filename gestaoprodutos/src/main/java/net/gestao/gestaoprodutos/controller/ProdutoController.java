package net.gestao.gestaoprodutos.controller;

import lombok.AllArgsConstructor;
import net.gestao.gestaoprodutos.modal.DTO.ProdutoDTO;
import net.gestao.gestaoprodutos.modal.DTO.ProdutoEdicaoDTO;
import net.gestao.gestaoprodutos.modal.Entity.Produto;
import net.gestao.gestaoprodutos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProdutoDTO produtoDTO){
        try {
            return new ResponseEntity<>(produtoService.save(produtoDTO), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        try {
            return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
            produtoService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody ProdutoEdicaoDTO produtoEDTO){
        try {
            return new ResponseEntity<>(produtoService.put(produtoEDTO), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
