package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Consultation;
import co.edu.uniquindio.proyecto.repositorio.ConsultationRepo;
import org.springframework.stereotype.Service;

@Service
public class ConsultationServiceImpl implements ConsultationService{

    private final ConsultationRepo consultationRepo;

    public ConsultationServiceImpl(ConsultationRepo consultationRepo) {
        this.consultationRepo = consultationRepo;
    }

    @Override
    public Consultation createConsultation(Consultation consultation) {
        return consultationRepo.save(consultation);
    }
}
