package br.com.api.endpoints;

import br.com.api.infrastructure.YamlPropertyLoader;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PetEndpointTest extends EndpointTest{

    @Test
    public void shouldReturnAllPet() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/pets")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnPetById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/pets/8881")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldCreatePet() throws Exception {
        final YamlPropertyLoader scenarioLoader = new YamlPropertyLoader(
                "scenarios/petTest.yml", "shouldCreatePet");
        mvc.perform(MockMvcRequestBuilders
                .post("/rs/pets")
                .content(scenarioLoader.getInputBody())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnBadRequestWhenTryCreatePetWithoutName() throws Exception {
        final YamlPropertyLoader scenarioLoader = new YamlPropertyLoader(
                "scenarios/petTest.yml", "shouldReturnBadRequestWhenTryCreatePetWithoutName");
        mvc.perform(MockMvcRequestBuilders
                .post("/rs/pets")
                .content(scenarioLoader.getInputBody())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void shouldChangePet() throws Exception {
        final YamlPropertyLoader scenarioLoader = new YamlPropertyLoader(
                "scenarios/petTest.yml", "shouldChangePet");
        mvc.perform(MockMvcRequestBuilders
                .put("/rs/pets/8881")
                .content(scenarioLoader.getInputBody())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldDeletePet() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/rs/pets/8883")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

}
