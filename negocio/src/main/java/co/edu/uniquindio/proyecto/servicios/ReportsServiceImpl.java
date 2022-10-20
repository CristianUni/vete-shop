package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ReportProductDto;
import co.edu.uniquindio.proyecto.repositorio.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportsServiceImpl implements ReportsService{

    private final ProductRepo productRepo;

    public ReportsServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ReportProductDto> getReportProducts() {
        List<Object[]> reports = productRepo.getReportProduct();
        List<ReportProductDto> list = new ArrayList<>();
        reports.forEach(objects -> {list.add(new ReportProductDto(objects[0].toString(),Integer.parseInt(objects[1].toString()),Double.parseDouble(objects[2].toString()),Integer.parseInt(objects[3].toString())));});
        return list;
    }
}
