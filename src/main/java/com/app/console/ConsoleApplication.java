package com.app.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.console.services.LectorService;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner
{
	public ConsoleApplication(LectorService lectorService) {
		this.lectorService = lectorService;
	}

	private final LectorService lectorService;

	public static void main(String[] args) {
		SpringApplication.run(ConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Welcome to the Console app");
		System.out.println("Choose a command");
		System.out.println("1 - Who is head of department");
		System.out.println("2 - Show statistic of department");
		System.out.println("3 - Show the average salary for the department");
		System.out.println("4 - Show count of employee");
		System.out.println("5 - Global search");
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int s = Integer.parseInt(scanner.nextLine());
			if (s == 1) {
				System.out.println("Write the name of department");
				String depName = scanner.nextLine();
				String result = lectorService.headOfDepart(depName);
				if(result == null){
					System.out.println("department with this name doesnt exist");
				} else {
					System.out.println(result);
				}
			}
			if(s == 2){
				System.out.println("Write the name of department");
				String stat = scanner.nextLine();
				Integer result1 = lectorService.stat(stat, "ASSISTANT");
				Integer result2 = lectorService.stat(stat, "ASSOCIATE_PROFESSOR");
				Integer result3 = lectorService.stat(stat, "PROFESSOR");
				if(result1 == null || result2 == null || result3 == null){
					System.out.println("department with this name doesnt exist");
				} else {
					System.out.println("Count of assistant - " + result1);
					System.out.println("Count of associate_professor - " + result2);
					System.out.println("Count of professor - " + result3);
				}
			}
			if(s == 3){
				System.out.println("Write the name of department");
				String stat = scanner.nextLine();
				Double result = lectorService.avgSalary(stat);
				if(result == null){
					System.out.println("department with this name doesnt exist");
				} else {
					System.out.println("AVG salary for this department is " + result);
				}
			}
			if(s == 4){
				System.out.println("Write the name of department");
				String stat = scanner.nextLine();
				Integer result = lectorService.countOfEmployee(stat);
				if(result == 0){
					System.out.println("department with this name doesnt exist");
				} else {
					System.out.println("Count of employee for this department " + result);
				}
			}
			if(s == 5){
				System.out.println("Write what you search");
				String stat = scanner.nextLine();
				List<String> result = lectorService.globalSearch(stat);
				if(result.size() == 0){
					System.out.println("Not fount");
				} else {
					for(String str: result){
						System.out.println(str);
					}
				}
			}
		}
	}

}
