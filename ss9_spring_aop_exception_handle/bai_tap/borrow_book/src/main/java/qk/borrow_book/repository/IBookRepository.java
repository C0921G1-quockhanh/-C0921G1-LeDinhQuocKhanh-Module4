package qk.borrow_book.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.borrow_book.model.Book;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book,Integer> {
}
