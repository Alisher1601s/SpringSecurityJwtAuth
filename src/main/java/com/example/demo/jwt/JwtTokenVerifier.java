package com.example.demo.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifier extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public JwtTokenVerifier(JwtConfig jwtConfig, SecretKey secretKey) {
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationheader=request.getHeader(jwtConfig.getAuthorization());

        String token=authorizationheader.replace(jwtConfig.getTokenPrefix(),"");
        if(Strings.isNullOrEmpty(authorizationheader) || !authorizationheader.startsWith(jwtConfig.getTokenPrefix()))
        {
            filterChain.doFilter(request,response);
            return;
        }
        try
        {
 //           String key="securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecure";

           Jws<Claims> claimsJws= Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
           Claims body=claimsJws.getBody();
           String subject=body.getSubject();
          var authorities=  (List<Map<String, String>> ) body.get("authorities");

          Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet=authorities.stream().map(m->new SimpleGrantedAuthority(m.get("authority"))).collect(Collectors.toSet());
            Authentication authenticaton=new UsernamePasswordAuthenticationToken(
                    subject,null,simpleGrantedAuthoritySet);

            SecurityContextHolder.getContext().setAuthentication(authenticaton);
        }
        catch (JwtException e)
        {
            throw new IllegalStateException(String.format("Token %s can not be truest",token));
        }
        filterChain.doFilter(request,response);
    }
}
