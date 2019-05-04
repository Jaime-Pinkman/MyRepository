package ru.itis.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.SignInForm;
import ru.itis.forms.SignUpForm;
import ru.itis.models.Auth;
import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * 25.10.2018
 * UsersServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AuthRepository authRepository;


    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .name(form.getName())
                .passwordHash(encoder.encode(form.getPassword()))
                .age(form.getAge())
                .xp(0)
                .index(0)
                .build();
        System.out.println(user);
        usersRepository.save(user);
    }

    @Override
    public Optional<String> signIn(SignInForm form) {
        Optional<User> userCandidate = usersRepository.findByName(form.getName());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if (encoder.matches(form.getPassword(), user.getPasswordHash())) {
                String cookieValue = UUID.randomUUID().toString();

                Auth auth = Auth.builder()
                        .user(user)
                        .cookieValue(cookieValue)
                        .build();

                authRepository.save(auth);
                return Optional.of(cookieValue);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        if (authRepository.findByCookieValue(cookieValue) != null) {
            return true;
        }
        return false;
    }
    @Override
    public String findIdByName(String name) {
        return String.valueOf(usersRepository.findByName(name).get().getId());
    }

    @Override
    public User findUserById(Long id) {
        return usersRepository.find(id).get();
    }

    @Override
    public void updateUserXp(Long id, Integer xp) {
        User user = User.builder()
                .id(id)
                .xp(xp)
                .build();
        usersRepository.update(user);
    }
    @Override
    public void updateUserIndex(Long id, Integer index, Integer xp) {
        User user = usersRepository.find(id).get();
        user.setIndex(user.getIndex() + index);
        user.setXp(user.getXp() + xp);
        usersRepository.update_index(user);
    }

    @Override
    public Auth findAuthById(Long id) {
        return authRepository.findByUserId(id).get();
    }

    @Override
    public Auth findTheLastAuth() {
        return authRepository.findTheLast().get();
    }
}