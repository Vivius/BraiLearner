import game.Game;

public class Launcher {

    public Launcher() {

    }

    private void start() {
        System.out.println("BraiLearner ready !");

        Game game = new Game();
        game.game();
    }

    public static void main(String[] args) {
        new Launcher().start();
    }
}
