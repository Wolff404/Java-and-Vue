import java.time.LocalDate;
public class Episode extends Produksjon {
    private int episodeNr, sesongNr;


    public Episode(String tittel, int episodeNr, int sesongNr) {
        // Kaller den andre konstruktøren, sender parameterne videre, men setter spilletid til 0
        this(tittel, episodeNr, sesongNr, 0);
    }

   public Episode(String tittel, int episodeNr, int sesongNr, int spilletid) {
        super(tittel, spilletid,LocalDate.now(),"Beskrivelse");
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }

    public Episode(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse, int episodeNr, int sesongNr) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }


    public Episode(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse, Person regissor, int episodeNr, int sesongNr) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse, regissor);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public int getSesongNr() {
        return sesongNr;
    }

    public void setSesongNr(int sesongNr) {
        this.sesongNr = sesongNr;
    }


    @Override
    public String toString() {
        // String format legger her bare på 0 foran, slik at vi f.eks. får det på formatet 03 fremfor bare 3
        return "Episode tittel - " + getTittel() + " - S" + String.format("%02d", sesongNr) + "E" + String.format("%02d", episodeNr) + " - Spilletid: " + getSpilletid() +
                "min"+ " - Beskrivelse: " + getBeskrivelse() + " -  Ressigert av: " + getRegissor() + " - med skuespiller(e): "
                + getRolleListe();
    }
}
