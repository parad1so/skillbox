package main;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.ToDo;

import java.util.List;

@RestController
public class ToDoListController {

    @RequestMapping(value = "/toDos/", method = RequestMethod.GET)
    public List<ToDo> list(){
        return Storage.getAllToDo();
    }

    @RequestMapping(value = "/toDos/", method = RequestMethod.POST)
    public int add(ToDo toDo){
        return Storage.addToDo(toDo);
    }

    @RequestMapping(value = "/toDos/{id}", method = RequestMethod.GET)
    public ResponseEntity get (@PathVariable int id) {
       ToDo toDo = Storage.getToDo(id);
       if (toDo == null) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       }
       return new ResponseEntity(toDo, HttpStatus.OK);
    }

    @RequestMapping(value = "/toDos/{id}", method = RequestMethod.POST)
    public ResponseEntity del (@PathVariable int id) {
        ToDo toDo = Storage.getToDo(id);
        if (toDo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.delToDo(id);
        return new ResponseEntity(toDo, HttpStatus.OK);
    }
}
