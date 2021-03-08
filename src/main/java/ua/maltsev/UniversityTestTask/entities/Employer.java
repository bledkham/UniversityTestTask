package ua.maltsev.UniversityTestTask.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Employer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double salary;

    @Enumerated(EnumType.ORDINAL)
    private Degree degree;

    @OneToOne(mappedBy = "headOfDepartment", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private Department department;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Department> departments;

    public Employer(String name, Double salary, Degree degree) {
        this.name = name;
        this.salary = salary;
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                ", departments=" + departments +
                '}';
    }
}
