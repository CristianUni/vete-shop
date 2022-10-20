package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ProductDTO;
import co.edu.uniquindio.proyecto.entidades.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDTO product);

    List<ProductDTO> getAllProductsOrderByName (Pageable pageable);
}
