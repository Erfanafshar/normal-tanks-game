import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {


            // Initialize the global thread-pool
            ThreadPool.init();

            // Show the game menu ...
            BasicGameMenu basicGameMenu = new BasicGameMenu("name", "menu.png");
            basicGameMenu.setLocationRelativeTo(null);
            basicGameMenu.setVisible(true);
    }
            // After the player clicks 'PLAY' ...
      /*  EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BasicGameMenu basicGameMenu = new BasicGameMenu("name", "menu.png" );
                basicGameMenu.setLocationRelativeTo(null);
                basicGameMenu.setVisible(true);

                GameFrame frame = new GameFrame("JTanks");
                frame.setLocationRelativeTo(null); // put frame at center of screen
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.initBufferStrategy();
                // Create and execute the game-loop
                GameLoop game = new GameLoop(frame);

                game.init();
                ThreadPool.execute(game);
                // and the game starts ...
            }
        });*/
        }


