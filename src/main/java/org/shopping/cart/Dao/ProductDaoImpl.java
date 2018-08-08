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

    @Override
    public Collection<Product> getProductByBrand(String brand){
        final String sql = "SELECT * FROM product WHERE brand = ?";
        List<Product> product = jdbcTemplate.query(sql, new ProductRowMapper(), brand);
        return product;
    }

    @Override
    public Collection<Product> getProductByType(String type){
        final String sql = "SELECT * FROM product WHERE type = ?";
        List<Product> product = jdbcTemplate.query(sql, new ProductRowMapper(), type);
        return product;
    }

    @Override
    public void insertProduct(Product product){
        final String sql = "INSERT INTO product (name, type, brand, price) VALUES (?, ?, ?, ?)";
        final String sqlGet = "INSERT INTO product (name, type, brand, price) VALUES (?, ?, ?, ?)";
        final String name = product.getName();
        final String type = product.getType();
        final String brand = product.getBrand();
        final int price = product.getPrice();
        jdbcTemplate.update(sql, new Object[]{name, type, brand, price});
    }

    @Override
    public Collection<Product> getProductByPrice(String high, String low){
        final String sql = "SELECT * FROM product WHERE price BETWEEN ? and ?";
        List<Product> product = jdbcTemplate.query(sql, new ProductRowMapper(), high, low);
        return product;
    }
}
