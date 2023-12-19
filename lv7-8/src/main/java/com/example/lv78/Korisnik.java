package com.example.lv78;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Korisnik {

    private StringProperty ime;
    private  StringProperty prezime;
    private  StringProperty email;
    private  StringProperty korisnickoIme;
    private  StringProperty lozinka;

    public Korisnik(String ime,String prezime,String email, String korisnickoIme, String password) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.korisnickoIme = new SimpleStringProperty(korisnickoIme);
        this.lozinka = new SimpleStringProperty(password);
    }

    public Korisnik() {
        this.ime = new SimpleStringProperty();
        this.prezime = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.korisnickoIme = new SimpleStringProperty();
        this.lozinka = new SimpleStringProperty();
    }

//setteri
    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.set(korisnickoIme);
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }



//getteri
    public String getIme() {
        return ime.get();
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public StringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public StringProperty lozinkaProperty() {
        return lozinka;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(ime, korisnik.ime) && Objects.equals(prezime, korisnik.prezime) && Objects.equals(email, korisnik.email) && Objects.equals(korisnickoIme, korisnik.korisnickoIme) && Objects.equals(lozinka, korisnik.lozinka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, email, korisnickoIme, lozinka);
    }


    @Override
    public String toString() {
        return ime.get() + " " + prezime.get();
    }
}
