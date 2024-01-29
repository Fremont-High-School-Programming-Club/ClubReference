package Year20234.Patterns;

public class GuardClauses {
    public static void main(String[] args) {
        Employee employee = new Employee("John", 30, 100000);

        System.out.println(badCheckIfValidEmployee(employee));

        System.out.println(goodCheckIfValidEmployee(employee));
    }

    public static boolean badCheckIfValidEmployee(Employee employee) {
        if (employee.name != null && !employee.name.isEmpty()) {
            if (employee.age >= 0 && employee.age <= 100) {
                if (employee.salary >= 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean goodCheckIfValidEmployee(Employee employee) {
        if (employee.name == null || employee.name.isEmpty()) {
            return false;
        }

        if (employee.age < 0 || employee.age > 100) {
            return false;
        }

        if (employee.salary < 0) {
            return false;
        }

        return true;
    }
}

class Employee {
    String name;
    int age;
    int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
