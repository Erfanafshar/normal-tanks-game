// Add libraries

import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;

import static java.awt.event.MouseEvent.BUTTON1;
import static java.awt.event.MouseEvent.BUTTON3;

/**
 * The GameState class for updating the state of game
 *
 * @author Erfan Afshar
 * @author AmirHossein Bagheri
 * @version 1
 * @since 7/1/2018
 */
public class GameState implements Serializable {
    int i = 0;
    public int locX, locY, coLocX, coLocY, mapEditorX, mapEditorY;
    public int lastLocX, lastLocY;
    private GameState thisState;

    public int mouseX, mouseY;
    public int lastMouseX, lastMouseY;

    private final int moveSpeed = 8;

    // The tank gun is light or not
    public boolean isLightGun, coIsLightGun;

    public boolean isLightProGun, coIsLightProGun;
    public boolean isHeavyProGun, coIsHeavyProGun;

    // The degree of tank and the gun rotation
    public int tankRotationDegree, coTankRotationDegree;
    public double tankGunRotationDegree, coTankGunRotationDegree;

    private final int rotationSpeed = 5;

    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;

    private boolean keyUP, keyDOWN, keyRIGHT, keyLEFT;
    private boolean clickRight, clickLeft;

    public ArrayList<Shot> playerShots;
    public ArrayList<SoftWall> softWallsLocation;
    public ArrayList<Tank> enemyTanksLocation;
    public ArrayList<Integer> helpersLocation;
    public ArrayList<Integer> teazelsLocation;

    // First is x coordinate and twice is y coordinate for each pair
    public ArrayList<Integer> hardWallsLocation;

    public ArrayList<Integer> destroyedEnemysLocation;

    public ArrayList<Integer> plantsLocation;

    public ArrayList<Integer> minesLocation;


    // Player tank fields
    public int playerTankHealth, coPlayerTankHealth;
    public int playerTankLightShot, coPlayerTankLightShot;
    public int playerTankHeavyShot, coPlayerTankHeavyShot;


    private int lastShotNumber = -1;
    private int twoLastShotNumber = -1;

    private int tankModel4HealthDecrease;


    // The difficulty of game
    public boolean isEasy = false;
    public boolean isMedium = false;
    public boolean isHard = true;

    // Cheat codes
    private boolean MHE;
    private boolean MLS;
    private boolean MHS;
    private boolean PLG;
    private boolean PHG;

    /**
     * The constructor of the GameState class
     * Create ArrayLists
     * And initialize the booleans
     * And set the player tank number of shots and amount of health
     */
    public GameState() {

        playerShots = new ArrayList<>();
        softWallsLocation = new ArrayList<>();
        enemyTanksLocation = new ArrayList<>();
        helpersLocation = new ArrayList<>();
        teazelsLocation = new ArrayList<>();
        hardWallsLocation = new ArrayList<>();

        destroyedEnemysLocation = new ArrayList<>();

        plantsLocation = new ArrayList<>();
        minesLocation = new ArrayList<>();

        isLightGun = false;

        isLightProGun = false;
        isHeavyProGun = false;

        keyUP = false;
        keyDOWN = false;
        keyRIGHT = false;
        keyLEFT = false;

        clickRight = false;
        clickLeft = false;

        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler();
        coPlayerTankHealth = 25;
        playerTankHealth = 25;
        playerTankHeavyShot = 50;
        playerTankLightShot = 200;
        coPlayerTankHeavyShot = 50;
        coPlayerTankLightShot = 200;

        tankModel4HealthDecrease = 5;

        MHE = false;
        MLS = false;
        MHS = false;
        PLG = false;
        PHG = false;

        thisState = this;
    }

    /**
     * Set the difficulty of game
     *
     * @param isEasy   game is easy
     * @param isMedium game is medium
     * @param isHard   game is hard
     */
    public GameState(boolean isEasy, boolean isMedium, boolean isHard) {
        this();
        this.isEasy = isEasy;
        this.isMedium = isMedium;
        this.isHard = isHard;
    }

