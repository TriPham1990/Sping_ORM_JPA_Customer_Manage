package tri.lo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import tri.lo.model.Product;
import tri.lo.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/create-product")
    public ModelAndView showCreateProduct(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView saveNewProduct(@ModelAttribute Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView showListProduct(){
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("list_product");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditProduct(@PathVariable long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/update-product")
    public ModelAndView editProduct(@ModelAttribute Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteProduct(@PathVariable long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/products")
    public ModelAndView deleteProduct(@ModelAttribute Product product){
        productService.remove(product.getId());
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("list_product");
        modelAndView.addObject("products", products);
        modelAndView.addObject("message", "Product delete successfully");
        return modelAndView;
    }
}
