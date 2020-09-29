package br.com.api.endpoints.validator;

import br.com.api.entity.Pet;
import br.com.api.infrastructure.exceptions.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PetValidator implements Validator<Pet> {

    @Override
    public void validate(Pet pet){
        if(StringUtils.isEmpty(pet.getName())){
            throw new ValidationException("name is mandatory");
        }

        if(StringUtils.isEmpty(pet.getCustomer()) && StringUtils.isEmpty(pet.getCustomer().getId())){
            throw new ValidationException("customer{id} is mandatory");
        }
    }
}
