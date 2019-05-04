package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.services.ProductsService;
import ru.itis.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/ads")
@Controller
public class AdsController{

    @Autowired
    private ProductsService productsService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return new ModelAndView("ads");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ArrayList> doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        List<Product> products = productsService.allAds();
        Integer count = 0;
        User user = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user_id")) {
                        String cookieValue = cookie.getValue();
                        if (!productsService.isExistByUserId(cookie.getValue())) {
                            productsService.createBasket(cookie.getValue());
                        }
                        usersService.updateUserIndex(Long.valueOf(cookieValue), 1, 20);
                        user = usersService.findUserById(Long.valueOf(cookieValue));
                        count = user.getIndex();
                        productsService.addProductToUserBasket(cookieValue, products.get(--count).getProduct_id());
                    }
                }
            }
            Integer xp = user.getXp();
            ArrayList list = new ArrayList();
            list.add(products.get(count).getImage());
            list.add(xp);

            return ResponseEntity.ok(list);
        }
}
