package net.gestao.gestaoprodutos.controller;

import lombok.AllArgsConstructor;
import net.gestao.gestaoprodutos.modal.DTO.CategoriaDTO;
import net.gestao.gestaoprodutos.modal.DTO.FabricanteDTO;
import net.gestao.gestaoprodutos.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoriaDTO categoriaDTO){
        try{
            return new ResponseEntity<>(categoriaService.save(categoriaDTO), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(categoriaService.findById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try{
            return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        categoriaService.deleteById(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> put(@RequestBody CategoriaDTO categoriaDTO, @PathVariable Integer id){
        try{
            return new ResponseEntity<>(categoriaService.save(categoriaDTO), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@RequestBody CategoriaDTO categoriaDTO){
        try{
            return new ResponseEntity<>(categoriaService.save(categoriaDTO), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
