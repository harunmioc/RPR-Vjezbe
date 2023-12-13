package com.example.tutorijal6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    private String ispisLabela = "";
    private StringBuilder prviBroj = new StringBuilder();
    private StringBuilder drugiBroj = new StringBuilder();
    private String operand;
    @FXML
    private Label labela;
    boolean prvi = true;



// 0
@FXML
    public void nulaBtnClick(ActionEvent actionEvent) {
        ispisLabela+="0";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("0");
        else
            drugiBroj.append("0");
    }

//1
@FXML
    public void jedanBtnClick(ActionEvent actionEvent) {
        ispisLabela+="1";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("1");
        else
            drugiBroj.append("1");
    }

//2
@FXML
    public void dvaBtnClick(ActionEvent actionEvent) {
        ispisLabela+="2";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("2");
        else
            drugiBroj.append("2");
    }

//3
@FXML
    public void triBtnClick(ActionEvent actionEvent) {
        ispisLabela+="3";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("3");
        else
            drugiBroj.append("3");
    }

//4
@FXML
    public void cetiriBtnClick(ActionEvent actionEvent) {
        ispisLabela+="4";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("4");
        else
            drugiBroj.append("4");
    }

//5
@FXML
    public void petBtnClick(ActionEvent actionEvent) {
        ispisLabela+="5";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("5");
        else
            drugiBroj.append("5");
    }

//6
@FXML
    public void sestBtnClick(ActionEvent actionEvent) {
        ispisLabela+="6";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("6");
        else
            drugiBroj.append("6");
    }

//7
@FXML
    public void sedamBtnClick(ActionEvent actionEvent) {
        ispisLabela+="7";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("7");
        else
            drugiBroj.append("7");
    }

//8
@FXML
    public void osamBtnClick(ActionEvent actionEvent) {
        ispisLabela+="8";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("8");
        else
            drugiBroj.append("8");
    }

//9
@FXML
    public void devetBtnClick(ActionEvent actionEvent) {
        ispisLabela+="9";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append("9");
        else
            drugiBroj.append("9");
    }

//.
@FXML
    public void tackaBtnClick(ActionEvent actionEvent) {
        ispisLabela+=".";
        labela.setText(ispisLabela);
        if(prvi)
            prviBroj.append(".");
        else
            drugiBroj.append(".");
    }

//+
@FXML
    public void plusBtnClick(ActionEvent actionEvent) {
        ispisLabela+="+";
        labela.setText("+");
        operand="+";
        prvi=false;
        ispisLabela="";
    }


//-
@FXML
    public void minusBtnClick(ActionEvent actionEvent) {
        ispisLabela+="-";
        labela.setText("-");
        operand="-";
        prvi=false;
        ispisLabela="";
    }

//x
@FXML
public void putaBtnClick(ActionEvent actionEvent) {
    ispisLabela+="x";
    labela.setText("x");
    operand="x";
    prvi=false;
    ispisLabela="";
}

// /
@FXML
public void podjeljenoBtnClick(ActionEvent actionEvent) {
    ispisLabela+="/";
    labela.setText("/");
    operand="/";
    prvi=false;
    ispisLabela="";
}

// %
@FXML
    public void postotakBtnClick(ActionEvent actionEvent) {
        ispisLabela+="%";
        labela.setText("%");
        operand="%";
        prvi=false;
        ispisLabela="";
    }

// =
@FXML
    public void jednakoBtnClick(ActionEvent actionEvent) {
    boolean greska = false;
        Double a = Double.parseDouble(prviBroj.toString());
        Double  b= Double.parseDouble(drugiBroj.toString());
        Double rezultat = (double) 0;
        switch(operand) {
            case "+":
                rezultat = a + b;
                break;
            case "-":
                rezultat = a - b;
                break;
            case "/":{
                if (b == 0) {
                    greska=true;
                    labela.setText("Greska! Dijeljenje nulom.");
                    prviBroj = new StringBuilder();
                    drugiBroj = new StringBuilder();
                    prvi = true;
                    ispisLabela = "";
                } else {
                    rezultat = a / b;
                }
                break;}
            case "%":
                rezultat = a % b;
                break;
            case "x":
                rezultat = a * b;
                break;
        }
        if(greska){;
        }
        else {
            labela.setText(rezultat.toString());
            prviBroj = new StringBuilder();
            prviBroj.append(rezultat);
            drugiBroj = new StringBuilder();
            operand = "";
            operand = "";
            ispisLabela = "";
        }
        }

    }

