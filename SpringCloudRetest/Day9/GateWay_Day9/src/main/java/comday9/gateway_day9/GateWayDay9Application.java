package comday9.gateway_day9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWayDay9Application {

    public static void main(String[] args) {
        SpringApplication.run(GateWayDay9Application.class, args);
    }

}
