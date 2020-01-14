package io.turntabl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.turntabl.models.Employee;
import io.turntabl.models.EmployeeProfile;
import io.turntabl.models.Project;
import io.turntabl.models.Tech;
import io.turntabl.services.AvailableEmployeesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class TimeApplication {

	public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        List<EmployeeProfile> employeeProfiles = new ArrayList<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(new URL("http://employementprofilingapp-env.snvx8mbkdw.us-east-2.elasticbeanstalk.com/v1/api/employees")).get("data");
            for (JsonNode next : jsonNode) {
                EmployeeProfile employeeProfile = new EmployeeProfile();
                employeeProfile.setEmployee(objectMapper.treeToValue(next.get("employee"), Employee.class));
                Project[] projects1 = objectMapper.treeToValue(next.get("projects"), Project[].class);
                employeeProfile.setProjects(Arrays.asList(projects1));

                Tech[] tech_stacks = objectMapper.treeToValue(next.get("tech_stack"), Tech[].class);
                employeeProfile.setTech_stack(Arrays.asList(tech_stacks));

                employeeProfiles.add(employeeProfile);
            }
        } catch (IOException e) { e.printStackTrace(); return new ArrayList<>();}
        employeeProfiles.forEach(y -> System.out.println(y.toString()));
        // SpringApplication.run(TimeApplication.class, args);
	}
	@Bean
	public AvailableEmployeesImpl getEmployeeService(){
		return new AvailableEmployeesImpl();
	}

}
