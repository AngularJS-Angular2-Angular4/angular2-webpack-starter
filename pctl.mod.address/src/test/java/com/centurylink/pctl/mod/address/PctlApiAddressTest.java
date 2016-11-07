

package com.centurylink.pctl.mod.address;


import com.centurylink.pctl.mod.address.domain.address.AddressService;
import com.centurylink.pctl.mod.address.domain.address.AddressType;
import com.centurylink.pctl.mod.core.model.address.Address;
import com.centurylink.pctl.mod.core.utils.Response;
import com.centurylink.pctl.mod.core.utils.StatusCode;
import com.centurylink.pctl.mod.core.utils.ValidateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This class PctlApiAddressTest is for test cases
 *
 * @author Haribabu.ka
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PctlApiAddressTest {

    private static final Logger log = LoggerFactory.getLogger(PctlApiAddressTest.class);
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
    @Autowired
    private AddressService addressService;
    private ValidateUtils validateUtils;
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Test
    public void validateEmptyObject() {
        Response<Address> respo = addressService.validate(new Address(), AddressType.CIVIC);
        Assert.assertNotNull(respo);
        Assert.assertNotNull(respo.getContent());
        Assert.assertNotNull(respo.getCode());
        Assert.assertNotNull(respo.getMessage());
        Assert.assertNotNull(respo.getHttpStatus());
        Assert.assertEquals(StatusCode.E400.getCode(), respo.getCode());
    }

    @Test
    public void validateTypeNull() {
        Address address = new Address();
        Response<Address> respo = addressService.validate(address, null);
        Assert.assertNotNull(respo);
        Assert.assertNotNull(respo.getCode());
        Assert.assertNotNull(respo.getMessage());
        Assert.assertNotNull(respo.getHttpStatus());
        Assert.assertEquals(StatusCode.E400.getCode(), respo.getCode());
    }

    @Test
    public void validateNull() {
        Address address = null;
        Response<Address> respo = addressService.validate(address, null);
        Assert.assertNotNull(respo);
        Assert.assertNotNull(respo.getCode());
        Assert.assertNotNull(respo.getMessage());
        Assert.assertNotNull(respo.getHttpStatus());
        Assert.assertEquals(StatusCode.E400.getCode(), respo.getCode());
    }

    @Test
    public void validateCorrectAdd() {
        Address address = new Address();
        Response<Address> respo = addressService.validate(address, AddressType.CIVIC);
        Assert.assertNotNull(respo);
        Assert.assertNotNull(respo.getContent());
        Assert.assertNotNull(respo.getCode());
        Assert.assertNotNull(respo.getMessage());
        Assert.assertNotNull(respo.getHttpStatus());
        Assert.assertEquals(StatusCode.E400.getCode(), respo.getCode());
    }

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(documentationConfiguration(this.restDocumentation))
            .build();
    }


    @Test
    @WithMockUser(username = "jbeginsamuel@gmail.com", roles = {"USER"})
    public void civicAddress() throws Exception {

        String content = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/correctAddressRequest.json").toURI())));

        MvcResult result = this.mockMvc.perform(
            post("/address/validation/civic").content(content).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(document("civicAddressValidation",
                preprocessRequest(
                    prettyPrint()),
                responseFields(
                    fieldWithPath("message").description("Civic address validation API Service Status message"),
                    fieldWithPath("code").description("Civic address validation API Service Status Code")
                )))
            .andReturn();
        ObjectMapper responseObject = new ObjectMapper();
        Response<Address> response = responseObject.readValue(result.getResponse().getContentAsString(), Response.class);
        assertThat(StatusCode.E200.getCode().equals(response.getCode()));
        assertThat(StatusCode.E200.getMessage().equals(response.getMessage()));
    }

    @Test
    @WithMockUser(username = "jbeginsamuel@gmail.com", roles = {"USER"})
    public void postalAddress() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/correctAddressRequest.json").toURI())));
        MvcResult result = this.mockMvc.perform(
            post("/address/validation/postal").content(content).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(document("postalAddressValidation",
                preprocessRequest(
                    prettyPrint()),
                responseFields(
                    fieldWithPath("message").description("Postal address validation API Service Status Message"),
                    fieldWithPath("code").description("Postal address validation API Service Status Code")
                )))
            .andReturn();
        ObjectMapper responseObject = new ObjectMapper();
        Response<Address> response = responseObject.readValue(result.getResponse().getContentAsString(), Response.class);
        assertThat(StatusCode.E200.getCode().equals(response.getCode()));
        assertThat(StatusCode.E200.getMessage().equals(response.getMessage()));
    }

    @Test
    @WithMockUser(username = "jbeginsamuel@gmail.com", roles = {"USER"})
    public void invalidCivicAddress() throws Exception {
        String content = "{}";
        MvcResult result = this.mockMvc.perform(
            post("/address/validation/civic").content(content).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andDo(document("invalidCivicAddress",
                preprocessRequest(
                    prettyPrint()),
                responseFields(
                    fieldWithPath("content").description("Invalid civic address validation API Service Status content"),
                    fieldWithPath("fieldStatus").description("Invalid civic address validation API Service Status fieldStatus"),
                    fieldWithPath("message").description("Invalid civic address validation API Service Status message"),
                    fieldWithPath("code").description("Invalid civic address validation API Service Status code")
                )))
            .andReturn();
        ObjectMapper responseObject = new ObjectMapper();
        Response<Address> response = responseObject.readValue(result.getResponse().getContentAsString(), Response.class);
        assertThat(StatusCode.E400.getCode().equals(response.getCode()));
        assertThat(StatusCode.E400.getMessage().equals(response.getMessage()));
    }

    @Test
    @WithMockUser(username = "jbeginsamuel@gmail.com", roles = {"USER"})
    public void invalidRequestUrl() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/correctAddressRequest.json").toURI())));
        MvcResult result = this.mockMvc.perform(
            post("/address/validation/post").content(content).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andDo(document("invalidRequestedUrl",
                preprocessRequest(
                    prettyPrint()),
                responseFields(
                    fieldWithPath("message").description("invalid Requested url for address validation API Service Status Message"),
                    fieldWithPath("code").description("invalid Requested url for address validation API Service Status Code")
                )))
            .andReturn();
        ObjectMapper responseObject = new ObjectMapper();
        Response<Address> response = responseObject.readValue(result.getResponse().getContentAsString(), Response.class);
        assertThat(StatusCode.E400.getCode().equals(response.getCode()));
        assertThat(StatusCode.E400.getMessage().equals(response.getMessage()));
    }

    @Test
    @WithMockUser(username = "jbeginsamuel@gmail.com", roles = {"USER"})
    public void validateTpyeParamNotProvided() throws Exception {
        String content = new String("{}");
        MvcResult result = this.mockMvc.perform(
            post("/address/validation/null").content(content).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andReturn();
        ObjectMapper responseObject = new ObjectMapper();
        Response<Address> response = responseObject.readValue(result.getResponse().getContentAsString(), Response.class);
        assertThat(StatusCode.E400.getCode().equals(response.getCode()));
        assertThat(StatusCode.E400.getMessage().equals(response.getMessage()));
    }


}




