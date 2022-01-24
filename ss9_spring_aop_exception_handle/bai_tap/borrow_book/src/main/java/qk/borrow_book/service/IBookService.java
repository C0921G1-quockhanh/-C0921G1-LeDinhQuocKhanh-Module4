package qk.borrow_book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.borrow_book.model.Book;

import java.util.Optional;

public interface IBookService {
    public Page<Book> findAll(Pageable pageable);

    public Optional<Book> findByID(Integer id);

    public void save(Book book);
}
