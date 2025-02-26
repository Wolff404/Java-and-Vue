import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TVSeries The_Last_of_Us = new TVSeries("The Last of us", "Thriller", LocalDate.parse("2023-01-24"));
        TVSeries The_TV_Show = new TVSeries("The TV show", "Thriller", LocalDate.parse("2023-01-24"));
        Episode episode1 = new Episode("Episode 1", 7,9);
        Episode episode2 = new Episode("Episode 2", 25, 9);

        Random randomPlaytime = new Random();

        for (int i = 1; i < 6; i++){
            for (int j = 1; j < 21; j++){
                int x = randomPlaytime.nextInt(20,30);
                Episode episode = new Episode("Episode " + j , j, i, x);
                The_TV_Show.leggTilEpisode(episode);
            }
        }



        ArrayList<Episode> inSeason = The_TV_Show.getEpisodesInSeason(4);
        for(int i = 0; i < inSeason.size(); i++) {
            System.out.println(inSeason.get(i).getTitle() + " " + "med spilletid: " + inSeason.get(i).getPlaytime() + " min");
        }

        The_TV_Show.leggTilEpisode(new Episode("Episode", 25,10));

        System.out.println("The average playtime is: " + The_TV_Show.getAveragePlayTime());
    }
}