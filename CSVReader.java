package src;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

    public static Map<Integer, Employee> readEmployees() throws Exception {
        Map<Integer, Employee> map = new HashMap<>();

        String br2 = null;
		BufferedReader br = new BufferedReader(new FileReader(br2));
        String line;
        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String firstName = data[1];
            String lastName = data[2];
            double salary = Double.parseDouble(data[3]);
            Integer managerId = data.length > 4 && !data[4].isEmpty()
                    ? Integer.parseInt(data[4]) : null;

            map.put(id, new Employee(id, firstName, lastName, salary, managerId));
        }
        return map;
    }

	public static Map<Integer, Employee> readEmployees1() {
		// TODO Auto-generated method stub
		return null;
	}
}