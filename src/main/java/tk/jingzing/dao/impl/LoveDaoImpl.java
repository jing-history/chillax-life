package tk.jingzing.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tk.jingzing.dao.LoveDao;
import tk.jingzing.entity.Love;

/**
 * Created by wangyunjing on 16/6/9.
 */
@Repository
public class LoveDaoImpl implements LoveDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Love getMyLove() {
        String sql = "select * from love WHERE id = ? limit 1";
        return (Love) jdbcTemplate.queryForObject(sql,new Object[]{2},new BeanPropertyRowMapper(Love.class));

        /*return Love jdbcTemplate.queryForObject(sql, new RowMapper<Love>() {
            @Override
            public Love mapRow(ResultSet resultSet, int i) throws SQLException {
                Love love = new Love();
                love.setId(resultSet.getInt("id"));
                love.setFirst_time(resultSet.getTimestamp("first_time"));
                return  love;
            }
        });*/
    }

    @Override
    public void asyncStatus(String status) {
        int type = Integer.valueOf(status);
        String sql = "update love set status = ? where id = ?";
        jdbcTemplate.update(sql,new Object[]{type,2});
    }
}
