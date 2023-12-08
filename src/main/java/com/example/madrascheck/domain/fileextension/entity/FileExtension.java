package com.example.madrascheck.domain.fileextension.entity;

import com.example.madrascheck.domain.fileextension.model.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "file_extension")
@Entity
public class FileExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public FileExtension(String name, Status status) {
        this.name = name;
        this.status = status;
    }

}