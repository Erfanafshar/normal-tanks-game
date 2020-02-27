// Add libraries

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The tank class that can crate new enemy tanks
 * And update them consider the shot received
 * *
 * @author Erfan Afshar
 * @author AmirHossein Bagheri
 * @version 1
 * @since 7/1/2018
 */
public class Tank implements Serializable {

    private int firstXPosition;
    private int firstYPosition;

    private int tankModelNumber;
    private double tankGunRotationDegree;
    private boolean changeDirection;
    private int minBound;
    private int maxBound;

    private int moveSpeed;

    private boolean isXChanging;
    private int tankRotationDegree;

    private int shotTimeCounter;
    private int shotTimeBound;

    private ArrayList<Shot> myShots;

    private int locX, locY;

    private boolean isStatic;

    private boolean goRight;
    private boolean goUp;

    // True : goRight result is Priority ( do that first )
    // False : goUp result is Priority
    private boolean firstWhich;

    // Min x and max coordinate of tank that if the player tank arrive to this x the tank will start movement
    private int startXMin, startXMax;

    // Min y and max coordinate of tank that if the player tank arrive to this x the tank will start movement
    private int startYMin, startYMax;

    private int health;
    private boolean isAvailable;
    private int shotNumber;


    // For tank model 4
    private boolean hitPlayerTank;
    private boolean hitCoPlayerTank;

    // The difficulty
    private boolean isEasy;
    private boolean isMedium;
    private boolean isHard;


    /**
     * This constructor is for tank model 4
     *
     * @param firstXPosition     The first X Position
     * @param firstYPosition     The first Y Position
     * @param tankModelNumber    The tank Model Number
     * @param tankRotationDegree The tank Rotation Degree
     * @param locX               The x location
     * @param locY               The y location
     * @param goRight            Go right or not
     * @param goUp               Go up or not
     * @param firstWhich         First which of them executed
     * @param myShots            This tank shots
     * @param startXMin          The min x for searching
     * @param startXMax          The max x for searching
     * @param startYMin          The min y for searching
     * @param startYMax          The max y for searching
     * @param isEasy             The game is Easy or not
     * @param isMedium           The game is Medium or not
     * @param isHard             The game is Hard or not
     */
    public Tank(int firstXPosition, int firstYPosition, int tankModelNumber, int tankRotationDegree, int locX, int locY,
                boolean goRight, boolean goUp, boolean firstWhich, ArrayList<Shot> myShots, int startXMin, int startXMax,
                int startYMin, int startYMax, boolean isEasy, boolean isMedium, boolean isHard) {
        this.firstXPosition = firstXPosition;
        this.firstYPosition = firstYPosition;
        this.tankModelNumber = tankModelNumber;
        this.tankRotationDegree = tankRotationDegree;

        this.isEasy = isEasy;
        this.isMedium = isMedium;
        this.isHard = isHard;

        this.locX = locX;
        this.locY = locY;

        this.goRight = goRight;
        this.goUp = goUp;
        this.firstWhich = firstWhich;

        this.myShots = new ArrayList<>();
        this.myShots = myShots;

        this.startXMin = startXMin;
        this.startXMax = startXMax;

        this.startYMin = startYMin;
        this.startYMax = startYMax;

        moveSpeed = 6;

        if (this.isEasy) {
            health = 3;
        }
        if (this.isMedium) {
            health = 5;
        }
        if (this.isHard) {
            health = 10;
        }

        isAvailable = true;
        hitPlayerTank = false;
        hitCoPlayerTank = false;

    }


