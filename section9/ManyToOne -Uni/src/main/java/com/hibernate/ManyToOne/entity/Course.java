package com.hibernate.ManyToOne.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Reviews> reviewsList;
    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Reviews> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<Reviews> reviewsList) {
        this.reviewsList = reviewsList;
    }
    public void addReviews(Reviews reviews){
        if(reviewsList == null){
            reviewsList = new ArrayList<>();
        }
        reviewsList.add(reviews);
    }
//    @Override
//    public String toString() {
//        return "Course{" +
//                "id=" + id +
//                ", title=" + title +
//                ", instructor=" + instructor +
//                '}';
//    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", reviewsList=" + reviewsList +
                '}';
    }
}
