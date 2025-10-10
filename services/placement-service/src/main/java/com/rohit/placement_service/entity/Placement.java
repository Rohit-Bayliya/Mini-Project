package com.rohit.placement_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "placements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String companyName;

    @NotBlank
    private String role;

    @NotNull
    private Double packageOffered;

    @NotBlank
    private String location;

    @NotNull
    private LocalDateTime applicationDeadline;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    private String status = "OPEN"; // OPEN, CLOSED
}

