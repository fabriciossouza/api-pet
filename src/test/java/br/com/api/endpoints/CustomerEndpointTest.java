package br.com.api.endpoints;

import br.com.api.infrastructure.YamlPropertyLoader;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerEndpointTest extends EndpointTest{

    @Test
    public void shouldReturnAllCustomers() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/customers")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnCustomerById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/customers/9991")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldCreateCustomer() throws Exception {
        final YamlPropertyLoader scenarioLoader = new YamlPropertyLoader(
                "scenarios/customerTest.yml", "shouldCreateCustomer");
        mvc.perform(MockMvcRequestBuilders
                .post("/rs/customers")
                .content(scenarioLoader.getInputBody())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnBadRequestWhenTryCreateCustomerWithoutName() throws Exception {
        final YamlPropertyLoader scenarioLoader = new YamlPropertyLoader(
                "scenarios/customerTest.yml", "shouldReturnBadRequestWhenTryCreateCustomerWithoutName");
        mvc.perform(MockMvcRequestBuilders
                .post("/rs/customers")
                .content(scenarioLoader.getInputBody())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void shouldChangeCustomer() throws Exception {
        final YamlPropertyLoader scenarioLoader = new YamlPropertyLoader(
                "scenarios/customerTest.yml", "shouldChangeCustomer");
        mvc.perform(MockMvcRequestBuilders
                .put("/rs/customers/9991")
                .content(scenarioLoader.getInputBody())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/rs/customers/9993")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

}
