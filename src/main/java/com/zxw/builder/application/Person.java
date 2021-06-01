package com.zxw.builder.application;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 17:05
 * @Version: 1.0
 * @Description:
 */
public class Person {

    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    private Person() {}

    public static class PersonBuilder {
        Person person = new Person();

        public PersonBuilder basicInfoBuild(int id, String name, int age) {
            person.id = id;
            person.name = name;
            person.age = age;

            return this;
        }

        public PersonBuilder weightBuild(double weight) {
            person.weight = weight;
            return this;
        }

        public PersonBuilder scoreBuild(int score) {
            person.score = score;
            return this;
        }

        public PersonBuilder locationBuild(String street, String roomNo) {
            person.loc = new Location(street, roomNo);
            return this;
        }

        public Person build() {
            return person;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", weight=").append(weight);
        sb.append(", score=").append(score);
        sb.append(", loc=").append(loc);
        sb.append('}');
        return sb.toString();
    }
}

class Location {
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Location{");
        sb.append("street='").append(street).append('\'');
        sb.append(", roomNo='").append(roomNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
