package com.example.lab05;

public class StudentRecord {

    private String studentID;
    private float midterm;
    private float assignment;
    private float exam;
    private float finalMark;
    private char letterGrade;

    public StudentRecord(String studentID, float midterm, float assignment, float exam) {
        this.studentID = studentID;
        this.midterm = midterm;
        this.assignment = assignment;
        this.exam = exam;
        this.finalMark = getFinalMark();
        this.letterGrade = getLetterGrade();

    }

    public float getFinalMark() {
        this.finalMark = (this.midterm * 0.2f) + (this.assignment * 0.2f) + (this.exam * 0.3f);
        return this.finalMark;
    }

    public char getLetterGrade() {
        if (this.finalMark >= 80 || this.finalMark <= 100) {
            this.letterGrade = 'A';
        } else if (this.finalMark >= 70 || this.finalMark <= 79) {
            this.letterGrade = 'B';
        } else if (this.finalMark >= 60 || this.finalMark <= 69) {
            this.letterGrade = 'C';
        } else if (this.finalMark >= 50 || this.finalMark <= 59) {
            this.letterGrade = 'D';
        } else if (this.finalMark >= 0 || this.finalMark <= 49) {
            this.letterGrade = 'F';
        }

        return this.letterGrade;

    }

}
