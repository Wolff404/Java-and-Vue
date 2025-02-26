package repository;

import model.Episode;
import model.Person;
import model.TvSerie;


import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class TvSerieCSVRepository implements TvSerieRepository {
    private HashMap<String, TvSerie> tvSerier;

    public TvSerieCSVRepository(String filename) throws FileNotFoundException {
        this(new File(filename));
    }

    public TvSerieCSVRepository(File file) throws FileNotFoundException {
        this.tvSerier = readCSVfile(file);
    }

    public HashMap<String, TvSerie> readCSVfile(File file) {
        HashMap<String, TvSerie> tvSeriesFromFile = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");
                String tv_tittel = parts[0];
                String tv_beskrivelse = parts[1];
                LocalDate tv_utgivelsesdato = LocalDate.parse(parts[2]);
                String tv_bildeUrl = parts[3];
                String ep_tittel = parts[4];
                String ep_beskrivelse = parts[5];
                int ep_nummer = Integer.parseInt(parts[6]);
                int ep_sesongNummer = Integer.parseInt(parts[7]);
                int ep_spilletid = Integer.parseInt(parts[8]);
                LocalDate ep_utgivelsesdato = LocalDate.parse(parts[9]);
                String ep_bildeUrl = parts[10];
                String reg_fornavn = parts[11];
                String reg_etternavn = parts[12];
                LocalDate reg_fodselsdato = LocalDate.parse(parts[13]);
                Person regissør = new Person(reg_fornavn,reg_etternavn,reg_fodselsdato);
                Episode episode = new Episode(ep_tittel,ep_beskrivelse,ep_nummer,ep_sesongNummer,ep_spilletid,ep_utgivelsesdato,regissør,ep_bildeUrl);

                if (!tvSeriesFromFile.containsKey(tv_tittel)){
                    TvSerie addTvserie = new TvSerie(tv_tittel,tv_beskrivelse,tv_utgivelsesdato,tv_bildeUrl);
                    tvSeriesFromFile.put(tv_tittel,addTvserie);
                }
                tvSeriesFromFile.get(tv_tittel).leggTilEpisode(episode);
            }

        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Wops");
        }
        catch (IOException ioException) {
            System.out.println("wops igjen");
        }
        return tvSeriesFromFile;
    }

    public void skrivTilCSVFil(String filnavn) {
        File csvFil = new File(filnavn);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFil))) {
            // writer.write("tv_tittel;tv_beskrivelse;tv_utgivelsesdato;tv_bildeUrl;ep_tittel;ep_beskrivelse;ep_nummer;ep_sesongNummer;ep_spilletid;ep_utgivelsesdato;ep_bildeUrl;reg_fornavn;reg_etternavn;reg_fodselsdato");
            // writer.newLine();

            for (TvSerie tvSerie : this.getTVSerier()) {
                for (Episode episode: tvSerie.getEpisoder()) {
                    writer.write(tvSerie.getTittel() + ";" +
                            tvSerie.getBeskrivelse() + ";" +
                            tvSerie.getUtgivelsesdato() + ";" +
                            tvSerie.getBildeUrl() + ";" +
                            episode.getTittel() + ";" +
                            episode.getBeskrivelse() + ";" +
                            episode.getEpisodeNummer() + ";" +
                            episode.getSesongNummer() + ";" +
                            episode.getSpilletid() + ";" +
                            episode.getUtgivelsesdato() + ";" +
                            episode.getBildeUrl() + ";" +
                            episode.getRegissor().getFornavn() + ";" +
                            episode.getRegissor().getEtternavn() + ";" +
                            episode.getRegissor().getFodselsDato());
                    writer.newLine();
                }
            }
        }
        catch (IOException e) {
            System.err.println("BufferedWriter feilet: " + e.getMessage());
        }
    }


    @Override
    public void createEpisode(String tvSerieTittel, Episode episode) {
    }

    @Override
    public void updateEpisode(String tvSerieTittel, int sesongNummer, int episodeNummer, String tittel, int nysesongNr, int nyepisodeNr, String beskrivelse, int spilletid, LocalDate utgivelsesdato, String bildeUrl) {

    }

    @Override
    public Episode deleteEpisode(String tvSerieTittel, int sesongNr, int episodeNr) {
        return null;
    }

    @Override
    public ArrayList<TvSerie> getTVSerier() {
        TvSerie[] buss = this.tvSerier.values().toArray(new TvSerie[0]);
        return new ArrayList<>(Arrays.asList(buss));
    }

    @Override
    public TvSerie getTvSerie(String tvSerieId) {
        return null;
    }

    @Override
    public ArrayList<Episode> getEpisoderISesong(String tvSerieTittel, int sesongNr) {
        return null;
    }

    @Override
    public Episode getEpisode(String tvSerieTittel, int sesongNr, int episodeNr) {
        return null;
    }
}

