package com.centurylink.pctl.mod.core.security.jwt.token;

import com.centurylink.pctl.mod.core.model.user.LoggedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sakthivel-s on 02-11-2016.
 */
@Component
public class UserTokenExtract {

    private final JwtSettings settings;

    private final RestTemplate restTemplate;

    @Autowired
    public UserTokenExtract(JwtSettings settings, @LoadBalanced RestTemplate normalRestTemplate) {
        this.restTemplate = normalRestTemplate;
        this.settings = settings;
    }

    public LoggedUser getUserObject(String request){
      //  String tokenPayload = request.getHeader("authToken");
        String tokenPayload =request;
            RawAccessJwtToken token = new RawAccessJwtToken(tokenPayload);
        Jws<Claims> jwsClaims = token.parseClaims(settings.getTokenSigningKey());
        String subject = jwsClaims.getBody().getSubject();


        HttpHeaders headers = new HttpHeaders();
       // headers.add("authToken", request.getHeader("authToken"));
        headers.add("username", subject);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<LoggedUser> responseEntity = restTemplate.exchange("http://user-service/auth/user/find", HttpMethod.GET, entity, LoggedUser.class);
        LoggedUser user = responseEntity.getBody();

        return user;
    }
}
