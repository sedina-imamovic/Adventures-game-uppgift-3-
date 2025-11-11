package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DungeonRoomTest {

    @Test
    public void testEnterRoom() {

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");

        Player player = new Player.Builder()
                .health(100)
                .strength(25)
                .build();

        DungeonRoom dungeonRoom = new DungeonRoom();

        dungeonRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasDefeatedEnemy(),
                "Fienden borde vara besegrad"
                );

    }

}
