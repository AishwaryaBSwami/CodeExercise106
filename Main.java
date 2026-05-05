package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
public class Main {

	

	public static void main(String[] args)throws Exception {
		
		//String filePath =  "employess.csv";
		System.out.println(new File("employees.csv").getAbsolutePath());
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\krish\\eclipse-workspace\\CodeAssesment106\\employees.csv"
				+ ""));
        Map<Integer, Employee> map = CSVReader.readEmployees();

        EmployeeService service = new EmployeeService();
        
        service.buildHierarchy(map);
        service.analyzeSalaries(map);
        service.analyzeReporting(map);


	}

}
