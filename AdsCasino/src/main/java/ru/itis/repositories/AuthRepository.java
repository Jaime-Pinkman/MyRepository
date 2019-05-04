package ru.itis.repositories;

import ru.itis.models.Auth;

import java.util.Optional;

public interface AuthRepository extends CrudRepository {
    Optional<Auth> findByCookieValue(String cookieValue);
    Optional<Auth> findByUserId(Long id);
    Optional<Auth> findTheLast();
}
