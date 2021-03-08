package ua.maltsev.UniversityTestTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.maltsev.UniversityTestTask.entities.Department;
import ua.maltsev.UniversityTestTask.repositories.DepartmentsRepository;
import ua.maltsev.UniversityTestTask.repositories.EmployersRepository;

import java.util.List;
import java.util.Locale;

@Service
public class UniversityService {

    private DepartmentsRepository departmentsRepository;
    private EmployersRepository employersRepository;

    @Autowired
    public UniversityService(DepartmentsRepository departmentsRepository, EmployersRepository employersRepository) {
        this.departmentsRepository = departmentsRepository;
        this.employersRepository = employersRepository;
    }

    public void showHeadOfDepartment(String departmentName){
        List<Department> departments = departmentsRepository.getDepartmentByDepartmentName(departmentName);
        ConsoleHelper.writeMessage(String.format("Head of %s department is %s", departmentName, departments.get(0).getHeadOfDepartment().getName()));
    }

    public void showDepartmentStatistic(String departmentName){
        ConsoleHelper.writeMessage(departmentName + " statistic: ");
        departmentsRepository.receiveEmployersStatisticFromDepartments(departmentName)
                .forEach(x -> ConsoleHelper.writeMessage(String.format("%s - %d"
                        ,x.getDegree().toString().toLowerCase(Locale.ROOT).replace('_', ' ')
                        ,x.getCount())));
    }


    public void showAverageSalaryByDepartment(String departmentName){
        Double avgSalary = departmentsRepository.receiveAverageSalaryFromDepartment(departmentName).get(0);
        ConsoleHelper.writeMessage(String.format("The average salary of %s is %.1f", departmentName, avgSalary));
    }

    public void showCountOfEmployersByDepartment(String departmentName){
        ConsoleHelper.writeMessage("Count of employers at " + departmentName + ":");
        ConsoleHelper.writeMessage(departmentsRepository.receiveCountOfEmployersFromDepartment(departmentName).get(0).toString());
    }

    public void showLectorsNameFromTemplate(String template){
        ConsoleHelper.writeMessage("Found lectors: ");
        employersRepository.getAllByNameContains(template)
        .forEach(x -> ConsoleHelper.writeMessage(x.getName()));
    }

}
