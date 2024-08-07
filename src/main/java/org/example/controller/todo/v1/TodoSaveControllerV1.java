package org.example.controller.todo.v1;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TodoSaveControllerV1 {
    private TodoDtoListV1 todoDtoList = TodoDtoListV1.getInstance();

    @RequestMapping(value = "/todo/form/save", method = RequestMethod.GET)
    public String process(HttpServletRequest request) {
        log.info(" =========> 회원 추가 Request, /todo/form/save");

        String todo = request.getParameter("todo");
        todoDtoList.addList(todo);

        request.setAttribute("todoList", todoDtoList.getList());

        return "todo-show";
    }




}
