// Add libraries

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * The GameFrame class have the render method that draw all of the game components
 * And read all of the Images from files
 * Use the GameState information of GameState class for rendering
 * *
 *
 * @author Erfan Afshar
 * @author AmirHossein Bagheri
 * @version 1
 * @since 7/1/2018
 */
public class GameFrame extends JFrame {

    // the height and width of the game frame
    private static final int GAME_HEIGHT = 720;
    private static final int GAME_WIDTH = 16 * GAME_HEIGHT / 9;

    // buffered image of all of the games component
    // HElP :
    // P : player
    // E : enemy
    // T : tank
    private BufferedImage areaImage;
    private BufferedImage hardWallImage;
    private BufferedImage softWallImage;
    private BufferedImage softWall1Image;
    private BufferedImage softWall2Image;
    private BufferedImage softWall3Image;
    private BufferedImage teazelImage;
    private BufferedImage plantImage;

    private BufferedImage cursorImage;
    private BufferedImage PTImage;

    private BufferedImage PTHeavyGunImage;
    private BufferedImage PTHeavyGunProImage;
    private BufferedImage PTLightGunImage;
    private BufferedImage PTLightGunProImage;

    private BufferedImage PTHeavyGunBulletImage;
    private BufferedImage PTHeavyGunProBulletImage;
    private BufferedImage PTLightGunBulletImage;
    private BufferedImage PTLightGunProBulletImage;

    private BufferedImage ET1Image;
    private BufferedImage ET2Image;
    private BufferedImage ET3Image;
    private BufferedImage ET4Image;

    private BufferedImage ET1GunImage;
    private BufferedImage ET2GunImage;

    private BufferedImage ET1GunBulletImage;
    private BufferedImage ET2GunBulletImage;

    private BufferedImage updateGunImage;
    private BufferedImage repairFoodImage;
    private BufferedImage heavyGunFoodImage;
    private BufferedImage lightGunFoodImage;
    private BufferedImage numberOfHeavyShots;
    private BufferedImage numberOfLightShots;
    private BufferedImage healthImage;

    private BufferedImage EDestroyedTankImage;
    private BufferedImage mineImage;


    // Wall and teazels use for drawing now
    private ArrayList<Integer> hardWalls;
    private ArrayList<SoftWall> softWalls;
    private ArrayList<Integer> teazels;
    private ArrayList<Tank> tanks;


    // wall and teazels save the last drawing
    private ArrayList<Integer> lastHardWalls;
    private ArrayList<SoftWall> lastSoftWalls;
    private ArrayList<Integer> lastTeazels;
    private ArrayList<Tank> lastTanks;

    // wall and teazels that dont checked until now
    private ArrayList<Integer> newHardWalls;
    private ArrayList<SoftWall> newSoftWalls;
    private ArrayList<Integer> newTeazels;
    private ArrayList<Tank> newTanks;

    // Other array lists
    private ArrayList<Integer> helperResources;
    private ArrayList<Integer> enemyDestroyedTank;
    private ArrayList<Integer> plants;
    private ArrayList<Integer> mines;

    // The Buffer Strategy
    private BufferStrategy bufferStrategy;

    // An object of Area class
    // Use for help GameFrame drawing
    private Area area;

    // Can check that this execution is first or not
    // Use for drawing some game components
    private boolean isFirstExecution;

    private int endGame = 0;

