package edu.miu.cs.cs489appsd;

import java.io.IOException;
import java.io.StringWriter;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.opencsv.CSVWriter;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) throws IOException, JAXBException {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person[] people = { person1, person2 };

        // Json
        Gson gson = new Gson();
        String jsonString = gson.toJson(people);
        System.out.println(jsonString);

        // CSV
        StringWriter stringWriter = new StringWriter();
        CSVWriter writer = new CSVWriter(stringWriter);

        String[] header = { "Name", "Age" };
        writer.writeNext(header);

        for (Person person : people) {
            String[] personData = { person.getName(), String.valueOf(person.getAge()) };
            writer.writeNext(personData);
        }

        writer.close();
        String csvString = stringWriter.toString();
        System.out.println(csvString);

        People peopleWrapper = new People(people); // Wrap the array if using a wrapper
        JAXBContext context = JAXBContext.newInstance(People.class); // Or Person.class if no wrapper
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Formatted
        marshaller.marshal(peopleWrapper, System.out); // Or marshaller.marshal(person1, System.out); for a single
                                                       // object
    }

    @XmlRootElement(name = "people")
    static class People {
        private Person[] people;

        public Person[] getPeople() {
            return people;
        }

        public void setPeople(Person[] people) {
            this.people = people;
        }

        public People() {
        } // Empty constructor required by JAXB

        public People(Person[] people) {
            this.people = people;
        }

        // Getters and setters for people (omitted for brevity)
    }

    @XmlRootElement(name = "person")
    static class Person {
        Person() {
        }

        private String name;

        public void setName(String name) {
            this.name = name;
        }

        @XmlAttribute
        public String getName() {
            return name;
        }

        private Integer age;

        public void setAge(Integer age) {
            this.age = age;
        }

        @XmlAttribute
        public Integer getAge() {
            return age;
        }

        Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

}
