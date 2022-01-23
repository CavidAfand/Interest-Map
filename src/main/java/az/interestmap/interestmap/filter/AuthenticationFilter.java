package az.interestmap.interestmap.filter;

import az.interestmap.interestmap.constant.SessionStatus;
import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.service.SessionService;
import az.interestmap.interestmap.service.TokenManager;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final TokenManager tokenManager;
    private final SessionService sessionService;

    public AuthenticationFilter(TokenManager tokenManager, SessionService sessionService) {
        this.tokenManager = tokenManager;
        this.sessionService = sessionService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String language = request.getHeader("Accept-Language");
        String token = request.getHeader("Authorization");

        LocaleContextHolder.setLocale(Locale.forLanguageTag(language));

        System.out.println("URI: " + request.getRequestURI());

//        if (request.getRequestURI().contains("/login"))

        if (token != null && !token.trim().isEmpty() &&
                !(request.getRequestURI().equals("/login") || request.getRequestURI().equals("/registration"))) {
            Map<String, String> info = tokenManager.getInfoFromToken(token);
            SessionDTO sessionDTO = sessionService.getSessionBySessionId(info.get("sessionId"));
            if (sessionDTO.getSessionStatus() == SessionStatus.ACTIVE) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(sessionDTO.getUser().getUsername(), null, null);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
