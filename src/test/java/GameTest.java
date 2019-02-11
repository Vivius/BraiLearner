import game.Game;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import tools.nfc.MockNfcReader;

public class GameTest {

    @Test
    public void testRandomGame() {
        MockNfcReader cardReader = new MockNfcReader();
        Game game = new Game(cardReader);

        cardReader.setGame(game);

        game.play(game.getDefaultDeck());

        Assert.assertTrue(true);
    }
}
