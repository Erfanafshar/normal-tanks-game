import java.io.Serializable;
import java.util.ArrayList;
//server game state saved here to  send by server or receive by client to update by server and send back to client
//  tank location , shots , softwalls , and  enemies saved here


public class ServerState implements Serializable {
    //locX , locY , tankRotationDegree , tankGunRotationDegree  guest tank location and gun degree
    //clientHealth is health of guest player
    //clientLightShots , clientHeavyShots guest player shot number
    //isLightGun , isLightProGun,isHeavyProGun guest player gun type
    //shots  available shots in game
    //softwalls  soft walls available in game
    // enemyTanks tanks available in game
    //helperResources bonuses available in game
    private int LocX,LocY , tankRotationDegree,clientHealth , clientHeavyShots , clientLightShots;
    private double tankGunRotationDegree;
    private boolean isLightGun , isLightProGun,isHeavyProGun ;
    private ArrayList<Shot> shots;
    private ArrayList<SoftWall> softWalls;
    private ArrayList<Tank> enemyTanks;
    private ArrayList<Integer> helperResources;

    public ServerState() {
    }

    public ServerState(int locX, int locY, int tankRotationDegree,  double tankGunRotationDegree,
                       boolean isLightGun, boolean isLightProGun, boolean isHeavyProGun,int clientHealth, ArrayList<Shot> shots,
                       ArrayList<SoftWall> softWalls, ArrayList<Tank> enemyTanks, ArrayList<Integer> helperResources , int clientHeavyShots
                        , int clientLightShots) {
        LocX = locX;
        LocY = locY;
        this.tankRotationDegree = tankRotationDegree;
        this.clientHealth = clientHealth;
        this.tankGunRotationDegree = tankGunRotationDegree;
        this.isLightGun = isLightGun;
        this.isLightProGun = isLightProGun;
        this.isHeavyProGun = isHeavyProGun;
        this.shots = shots;
        this.softWalls = softWalls;
        this.enemyTanks = enemyTanks;
        this.helperResources = helperResources;
        this.clientHeavyShots = clientHeavyShots;
        this.clientLightShots = clientLightShots;
    }

    public void setClientHeavyShots(int clientHeavyShots) {
        this.clientHeavyShots = clientHeavyShots;
    }

    public void setClientLightShots(int clientLightShots) {
        this.clientLightShots = clientLightShots;
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

    public void setClientHealth(int clientHealth) {
        this.clientHealth = clientHealth;
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

    public void setSoftWalls(ArrayList<SoftWall> softWalls) {
        //this.softWalls = new ArrayList<SoftWall>();
        this.softWalls = softWalls;
    }

    public void setEnemyTanks(ArrayList<Tank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }



    public void setHelperResources(ArrayList<Integer> helperResources) {

        this.helperResources = helperResources;
    }

    public int getClientHeavyShots() {
        return clientHeavyShots;
    }

    public int getClientLightShots() {
        return clientLightShots;
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

    public int getClientHealth() {
        return clientHealth;
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

    public ArrayList<SoftWall> getSoftWalls() {
        return softWalls;
    }

    public ArrayList<Tank> getEnemyTanks() {
        return enemyTanks;
    }

    public ArrayList<Integer> getHelperResources() {
        return helperResources;
    }
}
