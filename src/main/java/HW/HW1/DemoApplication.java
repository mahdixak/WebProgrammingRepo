package HW.HW1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @RequestMapping(value = "/calc")
    public String hello() {
        return "Hello World";
    }
    @GetMapping(value = "/calc/{operator}/{op1}/{op2}")
    private String calculation(@PathVariable String operator, @PathVariable int op1, @PathVariable int op2) {
        int c ;
        switch (operator) {
            case "sum" -> {
                c = op1 + op2;
                return c + " = " + op1 + " + " + op2;
            }
            case "div" -> {
                c = op1 / op2;
                return c + " = " + op1 + " / " + op2;
            }
            case "mult" -> {
                c = op1 * op2;
                return c + " = " + op1 + " * " + op2;
            }
            case "subtract" -> {
                c = op1 - op2;
                return c + " = " + op1 + " - " + op2;
            }
        }
        return null;
    }
}