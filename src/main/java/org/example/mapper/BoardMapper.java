package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dto.board.BoardDto;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardDto> getList();
    public BoardDto get(Long no);
    public int create(BoardDto board);
    public int update(BoardDto board);
    public int delete(Long no);
}
