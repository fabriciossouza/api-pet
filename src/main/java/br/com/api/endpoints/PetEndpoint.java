package br.com.api.endpoints;

import br.com.api.endpoints.validator.PetValidator;
import br.com.api.entity.Pet;
import br.com.api.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rs/pets", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetEndpoint {

    private PetService service;
    private PetValidator validator;

    @Autowired
    public PetEndpoint(final PetService service, final PetValidator validator){
        this.service = service;
        this.validator = validator;
    }

    @GetMapping
    public List<Pet> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pet findById(@PathVariable final Long id){
        return service.findById(id);
    }

    @PostMapping
    public Pet save(@RequestBody final Pet pet){
        validator.validate(pet);
        return service.save(pet);
    }

    @PutMapping(value = "/{id}")
    public Pet update(@PathVariable final Long id, @RequestBody final Pet pet){
        pet.setId(id);
        return service.update(pet);
    }

    @DeleteMapping(value = "/{id}")
    public Pet delete(@PathVariable final Long id){
        return service.delete(id);
    }
}
