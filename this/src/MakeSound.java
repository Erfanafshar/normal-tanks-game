import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
// a class for playing game sounds using buffer
public class MakeSound implements  Runnable {
    // a buffer of 128kb
    private final int BUFFER_SIZE = 128000;
    // name of sound file
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    private String strFileName;
    // is sound play continuously
    private boolean replay;
    // stop sound
    private boolean stop;
    // strFileName name of sound file
    //replay  play continuously or not
    public MakeSound(String strFileName , boolean replay){
        Path currentRelativePath = Paths.get("");
        String tmp = currentRelativePath.toAbsolutePath().toString();
        this.strFileName  = currentRelativePath.toAbsolutePath().toString()+"/Sounds/"+strFileName;
        this.replay = replay;
        stop = false;
    }

//playing sound
    public void run() {

        do {
            try {
                soundFile = new File(strFileName);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

            try {
                audioStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

            audioFormat = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            try {
                sourceLine = (SourceDataLine) AudioSystem.getLine(info);
                sourceLine.open(audioFormat);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

            sourceLine.start();

            int nBytesRead = 0;
            byte[] abData = new byte[BUFFER_SIZE];
            while (nBytesRead != -1 && !stop ) {

                try {

                    nBytesRead = audioStream.read(abData, 0, abData.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (nBytesRead >= 0) {
                    @SuppressWarnings("unused")
                    int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
                }
            }
            sourceLine.drain();
            sourceLine.close();
        }while(replay);
    }

    public boolean isReplay() {
        return replay;
    }

    public void setReplay(boolean replay) {
        this.replay = replay;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}