    /**
     * The update method
     * For updating the GameState
     */
    public void update() {
        if (GameLoop.server) {
            if (Server.clientState.getShot() != null) {
                playerShots.add(Server.clientState.getShot());
            }

            coLocX = Server.clientState.getLocX();
            coLocY = Server.clientState.getLocY();
            coTankRotationDegree = Server.clientState.getTankRotationDegree();
            coTankGunRotationDegree = Server.clientState.getTankGunRotationDegree();
            coIsLightGun = Server.clientState.isLightGun();
            coIsHeavyProGun = Server.clientState.isHeavyProGun();
            coIsLightProGun = Server.clientState.isLightProGun();

            coPlayerTankHeavyShot = Server.clientState.getTankHeavyShots();
            coPlayerTankLightShot = Server.clientState.getTankLightShots();


        } else if (GameLoop.client) {
            Client.clientState.setShot(null);
            coLocX = Client.serverState.getLocX();
            coLocY = Client.serverState.getLocY();
            coTankRotationDegree = Client.serverState.getTankRotationDegree();
            coTankGunRotationDegree = Client.serverState.getTankGunRotationDegree();
            coIsLightGun = Client.serverState.isLightGun();
            coIsLightProGun = Client.serverState.isLightProGun();
            coIsHeavyProGun = Client.serverState.isHeavyProGun();
            playerTankHealth = Client.serverState.getClientHealth();
            playerTankHeavyShot = Client.serverState.getClientHeavyShots();
            playerTankLightShot = Client.clientState.getTankLightShots();

            if (Client.serverState.getShots() != null) {
                playerShots = Client.serverState.getShots();

            }
            if (Client.serverState.getSoftWalls() != null) {

                softWallsLocation = Client.serverState.getSoftWalls();
            }
            if (Client.serverState.getHelperResources() != null) {
                Area.helperResourcesLocation = Client.serverState.getHelperResources();

            }
            if (Client.serverState.getEnemyTanks() != null) {
                enemyTanksLocation = Client.serverState.getEnemyTanks();

            }
        }


        // Change tank position and degree
        if (keyUP) {
            if (GameLoop.mapEditorMode) {
                mapEditorX -= moveSpeed;
            } else {

                lastLocY = locY;

                locY -= moveSpeed;
                changeTankRotationDegree2();
            }

        }
        if (keyDOWN) {
            if (GameLoop.mapEditorMode) {
                mapEditorY += moveSpeed;
            } else {
                lastLocY = locY;
                locY += moveSpeed;
                changeTankRotationDegree(90, 270);
            }
        }
        if (keyLEFT) {
            if (GameLoop.mapEditorMode) {
                mapEditorX -= moveSpeed;
            } else {
                lastLocX = locX;
                locX -= moveSpeed;
                changeTankRotationDegree(180, 360);
            }
        }
        if (keyRIGHT) {
            if (GameLoop.mapEditorMode) {
                mapEditorX += moveSpeed;
            } else {
                lastLocX = locX;
                locX += moveSpeed;
                changeTankRotationDegree(0, 180);
            }
        }

        // Set the range of the ground
        if (GameLoop.mapEditorMode) {
            mapEditorX = Math.max(120, mapEditorX);
            mapEditorY = Math.max(150, mapEditorY);
            mapEditorX = Math.min(6500, mapEditorX);
            mapEditorY = Math.min(4500, mapEditorY);
        } else {
            locX = Math.max(120, locX);
            locY = Math.max(150, locY);
            locX = Math.min(6500, locX);
            locY = Math.min(4500, locY);


            // Set the range of degree of ground
            tankRotationDegree = Math.max(0, tankRotationDegree);
            tankRotationDegree = Math.min(360, tankRotationDegree);


            // Set tankRotationDegree to appropriate range
            if (tankRotationDegree == 360) {
                tankRotationDegree = 0;
            }

            if (Math.abs(mouseX - 450) == 0) {
                tankGunRotationDegree = Math.atan(Math.abs(mouseY - 350) / 1);
            } else {
                tankGunRotationDegree = Math.atan((double) Math.abs(mouseY - 350) / Math.abs(mouseX - 450));
            }

            if (mouseY - 350 < 0) {
                if (mouseX - 450 < 0) {
                    tankGunRotationDegree += Math.PI;
                } else {
                    tankGunRotationDegree += (2 * Math.PI - 2 * tankGunRotationDegree);
                }
            } else {
                if (mouseX - 450 < 0) {
                    tankGunRotationDegree += (Math.PI - 2 * tankGunRotationDegree);
                }
            }
        }

        // Create new shot
        if (clickLeft) {
            if ((isLightGun && (playerTankLightShot == 0)) || (!isLightGun && (playerTankHeavyShot == 0))) {
                System.out.println("out of shot ");
            } else {
                MakeSound shotSound;
                if (!isLightGun) {
                    shotSound = new MakeSound(Sounds.HEAVY_GUN, false);

                } else {
                    shotSound = new MakeSound(Sounds.MACHINE_GUN, false);

                }
                if (!(lastMouseX == mouseX && lastMouseY == mouseY)) {
                    if (isLightGun) {
                        playerTankLightShot--;
                    } else {
                        playerTankHeavyShot--;
                    }
                }
                if (playerShots.size() == 0) {
                    if (isLightGun) {
                        if (playerTankLightShot > -1) {
                            if (!GameLoop.client) {
                                playerShots.add(new Shot(mouseX, mouseY, tankGunRotationDegree, locX, locY, isLightGun, isLightProGun, isHeavyProGun));
                                ThreadPool.execute(shotSound);
                            } else {
                                Client.clientState.setShot(new Shot(mouseX, mouseY, tankGunRotationDegree, locX, locY, isLightGun, isLightProGun, isHeavyProGun));
                            }
                        } else {
                            ThreadPool.execute(new MakeSound(Sounds.EMPTY_GUN, false));
                        }
                    } else {
                        if (playerTankHeavyShot > -1) {
                            if (!GameLoop.client) {
                                playerShots.add(new Shot(mouseX, mouseY, tankGunRotationDegree, locX, locY, isLightGun, isLightProGun, isHeavyProGun));
                                ThreadPool.execute(shotSound);
                            } else {
                                Client.clientState.setShot(new Shot(mouseX, mouseY, tankGunRotationDegree, locX, locY, isLightGun, isLightProGun, isHeavyProGun));
                            }
                        } else {
                            ThreadPool.execute(new MakeSound(Sounds.EMPTY_GUN, false));
                        }
                    }


                } else {
                    // Check that just one click
                    if ((Math.abs(playerShots.get(playerShots.size() - 1).getMouseX() - mouseX) > 2) &&
                            (Math.abs(playerShots.get(playerShots.size() - 1).getMouseY() - mouseY) > 2)) {
                        if (!GameLoop.client) {
                            playerShots.add(new Shot(mouseX, mouseY, tankGunRotationDegree, locX, locY, isLightGun, isLightProGun, isHeavyProGun));
                            ThreadPool.execute(shotSound);
                        } else {
                            Client.clientState.setShot(new Shot(mouseX, mouseY, tankGunRotationDegree, locX, locY, isLightGun, isLightProGun, isHeavyProGun));
                        }
                    }
                }
                lastMouseX = mouseX;
                lastMouseY = mouseY;
            }

        }

        // Change the gun
        if (clickRight) {
            if (!(lastMouseX == mouseX && lastMouseY == mouseY)) {
                isLightGun = !isLightGun;
            }
            lastMouseX = mouseX;
            lastMouseY = mouseY;
        }

        // Update soft walls and remove destroyed soft walls
        if (!GameLoop.client) {
            for (int i = 0; i < softWallsLocation.size(); i++) {
                if (!softWallsLocation.get(i).update(playerShots)) {
                    softWallsLocation.remove(i);
                }

            }


            // Update shots and remove shots that are in the wall
            for (int i = 0; i < playerShots.size(); i++) {
                playerShots.get(i).update();

            }

            // Update enemy tanks
            for (int i = 0; i < enemyTanksLocation.size(); i++) {
                if (!enemyTanksLocation.get(i).update(playerShots, locX, locY, coLocX, coLocY)) {
                    if (!(enemyTanksLocation.get(i).getTankModelNumber() == 3)) {
                        destroyedEnemysLocation.add(enemyTanksLocation.get(i).getFirstXPosition());
                        destroyedEnemysLocation.add(enemyTanksLocation.get(i).getFirstYPosition());
                    }

                    enemyTanksLocation.remove(i);
                }
            }

            // Update enemy shots
            for (int i = 0; i < enemyTanksLocation.size(); i++) {
                for (int j = 0; j < enemyTanksLocation.get(i).getMyShots().size(); j++) {
                    enemyTanksLocation.get(i).getMyShots().get(j).update();
                }

            }

            // Update player tank shot received
            for (int i = 0; i < enemyTanksLocation.size(); i++) {
                for (int j = 0; j < enemyTanksLocation.get(i).getMyShots().size(); j++) {
                    if (Math.abs(enemyTanksLocation.get(i).getMyShots().get(j).getLocX() - locX) < 50 &&
                            Math.abs(enemyTanksLocation.get(i).getMyShots().get(j).getLocY() - locY) < 50) {
                        if (!(lastShotNumber == enemyTanksLocation.get(i).getMyShots().get(j).getShotNumber())) {
                            if (!(twoLastShotNumber == enemyTanksLocation.get(i).getMyShots().get(j).getShotNumber())) {

                                playerTankHealth -= enemyTanksLocation.get(i).getMyShots().get(j).getDecreaseOfEnemyShots();
                                ThreadPool.execute(new MakeSound(Sounds.ENEMY_BULLET_TO_MY_TANK, false));

                                if (playerTankHealth <= 0) {
                                    System.out.println("game over");
                                }

                                twoLastShotNumber = lastShotNumber;
                                lastShotNumber = enemyTanksLocation.get(i).getMyShots().get(j).getShotNumber();

                            }
                        }


                    } else if (Math.abs(enemyTanksLocation.get(i).getMyShots().get(j).getLocX() - coLocX) < 50 &&
                            Math.abs(enemyTanksLocation.get(i).getMyShots().get(j).getLocY() - coLocY) < 50 && GameLoop.server) {
                        if (!(lastShotNumber == enemyTanksLocation.get(i).getMyShots().get(j).getShotNumber())) {
                            if (!(twoLastShotNumber == enemyTanksLocation.get(i).getMyShots().get(j).getShotNumber())) {

                                coPlayerTankHealth -= enemyTanksLocation.get(i).getMyShots().get(j).getDecreaseOfEnemyShots();

                                if (coPlayerTankHealth <= 0) {
                                    System.out.println("game over");
                                }

                                twoLastShotNumber = lastShotNumber;
                                lastShotNumber = enemyTanksLocation.get(i).getMyShots().get(j).getShotNumber();

                            }
                        }

                    }
                }
            }

            // Update the player tank
            // Hit with tank model 4
            for (int i = 0; i < enemyTanksLocation.size(); i++) {
                if (enemyTanksLocation.get(i).isHitPlayerTank()) {
                    playerTankHealth -= tankModel4HealthDecrease;
                }
            }

            // Check that the player use cheat codes or not
            if (MHE || MLS || MHS || PLG || PHG) {
                doCheatCodeWorks();
            }

        }

        // Set changes in myState to send to coop
        if (GameLoop.server) {
            Server.serverState.setLocX(locX);
            Server.serverState.setLocY(locY);
            Server.serverState.setTankRotationDegree(tankRotationDegree);
            Server.serverState.setTankGunRotationDegree(tankGunRotationDegree);
            Server.serverState.setLightGun(isLightGun);
            Server.serverState.setLightProGun(isLightProGun);
            Server.serverState.setHeavyProGun(isHeavyProGun);
            Server.serverState.setClientHealth(coPlayerTankHealth);
            Server.serverState.setEnemyTanks(enemyTanksLocation);
            Server.serverState.setHelperResources(Area.helperResourcesLocation);
            Server.serverState.setShots(playerShots);
            Server.serverState.setSoftWalls(softWallsLocation);
            Server.serverState.setClientHeavyShots(coPlayerTankHeavyShot);
            Server.serverState.setClientLightShots(coPlayerTankLightShot);

        } else if (GameLoop.client) {
            Client.clientState.setLocX(locX);
            Client.clientState.setLocY(locY);
            Client.clientState.setTankRotationDegree(tankRotationDegree);
            Client.clientState.setTankGunRotationDegree(tankGunRotationDegree);
            Client.clientState.setLightGun(isLightGun);
            Client.clientState.setLightProGun(isLightProGun);
            Client.clientState.setHeavyProGun(isHeavyProGun);
            Client.clientState.setTankHeavyShots(playerTankHeavyShot);
            Client.clientState.setTankLightShots(playerTankLightShot);
            if (Client.clientState.getShot() != null) {
                i++;
                System.out.println(" state shot created  " + i);

            }
        }
    }

