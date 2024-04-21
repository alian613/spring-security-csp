package com.alian.demo.configuration;

import com.alian.security.csp.nonce.CspNonceRepository;
import com.alian.security.csp.nonce.CspNonceToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CspNonceInterceptor implements HandlerInterceptor {

    @Autowired
    CspNonceRepository cspNonceRepository;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if (modelAndView == null) {
            return;
        }

        CspNonceToken cspNonceToken = cspNonceRepository.loadToken(request);
        if (cspNonceToken == null) {
            return;
        }

        modelAndView.addObject("_csp_nonce", cspNonceToken.token());
    }
}
