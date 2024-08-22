package org.example.repository.book.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.BookMabatis;

import java.util.List;

@Mapper
public interface BookMapper {
    public List<BookMabatis> findAll();
    public BookMabatis findById(@Param("id") Long id);
    public int save(BookMabatis newBook);
    public int delete(@Param("id") Long id);
}
