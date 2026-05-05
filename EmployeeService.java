package src;

import java.util.*;

public class EmployeeService {

    public void buildHierarchy(Map<Integer, Employee> map) {
        for (Employee e : map.values()) {
            if (e.managerId != null) {
                map.get(e.managerId).subordinates.add(e);
            }
        }
    }

    public void analyzeSalaries(Map<Integer, Employee> map) {
        for (Employee manager : map.values()) {

            if (manager.subordinates.isEmpty()) continue;

            double avg = manager.subordinates.stream()
                    .mapToDouble(e -> e.salary)
                    .average()
                    .orElse(0);

            double min = avg * 1.2;
            double max = avg * 1.5;

            if (manager.salary < min) {
                System.out.println("Manager " + manager.id + " underpaid by: " + (min - manager.salary));
            } else if (manager.salary > max) {
                System.out.println("Manager " + manager.id + " overpaid by: " + (manager.salary - max));
            }
        }
    }

    public int getDepth(Employee emp, Map<Integer, Employee> map) {
        int depth = 0;
        while (emp.managerId != null) {
            emp = map.get(emp.managerId);
            depth++;
        }
        return depth;
    }

    public void analyzeReporting(Map<Integer, Employee> map) {
        for (Employee emp : map.values()) {
            int depth = getDepth(emp, map);
            if (depth > 4) {
                System.out.println("Employee " + emp.id + " has too long reporting line by: " + (depth - 4));
            }
        }
    }
}