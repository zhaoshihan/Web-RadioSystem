package ssm.controller;
import ssm.entity.Product;
import ssm.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(value = "*")
public class ProductRestController {
    @Resource
    IProductService productService;

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product member = this.productService.getProductById(id);
        if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/query/all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> members = productService.getAllProducts();
        if (members.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addProduct(@RequestBody Product product){
        Product productExist = productService.getProductById(product.getId());
        if (productExist != null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        else {
            boolean result = productService.addProduct(product);
            if (result){
                return new ResponseEntity(HttpStatus.OK);
            }
            else{
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity updateProduct(@RequestBody Product product){
        Product productExist = productService.getProductById(product.getId());
        if(productExist != null){
            boolean result = productService.updateProduct(product);
            if (result){
                return new ResponseEntity(HttpStatus.OK);
            }
            else{
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity deleteProduct(@RequestBody Product product){
        Product productExist = productService.getProductById(product.getId());
        if (productExist != null){
            boolean result = productService.deleteProduct(product);
            if(result){
                return new ResponseEntity(HttpStatus.OK);
            }
            else{
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
