package it.city.crmsystem.auditing;

import it.city.crmsystem.entity.History;
import it.city.crmsystem.entity.Lead;
import it.city.crmsystem.entity.enums.OperationEnum;
import it.city.crmsystem.entity.template.AbsEntity;
import it.city.crmsystem.exception.GenericNotFoundException;
import it.city.crmsystem.repository.HistoryRepository;
import it.city.crmsystem.repository.LeadRepository;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.springframework.context.annotation.Lazy;


public class LeadListener {


    private final HistoryRepository historyRepository;
    private final LeadRepository leadRepository;

    public LeadListener(@Lazy HistoryRepository historyRepository,@Lazy LeadRepository leadRepository) {
        this.historyRepository = historyRepository;
        this.leadRepository = leadRepository;
    }

    @PreUpdate
    public void update(Object object){
        save(object, OperationEnum.UPDATE);
    }

    @PreRemove
    public void remove(Object object){
        save(object,OperationEnum.DELETE);
    }

    public void save(Object object, OperationEnum operationEnum){
        AbsEntity absEntity = (AbsEntity) object;
        Lead lead = leadRepository.findById(absEntity.getId()).orElseThrow(() ->
                GenericNotFoundException.builder().message("lead not found ").statusCode(404).build());
        historyRepository.save(new History(
                absEntity.getId(),
                operationEnum,
                lead.getLeadStatus().name()
        ));
    }

}
