package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.dao.UserDAO;
import ru.itis.model.User;
import ru.itis.util.UserValidator;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/view")
    public String view(@RequestParam(value = "name", required = false, defaultValue = "stranger") String name, Model model) {
        model.addAttribute("msg", "Hello " + name);
        return "index";
    }
    @GetMapping("/raw")
    @ResponseBody
    public String raw(){
        return "Raw data";
    }

    @GetMapping("/users")
    public String getUsers(Model model) throws SQLException {

        model.addAttribute("users", userDAO.getAll());
        return "/users";
    }

    @GetMapping("users/new")
    public String getSignUp(Model model){
        model.addAttribute("user", new User());
        return "/sign_up";
    }
    @PostMapping("users/new")
    public String signUp(@ModelAttribute @Valid User user, BindingResult result) throws SQLException {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/sign_up";
        }
        userDAO.add(user);
        return "redirect:/users";
    }

}
