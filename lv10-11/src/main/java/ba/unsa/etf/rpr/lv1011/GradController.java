package ba.unsa.etf.rpr.lv1011;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GradController {
    public TextField fieldNaziv;
    public TextField fieldBrojStanovnika;
    public ChoiceBox<Drzava> choiceDrzava;
    public ObservableList<Drzava> listDrzave;
    private Grad grad;


    public GradController(){
        GeografijaDAO dao = GeografijaDAO.getInstance();
        this.listDrzave = FXCollections.observableArrayList(dao.drzave());
    }
    public GradController(Grad grad){
        this.grad = grad;
        GeografijaDAO dao = GeografijaDAO.getInstance();
        this.listDrzave = FXCollections.observableArrayList(dao.drzave());
    }

    @FXML
    public void initialize(){

        choiceDrzava.setItems(listDrzave);
        if(grad != null){
            fieldNaziv.setText(grad.getNaziv());
            fieldBrojStanovnika.setText(Integer.toString(grad.getBrojStanovnika()));
            for (Drzava drzava : listDrzave)
                if (drzava.getId() == grad.getDrzava().getId())
                    choiceDrzava.getSelectionModel().select(drzava);
        }else{
            choiceDrzava.getSelectionModel().selectFirst();
        }

        fieldNaziv.textProperty().addListener((observableValue, o, n) -> {
            if (n.trim().isEmpty()) {
                fieldNaziv.getStyleClass().add("poljeNijeIspravno");
            } else {
                fieldNaziv.getStyleClass().removeAll("poljeNijeIspravno");
            }
        });

        fieldBrojStanovnika.textProperty().addListener((observableValue, o, n) -> {
            if (n.trim().isEmpty()) {
                fieldBrojStanovnika.getStyleClass().add("poljeNijeIspravno");
            } else {
                fieldBrojStanovnika.getStyleClass().removeAll("poljeNijeIspravno");
            }
        });
    }

    @FXML
    public void btnOk(){
        boolean sveOk = true;
        if (fieldNaziv.getText().trim().isEmpty()) {
            fieldNaziv.getStyleClass().removeAll("poljeIspravno");
            fieldNaziv.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fieldNaziv.getStyleClass().removeAll("poljeNijeIspravno");
            fieldNaziv.getStyleClass().add("poljeIspravno");
        }

        int brojStanovnika = 0;
        try {
            brojStanovnika = Integer.parseInt(fieldBrojStanovnika.getText());
        } catch (NumberFormatException e) {
            // ...
        }
        if (brojStanovnika <= 0) {
            fieldBrojStanovnika.getStyleClass().removeAll("poljeIspravno");
            fieldBrojStanovnika.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fieldBrojStanovnika.getStyleClass().removeAll("poljeNijeIspravno");
            fieldBrojStanovnika.getStyleClass().add("poljeIspravno");
        }

        if (!sveOk) return;

        if (grad == null) grad = new Grad();
        grad.setNaziv(fieldNaziv.getText());
        grad.setBrojStanovnika(Integer.parseInt(fieldBrojStanovnika.getText()));
        grad.setDrzava(choiceDrzava.getValue());
        Stage stage = (Stage) fieldNaziv.getScene().getWindow();
        stage.close();

    }

    @FXML
    public Grad getGrad() {
        return grad;
    }

    @FXML
    public void btnCancel() {
        grad = null;
        Stage stage = (Stage) fieldNaziv.getScene().getWindow();
        stage.close();
    }



}
