package com.example.madrascheck.domain.fileextension.entity;

import com.example.madrascheck.domain.fileextension.model.Status;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "file_extension")
@Entity
public class FileExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public FileExtension(String name, Status status) {
        this.name = name;
        this.status = status;
    }

}