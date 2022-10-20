package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ProductDTO;
import co.edu.uniquindio.proyecto.entidades.Category;
import co.edu.uniquindio.proyecto.entidades.Product;
import co.edu.uniquindio.proyecto.entidades.ProductCategory;
import co.edu.uniquindio.proyecto.entidades.ProductImage;
import co.edu.uniquindio.proyecto.repositorio.CategoryRepo;
import co.edu.uniquindio.proyecto.repositorio.ProductCategoryRepo;
import co.edu.uniquindio.proyecto.repositorio.ProductImageRepo;
import co.edu.uniquindio.proyecto.repositorio.ProductRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;
    private final ProductImageRepo productImageRepo;
    private final CategoryRepo categoryRepo;
    private final ProductCategoryRepo productCategoryRepo;

    public ProductServiceImpl(ProductRepo productRepo, ProductImageRepo productImageRepo, CategoryRepo categoryRepo, ProductCategoryRepo productCategoryRepo) {
        this.productRepo = productRepo;
        this.productImageRepo = productImageRepo;
        this.categoryRepo = categoryRepo;
        this.productCategoryRepo = productCategoryRepo;
    }

    @Override
    public Product createProduct(ProductDTO product) {
        Product p = new Product(product.getNameProduct(),product.getDescription(),product.getQuantityProduct(),product.getPrice());
        Product result = productRepo.save(p);
        product.getUrlPhotos().forEach(url -> {
            ProductImage pi = new ProductImage(url,result);
            productImageRepo.save(pi);
        });

        product.getCategoryList().forEach(nameCat -> {
            Category category = categoryRepo.findByName(nameCat);
            ProductCategory productCategory = new ProductCategory(result,category);
            productCategoryRepo.save(productCategory);
        });
        return result;
    }

    @Override
    public List<ProductDTO> getAllProductsOrderByName(Pageable pageable) {

        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> products = productRepo.getAllProductsOrderByName(pageable).getContent();
        products.forEach(product -> {
            List<ProductImage> productImages = productRepo.getProductImageByIdProduct(product.getId());
            List<Category> categories = productRepo.getCategoryByIdProduct(product.getId());

            ProductDTO temp = new ProductDTO(product.getNameProduct(),product.getDescription(),product.getQuantityProduct(),product.getPrice());
            temp.setUrlPhotos(productImages);
            temp.setCategoryList(categories);
            productDTOList.add(temp);

        });

        return productDTOList;
    }
}
