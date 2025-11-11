package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.StartRoom;
import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.service.StatisticsService;
import se.sprinto.hakan.adventuregame.view.AppInfo;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new ScannerUI();
        ui.showMessage("Välkommen till Äventyrsspelet!");

        // hämtar info från property-filen via Singleton
        AppInfo appInfo = AppInfo.getInstance();

        // läser upp info från property-filen
        String author = appInfo.getProperty("app.author");
        String version = appInfo.getProperty("app.version");

        ui.showMessage("Version " + version + " av " + author);


        String name = ui.getInput("Ange ditt namn:");

        // skapar en player med builder-mönstret
        Player player = new Player.Builder()
                .name(name)
                .health(100)
                .score(0)
                .strength(25)
                .build();


        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

