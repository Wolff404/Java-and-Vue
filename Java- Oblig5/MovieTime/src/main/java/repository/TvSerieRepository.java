package repository;

import model.Episode;
import model.TvSerie;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TvSerieRepository {
    ArrayList<TvSerie> getTVSerier();

    TvSerie getTvSerie(String tvSerieId);

    ArrayList<Episode> getEpisoderISesong(String tvSerieTittel, int sesongNr);

    Episode getEpisode(String tvSerieTittel, int sesongNr, int episodeNr);

    void createEpisode(String tvSerieTittel, Episode episode);
    void updateEpisode(String tvSerieTittel, int sesongNummer, int episodeNummer, String tittel, int nysesongNr, int nyepisodeNr, String beskrivelse, int spilletid, LocalDate utgivelsesdato, String bildeUrl);
    Episode deleteEpisode(String tvSerieTittel, int sesongNr, int episodeNr);

}
