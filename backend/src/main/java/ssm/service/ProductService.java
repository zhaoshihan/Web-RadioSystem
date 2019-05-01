package ssm.service;
import org.springframework.stereotype.Service;
import ssm.entity.Product;
import ssm.dao.IProductDao;

import javax.annotation.Resource;
import java.util.List;

@Service("ProductService")
public class ProductService implements IProductService{
    @Resource
    private IProductDao productDao;

    @Override
    public Product getProductById(int id){
        return productDao.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }
}
