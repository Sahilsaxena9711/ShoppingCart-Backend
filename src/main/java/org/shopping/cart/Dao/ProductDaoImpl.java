package org.shopping.cart.Dao;

import org.shopping.cart.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("product")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    private static class ProductRowMapper implements RowMapper<Product>{

        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException{
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setType(resultSet.getString("type"));
            product.setBrand(resultSet.getString("brand"));
            product.setPrice(resultSet.getInt("price"));

            return product;
        }
    }

    @Override
    public Collection<Product> getAllProduct(){
        final String sql = "SELECT * FROM product";
        List<Product> product = jdbcTemplate.query(sql, new ProductRowMapper());
        return product;
    }


}
