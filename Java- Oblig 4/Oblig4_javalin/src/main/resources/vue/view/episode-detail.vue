<!--

Det må finnes get-metoder i klassene Produksjon og Episode som matcher dataene som forventes i denne filen.

Produksjon:
- tittel
- spilletid (int i minutter)
- utgivelsesdato
- regissor   - forventer også instansvariabelen videre i Person-klassen:
    - fulltNavn
- bildeUrl

Episode:
- episodeNummer
- sesongNummer

 -->


<template id="episode-detail">
    <div v-if="episode" class="detail-episode-container">
        <div v-if="!episode.tittel" class="error">Produksjon må ha get-metode for "tittel"</div>
        <div v-if="!episode.sesongNummer" class="error">Episode må ha get-metode for "sesongNummer"</div>
        <div v-if="!episode.episodeNummer" class="error">Episode må ha get-metode for "episodeNummer"</div>
        <div v-if="!episode.spilletid" class="error">Produksjon må ha get-metode for "spilletid"</div>
        <div v-if="!episode.utgivelsesdato" class="error">Produksjon må ha get-metode for "utgivelsesdato"</div>
        <div v-if="!episode.beskrivelse" class="error">Produksjon må ha get-metode for "beskrivelse"</div>
        <div v-if="!episode.regissor" class="error">Produksjon må ha get-metode for "regissor"</div>
        <div v-if="episode.regissor && !episode.regissor.fulltNavn" class="error">Person må ha get-metode for "fulltNavn"</div>

        <h1>S{{episode.sesongNummer}}E{{episode.episodeNummer}} - {{episode.tittel}}</h1>
        <img v-if="episode.bildeUrl" class="cover-image" v-bind:src="episode.bildeUrl">
        <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Stranger_Things_Rasmiy_posteri.jpg/405px-Stranger_Things_Rasmiy_posteri.jpg">
        <br />
        <h2>Spilletid: {{episode.spilletid}} min</h2>

        <h2 v-if="episode.utgivelsesdato">Utgivelsesdato: {{episode.utgivelsesdato[2]}}.{{episode.utgivelsesdato[1]}}.{{episode.utgivelsesdato[0]}}</h2>
        <h3 v-if="episode.regissor && episode.regissor.fulltNavn">Regissert av: {{episode.regissor.fulltNavn}}</h3>
        <p>{{episode.beskrivelse}}</p>
    </div>
</template>
<script>
    app.component("episode-detail", {
        template: "#episode-detail",
        data: () => ({
            episode: null,
        }),
        created() {
            const tvserieId = this.$javalin.pathParams["tvserie-id"];
            const sesongNr = this.$javalin.pathParams["sesong-nr"];
            const episodeNr = this.$javalin.pathParams["episode-nr"];
            fetch(`/api/tvserie/${tvserieId}/sesong/${sesongNr}/episode/${episodeNr}`)
                .then(res => res.json())
                .then(res => this.episode = res)
                .catch(() => alert("4Feil ved uthenting av episode.\n" +
          "Har du laget en get-path i formatet: \napi/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}\n" +
          "som gir data om en Episode?"));
        }
    });
</script>
<style>
    ul{
       color:white;
    }
    div.detail-episode-container > p {
        max-width: 30em;
    }
    div.detail-episode-container{
      padding: 10px;
      overflow: hidden;
      width: 750px;
      margin: 0 auto;
      background-color: rgba(2, 2, 2, 0.98);
      opacity: 0.96;
      color: white;
      -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
      -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
      box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }


    img.cover-image {
      height: auto;
      width: 50%;
      margin: 5px;
      float: left;
    }

    .error {
      color: firebrick;
      font-size: 24px;
      text-align: center;
    }

</style>