import java.io.*;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
//   in multiplayer guest use this class to send and receive data
public class Client implements Runnable {
    //client receive server state
    public static ServerState serverState;
    // client sends client state
    public static  ClientState clientState;
    //input stream for receiving data
    private ObjectInputStream in;
    // output stream for sending data
    private ObjectOutputStream out;

    public Client( ObjectInputStream in ,ObjectOutputStream out) {
        this.in = in;
        this.out = out;
        serverState = new ServerState();
        clientState = new ClientState();
    }


    @Override
    public void run() {


        while (true){
            Shot tmpShot = null;

            try {
                //sending client state
                if(clientState.getShot() != null) {
                    tmpShot = new Shot(clientState.getShot().getMouseX(), clientState.getShot().getMouseY(), clientState.getShot().getLineSlope()
                            , (int) (clientState.getShot().getLocX()- 400 - 50 - 60 * Math.cos(clientState.getShot().getLineSlope())),
                            (int) (clientState.getShot().getLocY()-300 - 50 - 60 * Math.sin(clientState.getShot().getLineSlope())),
                            clientState.getShot().isLightShot()
                            , clientState.getShot().isLightProShot(), clientState.getShot().isHeavyProShot());

                    out.writeObject(new ClientState(clientState.getLocX(), clientState.getLocY(), clientState.getTankRotationDegree()

                            , clientState.getTankGunRotationDegree(), clientState.isLightGun(), clientState.isLightProGun()
                            , clientState.isHeavyProGun(), tmpShot, clientState.getTankHealth() , clientState.getTankHeavyShots() ,
                            clientState.getTankLightShots()));

                    clientState.setShot(null);

                }else {
                    out.writeObject(new ClientState(clientState.getLocX(), clientState.getLocY(), clientState.getTankRotationDegree()
                            , clientState.getTankGunRotationDegree(), clientState.isLightGun(), clientState.isLightProGun()
                            , clientState.isHeavyProGun(),  clientState.getTankHealth() , clientState.getTankHeavyShots()
                     , clientState.getTankLightShots()));

                }
                    if (clientState.getShot() != null)
                        clientState.getShot().setReadInServer(true);

                // receiving server state
                serverState = (ServerState) in.readObject();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
