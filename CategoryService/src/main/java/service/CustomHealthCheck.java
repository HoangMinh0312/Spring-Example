package service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

	int errorCode = 0;

	@Override
	public Health health() {
		errorCode++;
		// TODO Auto-generated method stub
		if (errorCode == 100) {
			return Health.down().withDetail("Error: ", errorCode).build();
		}
		System.out.println("I am still alive");

		return Health.up().build();
	}

}
