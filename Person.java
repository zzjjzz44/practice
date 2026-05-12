public class Person {
    String name;
    int age;
    String sex;

    public  Person() {
    }
    public  Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    static void show(Object o) {
        System.out.println(o.toString());
    }
public static void main(String[] args) {
    Person p = new Person("A", 18, "男");
    Student s = new Student("B", 20, "女", "1111");
    show(p);
    show(s);}
}

class Student extends Person {
    String Id;

    public Student() {
    }

    public Student(String name, int age, String sex, String Id) {
        super(name, age, sex);
        this.Id = Id;
    }
    @Override
    public String toString() {
        return "Student{name='" + super.toString() + "', Id='" + Id + "'}";
    }
}





