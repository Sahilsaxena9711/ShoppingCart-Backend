package org.shopping.cart.Dao;

import org.shopping.cart.Entity.Product;
import java.util.Collection;

public interface ProductDao {
    public Collection<Product> getAllProduct();

    public Collection<Product> getProductByBrand(String brand);

    public Collection<Product> getProductByType(String type);

    public void insertProduct(Product product);
}
