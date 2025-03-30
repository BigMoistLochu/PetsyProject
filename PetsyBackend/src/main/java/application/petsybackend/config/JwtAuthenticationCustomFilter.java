package application.petsybackend.config;

import application.petsybackend.entities.user.User;
import application.petsybackend.services.JwtService;
import application.petsybackend.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationCustomFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final JwtService jwtService;

    public JwtAuthenticationCustomFilter(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if(authHeader == null || authHeader.isBlank()){
            filterChain.doFilter(request,response);
            return;
        }

        String jwtToken = authHeader.substring(7);
        String email_claim = jwtService.getClaim(jwtToken,"email");
        User user = userService.getUserByEmail(email_claim);


        UsernamePasswordAuthenticationToken userTokenToAuth = new UsernamePasswordAuthenticationToken(user.getUsername(),null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(userTokenToAuth);


        filterChain.doFilter(request,response);
    }
}
