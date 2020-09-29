package br.com.api.services;

import br.com.api.entity.Pet;
import br.com.api.infrastructure.exceptions.EntityNotFoundException;
import br.com.api.repository.PetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;


    public Pet findById(final Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pet Not Found!"));
    }

    public Pet save(final Pet pet){
        return repository.save(pet);
    }

    public Pet update(final Pet petRequest){
        Pet pet = findById(petRequest.getId());
        BeanUtils.copyProperties(petRequest, pet);
        return repository.save(petRequest);
    }

    public Pet delete(final Long id){
        Pet pet = findById(id);
        repository.delete(pet);
        return pet;
    }
    public List<Pet> findAll(){
        return repository.findAll();
    }
}
