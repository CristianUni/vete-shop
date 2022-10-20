package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Category;
import co.edu.uniquindio.proyecto.entidades.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class ProductDTO implements Serializable {

    public ProductDTO(String nameProduct, String description, Integer quantityProduct, double price) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantityProduct = quantityProduct;
        this.price = price;
    }

    private String nameProduct;

    private String description;

    private Integer quantityProduct;

    private double price;

    List<String> urlPhotos;

    List<String> categoryList;

    public void setUrlPhotos(List<ProductImage> productImages){
        this.urlPhotos = new ArrayList<>();
        productImages.forEach(productImage -> {
            this.urlPhotos.add(productImage.getUrl());
        });
    }

    public void setCategoryList(List<Category> categories){
        this.categoryList = new ArrayList<>();
        categories.forEach(category -> {
            this.categoryList.add(category.getDescription());
        });
    }

}
