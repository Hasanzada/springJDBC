package az.ruslan.springJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import az.ruslan.springJDBC.dao.EmployeeDao;

public class Services {

	private EmployeeDao employeeDao;
	private static Services instance;
	
	public static Services getInstance() {
		if(instance == null)
			instance = new Services();
		
		return instance;
	}
	
	private Services() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/beans.xml");
		employeeDao = applicationContext.getBean("employeeDaoImpl", EmployeeDao.class);
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	
}
