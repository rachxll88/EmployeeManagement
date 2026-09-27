import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", 120000));
        employees.add(new Employee("Kate", 90000));
        employees.add(new Employee("Mike", 70000));
        employees.add(new Employee("Bob", 30000));
        employees.add(new Employee("Anna", 50000));
        employees.add(new Employee("Alex", 80000));
        System.out.println("Low paid:");
        ArrayList<Employee> lowPaid = getLowPaidEmployees(employees);
        for (Employee employee : lowPaid) {
            System.out.println(employee.getName() + " " + employee.getSalary());
        }
        System.out.println("High paid:");
        ArrayList<Employee> highPaid = getHighPaidEmployees(employees);
        for (Employee employee : highPaid) {
            System.out.println(employee.getName() + " " + employee.getSalary());
        }
        System.out.println("Employee withA:");
        ArrayList<Employee> employeeWithA = getEmployeeWithA(employees);
        for (Employee employee : employeeWithA) {
            System.out.println(employee.getName() + " " + employee.getSalary());

        }
        System.out.println("Total salary:");
        int totalSalary = getTotalSalary(employees);
        System.out.println(totalSalary);


        System.out.println("Highest paid:");
        Employee highestPaid = getHighestPaidEmployee(employees);
        System.out.println(highestPaid.getName() + " " + highestPaid.getSalary());


        HashSet<String> names = new HashSet<>();
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        System.out.println(names);

        HashMap<String, Integer> salaries = new HashMap<>();
        for (Employee employee : employees) {
            salaries.put(employee.getName(), employee.getSalary());
        }
        System.out.println(salaries);

        employees.sort(
                Comparator.comparing((Employee employee) -> employee.getSalary()).reversed());
        for (Employee employee: employees) {
            System.out.println(employee.getName() + " " + employee.getSalary());
        }

        try {


            addEmployee(employees, new Employee("John", -50000));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }

    public static ArrayList<Employee> getHighPaidEmployees(ArrayList<Employee> employees) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.salary > 70000) {
                result.add(employee);
            }
        }
        return result;
    }

    public static ArrayList<Employee> getLowPaidEmployees(ArrayList<Employee> employees) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.salary < 70000) {
                result.add(employee);
            }
        }
        return result;
    }

    public static ArrayList<Employee> getEmployeeWithA(ArrayList<Employee> employees) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.name.contains("A")) {
                result.add(employee);

            }
        }
        return result;
    }

    public static int getTotalSalary(ArrayList<Employee> employees) {
        int total = 0;
        for (Employee employee : employees) {
            total += employee.salary;
        }
        return total;
    }

    public static Employee getHighestPaidEmployee(ArrayList<Employee> employees) {
        Employee highest = employees.get(0);
        for (Employee employee : employees) {
            if (employee.salary > highest.salary) {
                highest = employee;
            }
        }

        return highest;
    }
    public static  void addEmployee(ArrayList<Employee> employees,Employee employee) {
        if(employee.salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        employees.add(employee);
    }

}





