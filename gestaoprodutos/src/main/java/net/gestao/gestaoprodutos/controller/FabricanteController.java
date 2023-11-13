package net.gestao.gestaoprodutos.controller;

import lombok.AllArgsConstructor;
import net.gestao.gestaoprodutos.modal.DTO.FabricanteDTO;
import net.gestao.gestaoprodutos.modal.Entity.Fabricante;
import net.gestao.gestaoprodutos.service.FabricanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabricante")
@AllArgsConstructor
public class FabricanteController {

    private final FabricanteService fabricanteService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody FabricanteDTO fabricanteDTO){
        try{
            return new ResponseEntity<>(fabricanteService.save(fabricanteDTO), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(fabricanteService.findById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> findOne(){
        try{
            return new ResponseEntity<>(fabricanteService.findAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        fabricanteService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@RequestBody FabricanteDTO fabricanteDTO){
        try{
            return new ResponseEntity<>(fabricanteService.save(fabricanteDTO), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
