package org.example;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import org.example.controller.EpisodeController;
import org.example.controller.TvSerieController;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {
        /*
        Javalin app = Javalin.create().start(6969);
        app.get("/", ctx -> ctx.result("Hello World"));

         */

        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(6969);



        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception{
                context.redirect("/tvserie/");
            }
        });


        app.get("/tvserie", new VueComponent("tvserie-overview"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}", new VueComponent("tvserie-detail"));

        TvSerieDataRepository TvSerieRepository  = new TvSerieDataRepository();
        TvSerieController tvSerieController = new TvSerieController(TvSerieRepository);
        EpisodeController episodeController = new EpisodeController(TvSerieRepository);

        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new VueComponent("episode-detail"));


        app.get("/api/tvserie/", new Handler() {
                @Override
                public void handle(Context context) {
                tvSerieController.getAlleTvseries(context);
                }
        });

        app.get("/api/tvserie/{tvserie-id}/", new Handler() {
            @Override
            public void handle(Context context) {
                tvSerieController.getTvserie(context);
            }
        });

        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}", new Handler() {
            @Override
            public void handle(Context context) {
                episodeController.getAlleEpisoder(context);
            }
        });
        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new Handler() {
            @Override
            public void handle(Context context){
                episodeController.getEpisode(context);
            }
        });

    }

}
