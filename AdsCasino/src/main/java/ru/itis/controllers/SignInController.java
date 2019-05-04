package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.forms.SignInForm;
import ru.itis.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * 25.10.2018
 * SignInServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequestMapping(value = "/signIn")
@Controller
public class SignInController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return new ModelAndView("signIn");
    }

    @RequestMapping(method = RequestMethod.POST)
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignInForm form = SignInForm.builder()
                .name(req.getParameter("name"))
                .password(req.getParameter("password"))
                .build();

        Optional<String> cookieValueCandidate = usersService.signIn(form);
        String cookieIdUser = usersService.findIdByName(req.getParameter("name"));
        if (cookieValueCandidate.isPresent()) {
            Cookie auth = new Cookie("auth", cookieValueCandidate.get());
            Cookie user_id = new Cookie("user_id", cookieIdUser);
            resp.addCookie(user_id);
            resp.addCookie(auth);
            resp.sendRedirect("/CasinoBar");
        } else {
            resp.sendRedirect("/signIn");
        }
    }
}
