package com.hibernate.ManyToOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="comment")
    private String comment;

    public Reviews() {
    }

    public Reviews(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