    /**
     * The constructor of the GameFrame class
     * Read the files of images
     * And create the ArrayLists
     * Initialize some game components place
     * And hide the cursor for game
     *
     * @param title The title of JFrame
     */
    public GameFrame(String title) {

        // Set the JFrame fields
        super(title);
        setResizable(false);
        setSize(GAME_WIDTH, GAME_HEIGHT);

        // Create area and set hard walls and teazels
        area = new Area();

        // Because it is the first execution now
        isFirstExecution = true;

        // Create array lists
        hardWalls = new ArrayList<>();
        softWalls = new ArrayList<>();
        teazels = new ArrayList<>();
        tanks = new ArrayList<>();

        lastHardWalls = new ArrayList<>();
        lastSoftWalls = new ArrayList<>();
        lastTeazels = new ArrayList<>();
        lastTanks = new ArrayList<>();

        newHardWalls = new ArrayList<>();
        newSoftWalls = new ArrayList<>();
        newTeazels = new ArrayList<>();
        newTanks = new ArrayList<>();

        helperResources = new ArrayList<>();
        enemyDestroyedTank = new ArrayList<>();
        plants = new ArrayList<>();
        mines = new ArrayList<>();

        // Create images
        try {
            areaImage = ImageIO.read(new File("Area.png"));
            hardWallImage = ImageIO.read(new File("hardWall.png"));
            softWallImage = ImageIO.read(new File("softWall.png"));
            softWall1Image = ImageIO.read(new File("softWall1.png"));
            softWall2Image = ImageIO.read(new File("softWall2.png"));
            softWall3Image = ImageIO.read(new File("softWall3.png"));
            teazelImage = ImageIO.read(new File("teazel.png"));
            plantImage = ImageIO.read(new File("plant.png"));

            PTImage = ImageIO.read(new File("PT.png"));
            cursorImage = ImageIO.read(new File("cursor.png"));

            PTHeavyGunImage = ImageIO.read(new File("PTHeavyGun.png"));
            PTHeavyGunProImage = ImageIO.read(new File("PTHeavyGunPro.png"));
            PTLightGunImage = ImageIO.read(new File("PTLightGun.png"));
            PTLightGunProImage = ImageIO.read(new File("PTLightGunPro.png"));

            PTHeavyGunBulletImage = ImageIO.read(new File("PTHeavyGunBullet.png"));
            PTHeavyGunProBulletImage = ImageIO.read(new File("PTHeavyGunProBullet.png"));
            PTLightGunBulletImage = ImageIO.read(new File("PTLightGunBullet.png"));
            PTLightGunProBulletImage = ImageIO.read(new File("PTLightGunProBullet.png"));
            numberOfHeavyShots = ImageIO.read(new File("NumberOfHeavyBullet2.png"));
            numberOfLightShots = ImageIO.read(new File("NumberOfMachinGun2.png"));
            healthImage = ImageIO.read(new File("health.png"));

            ET1Image = ImageIO.read(new File("ET1.png"));
            ET2Image = ImageIO.read(new File("ET2.png"));
            ET3Image = ImageIO.read(new File("ET3.png"));
            ET4Image = ImageIO.read(new File("ET4.png"));

            ET1GunImage = ImageIO.read(new File("ET1Gun.png"));
            ET2GunImage = ImageIO.read(new File("ET2Gun.png"));

            ET1GunBulletImage = ImageIO.read(new File("ET1GunBullet.png"));
            ET2GunBulletImage = ImageIO.read(new File("ET2GunBullet.png"));

            updateGunImage = ImageIO.read(new File("updateGun.png"));
            repairFoodImage = ImageIO.read(new File("repairFood.png"));
            heavyGunFoodImage = ImageIO.read(new File("heavyGunFood.png"));
            lightGunFoodImage = ImageIO.read(new File("lightGunFood.png"));

            EDestroyedTankImage = ImageIO.read(new File("EDestroyedTank.png"));
            mineImage = ImageIO.read(new File("mine.png"));

        } catch (IOException e) {
            System.out.println(e);
        }

        // Hide the cursor
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");

        getContentPane().setCursor(blankCursor);

    }

    /**
     * Init the Buffer Strategy
     */
    public void initBufferStrategy() {
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
    }

