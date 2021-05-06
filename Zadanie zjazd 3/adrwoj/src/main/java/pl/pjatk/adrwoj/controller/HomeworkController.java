package pl.pjatk.adrwoj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.adrwoj.model.Person;

@RestController
@RequestMapping("homework")
public class HomeworkController {

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<Object> testMapping(@RequestParam("query") String query) {
        return ResponseEntity.ok("path:test query:" + query);
    }

    @GetMapping("{path}")
    public ResponseEntity<Object> testVariableMapping(@PathVariable("path") String path){
        return ResponseEntity.ok("path:" + path);
    }

    @PostMapping("/person")
    @ResponseBody
    public ResponseEntity<Object> postPersonMapping(@RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @PutMapping("/person/{id}")
    @ResponseBody
    public ResponseEntity<Object> PutPersonMapping(@RequestBody Person person, @PathVariable int id) {
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/person/{id}")
    @ResponseBody
    public ResponseEntity<Object> deletePersonMapping(@PathVariable int id) {
        return ResponseEntity.ok("");
    }
}


