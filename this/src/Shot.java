// Add library

import java.io.Serializable;

/**
 * The Shot class fro creating shots of all of the tanks
 * And update the position of them
 * *
 * @author Erfan Afshar
 * @author AmirHossein Bagheri
 * @version 1
 * @since 7/1/2018
 */
public class Shot implements Serializable {

    // The position of shot in each second
    private int locX, locY;

    // The mouse position
    // For check that just one click
    private int mouseX, mouseY;

    // The slope of line
    private double lineSlope;

    // The speed of x changing
    private final int xChanges = 6;

    // The model of shot
    private boolean isLightShot;

    private boolean isLightProShot;
    private boolean isHeavyProShot;
    private boolean isReadInServer;

    // The decrease health of each model of shot
    private int light;
    private int lightPro;
    private int heavy;
    private int heavyPro;

    // Power of shot
    private int tankModel1;
    private int tankModel2;
    private int tankModel3;

    private int numberOfTankModel;

    private int shotNumber;

    /**
     * This constructor is for player tank shots
     * @param mouseX The mouse x position
     * @param mouseY The mouse y position
     * @param lineSlope The line slope
     * @param locX The x location
     * @param locY The y location
     * @param isLightShot Is shot light or heavy
     * @param isLightProShot Is light shot pro or not
     * @param isHeavyProShot Is heavy shot pro or not
     */
    public Shot(int mouseX, int mouseY, double lineSlope, int locX, int locY, boolean isLightShot, boolean isLightProShot, boolean isHeavyProShot) {

        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.lineSlope = lineSlope;

        // 60 = the length of pipe //
        // Location in map
        this.locX = (int) (locX + 400 + 50 + 60 * Math.cos(lineSlope));
        this.locY = (int) (locY + 300 + 50 + 60 * Math.sin(lineSlope));

        this.isLightShot = isLightShot;

        this.isLightProShot = isLightProShot;
        this.isHeavyProShot = isHeavyProShot;

        light = 1;
        lightPro = 2;
        heavy = 5;
        heavyPro = 10;
        isReadInServer = false;

    }

    /**
     * this constructor is for enemy tank shots
     * @param lineSlope The line slope
     * @param firstX The first x position
     * @param firstY The first y position
     * @param numberOfTankModel The number Of Tank Model
     * @param shotNumber The shot number
     */
    public Shot(double lineSlope, int firstX, int firstY, int numberOfTankModel, int shotNumber) {

        this.lineSlope = lineSlope;
        this.locX = (int) (firstX + 60 * Math.cos(lineSlope));
        this.locY = (int) (firstY + 60 * Math.sin(lineSlope));

        this.numberOfTankModel = numberOfTankModel;

        this.shotNumber = shotNumber;

        tankModel1 = 5;
        tankModel2 = 1;
        tankModel3 = 5;

    }

    public void setReadInServer(boolean readInServer) {
        isReadInServer = readInServer;
    }

    public boolean isReadInServer() {
        return isReadInServer;
    }

    public boolean isLightProShot() {
        return isLightProShot;
    }

    public boolean isHeavyProShot() {
        return isHeavyProShot;
    }

    public int getShotNumber() {
        return shotNumber;
    }

    public int getNumberOfTankModel() {
        return numberOfTankModel;
    }

    public boolean isLightShot() {
        return isLightShot;
    }

    public double getLineSlope() {
        return lineSlope;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    /**
     * Get the Decrease Of Enemy Shots to player tank
     * @return The Decrease Of Enemy Shots
     */
    public int getDecreaseOfEnemyShots() {
        switch (numberOfTankModel) {
            case 1:
                return tankModel1;
            case 2:
                return tankModel2;
            case 3:
                return tankModel3;
            case 4:
                return 8;
        }
        return 5;
    }

    /**
     * Get Decrease Of Health from each model of shot
     * @return Decrease Of Health
     */
    public int getDecreaseOfHealth() {
        if (isLightShot()) {
            if (isLightProShot) {
                return lightPro;
            } else {
                return light;
            }
        } else {
            if (isHeavyProShot) {
                return heavyPro;
            } else {
                return heavy;
            }
        }
    }

    /**
     * Update the position of shot in static line
     */
    public void update() {
        if (0 <= lineSlope && lineSlope < Math.PI / 2) {
            locX += xChanges;
            locY += xChanges * Math.tan(lineSlope);
        }
        if (Math.PI / 2 <= lineSlope && lineSlope < Math.PI) {
            locX -= xChanges;
            locY -= xChanges * Math.tan(lineSlope);
        }
        if (Math.PI <= lineSlope && lineSlope < 3 * Math.PI / 2) {
            locX -= xChanges;
            locY -= xChanges * Math.tan(lineSlope);
        }
        if (3 * Math.PI / 2 <= lineSlope && lineSlope < 2 * Math.PI) {
            locX += xChanges;
            locY += xChanges * Math.tan(lineSlope);
        }

    }

}

