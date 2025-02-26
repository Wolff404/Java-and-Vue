package org.example.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.random.*;

// En Episode "er en" produksjon, så derfor har vi satt at den extender Produksjon
// Vi får dermed med alle egenskapene fra Produksjon "gratis"
public class Episode extends Produksjon implements Comparable<Episode> {

    private int episodeNummer, sesongNummer;



    public Episode(String tittel, int episodeNummer, int sesongNummer) {
        this(tittel, "Hei", episodeNummer, sesongNummer, 0, LocalDate.now(), new Person("Unknown", "Unknown"),"https://st.depositphotos.com/1157399/2453/i/600/depositphotos_24531911-stock-photo-woman-with-old-retro-tv.jpg");
    }

    public Episode(String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        // Kaller superkontruktøren (som tilhører Produksjon), vi "sender" da tittel, beskrivelse, spilletid, utgivelsesdato og regisor videre
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }
    public Episode(String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato, Person regissor,String bildeUrl) {
        // Kaller superkontruktøren (som tilhører Produksjon), vi "sender" da tittel, beskrivelse, spilletid, utgivelsesdato og regisor videre
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor, bildeUrl="https://st.depositphotos.com/1157399/2453/i/600/depositphotos_24531911-stock-photo-woman-with-old-retro-tv.jpg");
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public void setEpisodeNummer(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    public void setSesongNummer(int sesongNummer) {
        this.sesongNummer = sesongNummer;
    }


    @Override
    public String toString() {
        return "E" + String.format("%02d", episodeNummer) + "S" + String.format("%02d", sesongNummer) + " - " + super.getTittel() + " - " + super.getSpilletid() + "min";
    }


    @Override
    public int compareTo(Episode annenEpisode) {
        if(this.episodeNummer == annenEpisode.getEpisodeNummer()){
            return 0;
        }
        else if (this.episodeNummer < annenEpisode.getEpisodeNummer()) {
            return -1;
        }
        else {
            return 1;
        }


    }
}
