package au.com.versent.spring.boot.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.versent.spring.boot.model.Employee;

@RestController
public class EmployeeController {

	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> findAll() {
		if (true) {
			/* fail 20% of times */
			if (Math.random() > 0.8) {
				throw new RuntimeException("random failure loading order over network");
			}

			/* latency spike 50% of the time */
			if (Math.random() > 0.5) {
				// random latency spike
				try {
					Thread.sleep((int) (Math.random() * 2000) + 25);
				} catch (InterruptedException e) {
					// do nothing
				}
			}
		}

		return new ArrayList<Employee>() {
			{
				add(new Employee(1L, "John"));
				add(new Employee(2L, "Sarah"));
				add(new Employee(3L, "Matt"));
				add(new Employee(4L, "Linda"));
			}
		};
	}
}