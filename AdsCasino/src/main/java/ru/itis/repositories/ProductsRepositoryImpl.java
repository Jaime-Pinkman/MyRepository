package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductsRepositoryImpl implements ProductsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_PRODUCT_BY_ID =
            "select * from product where id = ?";
    //language=SQL
    private static final String SQL_SELECT_PRODUCT_BY_PRODUCT_ID =
            "select * from product where product_id = ?";
    //language=SQL
    private static final String SQL_SELECT_ALL_PRODUCTS =
            "select * from product";
    //language=SQL
    private static final String SQL_INSERT =
            "insert into product(product_id, title, image, price, xp) values (?, ?, ?, ?, ?)";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("id"))
            .product_id(resultSet.getLong("product_id"))
            .title(resultSet.getString("title"))
            .image(resultSet.getString("image"))
            .price(resultSet.getLong("price"))
            .xp(resultSet.getLong("xp"))
            .build();

    public ProductsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productRowMapper);
    }

    @Override
    public Optional find(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_PRODUCT_BY_ID, productRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Product model) {
        jdbcTemplate.update(SQL_INSERT, model.getProduct_id(), model.getTitle(),
                model.getImage(), model.getPrice(),
                model.getXp());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Product model) {

    }

    @Override
    public Optional<Product> findByProductId(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_PRODUCT_BY_PRODUCT_ID, productRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
