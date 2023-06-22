package demo.olivares.infrastructure.controller.operation;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OperationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String URL_HOME_OPERATION = "/api/operation/v1/home";

    private final String URL_ADD_OPERATION = "/api/operation/v1/sum";

    private final String URL_SUBSTRACT_OPERATION = "/api/operation/v1/substract";

    private final String FIRST_VALUE_VALID = "10";
    private final String FIRST_VALUE_INVALID = "XX";
    private final String SECOND_VALUE_VALID = "5";
    private final String SECOND_VALUE_INVALID = "XX";

    private final String ADD_EXPECTED_VALUE = "15.0";
    private final String SUBSTRACT_EXPECTED_VALUE = "5.0";


    @Test
    @DisplayName("Test to check if the service is alive")
    public void shouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get(URL_HOME_OPERATION)).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hello World")));
    }

    @Test
    @SneakyThrows
    @DisplayName("Test add operation with valid input values , expected ok")
    void addOperationMustReturnCorrectValue() {

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL_ADD_OPERATION)
                .param("firstvalue", FIRST_VALUE_VALID)
                .param("secondvalue", SECOND_VALUE_VALID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();

        assertTrue(result.getResponse().getStatus() == HttpStatus.OK.value());
        assertEquals(ADD_EXPECTED_VALUE, result.getResponse().getContentAsString());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test add operation with the secondvalue valid and the second value valid , expected ko")
    void addOperationMustReturnBadRequestException_First_Value_Invalid() {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL_ADD_OPERATION)
                .param("firstvalue", FIRST_VALUE_INVALID)
                .param("secondvalue", SECOND_VALUE_VALID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());

        MvcResult result = resultActions.andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test add operation with the firstvalue valid and the second value invalid , expected ko")
    void addOperationMustReturnBadRequestException_Second_Value_Invalid() {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL_ADD_OPERATION)
                .param("firstvalue", FIRST_VALUE_VALID)
                .param("secondvalue", SECOND_VALUE_INVALID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());

        MvcResult result = resultActions.andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test add operation with both params with invalid value , expected ko")
    void addOperationMustReturnBadRequestExceptionBoth_Params_Invalid() {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL_ADD_OPERATION)
                .param("firstvalue", FIRST_VALUE_INVALID)
                .param("secondvalue", SECOND_VALUE_INVALID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());

        MvcResult result = resultActions.andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }


    @Test
    @SneakyThrows
    @DisplayName("Test substract operation with valid input values , expected ok")
    void substractOperationMustReturnCorrectValue() {

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL_SUBSTRACT_OPERATION)
                .param("firstvalue", FIRST_VALUE_VALID)
                .param("secondvalue", SECOND_VALUE_VALID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();

        assertTrue(result.getResponse().getStatus() == HttpStatus.OK.value());
        assertEquals(SUBSTRACT_EXPECTED_VALUE, result.getResponse().getContentAsString());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test substract operation with the secondvalue valid and the second value valid , expected ko")
    void substractOperationMustReturnBadRequestException_First_Value_Invalid() {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL_SUBSTRACT_OPERATION)
                .param("firstvalue", FIRST_VALUE_INVALID)
                .param("secondvalue", SECOND_VALUE_VALID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());

        MvcResult result = resultActions.andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test substract operation with the firstvalue valid and the second value invalid , expected ko")
    void substractOperationMustReturnBadRequestException_Second_Value_Invalid() {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL_SUBSTRACT_OPERATION)
                .param("firstvalue", FIRST_VALUE_VALID)
                .param("secondvalue", SECOND_VALUE_INVALID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());

        MvcResult result = resultActions.andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test substract operation with both params with invalid value , expected ko")
    void substractOperationMustReturnBadRequestExceptionBoth_Params_Invalid() {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL_SUBSTRACT_OPERATION)
                .param("firstvalue", FIRST_VALUE_INVALID)
                .param("secondvalue", SECOND_VALUE_INVALID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());

        MvcResult result = resultActions.andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
