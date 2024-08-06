package org.example.dto.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoDtoListV1 {
    private static TodoDtoListV1 instance;
    private List<TodoDto> todoDtoList;

    public TodoDtoListV1() {
        this.todoDtoList = new ArrayList<>();
        // 테스트 데이터 추가
        this.addList("다트 우승하기");
        this.addList("케잌 주문하기");
    }

    public static synchronized TodoDtoListV1 getInstance() {
        if (instance == null) {
            instance = new TodoDtoListV1();
        }
        return instance;
    }

    public void addList(String todo) {
        todoDtoList.add(new TodoDto(todo));
    }

    public List<TodoDto> getList() {
        return todoDtoList;
    }
}
