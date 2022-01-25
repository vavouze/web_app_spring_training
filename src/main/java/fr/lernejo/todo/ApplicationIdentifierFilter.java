package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements javax.servlet.Filter {
    private String uuid;

    public ApplicationIdentifierFilter(){
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ((javax.servlet.http.HttpServletResponse) servletResponse).setHeader("Instance-Id",this.uuid);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
