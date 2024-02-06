package it.city.crmsystem.entity;

import it.city.crmsystem.entity.enums.OperationEnum;
import it.city.crmsystem.entity.template.AbsEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class History extends AbsEntity {

    private UUID leadId;

    @Enumerated(value = EnumType.STRING)
    private OperationEnum operationEnum;

    private String leadStatus;

}
