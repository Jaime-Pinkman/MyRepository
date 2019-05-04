package ru.itis.services;

import ru.itis.forms.SignInForm;
import ru.itis.forms.SignUpForm;
import ru.itis.models.Auth;
import ru.itis.models.User;

import java.util.Optional;

/**
 * 25.10.2018
 * UsersService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    void signUp(SignUpForm form);

    Optional<String> signIn(SignInForm form);

    boolean isExistByCookie(String cookieValue);
    String findIdByName(String name);
    User findUserById(Long id);
    void updateUserXp(Long id, Integer xp);
    Auth findAuthById(Long id);
    Auth findTheLastAuth();
    void updateUserIndex(Long id, Integer index, Integer xp);

}