import java.io.Serializable;
import java.util.ArrayList;
// client state saved here to send to server
public class ClientState implements Serializable{
    //locX , locY , tankRotationDegree , tankGunRotationDegree  guest tank location and gun degree
    //shot  if new shot created in client sends it to server to process changes
    //isLightGun , isLightProGun,isHeavyProGun guest player gun type
    //shots  available shots in game
    private int LocX,LocY , tankRotationDegree , tankHealth , tankHeavyShots ,tankLightShots;
    private double tankGunRotationDegree;
    private boolean isLightGun , isLightProGun,isHeavyProGun;
    private Shot shot;

    public ClientState() {
    }

    public ClientState(int locX, int locY, int tankRotationDegree, double tankGunRotationDegree,
                       boolean isLightGun, boolean isLightProGun, boolean isHeavyProGun, Shot shot , int tankHealth , int tankHeavyShots
                       , int tankLightShots) {
        LocX = locX;
        LocY = locY;
        this.tankRotationDegree = tankRotationDegree;
        this.tankGunRotationDegree = tankGunRotationDegree;
        this.isLightGun = isLightGun;
        this.isLightProGun = isLightProGun;
        this.isHeavyProGun = isHeavyProGun;
        this.shot = shot;
        this.tankHealth = tankHealth;
        this.tankHeavyShots = tankHeavyShots;
        this.tankLightShots = tankLightShots;
    }
    public ClientState(int locX, int locY, int tankRotationDegree, double tankGunRotationDegree,
                       boolean isLightGun, boolean isLightProGun, boolean isHeavyProGun , int tankHealth , int tankHeavyShots
                       , int tankLightShots) {
        LocX = locX;
        LocY = locY;
        this.tankRotationDegree = tankRotationDegree;
        this.tankGunRotationDegree = tankGunRotationDegree;
        this.isLightGun = isLightGun;
        this.isLightProGun = isLightProGun;
        this.isHeavyProGun = isHeavyProGun;
        this.tankHealth = tankHealth;
        this.tankHeavyShots = tankHeavyShots;
        this.tankLightShots = tankLightShots;
    }

    public void setTankHeavyShots(int tankHeavyShots) {
        this.tankHeavyShots = tankHeavyShots;
    }

    public void setTankLightShots(int tankLightShots) {
        this.tankLightShots = tankLightShots;
    }

    public void setTankHealth(int tankHealth) {
        this.tankHealth = tankHealth;
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

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public int getTankHeavyShots() {
        return tankHeavyShots;
    }

    public int getTankLightShots() {
        return tankLightShots;
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

    public Shot getShot() {
        return shot;
    }

    public int getTankHealth() {
        return tankHealth;
    }
}

