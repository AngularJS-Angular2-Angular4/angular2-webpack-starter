package com.centurylink.pctl.mod.ui.controllers.web;

import com.centurylink.pctl.mod.core.model.user.LoggedUser;
import com.centurylink.pctl.mod.core.model.user.LoggedUserAuthority;
import com.centurylink.pctl.mod.core.utils.Response;
import com.centurylink.pctl.mod.core.utils.StatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakthivel-s on 31-10-2016.
 */
@Service
public class PctlApiUserService {

  private RestTemplate restTemplate;

  @Autowired
  public PctlApiUserService(@LoadBalanced RestTemplate normalRestTemplate) {
    this.restTemplate = normalRestTemplate;
  }


  public Response getAuthenticatedUser(HttpServletRequest request,
                                   HttpServletResponse response) {
    Response msg = new Response();
    HttpSession session =request.getSession();
    SecurityContext context = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
    if(context== null) {
      msg.setStatus(StatusCode.U403);
      return msg;
    }
    else{
      String username;
      msg.setStatus(StatusCode.E200);
      Authentication auth = context.getAuthentication();
      username = auth.getPrincipal().toString();
      HttpHeaders headers = new HttpHeaders();
      headers.add("username", username);
      headers.add("email", username);
      headers.add("x-Authorization", request.getHeader("x-Authorization"));
      HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
      ResponseEntity<LoggedUser> responseEntity = restTemplate.exchange("http://user-service/auth/user/me", HttpMethod.GET, entity, LoggedUser.class);
      if(responseEntity.getBody()==null){
        msg.setStatus(StatusCode.U403);
        return msg;
      }
      msg.setContent( responseEntity.getBody());
      return msg;
    }
  }


  public Response getLoginFromUser (HttpServletRequest request,
                                     HttpServletResponse response) {
    Response msg = new Response();
    ObjectMapper mapper = new ObjectMapper();
    HttpHeaders headers = new HttpHeaders();
    if(request.getHeader("username")== null){
      msg.setStatus(StatusCode.U401);
      return msg;
    }
    headers.add("username", request.getHeader("username"));
    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
    ResponseEntity<LoggedUser> responseEntity = restTemplate.exchange("http://user-service/auth/user/find", HttpMethod.GET, entity, LoggedUser.class);
    if(responseEntity.getBody()==null){
      msg.setStatus(StatusCode.U402);
      return msg;
    }
    LoggedUser resp = responseEntity.getBody();
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
   for(LoggedUserAuthority role: resp.getAuthorities()){
     authorities.add(new SimpleGrantedAuthority(role.getName()));
   }
    SecurityContext context = SecurityContextHolder.createEmptyContext();

    HttpSession session = request.getSession();

    Authentication authentication = new UsernamePasswordAuthenticationToken(resp.getEmail(),
      null, authorities);
    context.setAuthentication(authentication);
    session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);
    SecurityContextHolder.setContext(context);
    msg.setStatus(StatusCode.U200);
    msg.setContent("User Logged Successfully ");
     return msg;
  }


  public Response logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Response msg = new Response();
    String name = "no user found";
    HttpSession session = request.getSession();
    SecurityContext context = SecurityContextHolder.getContext();
    context = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
    if(context!= null) {

      Authentication auth = context.getAuthentication();
      name = auth.getPrincipal().toString();
      if (auth != null) {
        new SecurityContextLogoutHandler().logout(request, response, auth);
        msg.setStatus(StatusCode.U200);
        msg.setContent("User Logged Out Successfully ");
        return msg;
           }
    }
    msg.setStatus(StatusCode.U402);
    return msg;
  }

}
