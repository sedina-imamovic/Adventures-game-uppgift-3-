package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForestRoomTest {

    @Test
    public void testEnterRoom() {

        // för att kunna utföra testet skapas en instans av FakeUI
        // simulerar användarinmatning
        FakeUI fakeUI = new FakeUI();

        // använder set-metoden, då man hittat nyckeln
        fakeUI.setInput("ja");

        // för att kunna utföra testet skapas två instanser
        Player player = new Player.Builder()
                .build();

        ForestRoom forestRoom = new ForestRoom();

        // anropar metoden som ska testas,
        forestRoom.enterRoom(player, fakeUI);


        // verifierar om metoden returnerar true
        assertTrue(player.hasFoundKey(),
                "Spelaren borde ha hittat nyckeln"
        );
    }
}
