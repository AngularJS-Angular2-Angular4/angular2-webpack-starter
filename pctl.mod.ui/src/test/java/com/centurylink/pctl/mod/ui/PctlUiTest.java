package com.centurylink.pctl.mod.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PctlUiApplication.class )
@WebAppConfiguration
public class PctlUiTest {

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
    /*this.mockmvc1 = MockMvcBuilders
      .webAppContextSetup(context).apply(documentationConfiguration(this.restDocumentation)).addFilters(springSecurityFilterChain)
      .defaultRequest(get("/auth/token/generate")).alwaysDo(print())
      .build();*/

  }

  @Test
  public void postsWithUser() throws Exception {
    ResultActions auth = this.mockMvc.perform(
      get("/ui/user/login").header("username", "gmail@gmail.com"));


    MvcResult result = auth.andReturn();

    MockHttpSession session = (MockHttpSession) result.getRequest().getSession();

    RequestBuilder echoUserReq = MockMvcRequestBuilders.get("/ui/user/me").session(session);

    ResultActions resultActions = this.mockMvc.perform(
      echoUserReq)
      .andExpect(status().isOk());
     /* .andDo(document("Generated-Token",
        preprocessRequest(
          prettyPrint()),
        preprocessResponse(prettyPrint()),
        responseFields(
          fieldWithPath("message").description("Message"),
          fieldWithPath("code").description("Message Code"),
          fieldWithPath("content.id").description("Content ID"),
          fieldWithPath("content.login").description("Login"),
          fieldWithPath("content.firstName").description("First Name"),
          fieldWithPath("content.lastName").description("Last Name"),
          fieldWithPath("content.email").description("Email"),
          fieldWithPath("content.activated").description("User Activation Detail"),
          fieldWithPath("content.authorities[].name").description("Role")
        )));*/
  }

  /*@Test

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


  }*/

}

