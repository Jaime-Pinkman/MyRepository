package ru.itis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.model.User;

import java.util.Collection;
import java.util.List;

@Controller
public class MainController {
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
    public String getUsers(Model model) {
        Collection<User> users = List.of(
                new User("John", "Smith", "js@asd.com"),
                new User("Mike", "Tyson", "mt@asd.com")
        );
        model.addAttribute("users", users);
        return "/users";
    }

}
