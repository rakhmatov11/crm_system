package it.city.crmsystem.entity;

import it.city.crmsystem.entity.enums.LeadStatus;
import it.city.crmsystem.entity.template.AbsNameEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LeadGroup extends AbsNameEntity {

    @Enumerated(EnumType.STRING)
    private LeadStatus leadStatus;

    public LeadGroup(LeadStatus leadStatus,String name){
        this.leadStatus = leadStatus;
        this.setName(name);
    }

}
