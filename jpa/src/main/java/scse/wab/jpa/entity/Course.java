package scse.wab.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseID;

    @Column(nullable = false)
    private Integer courseLevelId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String nameVn;

    @Column(nullable = false)
    private Integer creditTheory;

    @Column(nullable = false)
    private Integer creditLab;

    @Lob
    @Column(nullable = true)
    private String description;

    // Optional: If you want to add the mapping to CourseType (if it exists)
    // @ManyToOne
    // @JoinColumn(name = "course_type_id", nullable = false)
    // private CourseType courseType;
}
