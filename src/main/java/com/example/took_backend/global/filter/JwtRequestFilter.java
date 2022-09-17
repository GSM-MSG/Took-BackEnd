package com.example.took_backend.global.filter;

import com.example.took_backend.global.exception.exceptionCollection.TokenNotVaildException;
import com.example.took_backend.global.security.jwt.TokenProvider;
import com.example.took_backend.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;
    private final JwtProperties jwtProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String accessToken = request.getHeader("Authorization");
            if(accessToken != null) {
                tokenProvider.extractAllClaims(accessToken, jwtProperties.getAccessSecret());
                /*if (!tokenProvider.getTokenType(accessToken, jwtProperties.getAccessSecret()).equals("accessToken")) {
                    throw new TokenNotVaildException("Token is not valid");
                }*/
                String email = tokenProvider.getUserEmail(accessToken, jwtProperties.getAccessSecret());
                registerSecurityContext(request, email);
            }
            filterChain.doFilter(request, response);
    }

    private void registerSecurityContext(HttpServletRequest request, String email) {
        UsernamePasswordAuthenticationToken authenticationToken = tokenProvider.authentication(email);
        // SecurityContextHolder는 보안 주체 세부 정보 응용프로그램의 현재 보안 컨텍스트 에 대한 정보가 저장됨
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
