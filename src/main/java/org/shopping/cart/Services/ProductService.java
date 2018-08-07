package org.shopping.cart.Services;

import org.shopping.cart.Dao.ProductDao;
import org.shopping.cart.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    
    @Autowired
    @Qualifier("product")
    private ProductDao productDao;
    
    public Collection<Product> getAllProduct(){
        return productDao.getAllProduct();
    }
}
