package org.example.controller;

import org.example.model.Episode;
import org.example.TvSerieDataRepository;
import org.example.TvSerieRepository;
import io.javalin.http.Context;
import org.example.model.TvSerie;

import java.util.ArrayList;
import java.util.Comparator;

public class EpisodeController {

    private TvSerieRepository tvSerieRepository;

    public EpisodeController(TvSerieDataRepository tvSerieRepository) {

        this.tvSerieRepository = tvSerieRepository;
    }

    public void getEpisode(Context context) {

        String tvserie = context.pathParam("tvserie-id");
        int sesongNr = Integer.parseInt(context.pathParam("sesong-nr"));
        int episodeNr = Integer.parseInt(context.pathParam("episode-nr"));
        Episode Episode = tvSerieRepository.getEnEpisode(tvserie,sesongNr,episodeNr);

        context.json(Episode);
    }
    public void getAlleEpisoder(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-id");
        ArrayList<Episode> alleEpisoder = tvSerieRepository.getAlleEpisoder(tvSerieTittel);
        String sorteringsparameter = context.queryParam("sortering");
        //System.out.println(sorteringsparameter);
        if (sorteringsparameter.equals("tittel")){
            alleEpisoder.sort(Comparator.comparing(Episode::getTittel));

        } else if (sorteringsparameter.equals("episodenr")) {
            alleEpisoder.sort(Comparator.comparingInt(Episode::getEpisodeNummer));

        } else if (sorteringsparameter.equals("spilletid")) {
            alleEpisoder.sort(Comparator.comparingInt(Episode::getSpilletid));

        }

        context.json(alleEpisoder);

    }

}
