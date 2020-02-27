// Add libraries

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The SoftWall class that contain the position of the soft wall
 * And the health of that
 * And can update the health and disposed
 * *
 * @author Erfan Afshar
 * @author AmirHossein Bagheri
 * @version 1
 * @since 7/1/2018
 */
public class SoftWall implements Serializable {

    private int x, y;
    private int health;

    private boolean isAvailable;

    /**
     * The constructor of softWall
     * @param XPos The x position
     * @param YPos The y position
     */
    public SoftWall(int XPos, int YPos) {
        x = XPos;
        y = YPos;
        health = 20;
        isAvailable = true;
    }

    /**
     * The constructor of softWall for creating objects
     * @param x The x position
     * @param y The y position
     * @param health The health of wall
     */
    public SoftWall(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    /**
     * Get the model of soft wall
     * @return The model of soft wall number
     */
    public int getModelOfWall() {
        if (health > 15) {
            return 1;
        } else {
            if (health > 10) {
                return 2;
            } else {
                if (health > 5) {
                    return 3;
                } else {
                    return 4;
                }
            }

        }
    }

    /**
     * Update the soft wall with consider to the shots received
     * @param shots The shot of player
     * @return Is wall available or not
     */
    public boolean update(ArrayList<Shot> shots) {

        // Check that is any shot knock to this wall
        for (int i = 0; i < shots.size(); i++) {

            if (Math.abs((x + 50) - (shots.get(i).getLocX() + 5 - 450)) < 50) {
                if (Math.abs((y + 50) - (shots.get(i).getLocY() - 350)) < 50) {
                    health -= shots.get(i).getDecreaseOfHealth();
                    ThreadPool.execute(new MakeSound(Sounds.SOFT_WALL , false));

                    if (health <= 0) {
                        isAvailable = false;
                    }

                    shots.remove(i);
                    break;
                }
            }
        }

        return isAvailable;
    }

}
