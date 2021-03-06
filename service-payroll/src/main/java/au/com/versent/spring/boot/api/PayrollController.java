package au.com.versent.spring.boot.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import au.com.versent.spring.boot.model.Employee;
import au.com.versent.spring.boot.model.Payroll;

@RestController
public class PayrollController {

	private final Logger logger = LoggerFactory.getLogger(PayrollController.class);

	@Autowired
    private RestTemplate restTemplate;
	
	@HystrixCommand(groupKey = "PayrollMicroService", commandKey = "getProfile", threadPoolKey = "PayrollMicroService")
	@RequestMapping(value = "/payroll", method = RequestMethod.GET, produces = "application/json")
	public List<Payroll> findAll() {
		Employee[] employeesResponse = restTemplate.getForObject("http://employeeservice/service-employee/employees",
				Employee[].class);
		List<Employee> employees = Arrays.asList(employeesResponse);
		List<Payroll> payroll = new ArrayList<>();
		for (Employee employee : employees) {
			payroll.add(new Payroll(employee, employee.getId() * 1500));
		}

		return payroll;

	}
}