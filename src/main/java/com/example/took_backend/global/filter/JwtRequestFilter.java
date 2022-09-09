package com.example.took_backend.global.filter;

import com.example.took_backend.global.exception.ErrorCode;
import com.example.took_backend.global.exception.exceptionCollection.TokenNotVaildException;
import com.example.took_backend.global.security.auth.AuthDetailsService;
import com.example.took_backend.global.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        private final AuthDetailsService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String accessToken = request.getHeader("Authorization");
            if(accessToken != null) {
                tokenProvider.extractAllClaims(accessToken);
                if (tokenProvider.getTokenType(accessToken).equals("accessToken")) {
                    throw new TokenNotVaildException("Token is not valid", ErrorCode.TOKEN_NOT_VALID);
                }
                String email = tokenProvider.getUserEmail(accessToken);
                registerSecurityContext(request, email);
            }
            filterChain.doFilter(request, response);
    }

    private void registerSecurityContext(HttpServletRequest request, String email) {
        UserDetails userDetails = userDetailService.loadUserByUsername(email);
        // SecurityContextHolder는 보안 주체 세부 정보 응용프로그램의 현재 보안 컨텍스트 에 대한 정보가 저장됨
        SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
