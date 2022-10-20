package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@ToString
public class ReportProductDto implements Serializable {

    public ReportProductDto(String productName, Integer cantSell, double totalPrice, Integer cantAvailable) {
        this.productName = productName;
        this.cantSell = cantSell;
        this.totalPrice = totalPrice;
        this.cantAvailable = cantAvailable;
    }

    private String productName;

    private Integer cantSell;

    private double totalPrice;

    private Integer cantAvailable;

}