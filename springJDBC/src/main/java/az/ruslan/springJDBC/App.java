package az.ruslan.springJDBC;

import az.ruslan.springJDBC.dao.EmployeeDao;
import az.ruslan.springJDBC.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Services services = Services.getInstance();
        EmployeeDao employeeDao = services.getEmployeeDao();
        Employee employee = new Employee();
        employee.setName("Nizami");
        employee.setSurname("Ismayilov");
        employee.setAge(29);
        employee.setSalary(700);
        //employee.setId(2);
        
        //employeeDao.insert(employee);
        
        for (Employee emp : employeeDao.getAllEmployees()) {
			System.out.println(emp);
		}
        
        System.out.println(employeeDao.getEmployeeById(2));
        
    }
}
