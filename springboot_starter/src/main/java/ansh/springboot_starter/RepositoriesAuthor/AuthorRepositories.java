package ansh.springboot_starter.RepositoriesAuthor;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepositories extends JpaRepository<Author,Integer> {

}
