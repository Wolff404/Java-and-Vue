import java.time.LocalDate;
import java.util.ArrayList;


public class Produksjon {

    private String tittel;
    private int spilletid;
    private LocalDate utgivelsesdato;
    private String beskrivelse;
    private Person regissor;
    private ArrayList<Rolle> rolleListe = new ArrayList<Rolle>();

    public Produksjon(String tittel, int spilletid,java.time.LocalDate utgivelsesdato, String beskrivelse,Person regissor) {
        this.tittel = tittel;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
        this.beskrivelse = beskrivelse;
        this.regissor = regissor;
    }

    public Produksjon(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse) {
        this.tittel = tittel;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
        this.beskrivelse = beskrivelse;
    }


    public void leggTilEnRolle(Rolle enRolle){
        rolleListe.add(enRolle);
    }

    public void leggTilFlereRoller(ArrayList<Rolle> flereRoller){
        rolleListe.addAll(flereRoller);
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String title) {
        this.tittel = title;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }


    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public Person getRegissor() {
        return regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    public ArrayList<Rolle> getRolleListe() {
        return rolleListe;
    }


}
