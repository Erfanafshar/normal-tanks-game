import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
// first game menu
public class BasicGameMenu extends JFrame {
    private Image background;
    private JFrame thisFrame;
    private MenuPanel mp;
    private Box b;
    // menu buttons
    private final String MENU[] = {"New Game", "Continue", "Multi Player","Create Your Map" , "Exit"};
    private ArrayList<JButton> buttonArrayList;
    // game mode:multiplayer as guest or server and difficulty level of game
    private boolean server , guest , resumeLastGame , easy , medium ,hard  , mapEditorMode;
    private ActionListener menuActionListener;
    // selected button to be highlighted or selected by enter
    private int selectedButtonIndex = 0;
    // sound of selection and menu background sound
    private MakeSound menuSound , selectSound;
    // name is  title  and image name is name of menu image
    public BasicGameMenu(String name, String imagename) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        thisFrame = this;
        mp = new MenuPanel(imagename);
        mp.setBounds(0, 0, 1280, 720);
        getContentPane().add(mp);
        this.setFocusable(true);
        menuActionListener = new MenuActionListener();
        this.addKeyListener(new MenuKeyListener());
        buttonArrayList = new ArrayList<>();
        // adding buttons to frame
        for (int i = 0; i < MENU.length; i++) {
            JButton jb = new JButton(MENU[i]);
            jb.addActionListener(menuActionListener);
            jb.setBackground(Color.darkGray);
            jb.setForeground(Color.cyan);
            jb.setContentAreaFilled(false);
            jb.setOpaque(true);
            jb.setBounds(80, 300 + 77 * i, 300, 75);
            this.add(jb);
            mp.add(jb);
            buttonArrayList.add(jb);
        }

        buttonArrayList.get(0).setBackground(Color.YELLOW);
        resumeLastGame = false;


        menuSound = new MakeSound(Sounds.START_UP , true);
        selectSound = new MakeSound(Sounds.SELECT , false);
        // playing menu sound
        ThreadPool.execute(menuSound);





        setSize(1280, 720);
        setResizable(false);
        setVisible(true);
    }
    //Action listener for menu button events
    class MenuActionListener implements ActionListener {
        private JPopupMenu jPopupMenu;
        private JPopupMenu gameDifficultyPopUpMenu;

        public MenuActionListener() {
            guest = false;
            server = false;
            easy = false;
            medium = false;
            hard = false;
            mapEditorMode = false;
            gameDifficultyPopUpMenu = new JPopupMenu();
            JMenuItem isEasy = new JMenuItem("Easy");
            JMenuItem isMedium = new JMenuItem("Medium");
            JMenuItem isHard = new JMenuItem("Hard");
            gameDifficultyPopUpMenu.add(isEasy);gameDifficultyPopUpMenu.add(isMedium);gameDifficultyPopUpMenu.add(isHard);
            // if easy is selected
            isEasy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    easy = true;
                    play();

                }
            });
            // if medium is selected
            isMedium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    medium = true;
                    play();
                }
            });
            // if hard is selected
            isHard.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hard = true;
                    play();
                }
            });
            jPopupMenu = new JPopupMenu();
            JMenuItem serverJMenuItem = new JMenuItem("Play as server");
            JMenuItem guestJMenuItem = new JMenuItem("Play as a guest");
            jPopupMenu.add(serverJMenuItem);
            jPopupMenu.add(guestJMenuItem);
            //if multiplayer select as server
            serverJMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    server = true;
                    play();
                }
            });
            //if multiplayer select as a guest
            guestJMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    guest = true;
                    play();

                }
            });

        }
        // start game and play game sound
        public void play(){
            menuSound.setStop(true);

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {

                    GameFrame frame = new GameFrame("JTanks");
                    frame.setLocationRelativeTo(null); // put frame at center of screen
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    thisFrame.dispose();
                    frame.initBufferStrategy();
                    ThreadPool.execute(new MakeSound(Sounds.GAME_SOUND1 , true));

                    // Create anand execute the game-loop
                    GameLoop game = new GameLoop(frame , server , guest , resumeLastGame , mapEditorMode);
                    System.out.println("before game loop init");
                    game.init(easy , medium , hard);
                    System.out.println("after game looop init");
                    System.out.println("/a/a/a/a/a/a/a");
                    ThreadPool.execute(game);
                    // and the game starts ...
                }
            });
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            ThreadPool.execute(selectSound);
            JButton source = (JButton) e.getSource();
            String selected = source.getText();
            switch (selected) {
                // playing a new game
                case "New Game":

                    ThreadPool.execute(selectSound);
                    gameDifficultyPopUpMenu.show(source, 150, 50);
                    gameDifficultyPopUpMenu.setVisible(true);
                    break;
                // continue last game saved
                case "Continue":
                    menuSound.setStop(true);
                    resumeLastGame = true;
                    play();
                    ThreadPool.execute(selectSound);

                    break;
                // playing multiplayer
                case "Multi Player":
                    ThreadPool.execute(selectSound);
                    jPopupMenu.show(source, 150, 50);
                    jPopupMenu.setVisible(true);

                    break;
                // creating map
                case "Create Your Map":
                    // exit from game
                    menuSound.setStop(true);
                    mapEditorMode = true;
                    play();

                    //playMapEditor();
                    break;
                case "Exit":
                    ThreadPool.execute(selectSound);
                    thisFrame.dispose();
                    System.exit(0);
                    break;

            }


        }

    }
    //key listener r for menu
    // changing selected button with arrow keys up and down
    class MenuKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){

                case KeyEvent.VK_UP:
                    buttonArrayList.get(selectedButtonIndex).setBackground(Color.darkGray);
                    if (selectedButtonIndex > 0){
                        selectedButtonIndex--;
                        buttonArrayList.get(selectedButtonIndex).setBackground(Color.YELLOW);
                    }else {
                        selectedButtonIndex = buttonArrayList.size() - 1;
                        buttonArrayList.get(selectedButtonIndex).setBackground(Color.YELLOW);

                    }
                    break;
                case KeyEvent.VK_DOWN:
                    buttonArrayList.get(selectedButtonIndex).setBackground(Color.darkGray);
                    if (selectedButtonIndex < buttonArrayList.size() -1 ){
                        selectedButtonIndex++;
                        buttonArrayList.get(selectedButtonIndex).setBackground(Color.YELLOW);
                    }else {
                        selectedButtonIndex = 0;
                        buttonArrayList.get(selectedButtonIndex).setBackground(Color.YELLOW);

                    }
                    break;
                case KeyEvent.VK_ENTER:
                    buttonArrayList.get(selectedButtonIndex).doClick();

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}