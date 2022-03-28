package uz.maniac4j.quizservice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.client.RestTemplate;

public class Test {
    public void test(){
        Page<Person> people;
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getForObject("",Person.class);
    }
}

@AllArgsConstructor
@NoArgsConstructor
class Person{
    public String name;
}
