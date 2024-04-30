package com.thinkdevs.msfitnessPlan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "meals")
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

//    @ElementCollection
//    @CollectionTable(name = "nutritional_info", joinColumns = @JoinColumn(name = "meal_id"))
//    @MapKeyColumn(name = "nutrition_name")
//    @Column(name = "nutrition_value")
//    private List<NutritionalInfo> nutritionalInfo;


    @ManyToOne
    @JoinColumn(name = "fitness_plan_id")
    private FitnessPlan fitnessPlan;
}