    /**
     * Try to Render the Game with use the GameState information
     *
     * @param state An object of GameState class use for drawing
     */
    public void render(GameState state) {
        Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
        try {
            doRendering(graphics, state);
        } finally {
            graphics.dispose();
        }
        bufferStrategy.show();

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Do the rendering with use the GameState object for updates drawing and Graphics2D for drawing
     *
     * @param g2d   An object of Graphics2D
     * @param state An object of GameState
     */
    private void doRendering(Graphics2D g2d, GameState state) {


        // Draw all soft walls for first time
        if (isFirstExecution && !GameLoop.resumeLastGame && !GameLoop.mapEditorMode) {
            area.setSoftWallsLocation(state);
            area.setTanksLocation(state);
            area.setHelperResources(state);
            area.setTeazelsLocation(state);
            area.setHardWallsLocation(state);

            area.setPlantsLocation(state);
            area.setMinesLocation(state);
        }

        // First black back ground
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);


        // Draw ground background
        for (int i = 0; i < GAME_WIDTH; i += 85) {
            for (int j = 32; j < GAME_HEIGHT; j += 91) {
                g2d.drawImage(areaImage, i, j, null);
            }
        }

        // For check hard Walls
        newHardWalls = area.getHardWallsLocation(state.locX, state.locY, state.playerShots, state.enemyTanksLocation, state);

        // Check and set
        if (area.isTankInWall) {
            state.locX = state.lastLocX;
            state.locY = state.lastLocY;

            hardWalls = lastHardWalls;

        } else {
            hardWalls = newHardWalls;
        }

        // Draw hard walls
        for (int i = 0; i < hardWalls.size(); i += 2) {
            g2d.drawImage(hardWallImage, hardWalls.get(i), hardWalls.get(i + 1), null);
        }


        // For check soft walls
        newSoftWalls = area.getSoftWallsLocation(state.locX, state.locY, state, state.enemyTanksLocation);

        // Check and set
        if (area.isTankInWall) {
            state.locX = state.lastLocX;
            state.locY = state.lastLocY;

            softWalls = lastSoftWalls;
        } else {
            softWalls = newSoftWalls;
        }

        // Draw soft walls
        for (int i = 0; i < softWalls.size(); i++) {
            g2d.drawImage(getSoftWallImage(softWalls.get(i).getModelOfWall()),
                    softWalls.get(i).getX(), softWalls.get(i).getY(), null);
        }

        // For check teazels
        newTeazels = area.getTeazelsLocation(state.locX, state.locY, state);

        // Check and set teazels
        if (area.isTankInWall) {
            state.locX = state.lastLocX;
            state.locY = state.lastLocY;

            teazels = lastTeazels;
        } else {
            teazels = newTeazels;
        }

        // Draw teazels
        for (int i = 0; i < teazels.size(); i += 2) {
            g2d.drawImage(teazelImage, teazels.get(i), teazels.get(i + 1), null);
        }

        // Get and draw plants
        plants = area.getPlantsLocation(state.locX, state.locY, state);

        for (int i = 0; i < plants.size(); i += 2) {
            g2d.drawImage(plantImage, plants.get(i), plants.get(i + 1), null);
        }

        // Get and draw helper resources
        helperResources = area.getHelperResourcesLocation(state.locX, state.locY, state);

        for (int i = 0; i < helperResources.size(); i += 3) {
            g2d.drawImage(getResourceImage(helperResources.get(i + 2)), helperResources.get(i), helperResources.get(i + 1), null);
        }

        // Get and draw mines
        mines = area.getMinesLocation(state.locX, state.locY, state);

        for (int i = 0; i < mines.size(); i += 2) {
            g2d.drawImage(mineImage, mines.get(i), mines.get(i + 1), null);
        }

        // For check enemy tanks
        newTanks = area.getTanksLocation(state.locX, state.locY, state);

        // Check and set
        if (area.isTankInWall) {
            state.locX = state.lastLocX;
            state.locY = state.lastLocY;

            tanks = lastTanks;
        } else {
            tanks = newTanks;
        }

        // Draw enemy tanks
        for (int i = 0; i < tanks.size(); i++) {
            g2d.rotate(Math.toRadians(tanks.get(i).getTankRotationDegree()),
                    tanks.get(i).getFirstXPosition() + 50, tanks.get(i).getFirstYPosition() + 50);
            g2d.drawImage(getEnemyTankImage(tanks.get(i).getTankModelNumber()),
                    tanks.get(i).getFirstXPosition(), tanks.get(i).getFirstYPosition(), null);
            g2d.rotate(-Math.toRadians(tanks.get(i).getTankRotationDegree()),
                    tanks.get(i).getFirstXPosition() + 50, tanks.get(i).getFirstYPosition() + 50);
        }

        // Draw enemy tank guns
        for (int i = 0; i < tanks.size(); i++) {
            if (!(tanks.get(i).getTankModelNumber() == 4)) {
                g2d.rotate(tanks.get(i).getTankGunRotationDegree(),
                        tanks.get(i).getFirstXPosition() + 46, tanks.get(i).getFirstYPosition() + 43);
                g2d.drawImage(getEnemyTankGunImage(tanks.get(i).getTankModelNumber()),
                        tanks.get(i).getFirstXPosition() + 20, tanks.get(i).getFirstYPosition() + 20, null);
                g2d.rotate(-tanks.get(i).getTankGunRotationDegree(),
                        tanks.get(i).getFirstXPosition() + 46, tanks.get(i).getFirstYPosition() + 43);
            }
        }

        // Draw enemy tank shots
        for (int i = 0; i < tanks.size(); i++) {
            if (!(tanks.get(i).getTankModelNumber() == 4)) {
                for (int j = 0; j < tanks.get(i).getMyShots().size(); j++) {

                    g2d.rotate(getEnemyTankGunRotationDegree(tanks.get(i).getTankModelNumber(),
                            tanks.get(i).getMyShots().get(j).getLineSlope()),
                            tanks.get(i).getMyShots().get(j).getLocX() - state.locX + 400,
                            tanks.get(i).getMyShots().get(j).getLocY() - state.locY + 300);
                    g2d.drawImage(getEnemyTankGunShotImage(tanks.get(i).getTankModelNumber()),
                            tanks.get(i).getMyShots().get(j).getLocX() - state.locX + 400,
                            tanks.get(i).getMyShots().get(j).getLocY() - state.locY + 300,
                            null);
                    g2d.rotate(-getEnemyTankGunRotationDegree(tanks.get(i).getTankModelNumber(),
                            tanks.get(i).getMyShots().get(j).getLineSlope()),
                            tanks.get(i).getMyShots().get(j).getLocX() - state.locX + 400,
                            tanks.get(i).getMyShots().get(j).getLocY() - state.locY + 300);
                }
            }
        }
        // Draw coop tank
        if (GameLoop.server || GameLoop.client) {
            if (Math.abs(state.locY - state.coLocY) < 400) {
                if (Math.abs(state.locX - state.coLocX) < 850) {
                    g2d.drawImage(rotateImage(state.coTankRotationDegree, false, PTImage.getWidth() / 2,
                            PTImage.getHeight() / 2).
                                    filter(PTImage, null), (state.coLocX + 400 - state.locX),
                            (state.coLocY + 300 - state.locY), null);
                    if (getGunOrShotImage(state.coIsLightGun, state.coIsLightProGun, state.isHeavyProGun, false) == PTLightGunImage) {
                        g2d.rotate(state.coTankGunRotationDegree, state.coLocX + 400 - state.locX + 20 + 26, state.coLocY + 300 + 20 - state.locY + 23);
                        g2d.drawImage(PTLightGunImage, state.coLocX + 400 - state.locX + 20, state.coLocY + 300 - state.locY, null);
                        g2d.rotate(-state.coTankGunRotationDegree, state.coLocX + 400 - state.locX + 20 + 26, state.coLocY + 300 + 20 - state.locY + 23);
                    } else {
                        g2d.rotate(state.coTankGunRotationDegree, state.coLocX + 400 - state.locX + 20 + 26, state.coLocY + 300 + 20 - state.locY + 23);
                        g2d.drawImage(getGunOrShotImage(state.coIsLightGun, state.coIsLightProGun, state.isHeavyProGun, false),
                                state.coLocX + 400 - state.locX + 20, state.coLocY + 300 - state.locY, null);
                        g2d.rotate(-state.coTankGunRotationDegree, state.coLocX + 400 - state.locX + 20 + 26, state.coLocY + 300 + 20 - state.locY + 23);
                    }
                }
            }
        }

        // Draw player tank on appropriate degree and static position in game screen
        if (GameLoop.mapEditorMode) {

        } else {
            g2d.drawImage(rotateImage(state.tankRotationDegree, false, PTImage.getWidth() / 2, PTImage.getHeight() / 2).
                    filter(PTImage, null), 400, 300, null);

            // Draw player tank gun
            double rotationRequired = (state.tankGunRotationDegree);

            if (getGunOrShotImage(state.isLightGun, state.isLightProGun, state.isHeavyProGun, false) == PTLightGunImage) {
                g2d.rotate(rotationRequired, 420 + 26, 320 + 23);
                g2d.drawImage(PTLightGunImage, 420, 300, null);
                g2d.rotate(-rotationRequired, 420 + 26, 320 + 23);
            } else {
                g2d.rotate(rotationRequired, 420 + 26, 320 + 23);
                g2d.drawImage(getGunOrShotImage(state.isLightGun, state.isLightProGun, state.isHeavyProGun, false), 420, 320, null);
                g2d.rotate(-rotationRequired, 420 + 26, 320 + 23);
            }
        }


        // Draw player shots
        if (!GameLoop.client) {
            for (int i = 0; i < state.playerShots.size(); i++) {
                g2d.drawImage(rotateImage(state.playerShots.get(i).getLineSlope(),
                        true, PTHeavyGunBulletImage.getWidth() / 2, PTHeavyGunBulletImage.getHeight() / 2).
                                filter(getGunOrShotImage(state.playerShots.get(i).isLightShot(), state.playerShots.get(i).isLightProShot(),
                                        state.playerShots.get(i).isHeavyProShot(), true), null),
                        state.playerShots.get(i).getLocX() - state.locX, state.playerShots.get(i).getLocY() - state.locY, null);
            }

        } else {
            for (int i = 0; i < state.playerShots.size(); i++) {
                g2d.drawImage(rotateImage(state.playerShots.get(i).getLineSlope(),
                        true, PTHeavyGunBulletImage.getWidth() / 2, PTHeavyGunBulletImage.getHeight() / 2).
                                filter(getGunOrShotImage(state.playerShots.get(i).isLightShot(), state.playerShots.get(i).isLightProShot(),
                                        state.playerShots.get(i).isHeavyProShot(), true), null),
                        state.playerShots.get(i).getLocX() - state.locX, state.playerShots.get(i).getLocY() - state.locY, null);
            }
        }

        // Draw mouse circle
        g2d.drawImage(cursorImage, state.mouseX - cursorImage.getWidth() / 2, state.mouseY - cursorImage.getHeight() / 2, null);

        //Draw number of shots & health
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.CYAN);
        g2d.setFont(new Font("Serif", Font.PLAIN, 20));
        g2d.drawImage(numberOfHeavyShots, 10, 40, null);
        g2d.drawString(String.valueOf(state.playerTankHeavyShot), 20, 85);

