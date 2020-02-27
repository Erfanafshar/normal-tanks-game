import java.io.Serializable;
import java.util.ArrayList;

public class MultiPlayerGameState implements Serializable{
    private int LocX,LocY , tankRotationDegree;
    private double tankGunRotationDegree;
    private boolean isLightGun , isLightProGun,isHeavyProGun;
    private ArrayList<Shot> shots;
    private Shot shot;
    private ArrayList<SoftWall> softWalls;
    private int clientHealth;

    public MultiPlayerGameState(int locX, int locY, int tankRotationDegree, double tankGunRotationDegree,
                                boolean isLightGun, boolean isLightProGun , boolean isHeavyProGun,  ArrayList<Shot> shots , ArrayList<SoftWall> softWalls , int clientHealth) {
        this.LocX = locX;
        this.LocY = locY;
        this.tankRotationDegree = tankRotationDegree;
        this.tankGunRotationDegree = tankGunRotationDegree;
        this.isLightGun = isLightGun;
        this.isLightProGun = isLightProGun;
        this.isHeavyProGun = isHeavyProGun;
        this.shots = shots;
        this.softWalls = softWalls;
        this.clientHealth = clientHealth;
    }
    public MultiPlayerGameState(int locX, int locY, int tankRotationDegree, double tankGunRotationDegree,
                                boolean isLightProGun,boolean isHeavyProGun, boolean isProGun, Shot shot) {
        this.LocX = locX;
        this.LocY = locY;
        this.tankRotationDegree = tankRotationDegree;
        this.tankGunRotationDegree = tankGunRotationDegree;
        this.isLightGun = isLightGun;
        this.isLightProGun = isLightProGun;
        this.isHeavyProGun = isHeavyProGun;
        this.shot = shot;
    }
    public MultiPlayerGameState(){

    }

    public void setClientHealth(int clientHealth) {
        this.clientHealth = clientHealth;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public void setSoftWalls(ArrayList<SoftWall> softWalls) {
        this.softWalls = softWalls;
    }

    public void setLocX(int locX) {
        LocX = locX;
    }

    public void setLocY(int locY) {
        LocY = locY;
    }

    public void setTankRotationDegree(int tankRotationDegree) {
        this.tankRotationDegree = tankRotationDegree;
    }

    public void setTankGunRotationDegree(double tankGunRotationDegree) {
        this.tankGunRotationDegree = tankGunRotationDegree;
    }

    public void setLightGun(boolean lightGun) {
        isLightGun = lightGun;
    }

    public void setLightProGun(boolean lightProGun) {
        isLightProGun = lightProGun;
    }

    public void setHeavyProGun(boolean heavyProGun) {
        isHeavyProGun = heavyProGun;
    }

    public void setShots(ArrayList<Shot> shots) {
        this.shots = shots;
    }

    public int getClientHealth() {
        return clientHealth;
    }
    public int getLocX() {
        return LocX;
    }

    public int getLocY() {
        return LocY;
    }

    public int getTankRotationDegree() {
        return tankRotationDegree;
    }

    public double getTankGunRotationDegree() {
        return tankGunRotationDegree;
    }

    public boolean isLightGun() {
        return isLightGun;
    }

    public boolean isLightProGun() {
        return isLightProGun;
    }

    public boolean isHeavyProGun() {
        return isHeavyProGun;
    }

    public ArrayList<Shot> getShots() {
        return shots;
    }

    public Shot getShot() {
        return shot;
    }

    public ArrayList<SoftWall> getSoftWalls() {
        return softWalls;
    }
}
