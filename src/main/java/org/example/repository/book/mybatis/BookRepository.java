package org.example.repository.book.mybatis;

import lombok.RequiredArgsConstructor;
import org.example.domain.BookMabatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    private final BookMapper bookMapper;

    @Autowired
    public BookRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<BookMabatis> findAll() {
        return bookMapper.findAll();
    }

    public BookMabatis findById(Long id) {
        return bookMapper.findById(id);
    }

    public int save(BookMabatis newBook) {
        return bookMapper.save(newBook);
    }

    public int delete(Long id) {
        return bookMapper.delete(id);
    }
}
