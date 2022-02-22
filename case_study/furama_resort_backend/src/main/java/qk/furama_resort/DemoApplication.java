package qk.furama_resort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import qk.furama_resort.validate.RegexPattern;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        System.out.println(RegexPattern.validateDateOfBirth("2015-09-02"));
    }

}
