package ua.maltsev.UniversityTestTask.services.answers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.maltsev.UniversityTestTask.entities.Degree;

@Getter
@AllArgsConstructor
public class DepartmentStatisticAnswer {
    private Degree degree;
    private Long count;
}
