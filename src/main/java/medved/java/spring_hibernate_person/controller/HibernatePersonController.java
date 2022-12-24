package medved.java.spring_hibernate_person.controller;

import medved.java.spring_hibernate_person.entity.Persons;
import medved.java.spring_hibernate_person.repository.PersonsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class HibernatePersonController {
    private final PersonsRepository repository;

    public HibernatePersonController(PersonsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city_of_living") String city){
        return repository.findPersonsByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    public List<Persons> getPersonsByAge(@RequestParam("age") int age){
        return repository.findPersonsByBasePersonAgeLessThanOrderByBasePersonAgeAsc(age);
    }

//    @GetMapping("/baseperson/by-age")
//    public List<BasePerson> getBasePersonsByAge(@RequestParam("age") int age){
//        return repository.findBasePersonByBasePersonAgeLessThanOrderByBasePersonAgeDesc(age);
//    }
//
//    @GetMapping("/phone/by-age")
//    public List<String> getPhoneByAge(@RequestParam("age") int age){
//        return repository.findPhoneNumberByBasePersonAgeLessThan(age);
//    }

    @GetMapping("/by-fio")
    public List<Optional<Persons>> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname){
        return repository.findPersonsByBasePersonNameAndBasePersonSurname(name, surname);
    }
}
