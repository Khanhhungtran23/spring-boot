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
@Table(name = "course_program")
public class CourseProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseProgramID;

    @ManyToOne
    @JoinColumn(name = "courseid", nullable = false)  // Liên kết với bảng Course
    private Course course;

    @ManyToOne
    @JoinColumn(name = "programid", nullable = false)  // Liên kết với bảng Program
    private Program program;

    @Column(nullable = false, length = 255)
    private String courseCode;  // Mã khóa học (course_code)

    @Column(nullable = false)
    private Integer courseTypeId;  // Loại khóa học (course_type_id)

    @Column(nullable = false)
    private Integer year;  // Năm học hoặc năm tham gia chương trình
}
