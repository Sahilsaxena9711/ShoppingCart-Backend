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

    public Collection<Product> getProductByBrand(String brand) {
        return productDao.getProductByBrand(brand);
    }

    public Collection<Product> getProductByType(String type) {
        return productDao.getProductByType(type);
    }

    public void inserProduct(Product product) {
        this.productDao.insertProduct(product);
    }

    public Collection<Product> getProductByPrice(String high, String low) {
        return productDao.getProductByPrice(high, low);
    }
}
