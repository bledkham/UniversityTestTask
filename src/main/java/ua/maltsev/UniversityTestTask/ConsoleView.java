package ua.maltsev.UniversityTestTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.maltsev.UniversityTestTask.services.ConsoleHelper;
import ua.maltsev.UniversityTestTask.services.UniversityService;

@Component
public class ConsoleView {

    private UniversityService universityService;

    @Autowired
    public ConsoleView(UniversityService universityService) {
        this.universityService = universityService;
    }

    public void start(){
        ConsoleHelper.writeMessage("\n\n\nWelcome to University Informational System!\n\n");


        ConsoleHelper.writeMessage("Available commands: \n\n"
                + "1  - Who is head of department?\n"
                + "2  - Show department statistics\n"
                + "3  - Show the average salary for the department\n"
                + "4  - Show count of employers for the department\n"
                + "5  - Global search by template\n"
                + "6  - Exit\n");
        while (true) {
            ConsoleHelper.writeMessage("\n\nPlease, enter the command number:");

            int selectedCommand = ConsoleHelper.readInt();
            if(selectedCommand == 1){
                ConsoleHelper.writeMessage("Please, enter the department name:");
                universityService.showHeadOfDepartment(ConsoleHelper.readString());
            }else if(selectedCommand == 2){
                ConsoleHelper.writeMessage("Please, enter the department name:");
                universityService.showDepartmentStatistic(ConsoleHelper.readString());
            }else if(selectedCommand == 3){
                ConsoleHelper.writeMessage("Please, enter the department name:");
                universityService.showAverageSalaryByDepartment(ConsoleHelper.readString());
            }else if(selectedCommand == 4){
                ConsoleHelper.writeMessage("Please, enter the department name:");
                universityService.showCountOfEmployersByDepartment(ConsoleHelper.readString());
            }else if(selectedCommand == 5){
                ConsoleHelper.writeMessage("Please, enter the template for search:");
                universityService.showLectorsNameFromTemplate(ConsoleHelper.readString());
            }else if(selectedCommand == 6){
                ConsoleHelper.writeMessage("Good bay!\n\n");
                break;
            }else {
                ConsoleHelper.writeMessage("Please, enter the correct number!");
            }
        }
    }
}
