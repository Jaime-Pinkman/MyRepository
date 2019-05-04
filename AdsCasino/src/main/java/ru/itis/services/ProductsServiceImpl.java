package ru.itis.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Basket;
import ru.itis.models.BasketProduct;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.repositories.BasketProductRepository;
import ru.itis.repositories.BasketRepository;
import ru.itis.repositories.ProductsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private BasketProductRepository basketProductRepository;

    @Override
    public List<Product> addProductToUserBasket(String cookieValue, Long productId) {
        createBasketProduct(cookieValue, productId);
        return null;
    }
    @Override
    public Boolean isExistByUserId(String cookieValue) {
        if (basketRepository.findBasketIdByUserId(cookieValue).isPresent()) {
            return true;
        }
        return false;
    }
    @Override
    public void createBasket(String cookieValue) {
        basketRepository.save(createUserAndBasket(cookieValue));
    }
    private Basket createUserAndBasket(String cookieValue) {
        User user = User.builder()
                .id(Long.valueOf(cookieValue))
                .build();
        Basket basket = Basket.builder()
                .user(user)
                .build();
        return basket;
    }
    @Override
    public void createBasketProduct(String cookieValue, Long product_id) {
        Product product = Product.builder()
                .product_id(product_id)
                .build();
        Basket basket = basketRepository.findBasketIdByUserId(cookieValue).get();
        BasketProduct basketProduct = BasketProduct.builder()
                .product(product)
                .basket(basket)
                .build();
        basketProductRepository.save(basketProduct);
    }

    @Override
    public List allAds() {
        return productsRepository.findAll();
    }

    @Override
    public List<BasketProduct> findBasketProductByBasketId(String id) {
        Basket basket = basketRepository.findBasketIdByUserId(id).get();
        Long basket_id = basket.getId();
        return basketProductRepository.findAllByBasketId(basket_id);
    }

    @Override
    public void addAd(Product product) {
        productsRepository.save(product);
    }


}
