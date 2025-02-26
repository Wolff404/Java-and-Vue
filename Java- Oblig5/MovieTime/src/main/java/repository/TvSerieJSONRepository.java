package repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Episode;
import model.TvSerie;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class TvSerieJSONRepository implements TvSerieRepository{
    private ArrayList<TvSerie> tvSeries;
    private final File file;


    public TvSerieJSONRepository(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        this.file = new File(fileName);
        this.tvSeries = objectMapper.readValue(this.file, new TypeReference<ArrayList<TvSerie>>(){});
    }


    public TvSerieJSONRepository(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        this.file = file;
        this.tvSeries = objectMapper.readValue(this.file, new TypeReference<ArrayList<TvSerie>>(){});
    }
    public void reload() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        this.tvSeries = objectMapper.readValue(this.file, new TypeReference<ArrayList<TvSerie>>(){});
    }


    public void skrivTilEnFil(String file, ArrayList<TvSerie> tvSeries) throws IOException {
        File jsonfile = new File(file);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonfile, tvSeries);
    }

    @JsonIgnore
    public void createEpisode(String tvSerieTittel, Episode episode) {
        getTvSerie(tvSerieTittel).leggTilEpisode(episode);

    }

    @JsonIgnore
    public void updateEpisode(String tvSerieTittel, int sesongNummer, int episodeNummer, String tittel, int nysesongNr, int nyepisodeNr, String beskrivelse, int spilletid, LocalDate utgivelsesdato, String bildeUrl) {
        Episode episode = this.getEpisode(tvSerieTittel, sesongNummer, episodeNummer);
        episode.setTittel(tittel);
        episode.setBeskrivelse(beskrivelse);
        episode.setEpisodeNummer(nyepisodeNr);
        episode.setSesongNummer(nysesongNr);
        episode.setSpilletid(spilletid);
        episode.setUtgivelsesdato(utgivelsesdato);
        episode.setBildeUrl(bildeUrl);


    }

    @JsonIgnore
    public Episode deleteEpisode(String tvSerieTittel, int sesongNr, int episodeNr)  {
        getTvSerie(tvSerieTittel).slettEpisode(getEpisode(tvSerieTittel,sesongNr,episodeNr));
        try {
            skrivTilEnFil("slettetelementfrafil.json",tvSeries);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @JsonIgnore
    public ArrayList<TvSerie> getTVSerier() {
        return this.tvSeries;
    }

    @JsonIgnore
    public TvSerie getTvSerie(String tvSerieId) {
        for (TvSerie tvSerie: tvSeries) {
            if (tvSerie.getTittel().equals(tvSerieId))
                return tvSerie;
        }
        return null;
    }

    @JsonIgnore
    public ArrayList<Episode> getEpisoderISesong(String tvSerieTittel, int sesongNr) {
        return getTvSerie(tvSerieTittel).hentEpisoderISesong(sesongNr);
    }

    @JsonIgnore
    public Episode getEpisode(String tvSerieTittel, int sesongNr, int episodeNr) {
        return getTvSerie(tvSerieTittel).getEpisode(sesongNr, episodeNr);
    }


}
