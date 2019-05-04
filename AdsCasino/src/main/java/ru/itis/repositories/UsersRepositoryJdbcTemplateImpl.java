package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


@Component
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    public static final String SQL_SELECT_USER_BY_ID =
            "select * from shop_user where id = ?";
    //language=SQL
    public static final String SQL_UPDATE_USER_BY_ID =
            "update shop_user set xp = xp + ? where id = ?";
    //language=SQL
    public static final String SQL_UPDATE_USER_INDEX_BY_ID =
            "update shop_user set (name, password_hash, age, xp, index) = (?, ?, ?, ?, ?) where id = ?";
    //language=SQL
    private static final String SQL_SELECT_ALL_USERS =
            "select * from shop_user";
    //language=SQL
    private static final String SQL_INSERT =
            "insert into shop_user(name, password_hash, age, xp, index) values (?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_NAME =
            "select * from shop_user where name = ?";
    public RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .passwordHash(resultSet.getString("password_hash"))
            .xp(resultSet.getInt("xp"))
            .index(resultSet.getInt("index"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }

    @Override
    public Optional<User> find(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID,
                    userRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(User model) {
        try {
            jdbcTemplate.update(SQL_INSERT, model.getName(), model.getPasswordHash(), model.getAge(), 0, 0);
        } catch (Exception e){
            System.out.println("хйн");
        }
    }

    @Override
    public void delete(Long id) {

    }
    @Override
    public void update_index(User model) {
        jdbcTemplate.update(SQL_UPDATE_USER_INDEX_BY_ID,  model.getName(), model.getPasswordHash(),
                model.getAge(), model.getXp(), model.getIndex(), model.getId());
    }

    @Override
    public void update(User model) {
        jdbcTemplate.update(SQL_UPDATE_USER_BY_ID, model.getXp(), model.getId());
    }

    @Override
    public Optional<User> findByName(String name) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, userRowMapper, name));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}
