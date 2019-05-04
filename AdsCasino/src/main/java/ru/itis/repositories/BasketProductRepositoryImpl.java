package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.Basket;
import ru.itis.models.BasketProduct;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class BasketProductRepositoryImpl implements BasketProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //language=SQL
    private static final String SQL_INSERT =
            "insert into basket_product(basket_id, product_id) values (?, ?)";
    //language=SQL
    private static final String SQL_SELECT_BY_BASKET_ID =
            "select basket_product.id, basket_product.product_id, basket_product.basket_id, basket.id as b_id, " +
                    "  product.product_id, product.image from basket_product join basket on basket_product.basket_id = basket.id " +
                    " join product on basket_product.product_id = product.product_id where basket_id = ?";



    public BasketProductRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<BasketProduct> basketProductRowMapper = (resultSet, i) -> BasketProduct.builder()
            .id(resultSet.getLong("id"))
            .product(Product.builder()
                    .product_id(resultSet.getLong("product_id"))
                    .image(resultSet.getString("image"))
                    .build())
            .basket(Basket.builder()
                        .id(resultSet.getLong("b_id"))
                        .build())
            .build();

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(BasketProduct model) {
        jdbcTemplate.update(SQL_INSERT, model.getBasket().getId(),
                model.getProduct().getProduct_id());
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(BasketProduct model) {

    }

    @Override
    public List<BasketProduct> findAllByBasketId(Long id) {
        return jdbcTemplate.query(SQL_SELECT_BY_BASKET_ID, basketProductRowMapper, id);
    }
}
