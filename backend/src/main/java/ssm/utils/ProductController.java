package ssm.utils;
import ssm.entity.Product;
import ssm.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping("/findProduct")
    public String findProduct(Model model){
        int id = 1;
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "index";
    }
}
