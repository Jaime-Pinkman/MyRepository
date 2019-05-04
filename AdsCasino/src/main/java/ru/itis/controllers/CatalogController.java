package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.BasketProduct;
import ru.itis.services.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private ProductsService productsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPage() {
        return new ModelAndView("catalog");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<BasketProduct>> doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_id")) {
                    String cookieValue = cookie.getValue();
                    return ResponseEntity.ok(productsService.findBasketProductByBasketId(cookieValue));
                }
            }
        }
        return null;
    }
}
