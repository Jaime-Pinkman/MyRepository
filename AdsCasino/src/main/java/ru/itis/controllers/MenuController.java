package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Auth;
import ru.itis.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/CasinoBar")
public class MenuController{

    @Autowired
    private UsersService usersService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new ModelAndView("CasinoBar");
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_id")) {
                    String cookieValue = cookie.getValue();
                    Auth auth = usersService.findTheLastAuth();
                    Long user_id = auth.getUser().getId();
                    if (user_id.equals(Long.valueOf(cookieValue)) && user_id == 3) {
                        resp.getWriter().write("admin");
                    }

                }
            }
        }
    }
}
