package com.centurylink.pctl.mod.ui.controllers.web;

import com.centurylink.pctl.mod.core.utils.Response;
import com.centurylink.pctl.mod.core.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by sakthivel-s on 31-10-2016.
 *
 */

@Transactional
@RestController
@RequestMapping("/ui")

public class PctlApiUiRestController {

  private PctlApiUserService pctlApiUserService;

  @Autowired
  public PctlApiUiRestController(PctlApiUserService pctlApiUserService) {
    this.pctlApiUserService = pctlApiUserService;
  }

  @RequestMapping(value = "/user/login", method = RequestMethod.GET)
  public Response getloggedUser(HttpServletRequest request,
                            HttpServletResponse response) {
   Response res =  pctlApiUserService.getLoginFromUser(request, response);
       return res;
  }

 @RequestMapping(value = "/user/me", method = RequestMethod.GET)
  public Response getAuthenticatedUser(HttpServletRequest request,
                              HttpServletResponse response) {
   Response user = pctlApiUserService.getAuthenticatedUser(request, response);
    return user;

  }

  @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
  public Response logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Response msg = new Response();
    String name = "no user found";
    HttpSession session = request.getSession();
    SecurityContext context = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
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
