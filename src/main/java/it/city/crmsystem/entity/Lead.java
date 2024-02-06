package it.city.crmsystem.entity;

import it.city.crmsystem.auditing.LeadListener;
import it.city.crmsystem.entity.enums.LeadStatus;
import it.city.crmsystem.entity.enums.WeekdayEnum;
import it.city.crmsystem.entity.template.AbsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(LeadListener.class)
@Entity
public class Lead extends AbsEntity {//Shahzodbek

    private String studentName;

    private String phoneNumber;

    @ManyToOne
    private User admin;

    @ManyToOne
    private Category category;

    private String color;//yangi lid 24 soat ichida statusi uzgarmasa ogohlantirish kerak

    @Enumerated(EnumType.STRING)
    private WeekdayEnum weekdayEnum;

    @ManyToOne
    private AwareType awareType;//nima orqali kelganligi

    @ManyToOne
    private LeadGroup leadGroup;

    @Enumerated(EnumType.STRING)
    private LeadStatus leadStatus;


}
