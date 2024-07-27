package com.taletalk.ws.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.swing.*;

@Entity
@Table(name= "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="user_id", nullable = false )
   @OnDelete(action=OnDeleteAction.CASCADE)

   User user;


    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;

    }
