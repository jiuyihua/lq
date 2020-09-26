package com.trade.lq.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trade.lq.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * describle :
 * author : huh
 * 2020/9/16 0016
 * 上午 10:16
 */
@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            Object principal = authentication.getPrincipal();
            response.setStatus(200);
            Map<String , Object> map = new HashMap();
            PrintWriter out = response.getWriter();
            map.put("status",200);
            map.put("msg", principal);

        if (principal != null) {
            User user = (User) principal;
            if (user != null) {
                System.out.println("user=" + user.getUserName());
                map.put("user", user.getRealName());
            }
        }
            ObjectMapper om= new ObjectMapper();
            out.write(om.writeValueAsString(map));
            out.flush();
            out.close();

    }
}
