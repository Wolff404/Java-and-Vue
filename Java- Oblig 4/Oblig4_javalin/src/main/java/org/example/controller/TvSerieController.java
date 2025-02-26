package org.example.controller;

import org.example.model.TvSerie;
import org.example.TvSerieDataRepository;
import org.example.TvSerieRepository;
import io.javalin.http.Context;

import java.util.ArrayList;

public class TvSerieController {
    private TvSerieRepository tvSerieRepository;
    public TvSerieController(TvSerieDataRepository tvSerieRepository) {

        this.tvSerieRepository = tvSerieRepository;
    }
    public void getTvserie(Context context) {

        String tvserieTittel = context.pathParam("tvserie-id");

        TvSerie TvSerie = tvSerieRepository.getEnSerie(tvserieTittel);

        context.json(TvSerie);
    }
    public void getAlleTvseries(Context context) {

        ArrayList<TvSerie> AlleTvseries = tvSerieRepository.getAlleSerier();

        context.json(AlleTvseries);

    }
}
