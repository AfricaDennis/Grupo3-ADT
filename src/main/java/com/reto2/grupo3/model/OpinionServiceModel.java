package com.reto2.grupo3.model;

public class OpinionServiceModel {
    Integer id;
    private TeacherServiceModel teacher;
    private Integer id_teacher;
    private StudentServiceModel student;
    private Integer id_students;
    String assesment;
    String date;
    String opinion;

    public OpinionServiceModel() {
    }

    public OpinionServiceModel(Integer id, TeacherServiceModel teacher, Integer id_teacher, StudentServiceModel student, Integer id_students, String assesment, String date, String opinion) {
        this.id = id;
        this.teacher = teacher;
        this.id_teacher = id_teacher;
        this.student = student;
        this.id_students = id_students;
        this.assesment = assesment;
        this.date = date;
        this.opinion = opinion;
    }

    public OpinionServiceModel(TeacherServiceModel teacher, Integer id_teacher, StudentServiceModel student, Integer id_students, String assesment, String date, String opinion) {
        this.teacher = teacher;
        this.id_teacher = id_teacher;
        this.student = student;
        this.id_students = id_students;
        this.assesment = assesment;
        this.date = date;
        this.opinion = opinion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TeacherServiceModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherServiceModel teacher) {
        this.teacher = teacher;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    public StudentServiceModel getStudent() {
        return student;
    }

    public void setStudent(StudentServiceModel student) {
        this.student = student;
    }

    public Integer getId_students() {
        return id_students;
    }

    public void setId_students(Integer id_students) {
        this.id_students = id_students;
    }

    public String getAssesment() {
        return assesment;
    }

    public void setAssesment(String assesment) {
        this.assesment = assesment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return "OpinionServiceModel{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", id_teacher=" + id_teacher +
                ", student=" + student +
                ", id_students=" + id_students +
                ", assesment='" + assesment + '\'' +
                ", date='" + date + '\'' +
                ", opinion='" + opinion + '\'' +
                '}';
    }
}
