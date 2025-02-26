package org.example;

import org.example.model.TvSerie;
import org.example.model.Episode;

import java.util.ArrayList;

public interface TvSerieRepository {
    ArrayList<TvSerie> getAlleSerier();

    TvSerie getEnSerie(String tvserieTittel);

    Episode getEnEpisode(String episodeTittel, int sesongNummer, int episodeNummer);

    ArrayList<Episode> getAlleEpisoder(String tvserieTittel);

}
