package com.example.springbasics.restapis;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
public class myController {
    private HashMap<Integer,Person> persons=new HashMap<>();
    //GET --> list of all persons in the hashmap
    //POST--> insert a user in the hashmap
    //PUT--> change the value of a person present in  hashmap
    //DELETE-> delee a person from hashmap
    //Two GET mappings one to return list of all the persons and one to give the person with given id

//
//    @GetMapping("/get_persons")
//    public Map<Integer,Person> getlist(){
//        return persons;
//    }
//    @GetMapping("/get_person")
//    public Person myget(@RequestParam("id") int id){
//        return persons.get(id);
//    }

    @GetMapping("/get_person")
    public List<Person> get_user(@RequestParam(value = "id",required = false) Integer id){
        if (id==null){
            return List.copyOf(persons.values());
        }
        return Collections.singletonList(persons.get(id));


    }
//   @PostMapping("/insert_person")
//    public void insert(@RequestParam(value = "id",required = true) int id
//            ,@RequestParam("name") String name
//            ,@RequestParam("age") int age){
//        Person p1=new Person(id,name,age);
//        persons.put(id,p1);
//
 //   }
    @PutMapping("/modify_user")
    public void modify_user(@RequestBody Person new_person){
        persons.put(new_person.getId(),new_person);

    }
    //curl -X DELETE "127.0.0.1:7000/delete_person/1"
    @DeleteMapping("/delete_person/{id}")
    public  void delete(@PathVariable("id") int id ){
        persons.remove(id);
    }
    //curl -A DELETE "127.0.0.1:7000/delete_person?id=1"
    @DeleteMapping("/delete_person")
    public void delete_user (@RequestParam("id") int id){
        persons.remove(id);
    }

    //Both of these have the same use




}
