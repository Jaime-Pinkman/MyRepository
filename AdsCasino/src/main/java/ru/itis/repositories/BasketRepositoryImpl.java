package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.Basket;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


@Component
public class BasketRepositoryImpl implements BasketRepository {
    //language=SQL
    private static final String SQL_INSERT =
            "insert into basket(user_id) values (?)";
    //language=SQL
    private static final String SQL_SELECT_FROM_BASKET_AND_USER_BY_USER_ID =
            "select basket.id, basket.user_id, shop_user.id as shop_user_id " +
                    " from basket join shop_user on basket.user_id = shop_user.id where basket.user_id = ?";
    //language=SQL
    private static final String SQL_SELECT_FROM_BASKET_AND_USER_BY_BASKET_ID =
            "select basket.id, basket.user_id, shop_user.id as shop_user_id " +
                    " from basket join shop_user on basket.user_id = shop_user.id where basket.id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    private RowMapper<Basket> basketRowMapper = (resultSet, i) -> Basket.builder()
            .id(resultSet.getLong("id"))
            .user(User.builder()
                    .id(resultSet.getLong("shop_user_id"))
                    .build())
            .build();

    public BasketRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Basket model) {
        jdbcTemplate.update(SQL_INSERT, model.getUser().getId());
    }

    @Override
    public Optional<Basket> findByUserId(String id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject
                    (SQL_SELECT_FROM_BASKET_AND_USER_BY_USER_ID, basketRowMapper, Long.valueOf(id)));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Basket> findBasketIdByUserId(String id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_FROM_BASKET_AND_USER_BY_USER_ID,
                    basketRowMapper, Long.valueOf(id)));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Basket model) {

    }


    @Override
    public Optional<Basket> findById(String id) {

        try {
            return Optional.of(jdbcTemplate.queryForObject
                    (SQL_SELECT_FROM_BASKET_AND_USER_BY_BASKET_ID, basketRowMapper, Long.valueOf(id)));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