    /**
     * This constructor is for tank model 1 and 2 and 3
     *
     * @param firstXPosition        The first X Position
     * @param firstYPosition        The first Y Position
     * @param tankModelNumber       The tank Model Number
     * @param tankGunRotationDegree The tank gun Rotation Degree
     * @param minCoordinates        The min Coordinates for move
     * @param maxCoordinates        The max Coordinates for move
     * @param isXChanging           Is x changing or y
     * @param tankRotationDegree    The tank Rotation Degree
     * @param locX                  The x location
     * @param locY                  The y location
     * @param myShots               This tank shots
     * @param isStatic              The tank is static or not
     * @param isEasy                The game is Easy or not
     * @param isMedium              The game is Medium or not
     * @param isHard                The game is Hard or not
     */
    public Tank(int firstXPosition, int firstYPosition, int tankModelNumber, double tankGunRotationDegree
            , int minCoordinates, int maxCoordinates, boolean isXChanging, int tankRotationDegree, int locX, int locY,
                ArrayList<Shot> myShots, boolean isStatic, boolean isEasy, boolean isMedium, boolean isHard) {
        this.firstXPosition = firstXPosition;
        this.firstYPosition = firstYPosition;
        this.tankModelNumber = tankModelNumber;
        this.tankGunRotationDegree = tankGunRotationDegree;
        this.minBound = minCoordinates;
        this.maxBound = maxCoordinates;
        changeDirection = false;
        this.isXChanging = isXChanging;
        this.tankRotationDegree = tankRotationDegree;

        this.isEasy = isEasy;
        this.isMedium = isMedium;
        this.isHard = isHard;

        this.myShots = new ArrayList<>();

        this.myShots = myShots;

        this.locX = locX;
        this.locY = locY;

        this.isStatic = isStatic;

        shotTimeCounter = 0;
        if (tankModelNumber == 1) {
            shotTimeBound = 100;
            moveSpeed = 4;
            health = 5;
        }
        if (tankModelNumber == 2) {
            shotTimeBound = 130;
            moveSpeed = 5;
            health = 5;
        }
        if (tankModelNumber == 3) {
            shotTimeBound = 70;
            moveSpeed = 2;
            health = 15;
        }

        if (isEasy) {
            if (tankModelNumber == 1) {
                health = 3;
            }
            if (tankModelNumber == 2) {
                health = 5;
            }
            if (tankModelNumber == 3) {
                health = 10;
            }
        }
        if (isMedium) {
            if (tankModelNumber == 1) {
                health = 5;
            }
            if (tankModelNumber == 2) {
                health = 7;
            }
            if (tankModelNumber == 3) {
                health = 15;
            }
        }
        if (isHard) {
            if (tankModelNumber == 1) {
                health = 7;
            }
            if (tankModelNumber == 2) {
                health = 10;
            }
            if (tankModelNumber == 3) {
                health = 25;
            }
        }
        isAvailable = true;

        shotNumber = 0;

        hitPlayerTank = false;

    }

    public boolean isEasy() {
        return isEasy;
    }

    public boolean isMedium() {
        return isMedium;
    }

    public boolean isHard() {
        return isHard;
    }

    public boolean isHitPlayerTank() {
        return hitPlayerTank;
    }

    public int getStartXMin() {
        return startXMin;
    }

    public int getStartXMax() {
        return startXMax;
    }

    public int getStartYMin() {
        return startYMin;
    }

    public int getStartYMax() {
        return startYMax;
    }

    public boolean isGoRight() {
        return goRight;
    }

    public boolean isGoUp() {
        return goUp;
    }

    public boolean isFirstWhich() {
        return firstWhich;
    }

    public int getFirstXPosition() {
        return firstXPosition;
    }

    public int getFirstYPosition() {
        return firstYPosition;
    }

    public int getTankModelNumber() {
        return tankModelNumber;
    }

    public double getTankGunRotationDegree() {
        return tankGunRotationDegree;
    }

    public int getMinBound() {
        return minBound;
    }

    public int getMaxBound() {
        return maxBound;
    }

    public boolean isXChanging() {
        return isXChanging;
    }

    public int getTankRotationDegree() {
        return tankRotationDegree;
    }

    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public ArrayList<Shot> getMyShots() {
        return myShots;
    }

    public boolean isStatic() {
        return isStatic;
    }


