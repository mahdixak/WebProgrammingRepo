package edu.webclass.restapi.Product.Management.System.controllers;

import edu.webclass.restapi.Product.Management.System.models.Product;
import edu.webclass.restapi.Product.Management.System.models.dto.ProductDto;
import edu.webclass.restapi.Product.Management.System.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<ProductDto> listAllProducts(){
        return productService.findAllProducts().stream().map(product -> new ProductDto(product)).toList();
    }

    @PostMapping("/add")
    public boolean addProduct(@RequestHeader("name") String title,@RequestHeader String brand,@RequestHeader int price){
        return productService.addProduct(title,brand,price);
    }

    //added function to the original code here :
    @GetMapping("/{id}")
    public Product productDetail(@PathVariable String id) throws FileNotFoundException {
        Product product = productService.findProductWithId(id);
        if (product!=null)
            return product;
        else
            throw new FileNotFoundException();
    }
}
