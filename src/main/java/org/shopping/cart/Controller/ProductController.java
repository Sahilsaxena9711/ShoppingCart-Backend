package org.shopping.cart.Controller;

import org.shopping.cart.Entity.Product;
import org.shopping.cart.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Product> getAllProduct(){
        return productService.getAllProduct();
    }

}
