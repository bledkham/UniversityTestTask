package ua.maltsev.UniversityTestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.maltsev.UniversityTestTask.entities.Department;
import ua.maltsev.UniversityTestTask.services.answers.DepartmentStatisticAnswer;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Long> {
    @Override
    <S extends Department> List<S> saveAll(Iterable<S> iterable);

    List<Department> getDepartmentByDepartmentName(String departmentName);

    @Query("select distinct new ua.maltsev.UniversityTestTask.services.answers.DepartmentStatisticAnswer(e.degree, count(e)) from Department d join d.employers e where d.departmentName= ?1 group by e.degree")
    List<DepartmentStatisticAnswer> receiveEmployersStatisticFromDepartments(String departmentName);

    @Query("select new java.lang.Double(avg(e.salary)) from Department d join d.employers e where d.departmentName= ?1")
    List<Double> receiveAverageSalaryFromDepartment(String departmentName);

    @Query("select new java.lang.Long(count(e)) from Department d join d.employers e where d.departmentName= ?1")
    List<Long> receiveCountOfEmployersFromDepartment(String departmentName);
}
