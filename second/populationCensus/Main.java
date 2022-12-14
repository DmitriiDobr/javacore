package javacore.second.populationCensus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        Stream<Person> streamFirst = persons.stream();
        Stream<Person> streamSecond = persons.stream();
        Stream<Person> streamThird = persons.stream();
        System.out.println(streamFirst.filter(x -> x.getAge() < 18).count());
        System.out.println();
        System.out.println(streamSecond.filter(x -> x.getAge()>18 && x.getAge()<27).filter(x -> x.getSex()==Sex.MAN).
                map(x -> x.getFamily()).collect(Collectors.toList()));
        System.out.println();
        System.out.println(streamThird.filter(x -> x.getEducation()==Education.HIGHER).
                filter(x -> (x.getSex()==Sex.MAN && x.getAge()>18 && x.getAge()<65) ||
                        (x.getSex()==Sex.WOMAN && x.getAge()>18 && x.getAge()<60)).
                        sorted(Comparator.comparing(Person::getFamily )).
                map(Person::toString).collect(Collectors.toList()));






    }
}
