package application.petsybackend.config;

import application.petsybackend.entities.User;
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

    public JwtAuthenticationCustomFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.getHeader("Origin"));
        System.out.println(request.getMethod());
        System.out.println(request.getServerName());
//        User user = userService.getUserByUsername("Konrad123");
//        UsernamePasswordAuthenticationToken userTokenToAuth = new UsernamePasswordAuthenticationToken(user.getUsername(), null,user.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(userTokenToAuth);
//        System.out.println("SIEMANKO!!!!");
        filterChain.doFilter(request,response);
    }
}
