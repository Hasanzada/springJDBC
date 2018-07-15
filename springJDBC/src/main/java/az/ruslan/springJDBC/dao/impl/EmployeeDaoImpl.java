package az.ruslan.springJDBC.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import az.ruslan.springJDBC.dao.EmployeeDao;
import az.ruslan.springJDBC.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Employee employee) {
		Object params[] = {employee.getName(),employee.getSurname(),employee.getAge(),employee.getSalary()};
		jdbcTemplate.update("insert into employee(name,surname,age,salary) values(?,?,?,?)",params);
		
	}

	@Override
	public void update(Employee employee) {
		Object params[] = {employee.getName(),employee.getSurname(),employee.getAge(),employee.getSalary(), employee.getId()};
		jdbcTemplate.update("update employee set name = ?,surname = ?,age = ?,salary = ? where id = ?",params);
		
	}

	@Override
	public void delete(int employeeId) {
		Object params[] = {employeeId};
		jdbcTemplate.update("delete from employee where id = ?",params);
		
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Object params[] = {employeeId};
		return (Employee) jdbcTemplate.queryForObject("select * from employee where id = ?", params, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
