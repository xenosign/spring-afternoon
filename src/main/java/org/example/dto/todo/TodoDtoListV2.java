package org.example.dto.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDtoListV2 {
    private List<TodoDto> todoDtoList;

    public TodoDtoListV2() {
        this.todoDtoList = new ArrayList<>();
        // 테스트 데이터 추가
        this.addList("다트 우승하기");
        this.addList("케잌 주문하기");
    }

    public void addList(String todo) {
        todoDtoList.add(new TodoDto(todo));
    }

    public List<TodoDto> getList() {
        return todoDtoList;
    }
}
