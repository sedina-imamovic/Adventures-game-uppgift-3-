package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testAttackPlayer() {

        Player player = new Player.Builder()
                .name("Hero")
                .strength(15)
                .health(100)
                .build();

        Enemy enemy = new Enemy("Enemy", 50, 10, 5);

        // hämtar enemy health innan attacken
        int beforeAttack = enemy.getHealth();

        player.attack(enemy);

        // beräknar förväntad hälsa efter attacken
        int expectedHealth = beforeAttack - player.getStrength();

        // verifierar att enemy health har minskat med player strength

        assertEquals(expectedHealth, enemy.getHealth(),
                "Fiendens hälsa minskade inte korrekt efter attacken!"
        );

    }

}
