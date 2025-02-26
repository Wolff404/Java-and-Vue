import java.time.LocalDate;
import java.util.ArrayList;



public class TVSeries {
    private String title;
    private String description;
    private LocalDate release_date;
    private ArrayList<Episode> episodes = new ArrayList<Episode>();
    private float averagePlayTime;
    private int numberOfSeasons = 0;


    public void leggTilEpisode(Episode episode) {
        if(episode.getSeasonNr() <= numberOfSeasons+ 1){
            episodes.add(episode);
            updateAveragePlaytime();
        }
        else {
            System.out.println("Error, you can not add an episode to a season that does not exist, yet.");
        }
        if(episode.getSeasonNr() == numberOfSeasons+1){
            numberOfSeasons++;
        }
    }

    public float getAveragePlayTime() {
        return averagePlayTime;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public TVSeries(String title, String description, LocalDate release_date) {
        this.title = title;
        this.description = description;
        this.release_date = release_date;
    }
    public String toString(){
        return " Tittel: " + this.title + "\n Har beskrivelsen: " + this.description + "\n Ble utgitt: " + this.release_date ;
    }
    public ArrayList<Episode> getEpisodesInSeason(int season) {
        ArrayList<Episode> episodesInSeason = new ArrayList<Episode>();
        for (int i = 0; i < this.episodes.size(); i++ ) {
            if (this.episodes.get(i).getSeasonNr() == season){
                episodesInSeason.add(this.episodes.get(i));
            }
        }
        return episodesInSeason;
    }
    private void updateAveragePlaytime(){
        float sumOfPlaytime = 0;
        for (int i = 0; i < this.episodes.size(); i++){
            sumOfPlaytime += this.episodes.get(i).getPlaytime();
        }
        this.averagePlayTime = sumOfPlaytime / this.episodes.size();
    }
}
