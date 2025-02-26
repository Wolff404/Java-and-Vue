public class Episode {
    private String title;
    private int episodeNr;
    private int seasonNr;
    private int playtime;

    public Episode(String title, int episodeNr, int seasonNr, int playtime) {
        this.title = title;
        this.episodeNr = episodeNr;
        this.seasonNr = seasonNr;
        this.playtime = playtime;
    }
    public Episode(String title, int episodeNr, int seasonNr) {
        this.title = title;
        this.episodeNr = episodeNr;
        this.seasonNr = seasonNr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public int getSeasonNr() {
        return seasonNr;
    }

    public void setSeasonNr(int seasonNr) {
        this.seasonNr = seasonNr;
    }

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }
}