    /**
     * Update the tank position and the gun rotation degree
     * And the tank shots
     *
     * @param playerTankShots The player Tank Shots
     * @param locX            The x location
     * @param locY            The y location
     * @param coLocX          The x location of co
     * @param coLocY          The x location of co
     * @return Is tank available now or not
     */
    public boolean update(ArrayList<Shot> playerTankShots, int locX, int locY, int coLocX, int coLocY) {
        if ((Math.pow(coLocX - firstXPosition, 2) + Math.pow(coLocY - firstYPosition, 2) <
                (Math.pow(locX - firstXPosition, 2) + Math.pow(locY - firstYPosition, 2))) && GameLoop.server) {
            locX = coLocX;
            locY = coLocY;
        }

        if (!(tankModelNumber == 4)) {

            // Check time for creating new shot
            if (Math.abs(firstXPosition + 400 - locX) < 900 && Math.abs(firstYPosition + 300 - locY) < 600) {
                if (shotTimeCounter == shotTimeBound) {
                    myShots.add(new Shot(tankGunRotationDegree, firstXPosition + 50, firstYPosition + 50, tankModelNumber, shotNumber));
                    ThreadPool.execute(new MakeSound(Sounds.ENEMY_SHOT, false));
                    shotTimeCounter = 0;
                    shotNumber++;
                } else {
                    shotTimeCounter++;
                }
            }

            // Update tank direction
            if (isXChanging) {
                if (firstXPosition <= minBound || firstXPosition >= maxBound) {
                    changeDirection = !changeDirection;
                }
            } else {
                if (firstYPosition <= minBound || firstYPosition >= maxBound) {
                    changeDirection = !changeDirection;
                }
            }

            // Update gun rotation
            if (Math.abs((locX + 50) - (firstXPosition + 50)) == 0) {
                tankGunRotationDegree = Math.atan((Math.abs((locY + 50) - (firstYPosition + 50))) / 1.0);


            } else {
                tankGunRotationDegree = Math.atan((double) (Math.abs((locY + 50) - (firstYPosition + 50))) /
                        (Math.abs((locX + 50) - (firstXPosition + 50))));
            }

            if (((locY + 50) - (firstYPosition + 50)) < 0) {
                if (((locX + 50) - (firstXPosition + 50)) < 0) {
                    tankGunRotationDegree += Math.PI;

                } else {
                    tankGunRotationDegree += (2 * Math.PI - 2 * tankGunRotationDegree);

                }
                if (!(Math.abs((locY + 50) - (firstYPosition + 50)) < 150 && Math.abs((locX + 50) - (firstXPosition + 50)) < 150)) {
                    // Prevent vibrate
                    if (!(Math.abs((locY + 50) - (firstYPosition + 50)) < 6)) {
                        if (!isStatic) {
                            if (changeDirection) {
                                if (isXChanging) {
                                    firstXPosition -= moveSpeed;
                                } else {
                                    firstYPosition -= moveSpeed;
                                }
                            } else {
                                if (isXChanging) {
                                    firstXPosition += moveSpeed;
                                } else {
                                    firstYPosition += moveSpeed;
                                }
                            }
                        }
                    }
                }

            } else {
                if (((locX + 50) - (firstXPosition + 50)) < 0) {
                    tankGunRotationDegree += (Math.PI - 2 * tankGunRotationDegree);

                }
                if (!(Math.abs((locY + 50) - (firstYPosition + 50)) < 150 && Math.abs((locX + 50) - (firstXPosition + 50)) < 150)) {
                    if (!(Math.abs((locY + 50) - (firstYPosition + 50)) < 6)) {
                        if (!isStatic) {
                            if (changeDirection) {
                                if (isXChanging) {
                                    firstXPosition += moveSpeed;
                                } else {
                                    firstYPosition += moveSpeed;
                                }
                            } else {
                                if (isXChanging) {
                                    firstXPosition -= moveSpeed;
                                } else {
                                    firstYPosition -= moveSpeed;
                                }
                            }
                        }
                    }

                }
            }
            // Update tank model 4
        } else {
            if (locX > startXMin && locX < startXMax && locY > startYMin && locY < startYMax) {
                if (Math.abs((locX + 50) - (firstXPosition + 50)) < 50 && Math.abs((locY + 50) - (firstYPosition + 50)) < 50) {
                    if (hitPlayerTank) {
                        isAvailable = false;
                        ThreadPool.execute(new MakeSound(Sounds.MINE_BOOM, false));
                    }
                    hitPlayerTank = true;

                } else {
                    if (Math.abs((locX + 50) - (firstXPosition + 50)) < 50) {
                        if (firstWhich) {
                            firstWhich = !firstWhich;
                        }
                    }

                    if ((Math.abs((locY + 50) - (firstYPosition + 50)) < 50)) {
                        if (!firstWhich) {
                            firstWhich = !firstWhich;
                        }
                    }

                    if (firstXPosition > locX) {
                        goRight = false;
                    } else {
                        goRight = true;
                    }

                    if (firstYPosition > locY) {
                        goUp = true;
                    } else {
                        goUp = false;
                    }

                    if (firstWhich) {
                        if (goRight) {
                            // Go right
                            tankRotationDegree = 0;
                            firstXPosition += moveSpeed;
                        } else {
                            // Go left
                            tankRotationDegree = 0;
                            firstXPosition -= moveSpeed;
                        }
                    } else {
                        if (goUp) {
                            // Go up
                            tankRotationDegree = 90;
                            firstYPosition -= moveSpeed;
                        } else {
                            // Go down
                            tankRotationDegree = 90;
                            firstYPosition += moveSpeed;
                        }
                    }
                }
            }


        }

        // For all tank models
        // Update shot received
        // Decrease the health of tank
        for (int i = 0; i < playerTankShots.size(); i++) {
            if (Math.abs((firstXPosition) - (playerTankShots.get(i).getLocX() + 5 - 450)) < 50) {
                if (Math.abs((firstYPosition) - (playerTankShots.get(i).getLocY() - 350)) < 50) {

                    // Decrease the health of tank
                    health -= playerTankShots.get(i).getDecreaseOfHealth();
                    if (health <= 0) {
                        isAvailable = false;
                        ThreadPool.execute(new MakeSound(Sounds.ENEMY_DESTROYED, false));
                    }

                    // Remove the shot
                    playerTankShots.remove(i);

                    break;
                }
            }
        }
        return isAvailable;
    }
}
