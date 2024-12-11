package Comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    int age;
    String name;

    Student(int a, String n) {
        age = a;
        name = n;
    }

    @Override
    public String toString() {
        return "Student: " + name + " " + age;
    }

    @Override
    public int compareTo(Student s) {
        return this.age - s.age;
    }

}



public class Practice {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(72);
        nums.add(29);

        Comparator<Integer> intComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (x % 10 > y % 10) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };


        Collections.sort(nums, intComp);

        System.out.println(nums);
        List<String> words = new ArrayList<>();
        words.add("elephants");
        words.add("human");
        words.add("monkeys");
        words.add("bees");

        Comparator<String> strComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
        Collections.sort(words, strComp);
        System.out.println(words);

        List<Student> students = new ArrayList<>();
        students.add(new Student(20, "Alice"));
        students.add(new Student(19, "Bob"));
        students.add(new Student(18, "Cathy"));
        students.add(new Student(30, "Dan"));

        Collections.sort(students);
        System.out.println(students);
    }
}
