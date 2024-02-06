package it.city.crmsystem.entity;

import it.city.crmsystem.entity.template.AbsNameEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category extends AbsNameEntity {

    @Column(nullable = false)
    private double price;//kurs narxi

    @Column(nullable = false)
    private Integer durationTime;//kurs necha daqiqa buladi

    @Column(nullable = false)
    private Integer durationDate; //kurs necha oy bulishi

    private String description;

    @ManyToOne
    private Attachment attachment;



}
