package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreasureRoomTest {

    @Test
    public void testEnterRoom() {
        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        Player player = new Player.Builder()
                // spelaren har redan hittat nyckeln
                .foundKey(true)
                .build();

        TreasureRoom treasureRoom = new TreasureRoom();

        treasureRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasOpenedChest(),
                "Kistan borde ha öppnats efter att spelaren hittat nyckeln"
        );


    }


}
