package com.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Survey")
public class Survey {
    @Id
    //Primary key'lerin değerleri için üretim stratejilerinin spesifikasyonunu sağlar.
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nicknames", nullable = false, unique = true)
    private String nickname;


    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    @Column(name = "plakalar")
    private String plaka;


    @Column(name = "provinces", nullable = false )
    private String province; // il

    @Column(name = "counties", nullable = false)
    private String county;  // ilçe

    @Column(name = "books", nullable = false )
    private int book; // kitap sayısı

    public Survey(){

    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Survey [id=" + id + ", nickname=" + nickname + ", province=" + province + ", county=" + county + "]";
    }
}