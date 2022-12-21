package com.reto2.grupo3.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "opinion")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher", referencedColumnName = "user_id", foreignKey=@ForeignKey(name = "fk_teacher_opinions"))
    @JsonBackReference(value = "opinion_teacher")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Teacher teacher;

    @Column(name="id_teacher", insertable = false, updatable = false)
    private Integer id_teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_students", referencedColumnName = "user_id", foreignKey=@ForeignKey(name = "fk_student_opinions"))
    @JsonBackReference(value = "opinion_student")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Student student;

    @Column(name="id_students", insertable = false, updatable = false)
    private Integer id_students;
    @Column(length = 50)
    String assesment;
    @Column(length = 50)
    String date;
    @Column(length = 50)
    String opinion;

    public Opinion() {
    }

    public Opinion(Integer id, Teacher teacher, Integer id_teacher, Student student, Integer id_students, String assesment, String date, String opinion) {
        this.id = id;
        this.teacher = teacher;
        this.id_teacher = id_teacher;
        this.student = student;
        this.id_students = id_students;
        this.assesment = assesment;
        this.date = date;
        this.opinion = opinion;
    }

    public Opinion(Teacher teacher, Integer id_teacher, Student student, Integer id_students, String assesment, String date, String opinion) {
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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
        return "Opinion{" +
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
