package org.example;

import org.example.model.Episode;
import org.example.model.TvSerie;

import java.time.LocalDate;
import java.util.ArrayList;

public class TvSerieDataRepository implements TvSerieRepository {
    public ArrayList<TvSerie> tvSerierliste = new ArrayList<>();



    public TvSerieDataRepository(){

        laginfo();
    }

    private void laginfo() {
        TvSerie lou = new TvSerie("The Last of us", "Very nice", LocalDate.now(),"https://img-9gag-fun.9cache.com/photo/aL1vwev_460s.jpg");
        Episode louep1 = new Episode("The first of us", 1, 1);
        Episode louep2 = new Episode("The second of us", 2, 1);
        lou.leggTilEpisode(louep1);
        lou.leggTilEpisode(louep2);
        tvSerierliste.add(lou);


        TvSerie st = new TvSerie("Stranger things", "Very ok", LocalDate.now(),"https://pyxis.nymag.com/v1/imgs/f84/a58/35e8b77a776e16f01845704ca644b89344-vecna-lede.rhorizontal.h600.jpg");
        Episode step1 = new Episode("Skummle ting episode 1", 1, 1);
        Episode step2 = new Episode("Litt mer skummle ting episode 2", 2, 1);
        st.leggTilEpisode(step1);
        st.leggTilEpisode(step2);
        tvSerierliste.add(st);
    }

    @Override
    public ArrayList<TvSerie> getAlleSerier() {
        return tvSerierliste;
    }

    @Override
    public TvSerie getEnSerie(String tvserieTittel) {
        for (TvSerie tvSerie : tvSerierliste) {
            if (tvSerie.getTittel().equals(tvserieTittel))
                return tvSerie;
            }
        return null;

    }


    @Override
    public ArrayList<Episode> getAlleEpisoder(String tvserieTittel) {
        TvSerie tvSerie = getEnSerie(tvserieTittel);
        return tvSerie.hentEpisodeListe();

    }
    @Override
    public Episode getEnEpisode(String tvserie, int sesongNummer, int episodeNummer) {
        for (Episode episode : getAlleEpisoder(tvserie)) {
            if (episode.getSesongNummer() == (sesongNummer) && episode.getEpisodeNummer() == episodeNummer) {
                return episode;
            }

        }
        return null;
    }
}


