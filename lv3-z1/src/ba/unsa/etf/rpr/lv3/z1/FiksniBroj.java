package ba.unsa.etf.rpr.lv3.z1;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private String broj;
    private Grad grad;

    //konstruktor
    public FiksniBroj(Grad grad, String broj){
        if(grad == null) throw new BrojException("Pozivni broj za fiksni telefon nije uredu!");
        this.grad=grad;
        this.broj=broj;
    }


@Override
public String ispisi(){
        if(grad != null && broj != null)
            return grad.getPozivniBroj()+"/"+broj;
        else{
            return null;
        }
}


@Override
    public int hashCode() { return Objects.hash(grad, broj);}

    public Grad getGrad(){
        return grad;
    }

    public String getBroj(){
        return broj;
    }

}



