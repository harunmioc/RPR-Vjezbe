package ba.unsa.etf.rpr.lv3.z1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

        private static Imenik imenik = new Imenik();

        @BeforeAll
        public static void setup(){
            imenik.dodaj("Eldar",  new FiksniBroj(Grad.SARAJEVO, "225-883"));
            imenik.dodaj("Dino" , new MobilniBroj(61, "225-885"));
            imenik.dodaj("Chris", new MedunarodniBroj("+44", "7768878794"));
        }


    @Test
    public void dajBrojFound() {
       String broj = imenik.dajBroj("Eldar");
       assertEquals(broj, "033/225-883");
    }

    @Test
    public void dajBrojNotFound(){
        String broj = imenik.dajBroj("Eldarinjo");
        assertNull(broj);
    }

    @Test
    public void dodajTestPositive(){
            TelefonskiBroj br= new MobilniBroj(61, "507-885");
            imenik.dodaj("Hamo", br);

            String brojStr = imenik.dajBroj("Hamo");
            assertEquals(brojStr, "061/607-855");
    }

    @Test
    public void dodajFiksniException(){
            assertThrows(BrojException.class, new Executable() {
                @Override
                public void execute() throws Throwable {
                    new FiksniBroj(null, "123-123");
                }
            });
            assertThrows(BrojException.class, ()-> {new FiksniBroj(null, "123-123");});
    }


}
