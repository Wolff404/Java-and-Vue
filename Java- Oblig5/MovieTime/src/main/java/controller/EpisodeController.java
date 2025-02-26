package controller;

import io.javalin.http.Context;
import model.Episode;
import model.Produksjon;
import repository.TvSerieRepository;

import java.time.LocalDate;
import java.util.*;

public class EpisodeController {
    private TvSerieRepository tvSerieRepository;

    public EpisodeController(TvSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getEpisoderISesong(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-id");
        String sesong = context.pathParam("sesong-nr");
        String sortering = context.queryParam("sortering");

        int sesongNr = sesong.isEmpty()? 1 : Integer.parseInt(sesong);

        ArrayList<Episode> episoder = tvSerieRepository.getEpisoderISesong(tvSerieTittel, sesongNr);

        if (sortering != null) {
            switch (sortering) {
                case "episodenr" -> Collections.sort(episoder);
                case "tittel" -> episoder.sort((e1, e2) -> e1.getTittel().compareTo(e2.getTittel()));
                case "spilletid" -> episoder.sort(Comparator.comparingInt(Produksjon::getSpilletid));
            }
        }

        context.json(episoder);
    }

    public void getEpisode(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-id");
        String sesongNr = context.pathParam("sesong-nr");
        String episodeNr = context.pathParam("episode-nr");

        context.json(tvSerieRepository.getEpisode(tvSerieTittel, Integer.parseInt(sesongNr), Integer.parseInt(episodeNr)));

    }
    public void deleteEpisode(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-id");
        String sesongNr = context.pathParam("sesong-nr");
        String episodeNr = context.pathParam("episode-nr");

        tvSerieRepository.deleteEpisode(tvSerieTittel,Integer.parseInt(sesongNr),Integer.parseInt(episodeNr));
        context.redirect("/tvserie/" + tvSerieTittel + "/sesong/" + sesongNr);

    }
    public void createEpisode(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-id");
        String tittel = context.formParam("tittel");
        int sesongnummer = Integer.parseInt(context.formParam("sesongNummer"));
        int episodenummer = Integer.parseInt(context.formParam("episodeNummer"));
        String beskrivelse = context.formParam("beskrivelse");
        int spilletid = Integer.parseInt(context.formParam("spilletid"));
        LocalDate utgivelsesdato = LocalDate.parse(context.formParam("utgivelsesdato"));
        String bilde_url = context.formParam("bildeUrl");
        Episode nyEpisode = new Episode(tittel,beskrivelse,episodenummer,sesongnummer,spilletid,utgivelsesdato,bilde_url);
        tvSerieRepository.createEpisode(tvSerieTittel, nyEpisode);
        context.redirect("/tvserie/" + tvSerieTittel + "/sesong/" + sesongnummer);

    }

    public void updateEpisode(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-id");
        int sesongNr = Integer.parseInt(context.pathParam("sesong-nr"));
        int episodeNr = Integer.parseInt(context.pathParam("episode-nr"));

        String tittel = context.formParam("tittel");
        int nyttsesongnummer = Integer.parseInt(context.formParam("sesongNummer"));
        int nyttepisodenummer = Integer.parseInt(context.formParam("episodeNummer"));
        String beskrivelse = context.formParam("beskrivelse");
        int spilletid = Integer.parseInt(context.formParam("spilletid"));
        LocalDate utgivelsesdato = LocalDate.parse(context.formParam("utgivelsesdato"));
        String bilde_url = context.formParam("bildeUrl");
        tvSerieRepository.updateEpisode(tvSerieTittel,sesongNr,episodeNr,tittel,nyttsesongnummer,nyttepisodenummer,beskrivelse,spilletid,utgivelsesdato,bilde_url);

        context.redirect("/tvserie/" + tvSerieTittel + "/sesong/" + nyttsesongnummer + "/episode/" + nyttepisodenummer);
    }

}
