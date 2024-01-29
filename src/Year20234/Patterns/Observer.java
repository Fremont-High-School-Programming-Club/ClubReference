package Year20234.Patterns;

import java.util.ArrayList;

class Subject {
    private int data;

    public Subject(int initialData) {
        this.data = initialData;
    }

    public void update(int newData) {
        this.data = newData;
    }

    public void useData() {
        System.out.println(this.data);
    }
}

class Observer {
    private ArrayList<Subject> subjects;

    public Observer() {
        this.subjects = new ArrayList<Subject>();
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void update(int data) {
        for (Subject subject : this.subjects) {
            subject.update(data);
        }
    }
}
