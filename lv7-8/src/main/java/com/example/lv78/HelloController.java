package com.example.lv78;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static javafx.beans.binding.Bindings.bindBidirectional;
import static javafx.beans.binding.Bindings.unbindBidirectional;


public class HelloController {
    @FXML
    private ListView<Korisnik> listKorisnici;

    @FXML
    private TextField imeField;

    @FXML
    private TextField prezimeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField korisnickoImeField;

    @FXML
    private PasswordField lozinkaField;
    private KorisniciModel model = new KorisniciModel();



    @FXML
    public void initialize() {
        model.napuni();

        // Postavljanje bidirekcione veze za trenutnog korisnika (ako postoji)
        Korisnik trenutniKorisnik = model.getTrenutniKorisnik();
        if (trenutniKorisnik != null) {
            imeField.textProperty().bindBidirectional(trenutniKorisnik.imeProperty());
        }

        listKorisnici.setItems(model.getKorisnici());

        // Dodavanje ChangeListener-a za promjenu izabranog korisnika
        listKorisnici.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if (oldKorisnik != null) {
                imeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
                prezimeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
                emailField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
                korisnickoImeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
                lozinkaField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
            }
            if (newKorisnik == null) {
                imeField.setText("");
                prezimeField.setText("");
                emailField.setText("");
                korisnickoImeField.setText("");
                lozinkaField.setText("");
            }
            else {
                model.setTrenutniKorisnik(newKorisnik);
                listKorisnici.refresh();

                imeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
                prezimeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
                emailField.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
                korisnickoImeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
                lozinkaField.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());



            }
        });

    }

    @FXML
    protected void onDodajButtonClick() {
       if(model.getTrenutniKorisnik()!=null) {
           imeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
           prezimeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
           emailField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
           korisnickoImeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
           lozinkaField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
       }
        Korisnik noviKorisnik = new Korisnik("", "", "", "", "");

        model.getKorisnici().add(noviKorisnik);
        model.setTrenutniKorisnik(noviKorisnik);
        imeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailField.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korisnickoImeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        lozinkaField.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
/*

        String ime = imeField.getText();
        String prezime = prezimeField.getText();
        String email = emailField.getText();
        String korisnicko = korisnickoImeField.getText();
        String pass = lozinkaField.getText();
        Korisnik novi = new Korisnik(ime, prezime, email, korisnicko, pass);
        model.dodajKorisnika(novi);
        model.setTrenutniKorisnik(novi);*/
        listKorisnici.refresh();
    }

    @FXML
    protected void onKrajButtonClick() {
        Platform.exit();
    }

}
