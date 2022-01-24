package qk.borrow_book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.borrow_book.model.Book;
import qk.borrow_book.repository.IBookRepository;

import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return this.iBookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findByID(Integer id) {
        return this.iBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        this.iBookRepository.save(book);
    }
}
