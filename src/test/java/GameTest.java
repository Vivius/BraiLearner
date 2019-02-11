import game.Game;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import tools.nfc.MockNfcReader;

public class GameTest {

    @Test
    public void testRandomGame() {
        MockNfcReader cardReader = new MockNfcReader();
        Game game = new Game(cardReader);

        cardReader.setDeck(game.getDefaultDeck());

        game.play(game.getDefaultDeck());

        Assert.assertTrue(true);
    }
}
