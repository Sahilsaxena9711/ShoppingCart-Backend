package org.shopping.cart.Controller;

import org.shopping.cart.Entity.Product;
import org.shopping.cart.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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

    @RequestMapping(value = "/brand/{brand}", method = RequestMethod.GET)
    public Collection<Product> getProductByBrand(@PathVariable("brand") String brand){ return productService.getProductByBrand(brand); }

    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public Collection<Product> getProductByType(@PathVariable("type") String type) {
        return productService.getProductByType(type);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertProduct(@RequestBody Product product) {
        this.productService.inserProduct(product);
    }


}
