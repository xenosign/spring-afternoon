package org.example.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.post.PostDto;
import org.example.dto.post.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/post/v2/rest")
public class RestPostControllerV2 {
    private final PostRepository postRepository;
    private String context = "/post";

    // 게시글 목록 보기
    @GetMapping("/show")
    public ResponseEntity<List<PostDto>> postList(HttpServletRequest request) {
        log.info("=========> 게시글 목록 페이지 호출, " + request.getRequestURI());

        List<PostDto> list = postRepository.findAll();

        // ok = 200번
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/test", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> test() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("요청을 처리할 수 없습니다");
    }

    
    // 게시물 조건 조회
    @GetMapping("/search")
    public List<PostDto> postSearch(
         @RequestParam("title") String title,
         @RequestParam("content") String content,
         HttpServletRequest request,
         Model model
    ) {
        log.info("============> 게시글 검색 기능 호출, " + request.getRequestURI());

        List<PostDto> searchedList = postRepository.findByCondition(title, content);
        return searchedList;
    }

    // 게시글 추가 페이지 요청
    @GetMapping("/new")
    public String postNew(HttpServletRequest request) {
        log.info("================> 게시글 추가 페이지 호출, " + request.getRequestURI());
        return context + "/post-new";
    }

    // 게시글 추가 기능 컨트롤러
    @PostMapping("/new")
    public String postSave(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request
    ) {
        log.info("================> 게시글 추가 기능 호출, " + request.getRequestURI());

        postRepository.save(title, content);

        return "redirect:/post/v1/show";
    }

    // 게시글 수정 페이지 호출
    @GetMapping("/update")
    public String postEdit(@RequestParam("id") String id, HttpServletRequest request, Model model) {
        log.info("================> 게시글 수정 페이지 호출, " + request.getRequestURI());

        long postId = Long.parseLong(id);

        System.out.println("##### " + postId);
        PostDto post = postRepository.findById(postId);

        model.addAttribute("post", post);
        return context + "/post-update";
    }

    // 게시글 수정 기능 컨트롤러
    @PostMapping("/update")
    public String postUpdate(
            @RequestParam("id") String id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request
    ) {
        log.info("================> 게시글 수정 기능 호출, " + request.getRequestURI());

        long postId = Long.parseLong(id);
        int affectedRows = postRepository.update(postId, title, content);

        if (affectedRows > 0) log.info("수정 성공");

        return "redirect:/post/v1/show";
    }

    // 삭제 기능 컨트롤러
    @DeleteMapping(value = "/delete/{id}", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> postDelete(@PathVariable("id") Long id, HttpServletRequest request) {
        log.info("================> 게시글 삭제 기능 호출, " + request.getRequestURI());
        int affectedRows = postRepository.delete(id);

        if (affectedRows > 0) {
            return ResponseEntity.ok("삭제 성공");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제 실패");
        }        
    }
}
