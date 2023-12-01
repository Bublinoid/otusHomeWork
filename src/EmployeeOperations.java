import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeOperations {

    public static List<String> getEmployeeName (List<Employee> employees) {
        return employees.stream()
                .map(employee -> employee.name)
                .collect(Collectors.toList()); // Java 8 vs toList()
    }

    public static List<Employee> filtersEmployeesByAge(List<Employee> employees, int minAge) {
        return employees.stream()
                .filter(employee -> employee.age >= minAge)
                .collect(Collectors.toList()); //Java 8 vs toList()
    }

    public static boolean isAverageAgeGreater(List<Employee> employees, int threshold) {
        double averageAge = employees.stream()
                .mapToDouble(employee -> employee.age)
                .average()
                .orElse(0);

        return averageAge > threshold;
    }

    public static Employee findYoungestEmployee(List<Employee> employees) {
        Optional<Employee> youngest = employees.stream()
                .min((a1, a2) -> Integer.compare(a1.age, a2.age));
        return youngest.orElse(null);
    }
}
