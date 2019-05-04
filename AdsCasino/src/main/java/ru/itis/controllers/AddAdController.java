package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Auth;
import ru.itis.models.Product;
import ru.itis.services.ProductsService;
import ru.itis.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@RequestMapping(value = "/addAd")
@Controller
public class AddAdController {


    @Autowired
    private ProductsService productsService;
    @Autowired
    private UsersService usersService;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_id")) {
                    String cookieValue = cookie.getValue();
                    Auth auth = usersService.findTheLastAuth();
                    Long user_id = auth.getUser().getId();
                    if (!(user_id.equals(Long.valueOf(cookieValue)) && user_id == 3)) {
                        response.sendRedirect("/catalog");
                    }

                }
            }
        }
        return new ModelAndView("addAd");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = Product.builder()
                .product_id(Long.valueOf(req.getParameter("product_id")))
                .title(req.getParameter("title"))
                .xp(Long.valueOf(req.getParameter("xp")))
                .price(Long.valueOf(req.getParameter("price")))
                .image(req.getParameter("image"))
                .build();
        productsService.addAd(product);
        return "redirect:/addAd";
    }
}