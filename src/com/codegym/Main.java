package com.codegym;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static final String MALE = "male";
    public static final String FEMALE = "female";

    public static void main(String[] args) {
        ArrayList<Person> persons = newPersonList();
        System.out.println("Danh sách thành viên ban đầu: ");
        printPersonList(persons);

        System.out.println("Danh sách thành viên demerged: ");
        ArrayList<Person> demergePersonList = demergePersonList(persons);
        printPersonList(demergePersonList);

    }

    // hàm in ra một danh sách thành viên
    public static void printPersonList(ArrayList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d.\t %s\n", i + 1, list.get(i).toString());
        }
    }


    // hàm nhận vào một ArrayList<Employee> và trả về ArrayList đã được sắp xếp lại
    // female đưa lên đầu tiên
    public static ArrayList<Person> demergePersonList(ArrayList<Person> list) {
        Queue<Person> maleQueue = new LinkedList<>();
        Queue<Person> femaleQueue = new LinkedList<>();
        ArrayList<Person> demerged = new ArrayList<>();

        list.forEach(person -> {
            if (person.getGender().equals(FEMALE))
                femaleQueue.add(person);
            else
                maleQueue.add(person);
        });

        femaleQueue.forEach(person -> demerged.add(person));
        maleQueue.forEach(person -> demerged.add(person));

        return demerged;
    }


    // hàm khởi tạo danh sách nhân viên để test
    public static ArrayList<Person> newPersonList() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Nguyễn Văn A", "19/08/1950", MALE));
        list.add(new Person("Nguyễn Thị B", "05/02/1961", FEMALE));
        list.add(new Person("Trần Văn C", "15/03/1962", MALE));
        list.add(new Person("Phạm Thị D", "11/08/1962", FEMALE));
        list.add(new Person("Lê Hồng E", "22/01/1975", FEMALE));
        list.add(new Person("Trần Quang F", "13/05/1976", MALE));
        list.add(new Person("Ngô Quang G", "06/06/1981", MALE));
        list.add(new Person("Trần Hoài H", "09/07/1983", FEMALE));
        list.add(new Person("Phan Thị K", "20/04/1986", FEMALE));
        list.add(new Person("Nguyễn Thu L", "18/12/1989", FEMALE));
        list.add(new Person("Tô Văn M", "22/01/1990", MALE));
        list.add(new Person("Bùi Văn L", "11/11/1993", MALE));
        list.add(new Person("Lâm Thị T", "20/10/1996", FEMALE));

        return list;
    }
}

