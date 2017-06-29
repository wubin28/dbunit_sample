package bootsimple.controller;

import bootsimple.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}
