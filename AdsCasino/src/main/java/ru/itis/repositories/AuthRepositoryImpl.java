package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.Auth;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Component
public class AuthRepositoryImpl implements AuthRepository {
    //language=SQL
    private static final String SQL_INSERT =
            "insert into auth(user_id, cookie_value) values (?, ?)";
    //language=SQL
    private static final String SQL_SELECT_BY_COOKIE_VALUE =
            "select * from auth where cookie_value = ?";
    //language=SQL
    private static final String SQL_SELECT_BY_USER_ID =
            "SELECT * FROM auth WHERE user_id = ?)";
    //language=SQL
    private static final String SQL_SELECT_THE_LAST =
            "SELECT * FROM auth WHERE id=(SELECT max(id) FROM auth)";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Auth> authRowMapper = new RowMapper<Auth>() {
        @Override
        public Auth mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Auth.builder()
                    .id(rs.getLong("id"))
                    .user(User.builder()
                            .id(rs.getLong("user_id"))
                            .build())
                    .cookieValue(rs.getString("cookie_value"))
                    .build();
        }
    };
    public AuthRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Auth> findByCookieValue(String cookieValue) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_COOKIE_VALUE, authRowMapper, cookieValue));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Auth> findByUserId(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_USER_ID, authRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Auth> findTheLast() {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_THE_LAST, authRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
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
    public void save(Object model) {
        jdbcTemplate.update(SQL_INSERT, ((Auth)model).getUser().getId(), ((Auth)model).getCookieValue());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Object model) {

    }
}
