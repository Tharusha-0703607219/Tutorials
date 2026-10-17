package uk.ac.westminster.productsapi;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping({"/hello"})
    public String hello() {
        return "Hello from spring boot!";
    }

    @GetMapping({"/status"})
    public String Status() {
        return "Ok " + LocalDate.now().toString();
    }
}
