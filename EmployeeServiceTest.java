package test;

import src.Employee;
import src.EmployeeService;

import java.util.HashMap;
import java.util.Map;


//import org.junit.Test;
//import CodeAssignment106.Employee;

public class EmployeeServiceTest<EmployeeServiceTest> {

    @Test
    public void testDepthCalculation() {
        Employee e1 = new Employee(1, "A", "A", 1000, null);
        Employee e2 = new Employee(2, "B", "B", 800, 1);
        Employee e3 = new Employee(3, "C", "C", 600, 2);

        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, e1);
        map.put(2, e2);
        map.put(3, e3);

        EmployeeService service = new EmployeeService();

        int depth = service.getDepth(e3, map);

        assertEquals(2, depth);
    }

	private void assertEquals(int i, int depth) {
	
		
	}
}
