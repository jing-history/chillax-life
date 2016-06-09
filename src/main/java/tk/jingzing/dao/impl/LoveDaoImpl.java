package tk.jingzing.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tk.jingzing.dao.LoveDao;
import tk.jingzing.entity.Love;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wangyunjing on 16/6/9.
 */
public class LoveDaoImpl implements LoveDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Love getMyLove() {
        String sql = "select * from love limit 1";
        return (Love) jdbcTemplate.query(sql, new RowMapper<Love>() {
            @Override
            public Love mapRow(ResultSet resultSet, int i) throws SQLException {
                Love love = new Love();
                love.setId(resultSet.getInt("id"));
                love.setFirst_time(resultSet.getTimestamp("first_time"));
                return  love;
            }
        });
    }
}
