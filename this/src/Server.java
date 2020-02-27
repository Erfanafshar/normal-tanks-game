import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
//in multiplayer host use this class to send and receive data
public class Server implements Runnable {
    //server sends server state
    public static ServerState serverState;
    // input stream for receiving data
    private ObjectInputStream in;
    // output stream for sending data
    private ObjectOutputStream out;
    //server receives client state
    public static ClientState clientState;
    // a temporary object for handling object output stream cash
    private ServerState tmp;

    public Server( ObjectInputStream in , ObjectOutputStream out ) {
        this.in = in;
        this.out = out;
        serverState = new ServerState();
        clientState = new ClientState();


    }
    // sends server state and receive client state
    @Override
    public void run() {

        while (true) {
            try {
                //temporary objects for handling object output stream cash
                ArrayList<Shot> tmpShots;
                ArrayList<Tank> tmpTank;
                ArrayList<Integer> tmpHelper;
                ArrayList<SoftWall> tmpSoft;
                if (serverState.getSoftWalls() != null && serverState.getShots() != null && serverState.getEnemyTanks() != null
                        && serverState.getHelperResources() != null) {

                    tmpSoft = new ArrayList<>();
                    for (SoftWall wall : serverState.getSoftWalls()) {
                        tmpSoft.add(new SoftWall(wall.getX(), wall.getY(), wall.getHealth()));
                    }
                    tmpShots = new ArrayList<>();
                    for (Shot shot : serverState.getShots()) {
                        tmpShots.add(new Shot(shot.getMouseX(), shot.getMouseY(), shot.getLineSlope()
                                , (int) (shot.getLocX() - 400 - 50 - 60 * Math.cos(shot.getLineSlope()))
                                , (int) (shot.getLocY() - 300 - 50 - 60 * Math.sin(shot.getLineSlope()))
                                , shot.isLightShot(), shot.isLightProShot(), shot.isHeavyProShot()));
                    }
                    tmpTank = new ArrayList<>();
                    for (Tank tank : serverState.getEnemyTanks()) {
                        if (tank.getTankModelNumber() == 4) {
                            tmpTank.add(new Tank(tank.getFirstXPosition(), tank.getFirstYPosition(), tank.getTankModelNumber(), tank.getTankRotationDegree()
                                    , tank.getLocX(), tank.getLocY(), tank.isGoRight(), tank.isGoUp(), tank.isFirstWhich(), tank.getMyShots(), tank.getStartXMin()
                                    , tank.getStartXMax(), tank.getStartYMin(), tank.getStartYMax(), tank.isEasy(), tank.isMedium(), tank.isHard()));
                        } else {
                            ArrayList<Shot> newShots = new ArrayList<>();
                            for (Shot shot : tank.getMyShots()) {
                                newShots.add(new Shot(shot.getLineSlope(), (int) (shot.getLocX() - 60 * Math.cos(shot.getLineSlope())),
                                        (int) (shot.getLocY() - 60 * Math.sin(shot.getLineSlope())), shot.getNumberOfTankModel()
                                        , shot.getShotNumber()));

                            }

                            tmpTank.add(new Tank(tank.getFirstXPosition(), tank.getFirstYPosition(), tank.getTankModelNumber()
                                    , tank.getTankGunRotationDegree(), tank.getMinBound(), tank.getMaxBound(), tank.isXChanging(), tank.getTankRotationDegree()
                                    , tank.getLocX(), tank.getLocY(), newShots, tank.isStatic(), tank.isEasy(), tank.isMedium()
                                    , tank.isHard()));
                        }
                    }
                    tmpHelper = new ArrayList<>();
                    for (Integer integer : serverState.getHelperResources()) {
                        tmpHelper.add(new Integer(integer));
                    }

                    // receiving client state
                    clientState = (ClientState) in.readObject();
                    // sending server state
                    out.writeObject(new ServerState(serverState.getLocX(), serverState.getLocY(), serverState.getTankRotationDegree()
                            , serverState.getTankGunRotationDegree(), serverState.isLightGun(), serverState.isLightProGun()
                            , serverState.isHeavyProGun(), serverState.getClientHealth(), tmpShots, tmpSoft
                            , tmpTank, tmpHelper, serverState.getClientHeavyShots(), serverState.getClientLightShots()));

                }


                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                   }
            }

    }
}

