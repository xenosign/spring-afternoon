package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.dto.post.PostDto;

import java.util.List;

@Mapper
public interface PostMapper {
    // 게시글 전체 조회
    List<PostDto> findAll();
    // 게시글 조건 조회
    List<PostDto> findByCondition(
            @Param("title") String title,
            @Param("content") String content
    );
    // 게시글을 id 로 조회 -> 게시글 수정에서 사용
    PostDto findById(@Param("id") Long id);

    // 게시글 삭제
    int delete(@Param("id") Long id);
    // 게시글 추가
    int save(@Param("title") String title, @Param("content") String content);
    // 게시글 수정
    int update(@Param("id") Long id, @Param("title") String title, @Param("content") String content);
}
