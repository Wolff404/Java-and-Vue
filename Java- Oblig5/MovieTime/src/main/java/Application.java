import controller.EpisodeController;
import controller.TvSerieController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import model.TvSerie;
import repository.TvSerieCSVRepository;
import repository.TvSerieDataRepository;
import repository.TvSerieJSONRepository;
import repository.TvSerieRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(8100);

        File javatest = new File("src/main/resources/jsonfilmer/tvshows_10.json");
        TvSerieJSONRepository json = new TvSerieJSONRepository((File) javatest);

        File csvtest = new File("src/main/resources/csvshows/tvshows_10.csv");
        TvSerieCSVRepository csv = new TvSerieCSVRepository(csvtest);

        csv.skrivTilCSVFil("skrivtilcsv.csv");
        json.skrivTilEnFil("skrivtiljson.json", json.getTVSerier());

        Thread thread = new Thread();

        /*
        for (TvSerie info: json.getTVSerier()) {
            //System.out.println(info.getTittel()+ " (" + info.getAntallSesonger() + " sesonger)");
        }

        for (TvSerie test: csv.getTVSerier()) {
            System.out.println(test.getTittel() + " - " + test.getAntallSesonger() + " sesonger");
        }

        */

        app.before("/", ctx -> ctx.redirect("/tvserie"));

        app.get("/tvserie", new VueComponent("tvserie-overview"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}", new VueComponent("tvserie-detail"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new VueComponent("episode-detail"));
        app.get("/tvserie/{tvserie-id}/createepisode", new VueComponent("episode-create"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}/updateepisode", new VueComponent("episode-update"));

        //TvSerieRepository tvSerieRepository = new TvSerieDataRepository();
        TvSerieRepository tvSerieRepository = new TvSerieJSONRepository("heisannhoppsann.json");
        TvSerieController tvSerieController = new TvSerieController(tvSerieRepository);
        EpisodeController episodeController = new EpisodeController(tvSerieRepository);



        app.get("api/tvserie", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                tvSerieController.getAlleTvSerier(ctx);
            }
        });

        app.get("api/tvserie/{tvserie-id}", context -> tvSerieController.getTVSerie(context));
        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}", episodeController::getEpisoderISesong);
        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", episodeController::getEpisode);
        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}/deleteepisode", episodeController::deleteEpisode);
        app.post("/api/tvserie/{tvserie-id}/createepisode", episodeController::createEpisode);
        app.post("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}/updateepisode", episodeController::updateEpisode);
    }

}
