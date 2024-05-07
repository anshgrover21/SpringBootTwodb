package ansh.springboot_starter.Controller;

import ansh.springboot_starter.RepositoriesAuthor.Author;
import ansh.springboot_starter.RepositoriesPerson.Person;
import ansh.springboot_starter.Service.commonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

  @Autowired
  private commonService service;

  @PostMapping("/addAuthor")
    public boolean addAuthor(@RequestBody Author author){

      service.addAuthor(author);
      return true;

  }

  @PostMapping("/addPerson")
    public boolean addPerson(@RequestBody Person person){
      service.addPerson(person);
      return true;

    }


}
