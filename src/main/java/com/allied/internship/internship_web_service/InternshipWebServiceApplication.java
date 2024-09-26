package com.allied.internship.internship_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class InternshipWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternshipWebServiceApplication.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hellospring")
    public String helloSpring() {
        return "Hello, Spring!";
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/hellospring/{firstName}")
//    public String helloSpringWithVariable(@PathVariable String firstName) {
//        return "Hello," + firstName;
//    }

    @RequestMapping(method = RequestMethod.GET, path = "/hellospring/{firstName}")
    public Person helloSpring(@PathVariable String firstName, @RequestParam String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/showPerson")
    public ResponseEntity<String> showPerson(@RequestBody Person requestPerson) {
        System.out.println("Recieved Person: " + requestPerson.getFirstName() + ", " + requestPerson.getLastName());
        return ResponseEntity.status(HttpStatus.CREATED).body("Recieved");
    }

}