    /**
     * Do the Cheat Code Works
     */
    private void doCheatCodeWorks() {
        if (MHE) {
            playerTankHealth = 25;
        }
        if (MLS) {
            playerTankLightShot = 200;
        }
        if (MHS) {
            playerTankHeavyShot = 50;
        }
        if (PLG) {
            isLightProGun = true;
        }
        if (PHG) {
            isHeavyProGun = true;
        }
    }

    /**
     * Change the Tank Rotation Degree
     *
     * @param min The min rotation degree
     * @param max The max rotation degree
     */
    public void changeTankRotationDegree(int min, int max) {
        if (tankRotationDegree > min && tankRotationDegree < max) {
            tankRotationDegree -= rotationSpeed;
        } else {
            if (!(tankRotationDegree == min)) {
                tankRotationDegree += rotationSpeed;
            }
        }
    }

    /**
     * Do the Helper Works
     *
     * @param helperNumber The helper number
     * @param isLightGun   Is light gun or heavy gun
     */
    public void doHelperWorks(int helperNumber, boolean isLightGun) {

        if (helperNumber == 1) {
            if (isLightGun) {
                isLightProGun = true;
                ThreadPool.execute(new MakeSound(Sounds.AGREE, false));
            } else {
                isHeavyProGun = true;
                ThreadPool.execute(new MakeSound(Sounds.AGREE, false));
            }

        }
        if (helperNumber == 2) {
            playerTankHealth = 25;
            ThreadPool.execute(new MakeSound(Sounds.REPAIR, false));

        }
        if (helperNumber == 3) {
            playerTankHeavyShot += 20;
            ThreadPool.execute(new MakeSound(Sounds.AGREE, false));

        }
        if (helperNumber == 4) {
            playerTankLightShot += 50;
            ThreadPool.execute(new MakeSound(Sounds.AGREE, false));

        }
    }

