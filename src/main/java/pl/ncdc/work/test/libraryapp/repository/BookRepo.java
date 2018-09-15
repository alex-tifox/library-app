package pl.ncdc.work.test.libraryapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ncdc.work.test.libraryapp.model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
}
