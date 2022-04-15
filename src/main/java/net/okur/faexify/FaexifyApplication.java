package net.okur.faexify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// butun endpointleri secure  etme ozelligi kaldirildi
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FaexifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaexifyApplication.class, args);
    }

}
