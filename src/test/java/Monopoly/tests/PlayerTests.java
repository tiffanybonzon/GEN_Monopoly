package Monopoly.tests;

import Monopoly.impl.Board;
import Monopoly.impl.Cup;
import Monopoly.impl.Player;
import Monopoly.impl.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {
    Board board;
    Cup cup;

    @BeforeEach
    void init() {
        board = new Board();
        cup = new Cup(2);
    }

    @Test
    void aPlayerShouldStartInTheStartingSquare() {
        Player player = new Player("Jim", cup, board);
        String obtained = player.getPiece().getLocation().getName();

        assertEquals("GO", obtained);
    }

    @Test
    void aPlayerShouldHaveAName() {
        Player player = new Player("James", cup, board);
        assertNotNull(player.getName());
        assertEquals("James", player.getName());
    }

    @RepeatedTest(100)
    void aPlayerNeverStaysOnTheSameSquare() {
        Player player = new Player("Jake", cup, board);
        Square previousSquare = player.getPiece().getLocation();

        player.takeTurn();
        if(previousSquare == (player.getPiece().getLocation())) {
            fail();
        }
    }
}
