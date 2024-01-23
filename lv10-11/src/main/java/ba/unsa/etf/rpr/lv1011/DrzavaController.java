package ba.unsa.etf.rpr.lv1011;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DrzavaController {

    public TextField fieldNaziv;
    public ChoiceBox<Grad> choiceGrad;
    private Drzava drzava;
    private ObservableList<Grad> listGradovi;

    public DrzavaController(){
        GeografijaDAO dao = GeografijaDAO.getInstance();
        listGradovi = FXCollections.observableArrayList(dao.gradovi());
    }
    public DrzavaController(Drzava drzava) {
        this.drzava = drzava;
        GeografijaDAO dao = GeografijaDAO.getInstance();
        listGradovi = FXCollections.observableArrayList(dao.gradovi());
    }

    @FXML
    public void initialize() {
        choiceGrad.setItems(listGradovi);
        if (drzava != null) {
            fieldNaziv.setText(drzava.getNaziv());
            choiceGrad.getSelectionModel().select(drzava.getGlavniGrad());
        } else {
            choiceGrad.getSelectionModel().selectFirst();
        }

        fieldNaziv.textProperty().addListener((observableValue, o, n) -> {
            if (n.trim().isEmpty()) {
                fieldNaziv.getStyleClass().add("poljeNijeIspravno");
            } else {
                fieldNaziv.getStyleClass().removeAll("poljeNijeIspravno");
            }
        });

    }

    @FXML
    public Drzava getDrzava() {
        return drzava;
    }
    @FXML
    public void btnOk() {
        boolean sveOk = true;

        if (fieldNaziv.getText().trim().isEmpty()) {
            fieldNaziv.getStyleClass().removeAll("poljeIspravno");
            fieldNaziv.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fieldNaziv.getStyleClass().removeAll("poljeNijeIspravno");
            fieldNaziv.getStyleClass().add("poljeIspravno");
        }

        if (!sveOk) return;

        if (drzava == null) drzava = new Drzava();
        drzava.setNaziv(fieldNaziv.getText());
        drzava.setGlavniGrad(choiceGrad.getSelectionModel().getSelectedItem());
        Stage stage = (Stage) fieldNaziv.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void btnCancel() {
        drzava = null;
        Stage stage = (Stage) fieldNaziv.getScene().getWindow();
        stage.close();
    }




}
