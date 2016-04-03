package au.com.versent.spring.boot.model;

import java.io.Serializable;

public class Payroll implements Serializable {
    private Employee employee;
    
    private long salary;

	public Payroll(Employee employee, long salary) {
		super();
		this.employee = employee;
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getEmployeeName() {
		return employee == null ? null : employee.getName();
	}

}