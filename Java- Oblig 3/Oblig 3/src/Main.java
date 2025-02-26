import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
// Lager og instansierer objektet strangerThings av typen TvSerie
        TvSerie strangerThings = new TvSerie("Stranger Things",
                "When a young boy disappears, his mother, a police chief, and his friends must confront terrifying forces in order to get him back.",
                LocalDate.of(2016, 7,15));

        // Lager og instansierer noen objekter av typen Episode
        Episode episode1 = new Episode("Chapter One: The Vanishing of Will Byers", 1, 1, 50);
        Episode episode2 = new Episode("Chapter Two: The Weirdo on Maple Street", 2, 1, 50);
        Episode episode3 = new Episode("Chapter Three: Holly, Jolly", 3, 1, 50);
        Episode episode4 = new Episode("Chapter Four: The Body", 4, 1, 50);

        // Legger til episodeobjektene til tvserieobjektet strangerThings
        strangerThings.leggTilEpisode(episode1);
        strangerThings.leggTilEpisode(episode2);
        strangerThings.leggTilEpisode(episode3);
        strangerThings.leggTilEpisode(episode4);

        // Instansierer noen objekter av typen Episode og legger de direkte inn i TvSerie objektet strangerThings
        strangerThings.leggTilEpisode(new Episode("Chapter One: MADMAX", 1, 2, 50));
        strangerThings.leggTilEpisode(new Episode("Chapter Two: Trick or Treat, Freak", 2, 2, 50));
        strangerThings.leggTilEpisode(new Episode("Chapter Three: The Pollywog", 3, 2, 50));

        // Henter ut en liste med episoder fra objektet strangerThings
        ArrayList<Episode> episodeListe = strangerThings.getEpisoder();

        System.out.println("**************************");
        System.out.println("* " + strangerThings + " *"); // Skriver ut TvSerie-objektet (toString() blir kalt)
        System.out.println("**************************");
        System.out.println("-------Alle Episoder------");

        // Går gjennom alle episoder og skriver ut objektet (toString blir kalt)
        for (Episode enEpisode : episodeListe) {
            System.out.println(enEpisode);
        }

        System.out.println("**************************\n");

        // Lager og instansierer objektet gameOfThrones av typen TvSerie
        TvSerie gameOfThrones = new TvSerie("Game of Thrones", "They are in a game for the throne.", LocalDate.of(2011, 4, 11));

        // Oppretter og instansierer ett objekt av typen Random, for å kunne generere en tilfeldig spilletid
        Random randomTallGenerator = new Random();

        // En dobbel for-løkke som går gjennom å lager 5 sesonger med 20 episoder av Game of Thrones
        for (int sesongNr = 1; sesongNr <= 5; sesongNr++) {
            for (int episodeNr = 1; episodeNr <= 20; episodeNr++) {
                // Instansierer og legger til en episode, bruker Random-objektet til å generere et tall mellom 0 og 10, plusser så på 20 (for å få en verdi mellom 20 og 30)
                gameOfThrones.leggTilEpisode(new Episode("Generic Title", episodeNr, sesongNr, randomTallGenerator.nextInt(11) + 20));
            }
        }

        // Henter ut alle episodene til TvSerie-objektet gameOfThrones for sesong 4
        ArrayList<Episode> gameOfThronesSesong4Episoder = gameOfThrones.hentEpisoderISesong(4);

        System.out.println("**************************");
        System.out.println("* " + gameOfThrones + " *");  // Skriver ut TvSerie-objektet (toString() blir kalt)
        System.out.println("**************************");
        System.out.println("**** Spilletid: " + gameOfThrones.getGjennomsnittligSpilletid() + "min ****");
        System.out.println("**************************");
        System.out.println("-------Episoder S04-------");

        // Går gjennom alle episoder vi hentet ut for sesong 4 og skriver ut Episode-objektet (toString blir kalt)
        for (Episode enEpisode : gameOfThronesSesong4Episoder) {
            System.out.println(enEpisode);
        }

        System.out.println("**************************");

        // Prøver å legge til en episode i sesong 10 (om er flere nummer høyere enn nåværende antallet sesonger)
        gameOfThrones.leggTilEpisode(new Episode("EpisodeISesong10", 1, 10, 50));

        Film film1 = new Film("Inception", 240,LocalDate.now(), "Very good nice");
        System.out.println(film1);

        System.out.println();
        Person person1 = new Person("Evan", "Per",19);
        Person person2 = new Person("Test", "Telle",20);
        Person person3 = new Person("Destin", "Palfek",25);
        Person person4 = new Person("Cruster", "Duster",42);
        Person person5 = new Person("Tankelf", "Tralle",39);
        Person person6 = new Person("Kronk", "Penkel",59);


        Film film69 = new Film("Film i kardemommeby",201,LocalDate.now(), "Barnefilm",person1);
        Episode episode69 = new Episode("Teitel", 24,LocalDate.now(), "Brann", person2,1,1);
        System.out.println(film69);
        System.out.println(episode69);

        System.out.println();

        Rolle rolle1 = new Rolle(person3, "Mester", "Malem");
        Rolle rolle2 = new Rolle(person4, "Jemeni", "Koltbord");
        Rolle rolle3 = new Rolle(person5, "Erfiner", "Sapp");
        Rolle rolle4 = new Rolle(person6, "Kanfies", "Albeirt");


        film69.leggTilEnRolle(rolle1);
        episode69.leggTilEnRolle(rolle2);
        System.out.println(film69);
        System.out.println(episode69);
        System.out.println();

        ArrayList<Rolle> theBoys = new ArrayList<Rolle>();
        theBoys.add(rolle3);
        theBoys.add(rolle4);
        theBoys.add(rolle2);


        film69.leggTilFlereRoller(theBoys);
        System.out.println(film69);

        episode69.leggTilFlereRoller(theBoys);

        TvSerie serie420 = new TvSerie("Basisst", "Hjelp", LocalDate.now());

        serie420.leggTilEpisode(episode69);
        System.out.println();

        for(Rolle pent : serie420.hentRollebesetning() ){
            System.out.println(pent);
        }
        System.out.println();
        //System.out.println(serie420.hentRollebesetning());

    }
}
