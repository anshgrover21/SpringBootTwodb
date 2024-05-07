package ansh.springboot_starter.RepositoriesPerson;

import ansh.springboot_starter.RepositoriesPerson.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personRepository extends JpaRepository<Person,Integer> {
}
