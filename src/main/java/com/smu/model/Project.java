package com.smu.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROJECTS")
public class Project {

    @Id
    private String id;

    private String title;
    private String technology;
    private String goals;
    private String location;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
