import java.time.LocalDate;

public class Film extends Produksjon {
   public Film(String tittel, int spilletid) {
        super(tittel, spilletid,LocalDate.now(),"Test");
    }

    public Film(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse);
    }

    public Film(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse, Person regissor) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse, regissor);
    }

    @Override
    public String toString() {
        return "Film tittel = " + getTittel()+ '\'' + ", Spilletid = " + getSpilletid()
                + " min " + ", Utgivelses dato =  " + getUtgivelsesdato() + ", " + " Beskrivelse =  " + getBeskrivelse() +
                ", Ressigert av =  " + getRegissor() + ", med skuespiller(e): " + getRolleListe();


    }
}
