import java.time.LocalDate;
import java.util.ArrayList;

public class TvSerie {
    private String tittel, beskrivelse;
    private LocalDate utgivelsesDato;
    private ArrayList<Episode> episoder;
    private int gjennomsnittligSpilletid, antallSesonger;

    public TvSerie(String tittel, String beskrivelse, LocalDate utgivelsesDato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesDato = utgivelsesDato;
        episoder = new ArrayList<>();
    }

    public void leggTilEpisode(Episode episode) {
        if (antallSesonger+1 < episode.getSesongNr()) {
            System.out.println("FEIL: Episoden \"" + episode + "\" kan ikke være høyere enn sesong: " + (antallSesonger+1));
        }
        else {
            episoder.add(episode);
            oppdaterGjennomsnittligSpilletid();

            if (antallSesonger < episode.getSesongNr()) {
                antallSesonger++;
            }
        }
    }

    private void oppdaterGjennomsnittligSpilletid() {
        int sum = 0;

        for (Episode episode : episoder) {
            sum += episode.getSpilletid();
        }

        gjennomsnittligSpilletid = sum / episoder.size();
    }

    public ArrayList<Episode> hentEpisoderISesong(int sesong) {
        ArrayList<Episode> episoderISesong = new ArrayList<>();

        for (Episode episode : episoder) {
            if (episode.getSesongNr() == sesong)
                episoderISesong.add(episode);
        }

        return episoderISesong;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesDato() {
        return utgivelsesDato;
    }

    public void setUtgivelsesDato(LocalDate utgivelsesDato) {
        this.utgivelsesDato = utgivelsesDato;
    }

    /**
     * Henter en liste med alle episodene for TvSerien
     * @return Liste med alle episodene
     */
    public ArrayList<Episode> getEpisoder() {
        // Vi lager en kopi av listen vi har, slik at den interne listen ikke kan manipuleres direkte utenfor klassen (innkapsling)
        return new ArrayList<>(episoder);
    }

    public ArrayList<Rolle> hentRollebesetning() {
        ArrayList<Rolle> alleRoller = new ArrayList<Rolle>();
        for (Episode episode: this.episoder) {
            alleRoller.addAll(episode.getRolleListe());
        }
        return alleRoller;

    }

    public int getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    @Override
    public String toString() {
        return tittel +" - " + utgivelsesDato.getYear();
    }
}
