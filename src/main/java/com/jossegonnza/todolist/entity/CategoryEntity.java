package com.jossegonnza.todolist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
        name = "tbl_categories"
)
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL
    )
    private List<TaskEntity> tasks = new ArrayList<>();
}
