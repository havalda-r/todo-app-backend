package com.rich.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJpaResource {

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable("username") String username) {
        return todoJpaRepository.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable("username") String username, @PathVariable long id) {
        return todoJpaRepository.findById(id).get();
    }

//    @DeleteMapping("/jpa/users/{username}/todos/{id}")
//    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
//        Todo todo = todoJpaRepository.deleteById(id);
//        if (todo != null) return ResponseEntity.noContent().build();
//        return ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/jpa/users/{username}/todos/{id}")
//    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
//        Todo todoUpdated = todoJpaRepository.save(todo);
//        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
//    }
//
//    @PostMapping("/jpa/users/{username}/todos")
//    public ResponseEntity<Void> addTodo(@PathVariable String username, @RequestBody Todo todo) {
//        Todo createdTodo = todoJpaRepository.save(todo);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
}
