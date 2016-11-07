

package com.centurylink.pctl.mod.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PctlUserApplication.class )
@WebAppConfiguration
public class PctlUserTest {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;


    @Autowired
    private Filter springSecurityFilterChain;

    @Autowired
    private ObjectMapper objectMapper;
    private MockMvc mockmvc1;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(documentationConfiguration(this.restDocumentation))
            .alwaysDo(print())
            .build();
        this.mockmvc1 = MockMvcBuilders
            .webAppContextSetup(context).apply(documentationConfiguration(this.restDocumentation)).addFilters(springSecurityFilterChain)
            .defaultRequest(get("/auth/token/generate")).alwaysDo(print())
            .build();

    }

    @Test
    public void postsWithUser() throws Exception {
    /*    ResultActions auth = this.mockMvc.perform(
            get("/auth/user/login").header("username", "gmail@gmail.com"));


        MvcResult result = auth.andReturn();

        MockHttpSession session = (MockHttpSession) result.getRequest().getSession();

        RequestBuilder echoUserReq = MockMvcRequestBuilders.get("/auth/user/me").session(session);*/

     /*   ResultActions auth = this.mockMvc.perform(
            get("/auth/user/me").header("username", "gmail@gmail.com"));*/

        ResultActions resultActions = this.mockMvc.perform(
            get("/auth/user/me").header("username", "gmail@gmail.com"))
            .andExpect(status().isOk())
            .andDo(document("Generated-Token",
                preprocessRequest(
                    prettyPrint()),
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("id").description("Content ID"),
                    fieldWithPath("login").description("Login"),
                    fieldWithPath("firstName").description("First Name"),
                    fieldWithPath("lastName").description("Last Name"),
                    fieldWithPath("password").description("Last Name"),
                    fieldWithPath("authToken").description("authToken"),
                    fieldWithPath("email").description("Email"),
                    fieldWithPath("activated").description("User Activation Detail"),
                    fieldWithPath("authorities[].name").description("Role"),
                    fieldWithPath("cartHist[].shoppingCartId").description("shoppingCartId"),
                    fieldWithPath("cartHist[].cartItemCount").description("cartItemCount"),
                    fieldWithPath("cartHist[].cartStatus").description("cartStatus"),
                    fieldWithPath("cartInfo.shoppingCartId").description("current shoppingCartId"),
                    fieldWithPath("cartInfo.cartItemCount").description("current cartItemCount"),
                    fieldWithPath("cartInfo.cartStatus").description("current cartStatus")
                )));
    }

    @Test

    public void postToken() throws Exception {

        mockmvc1.perform(
            get("/auth/token/generate").header("username", "gmail@gmail.com"))
            .andExpect(status().isOk())
            .andDo(print())
            .andDo(document("token-raw",
                preprocessRequest(
                    prettyPrint()),
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("token").description("token"),
                    fieldWithPath("refreshToken").description("refreshToken")
                )));


    }

}



