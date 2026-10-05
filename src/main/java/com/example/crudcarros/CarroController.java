package com.example.crudcarros;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroRepository repository;

    public CarroController(CarroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Carro criar(@RequestBody Carro carro) {
        return repository.save(carro);
    }

    @GetMapping
    public List<Carro> listar() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @RequestBody Carro carro) {
        carro.setId(id);
        return repository.save(carro);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}