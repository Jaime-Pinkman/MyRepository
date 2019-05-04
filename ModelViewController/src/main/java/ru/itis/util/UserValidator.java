package ru.itis.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import ru.itis.dao.UserDAO;
import ru.itis.model.User;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDAO userDAO;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if(userDAO.getOne(user.getEmail()) != null) {
            errors.rejectValue("email", "", "This email is already taken");
        }

    }
}
