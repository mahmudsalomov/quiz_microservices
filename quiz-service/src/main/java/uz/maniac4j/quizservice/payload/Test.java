package uz.maniac4j.quizservice.payload;

public class Test {
    public static void main(String[] args) {
        Person mahmud = new Person("Mahmud");
        System.out.println(Payload.accepted(mahmud));
        System.out.println(Payload.accepted());
    }
}

class Person{
    public Person(String name) {
        this.name = name;
    }

    public String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
