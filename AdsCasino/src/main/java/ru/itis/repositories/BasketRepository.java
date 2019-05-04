package ru.itis.repositories;

import ru.itis.models.Basket;

import java.util.Optional;

public interface BasketRepository extends CrudRepository<Basket>{
    Optional<Basket> findById(String id);
    Optional<Basket> findByUserId(String id);
    Optional<Basket> findBasketIdByUserId(String id);
}
