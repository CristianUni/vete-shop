import co.edu.uniquindio.proyecto.BusinessApplication;
import co.edu.uniquindio.proyecto.dto.ProductDTO;
import co.edu.uniquindio.proyecto.entidades.Product;
import co.edu.uniquindio.proyecto.servicios.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = BusinessApplication.class)
@Transactional
public class ProductServiceTest {


    @Autowired
    private ProductService productService;



}
