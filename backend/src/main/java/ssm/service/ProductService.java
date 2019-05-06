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

    @Override
    public boolean addProduct(Product product){
        return productDao.addProduct(product) > 0;
    }

    @Override
    public boolean updateProduct(Product product){
        return productDao.updateProduct(product) > 0;
    }

    @Override
    public boolean deleteProduct(Product product){
        return productDao.deleteProduct(product) > 0;
    }
}
