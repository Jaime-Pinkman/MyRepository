package ru.itis.repositories;

import ru.itis.models.BasketProduct;

import java.util.List;

public interface BasketProductRepository extends CrudRepository<BasketProduct> {
    List<BasketProduct> findAllByBasketId(Long id);
}
