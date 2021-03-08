package ua.maltsev.UniversityTestTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityTestTaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversityTestTaskApplication.class, args);
	}

	private ConsoleView view;

	@Override
	public void run(String... args) throws Exception {
		view.start();
	}

	@Autowired
	public void setView(ConsoleView view) {
		this.view = view;
	}
}
