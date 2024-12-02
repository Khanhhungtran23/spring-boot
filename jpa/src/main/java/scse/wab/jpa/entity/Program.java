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
@Table(name = "program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer programID;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false, length = 4)
    private String version;

    @Column(nullable = false)
    private Integer majorId;

    @Column(nullable = false)
    private Integer programTypeId;

    @Column(nullable = false, length = 255)
    private String validFrom;
}
