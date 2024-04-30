package com.thinkdevs.msfitnessPlan.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String suggestion;

    public Suggestion(String category, String suggestion) {
        this.category = category;
        this.suggestion = suggestion;
    }
}
