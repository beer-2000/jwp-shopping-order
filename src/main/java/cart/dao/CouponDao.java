package cart.dao;

import cart.domain.Coupon;
import cart.domain.CouponType;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CouponDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Coupon> rowMapper = (resultSet, rowNum) -> new Coupon(
            resultSet.getLong("id"),
            resultSet.getString("name"),
            CouponType.from(resultSet.getString("type")),
            resultSet.getInt("amount")
    );

    public CouponDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Coupon findById(long couponId) {
        String sql = "SELECT id, name, type, amount FROM coupon WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{couponId}, rowMapper);
    }

    public List<Coupon> findAll() {
        String sql = "SELECT id, name, type, amount FROM coupon";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
