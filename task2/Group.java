package com.gmail.malynovskyiroman.task2;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Group {
    private ArrayList<Student> students = new ArrayList<>();

    public Group(ArrayList<Student> students) {
        this.students = students;
    }

    public Group() {
        super();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void safeGroupInFile(String pathname) {
        try (PrintWriter pw = new PrintWriter(pathname)) {
            for (Student student : students) {
                if (student != null) {
                    pw.println("Student{" + "Name:" + "," + student.getName() + "," +
                            "Surname:" + "," + student.getSurname() + "," +
                            "Gender:" + "," + student.getGender() + "," +
                            "Age:" + "," + student.getAge() + "," +
                            "Faculty:" + "," + student.getFaculty() + "," +
                            "Number of test book:" + "," + student.getNumberOfTestBook() + "," + "}");
                } else {
                    continue;
                }
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not founded!");
        }
    }


    public Group getGroupFromFile(File file) {
        Group fromFile = new Group();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String str = "";
            for (; (str = bf.readLine()) != null; ) {
                String[] array = str.split(",");
                String name = array[1];
                String surname = array[3];
                String gender = array[5];
                int age = Integer.parseInt(array[7]);
                String faculty = array[9];
                int numberTestBook = Integer.parseInt(array[11]);
                fromFile.addStudent(new Student(name, surname, gender, age, faculty, numberTestBook));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fromFile;
    }

    private String readFile(File file) {
        String s1 = "";
        String str = null;
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            for (; (s1 = bf.readLine()) != null; ) {
                str = s1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private String[] splitingString(String str) {
        String[] array = str.split(",");
        return array;
    }

    public ArrayList<Student> sortedByAge(ArrayList<Student> list) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 != null && o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1 != null && o2 != null && o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return students;
    }

    public ArrayList<Student> sortedBySurname(ArrayList<Student> list) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 != null) {
                    return o1.getSurname().compareTo(o2.getSurname());
                } else if (o1 == null && o2 != null) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return students;
    }

    public ArrayList<Student> sortedByName(ArrayList<Student> list) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 != null) {
                    return o1.getName().compareTo(o2.getName());
                } else if (o1 == null && o2 != null) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public String toString() {
        return "Group " + "\n" + sortedBySurname(students) + "\n";
    }
}
