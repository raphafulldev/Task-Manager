package com.raphabarreto.Task_Manager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }


}
