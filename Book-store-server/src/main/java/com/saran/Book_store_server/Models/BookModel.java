package com.saran.Book_store_server.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class BookModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String image;
    private int price;
    private String title;
    private String category;

}