        g2d.drawImage(numberOfLightShots, 10, 90, null);
        g2d.drawString(String.valueOf(state.playerTankLightShot), 20, 145);
        for (int i = 0; i < state.playerTankHealth / 5; i++) {
            g2d.drawImage(healthImage, 500 + i * 30, 50, null);
        }

        // Check end if game
        if (state.locX > 6000 || state.coLocX > 6000 || state.playerTankHealth < 0 || state.coPlayerTankHealth < 0) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            Font font = new Font("Serif", Font.PLAIN, 96);
            g2d.setFont(font);
            if (state.locX > 6000 || state.coLocX > 6000) {
                g2d.drawString("You win! ", 640 - 200, 360);
            } else {
                g2d.drawString("You lost! ", 640 - 200, 360);
            }

            if (endGame > 100) {
                GameLoop.gameOver = true;
            } else
                endGame++;

        }

        // Get and draw enemy destroyed tank
        enemyDestroyedTank = area.getDestroyedEnemy(state.destroyedEnemysLocation, state.locX, state.locY);
        for (int i = 0; i < enemyDestroyedTank.size(); i += 2) {
            g2d.drawImage(EDestroyedTankImage, enemyDestroyedTank.get(i), enemyDestroyedTank.get(i + 1), null);
        }


        // Save hard walls
        lastHardWalls = hardWalls;

        // Save soft walls
        lastSoftWalls = softWalls;

        // Save teazels
        lastTeazels = teazels;

        // Save tanks
        lastTanks = tanks;

        isFirstExecution = false;
    }

    /**
     * Get the helper resources image
     *
     * @param sourceNumber The number of source
     * @return The image of the source
     */
    public BufferedImage getResourceImage(int sourceNumber) {

        switch (sourceNumber) {
            case 0:
                return updateGunImage;
            case 1:
                return updateGunImage;
            case 2:
                return repairFoodImage;
            case 3:
                return heavyGunFoodImage;
            case 4:
                return lightGunFoodImage;
        }
        return updateGunImage;
    }

    /**
     * Get the tank gun and the shot image
     *
     * @param isLightGun    Is gun light now or is heavy
     * @param isLightProGun Is pro gun light now
     * @param isHeavyProGun Is Pro gun heavy now
     * @param isShot        Needed shot image or gun image
     * @return The appropriate image consider the parameters
     */
    public BufferedImage getGunOrShotImage(boolean isLightGun, boolean isLightProGun, boolean isHeavyProGun, boolean isShot) {
        if (isLightProGun || isHeavyProGun) {
            if (isLightGun) {
                if (isLightProGun) {
                    if (isShot)
                        return PTLightGunProBulletImage;
                    else {
                        return PTLightGunProImage;
                    }
                } else {
                    if (isShot)
                        return PTLightGunBulletImage;
                    else {
                        return PTLightGunImage;
                    }
                }
            } else {
                if (isHeavyProGun) {
                    if (isShot)
                        return PTHeavyGunProBulletImage;
                    else
                        return PTHeavyGunProImage;
                }
            }
        } else {
            if (isLightGun) {
                if (isShot)
                    return PTLightGunBulletImage;
                else
                    return PTLightGunImage;
            } else {
                if (isShot)
                    return PTHeavyGunBulletImage;
                else
                    return PTHeavyGunImage;
            }
        }
        return PTLightGunProBulletImage;
    }

    /**
     * Get the Enemy tanks image
     *
     * @param enemyTankModelNumber The enemy Tank Model Number
     * @return The enemy tank image
     */
    public BufferedImage getEnemyTankImage(int enemyTankModelNumber) {
        switch (enemyTankModelNumber) {
            case 1:
                return ET1Image;
            case 2:
                return ET2Image;
            case 3:
                return ET3Image;
            case 4:
                return ET4Image;
        }
        return ET1Image;
    }

    /**
     * Get the Enemy tanks gun image
     *
     * @param enemyTankModelNumber The enemy Tank Model Number
     * @return The enemy tank gun image
     */
    public BufferedImage getEnemyTankGunImage(int enemyTankModelNumber) {
        switch (enemyTankModelNumber) {
            case 1:
                return ET1GunImage;
            case 2:
                return ET2GunImage;
            case 3:
                return ET1GunImage;
        }
        return ET1GunImage;
    }

    /**
     * Get the Enemy tanks gun shot image
     *
     * @param enemyTankModelNumber The enemy Tank Model Number
     * @return The enemy tank gun shot image
     */
    public BufferedImage getEnemyTankGunShotImage(int enemyTankModelNumber) {
        if (enemyTankModelNumber == 1) {
            return ET1GunBulletImage;
        }
        if (enemyTankModelNumber == 2) {
            return ET2GunBulletImage;
        }
        if (enemyTankModelNumber == 3) {
            return ET1GunBulletImage;
        }
        System.out.println("worng");
        return ET1GunBulletImage;
    }

    /**
     * Get the Enemy Tank Gun Rotation Degree
     *
     * @param enemyTankModelNumber The enemy Tank Model Number
     * @param rotationDegree       The rotation Degree
     * @return The appropriate rotation Degree
     */
    public double getEnemyTankGunRotationDegree(int enemyTankModelNumber, double rotationDegree) {
        switch (enemyTankModelNumber) {
            case 1:
                return rotationDegree - Math.PI / 2;
            case 2:
                return rotationDegree;
            case 3:
                return rotationDegree - Math.PI / 2;
        }
        return rotationDegree - Math.PI / 2;
    }

    /**
     * Get the appropriate image considering the number of received shots
     *
     * @param modelOfWall The model of wall
     * @return The appropriate image of soft wall consider the model of wall
     */
    public BufferedImage getSoftWallImage(int modelOfWall) {
        switch (modelOfWall) {
            case 1:
                return softWallImage;
            case 2:
                return softWall1Image;
            case 3:
                return softWall2Image;
            case 4:
                return softWall3Image;
            case 5:
                break;

        }
        return softWallImage;
    }

    /**
     * Rotate the Image
     *
     * @param rotationDegree The rotation Degree
     * @param isRadian       Is the angle in radian or degree
     * @param locX           The x location
     * @param locY           The y location
     * @return The Transform of image
     */
    public AffineTransformOp rotateImage(double rotationDegree, boolean isRadian, int locX, int locY) {
        double rotationRequired;
        if (isRadian) {
            rotationRequired = (rotationDegree);
        } else {
            rotationRequired = Math.toRadians(rotationDegree);
        }

        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locX, locY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        return op;
    }


}
