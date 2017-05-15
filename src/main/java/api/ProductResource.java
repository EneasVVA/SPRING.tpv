package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.exceptions.NotFoundProductCodeException;
import controllers.ProductController;
import entities.core.Product;
import wrappers.ProductWrapper;

@RestController
@RequestMapping(Uris.VERSION + Uris.PRODUCTS)
public class ProductResource {

    private ProductController productController;

    @Autowired
    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    // @PreAuthorize("hasRole('ADMIN')or hasRole('MANAGER') or hasRole('OPERATOR')")
    @RequestMapping(value = Uris.CODE, method = RequestMethod.GET)
    public ProductWrapper getProductByCode(@PathVariable(value = "code") String code) throws NotFoundProductCodeException {
        Product product = productController.getProductByCode(code);
        if (product == null) {
            throw new NotFoundProductCodeException("Product code: " + code);
        }
        return new ProductWrapper(product);
    }

}