    /**
     * Change Tank Rotation Degree
     */
    public void changeTankRotationDegree2() {
        if (tankRotationDegree < 90 || tankRotationDegree > 270) {
            if (tankRotationDegree >= 0 && tankRotationDegree < 90) {
                if (tankRotationDegree < 5) {
                    tankRotationDegree = 360;
                }
            }
            tankRotationDegree -= rotationSpeed;

        } else {
            if (!(tankRotationDegree == 270)) {
                tankRotationDegree += rotationSpeed;
            }
        }
    }

    /**
     * Get Key Listener
     *
     * @return KeyListener
     */
    public KeyListener getKeyListener() {
        return keyHandler;
    }

    /**
     * Get Mouse Listener
     *
     * @return MouseListener
     */
    public MouseListener getMouseListener() {
        return mouseHandler;
    }

    /**
     * Get Mouse Motion Listener
     *
     * @return MouseMotionListener
     */
    public MouseMotionListener getMouseMotionListener() {
        return mouseHandler;
    }

    /**
     * The key Handler method
     */
    class KeyHandler implements KeyListener, Serializable {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                keyUP = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                keyDOWN = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                keyLEFT = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                keyRIGHT = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_T && e.isAltDown()) {
                MHE = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_L && e.isAltDown()) {
                MLS = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_H && e.isAltDown()) {
                MHS = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_P && e.isAltDown()) {
                PLG = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_R && e.isAltDown()) {
                PHG = true;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                if (e.isControlDown()) {
                    GameLoop.saveObject("save.jdm", thisState);
                    System.out.println("saved");
                }
                return;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                keyUP = false;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                keyDOWN = false;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                keyLEFT = false;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                keyRIGHT = false;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_T && e.isAltDown()) {
                MHE = false;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_L && e.isAltDown()) {
                MLS = false;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_H && e.isAltDown()) {
                MHS = false;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_P && e.isAltDown()) {
                PLG = false;
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_R && e.isAltDown()) {
                PHG = false;
                return;
            }

        }

    }


    class MouseHandler implements MouseListener, MouseMotionListener, Serializable {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            //System.out.println("press");
            switch (e.getButton()) {
                case BUTTON1:
                    clickLeft = true;
                    break;
                case BUTTON3:
                    clickRight = true;
                    break;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //System.out.println("release");
            switch (e.getButton()) {
                case BUTTON1:
                    clickLeft = false;
                    break;
                case BUTTON3:
                    clickRight = false;
                    break;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }
}

