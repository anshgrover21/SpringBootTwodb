package ansh.springboot_starter.Service;

import ansh.springboot_starter.RepositoriesAuthor.Author;
import ansh.springboot_starter.RepositoriesAuthor.AuthorRepositories;
import ansh.springboot_starter.RepositoriesPerson.Person;


import ansh.springboot_starter.RepositoriesPerson.personRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commonService {

    @Autowired
    private AuthorRepositories authorRepositories;

    @Autowired
    private personRepository personRepositoryy;



    public void addPerson(Person person) {
        personRepositoryy.save(person);
    }

    public void addAuthor(Author author){
        authorRepositories.save(author);
    }

}
