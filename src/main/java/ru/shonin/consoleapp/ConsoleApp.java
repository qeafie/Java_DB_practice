package ru.shonin.consoleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shonin.database.Employee;
import ru.shonin.database.EmployeeRepository;

import java.util.Scanner;

@Component
public class ConsoleApp {
    private EmployeeRepository employeeRepository;

    public ConsoleApp(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void run(){

        while (true){
            System.out.println("1. Посмотреть всех сотрудников \n" +
                    "2. Добавить сотрудника \n" +
                    "3. Удалить сотрудника по ID \n" +
                    "4. Выход");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    employeeRepository.findAll().forEach(System.out::println);
                    break;
                case 2:
                    saveEmployee();
                    break;

                case 3:
                    deleteEmployee();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неккоректный ввод");
            }


        }

    }

    private void deleteEmployee() {
        System.out.println("Введите ID сотрудника: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        employeeRepository.deleteById(id);

    }

    void saveEmployee(){

        System.out.println("Введите имя сотрудника: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Введите код отдела: ");
        int idDepartment = scanner.nextInt();
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartmentId(idDepartment);
        employeeRepository.save(employee);


    }

}
