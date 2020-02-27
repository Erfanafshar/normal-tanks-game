import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameLoop implements Runnable {

    public static final int FPS = 60;

    /*private MapEditorFrame mapEditorFrame;
    private MapEditorState mapEditorState;*/
    private GameFrame gameFrame;
    private GameState gameState;
    public static boolean server,client , resumeLastGame , mapEditorMode , gameOver ;


    public GameLoop(GameFrame frame , boolean server , boolean client , boolean resumeLastGame , boolean mapEditorMode ) {
        gameFrame = frame;
        this.server = server;
        this.client = client;
        this.resumeLastGame = resumeLastGame;
        this.mapEditorMode = mapEditorMode;


    }
    /*public GameLoop(MapEditorFrame frame ) {
        this.server = false;
        this.client =false;
        this.mapEditorFrame = frame;
        this.mapEditorMode = true;


    }*/

    public void init(boolean easy , boolean medium , boolean hard) {
        // Perform all initializations ...
//        if (mapEditorMode) {
//            /*mapEditorState = new MapEditorState();
//            mapEditorFrame.addKeyListener(mapEditorState.getKeyListener());
//            mapEditorFrame.addMouseListener(mapEditorState.getMouseListener());
//            mapEditorFrame.addMouseMotionListener(mapEditorState.getMouseMotionListener());*/
//        }
//
        //else {
            if (client || server) {
                gameState = new GameState();
            }else {
                gameState = new GameState(easy , medium , hard);
            }
            if (resumeLastGame) {
                gameState = loadObject("save.jdm");
            }
            gameFrame.addKeyListener(gameState.getKeyListener());
            gameFrame.addMouseListener(gameState.getMouseListener());
            gameFrame.addMouseMotionListener(gameState.getMouseMotionListener());


        if (server){
            try {
                System.out.println("in server game loop init");
                ServerSocket server = new ServerSocket(7654);
                System.out.println("before accepting");
                Socket client = server.accept();
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream()) ;
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                System.out.println("Server socket accept");
                ThreadPool.execute(new Server( in , out ));
                System.out.println(" server executed");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (client){
            try {

                System.out.println(" in client Game loop init");
                Socket server = new Socket("127.0.0.1", 7654);
                System.out.println("Client socketed!");
                ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(server.getInputStream());
                ThreadPool.execute(new Client( in , out));
                System.out.println("Client executed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
            System.out.println(" in gameloop reun");


                gameOver = false;
                while (!gameOver) {
                    try {
                        //System.out.println("game loop run");
                        long start = System.currentTimeMillis();
                        //
                        //if (mapEditorMode) {
                            //    mapEditorState.update();
                            //  mapEditorFrame.render(mapEditorState);
                        //} else {
                            gameState.update();
                            gameFrame.render(gameState);

                        //
                        long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
                        if (delay > 0)
                            Thread.sleep(delay);
                    } catch (InterruptedException ex) {
                    }
                }
                ThreadPool.shutdownNow();
                System.exit(1);
//                //this.gameFrame.dispose();
//                ThreadPool.init();
//
//                // Show the game menu ...
//                BasicGameMenu basicGameMenu = new BasicGameMenu("name", "menu.png");
//                basicGameMenu.setLocationRelativeTo(null);
//                basicGameMenu.setVisible(true);


//        String[] sdw;
//        sdw = new String[Integer.parseInt("2")];
//        Main.main(sdw);
//        System.exit(1);
       // this.gameFrame.dispose();

        }

    public static  <E> boolean saveObject(String destination , E writingObject){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(destination , false)))){
            objectOutputStream.writeObject(writingObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static < E > E loadObject(String address){
        E object = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(address)));) {
            object = (E)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object ;
    }
}
