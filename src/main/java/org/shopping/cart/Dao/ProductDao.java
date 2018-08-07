package org.shopping.cart.Dao;

import org.shopping.cart.Entity.Product;
import java.util.Collection;

public interface ProductDao {
    public Collection<Product> getAllProduct();
}
