package com.gmail.malynovskyiroman.task2;

    /*Модифицируйте класс группа для более удобных методов работы
    с динамическими массивами.*/

public class GroupRunner {

    public static void main(String[] args) {
        Student student1 = new Student("Roman", "Malynovskyi", "male", 18, "mechanical", 12345);
        Student student2 = new Student("Serhiy", "Pavlov", "male", 20, "economical", 34269);
        Student student3 = new Student("Yulia", "Vorobieva", "female", 19, "computer science", 77745);
        Student student4 = new Student("Sara", "Konor", "female", 16, "AKS", 34911);
        Student student5 = new Student("Maria", "Solovieva", "female", 22, "mechanical", 56345);

        Group group = new Group();

        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        group.addStudent(student4);
        group.addStudent(student5);

        System.out.println(group);

        group.removeStudent(student4);

        System.out.println(group);
    }
}
