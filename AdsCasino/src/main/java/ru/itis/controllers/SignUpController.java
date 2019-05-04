package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.forms.SignUpForm;
import ru.itis.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 25.10.2018
 * SignUpServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequestMapping(value = "/signUp")
@Controller
public class SignUpController {

    @Autowired
    private UsersService usersService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new ModelAndView("signUp");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SignUpForm form = SignUpForm.builder()
                .name(request.getParameter("name"))
                .password(request.getParameter("password"))
                .age(Integer.parseInt(request.getParameter("age")))
                .build();
        System.out.println(form);
        usersService.signUp(form);
        return new ModelAndView("signIn");
    }
}
