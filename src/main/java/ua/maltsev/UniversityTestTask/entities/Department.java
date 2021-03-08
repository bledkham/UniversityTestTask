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
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    private String departmentName;

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private List<Employer> employers;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "head_of_department_id")
    public Employer headOfDepartment;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employers=" + employers +
                ", headOfDepartment=" + headOfDepartment +
                '}';
    }
}
