// Add library

import java.util.ArrayList;

/**
 * The Area class that have the location of some of the game components
 * And get them with consider the the x location and y location
 * *
 *
 * @author Erfan Afshar
 * @author AmirHossein Bagheri
 * @version 1
 * @since 7/1/2018
 */
public class Area {

    // for each third of them
    // first is x coordinate
    // twice is y coordinate
    // third is the model number of recources
    public static ArrayList<Integer> helperResourcesLocation;

    // Is the tank in wall or not
    public boolean isTankInWall;

    /**
     * The constructor of Area class
     * That create the ArrayLists
     */
    public Area() {
        helperResourcesLocation = new ArrayList<>();
        isTankInWall = false;
    }

    /**
     * Draw all hard walls in map
     */
    public void setHardWallsLocation(GameState state) {

        // 1
        for (int i = 1; i < 10; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(32);
        }

        // 2
        for (int i = 0; i < 4; i++) {
            state.hardWallsLocation.add(0);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 3
        for (int i = 0; i < 6; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(432);
        }

        // 4
        for (int i = 4; i < 6; i++) {
            state.hardWallsLocation.add(600);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 5
        for (int i = 6; i > 0; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(632);
        }

        // 6
        for (int i = 6; i < 17; i++) {
            state.hardWallsLocation.add(0);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 7
        for (int i = 0; i < 17; i++) {
            state.hardWallsLocation.add(1000);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 8
        for (int i = 0; i < 3; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1732);
        }

        // 9
        for (int i = 17; i < 22; i++) {
            state.hardWallsLocation.add(300);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 10
        for (int i = 10; 8 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1732);
        }

        // 11
        for (int i = 17; i < 23; i++) {
            state.hardWallsLocation.add(800);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 12
        for (int i = 3; 1 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2232);
        }

        // 13
        for (int i = 22; i < 28; i++) {
            state.hardWallsLocation.add(100);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 14
        for (int i = 1; i < 5; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2832);
        }

        // 15
        for (int i = 8; i < 17; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2332);
        }

        // 16
        for (int i = 23; i < 33; i++) {
            state.hardWallsLocation.add(1700);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 17
        for (int i = 28; i < 34; i++) {
            state.hardWallsLocation.add(500);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 18
        for (int i = 5; i < 10; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(3432);
        }

        // 19
        for (int i = 34; i < 38; i++) {
            state.hardWallsLocation.add(1000);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 20
        for (int i = 10; i < 25; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(3832);
        }

        // 21
        for (int i = 17; i < 21; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(3332);
        }

        // 22
        for (int i = 33; 21 < i; i--) {
            state.hardWallsLocation.add(2100);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 23
        for (int i = 38; 12 < i; i--) {
            state.hardWallsLocation.add(2500);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 24
        for (int i = 25; 22 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1232);
        }

        // 25
        for (int i = 21; 14 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2132);
        }

        // 26
        for (int i = 21; 4 < i; i--) {
            state.hardWallsLocation.add(1400);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 27
        for (int i = 12; 8 < i; i--) {
            state.hardWallsLocation.add(2200);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 28
        for (int i = 22; i < 30; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(832);
        }

        // 29
        for (int i = 14; i < 36; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(432);
        }

        // 30
        for (int i = 4; i < 11; i++) {
            state.hardWallsLocation.add(3600);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 31
        for (int i = 36; 34 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1132);
        }

        // 32
        for (int i = 11; i < 18; i++) {
            state.hardWallsLocation.add(3400);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 33
        for (int i = 8; i < 18; i++) {
            state.hardWallsLocation.add(3000);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 34
        for (int i = 30; 28 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1832);
        }

        // 35
        for (int i = 18; i < 34; i++) {
            state.hardWallsLocation.add(2800);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 36
        for (int i = 34; i < 37; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1832);
        }

        // 37
        for (int i = 18; i < 27; i++) {
            state.hardWallsLocation.add(3700);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 38
        for (int i = 37; 32 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2732);
        }

        // 39
        for (int i = 27; i < 30; i++) {
            state.hardWallsLocation.add(3200);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 40
        for (int i = 32; i < 40; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(3032);
        }

        // 41
        for (int i = 28; i < 46; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(3432);
        }

        // 42
        for (int i = 34; 28 < i; i--) {
            state.hardWallsLocation.add(4600);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 43
        for (int i = 46; i < 49; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2832);
        }

        // 44
        for (int i = 28; 24 < i; i--) {
            state.hardWallsLocation.add(4900);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 45
        for (int i = 49; i < 52; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2432);
        }

        // 46
        for (int i = 24; 17 < i; i--) {
            state.hardWallsLocation.add(5200);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 47
        for (int i = 30; 21 < i; i--) {
            state.hardWallsLocation.add(4000);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 48
        for (int i = 40; i < 43; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2132);
        }

        // 49
        for (int i = 21; 18 < i; i--) {
            state.hardWallsLocation.add(4300);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 50
        for (int i = 43; 41 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1832);
        }

        // 51
        for (int i = 18; 7 < i; i--) {
            state.hardWallsLocation.add(4100);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 52
        for (int i = 52; 47 < i; i--) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1732);
        }

        // 53
        for (int i = 17; 12 < i; i--) {
            state.hardWallsLocation.add(4700);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 54
        for (int i = 47; i < 53; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1232);
        }

        // 55
        for (int i = 41; i < 53; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(732);
        }

        // 56
        for (int i = 7; 5 < i; i--) {
            state.hardWallsLocation.add(5300);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 57
        for (int i = 53; i < 57; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(532);
        }

        // 58
        for (int i = 12; i < 14; i++) {
            state.hardWallsLocation.add(5300);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 59
        for (int i = 53; i < 57; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1432);
        }

        // 60
        for (int i = 5; i < 9; i++) {
            state.hardWallsLocation.add(5700);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // 61
        for (int i = 14; 10 < i; i--) {
            state.hardWallsLocation.add(5700);
            state.hardWallsLocation.add(100 * i + 32);
        }

        // Model 2 ;

        // 1
        for (int j = -2; j < 0; j++) {
            for (int i = -3; i < 60; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 2
        for (int j = 0; j < 18; j++) {
            if (!(j == 5)) {
                for (int i = -3; i < 0; i++) {
                    state.hardWallsLocation.add(100 * i);
                    state.hardWallsLocation.add(32 + 100 * j);
                }
            }
        }

        // 3
        for (int i = -3; i < 6; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(532);
        }

        // 4
        for (int j = 18; j < 22; j++) {
            for (int i = -3; i < 3; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 5
        for (int j = 22; j < 29; j++) {
            for (int i = -2; i < 1; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 6
        for (int j = 29; j < 35; j++) {
            for (int i = -2; i < 5; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 7
        for (int j = 35; j < 39; j++) {
            for (int i = 0; i < 10; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 8
        for (int j = 39; j < 42; j++) {
            for (int i = 6; i < 60; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 9
        for (int j = 0; j < 4; j++) {
            for (int i = 11; i < 65; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 10
        for (int j = 4; j < 18; j++) {
            for (int i = 11; i < 14; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 11
        for (int j = 18; j < 22; j++) {
            for (int i = 9; i < 14; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 12
        for (int i = 9; i < 21; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(2232);
        }

        // 13
        for (int j = 23; j < 33; j++) {
            for (int i = 18; i < 21; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 14
        for (int j = 9; j < 12; j++) {
            for (int i = 23; i < 30; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 15
        for (int j = 12; j < 18; j++) {
            for (int i = 26; i < 30; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 16
        for (int j = 18; j < 35; j++) {
            for (int i = 26; i < 28; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 17
        for (int j = 35; j < 39; j++) {
            for (int i = 26; i < 60; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 18
        for (int i = 37; i < 65; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(432);
        }

        // 19
        for (int j = 5; j < 7; j++) {
            for (int i = 37; i < 53; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 20
        for (int j = 7; j < 12; j++) {
            for (int i = 37; i < 41; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 21
        for (int j = 12; j < 18; j++) {
            for (int i = 35; i < 41; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 22
        for (int i = 38; i < 41; i++) {
            state.hardWallsLocation.add(100 * i);
            state.hardWallsLocation.add(1832);
        }

        // 23
        for (int j = 19; j < 21; j++) {
            for (int i = 38; i < 43; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 24
        for (int j = 21; j < 28; j++) {
            for (int i = 38; i < 40; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 25
        for (int j = 28; j < 30; j++) {
            for (int i = 33; i < 40; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 26
        for (int j = 5; j < 15; j++) {
            if (!(j == 9 || j == 10)) {
                for (int i = 58; i < 75; i++) {
                    state.hardWallsLocation.add(100 * i);
                    state.hardWallsLocation.add(32 + 100 * j);
                }
            }
        }

        // 27
        for (int j = 13; j < 15; j++) {
            for (int i = 48; i < 53; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 28
        for (int j = 15; j < 17; j++) {
            for (int i = 48; i < 65; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 29
        for (int j = 17; j < 25; j++) {
            for (int i = 53; i < 60; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 30
        for (int j = 25; j < 29; j++) {
            for (int i = 50; i < 60; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }

        // 31
        for (int j = 29; j < 35; j++) {
            for (int i = 47; i < 54; i++) {
                state.hardWallsLocation.add(100 * i);
                state.hardWallsLocation.add(32 + 100 * j);
            }
        }
    }


    /**
     * Get the required hard wall for drawing in this coordinate
     *
     * @param x     The x location
     * @param y     The y location
     * @param shots The array list of shots
     * @param tanks The array list of tanks
     * @return The appropriate HardWalls Location for drawing
     */
    public ArrayList<Integer> getHardWallsLocation(int x, int y, ArrayList<Shot> shots, ArrayList<Tank> tanks, GameState state) {

        // Create array list for returning
        ArrayList<Integer> hardWalls = new ArrayList<>();

        // Set to the first value
        isTankInWall = false;

        for (int i = 0; i < state.hardWallsLocation.size(); i += 2) {
            // Find appropriate walls for drawing
            if (Math.abs(y - state.hardWallsLocation.get(i + 1)) < 400) {
                if (Math.abs(x - state.hardWallsLocation.get(i)) < 850) {

                    // Add them to array list
                    hardWalls.add(400 + state.hardWallsLocation.get(i) - x);
                    hardWalls.add(300 + state.hardWallsLocation.get(i + 1) - y);

                    // Check that the shots are in wall or not
                    for (int j = 0; j < shots.size(); j++) {
                        if (Math.abs((state.hardWallsLocation.get(i) + 50) - (shots.get(j).getLocX() + 5 - 450)) < 50) {
                            if (Math.abs((state.hardWallsLocation.get(i + 1) + 50) - (shots.get(j).getLocY() - 350)) < 50) {
                                shots.remove(j);
                                ThreadPool.execute(new MakeSound(Sounds.RECOSH, false));
                            }
                        }
                    }

                    // Check that the tank is in wall or not
                    if (Math.abs((x + 50) - (state.hardWallsLocation.get(i) + 50)) < 95 &&
                            Math.abs((y + 50) - (state.hardWallsLocation.get(i + 1) + 50)) < 95) {
                        isTankInWall = true;

                        // continue is useless
                        return hardWalls;
                    }

                    // Check that enemy tank shots are in wall or not
                    for (int j = 0; j < tanks.size(); j++) {
                        for (int k = 0; k < tanks.get(j).getMyShots().size(); k++) {
                            if (Math.abs((state.hardWallsLocation.get(i) + 50) - (tanks.get(j).getMyShots().get(k).getLocX())) < 50) {
                                if (Math.abs((state.hardWallsLocation.get(i + 1) + 50) - (tanks.get(j).getMyShots().get(k).getLocY())) < 50) {
                                    tanks.get(j).getMyShots().remove(k);
                                }
                            }
                        }
                    }

                }
            }
        }

        return hardWalls;
    }

    /**
     * Draw softWalls in map
     *
     * @param state An object of GameState
     */
    public void setSoftWallsLocation(GameState state) {

        // 1
        for (int i = 5; i < 10; i++) {
            state.softWallsLocation.add(new SoftWall(i * 100, 1132));
        }

        // 2
        for (int i = 27; i < 30; i++) {
            state.softWallsLocation.add(new SoftWall(1300, i * 100 + 32));
        }

        // 3
        for (int i = 10; i < 14; i++) {
            state.softWallsLocation.add(new SoftWall(i * 100, 3032));
        }

        // 4
        for (int i = 30; i < 32; i++) {
            state.softWallsLocation.add(new SoftWall(900, i * 100 + 32));
        }

        // 5
        for (int i = 22; i < 24; i++) {
            state.softWallsLocation.add(new SoftWall(i * 100, 2332));
        }

        // 6
        for (int i = 5; i < 8; i++) {
            state.softWallsLocation.add(new SoftWall(2600, i * 100 + 32));
        }

        // 7
        for (int i = 29; i < 35; i++) {
            state.softWallsLocation.add(new SoftWall(i * 100, 2332));
        }

        // 8
        for (int i = 44; i < 47; i++) {
            state.softWallsLocation.add(new SoftWall(i * 100, 1932));
        }

        // 9
        for (int i = 18; i < 20; i++) {
            state.softWallsLocation.add(new SoftWall(4700, i * 100 + 32));
        }

        // 10
        for (int i = 9; i < 11; i++) {
            state.softWallsLocation.add(new SoftWall(5300, i * 100 + 32));
        }

        // 11
        for (int i = 18; i < 24; i++) {
            state.softWallsLocation.add(new SoftWall(4900, i * 100 + 32));
        }

        // 12
        for (int i = 50; i < 52; i++) {
            state.softWallsLocation.add(new SoftWall(i * 100, 2132));
        }

    }

    /**
     * Get the required soft wall for drawing in this coordinate
     *
     * @param x     The x location
     * @param y     The y location
     * @param state An object of GameState
     * @param tanks An array list of tank
     * @return The appropriate SoftWalls Location for drawing
     */
    public ArrayList<SoftWall> getSoftWallsLocation(int x, int y, GameState state, ArrayList<Tank> tanks) {

        // Create array list for returning
        ArrayList<SoftWall> softWalls = new ArrayList<>();

        // Set to the first value
        isTankInWall = false;

        for (int i = 0; i < state.softWallsLocation.size(); i++) {
            // Find appropriate walls for drawing
            if (Math.abs(y - state.softWallsLocation.get(i).getY()) < 400) {
                if (Math.abs(x - state.softWallsLocation.get(i).getX()) < 850) {

                    // Add them to array list
                    softWalls.add(new SoftWall(400 + state.softWallsLocation.get(i).getX() - x,
                            300 + state.softWallsLocation.get(i).getY() - y, state.softWallsLocation.get(i).getHealth()));

                    // Check that the tank is in wall or not
                    if (Math.abs((x + 50) - (state.softWallsLocation.get(i).getX() + 50)) < 90 &&
                            Math.abs((y + 50) - (state.softWallsLocation.get(i).getY() + 50)) < 90) {
                        isTankInWall = true;
                    }

                    // Check that enemy tank shots are in wall or not
                    for (int j = 0; j < tanks.size(); j++) {
                        for (int k = 0; k < tanks.get(j).getMyShots().size(); k++) {
                            if (Math.abs((state.softWallsLocation.get(i).getX() + 50) - (tanks.get(j).getMyShots().get(k).getLocX())) < 50) {
                                if (Math.abs((state.softWallsLocation.get(i).getY() + 50) - (tanks.get(j).getMyShots().get(k).getLocY())) < 50) {
                                    tanks.get(j).getMyShots().remove(k);
                                }
                            }
                        }
                    }

                }
            }
        }

        return softWalls;
    }

    /**
     * Draw teazels in map
     */
    public void setTeazelsLocation(GameState state) {

        // 1
        for (int i = 1; i < 5; i++) {
            state.teazelsLocation.add(i * 100);
            state.teazelsLocation.add(1132);
        }

        // 2
        for (int i = 14; i < 17; i++) {
            state.teazelsLocation.add(i * 100);
            state.teazelsLocation.add(2732);
        }

        // 3
        for (int i = 6; i < 9; i++) {
            state.teazelsLocation.add(i * 100);
            state.teazelsLocation.add(3132);
        }

        // 4
        for (int i = 34; i < 36; i++) {
            state.teazelsLocation.add(1900);
            state.teazelsLocation.add(i * 100 + 32);
        }

        // 5
        for (int i = 22; i < 24; i++) {
            state.teazelsLocation.add(i * 100);
            state.teazelsLocation.add(2932);
        }

        // 6
        for (int i = 24; i < 25; i++) {
            state.teazelsLocation.add(i * 100);
            state.teazelsLocation.add(2332);
        }

        // 7
        for (int i = 18; i < 22; i++) {
            state.teazelsLocation.add(i * 100);
            state.teazelsLocation.add(832);
        }

        // 8
        for (int i = 31; i < 33; i++) {
            state.teazelsLocation.add(i * 100);
            state.teazelsLocation.add(1332);
        }

        // 9
        for (int i = 24; i < 27; i++) {
            state.teazelsLocation.add(3400);
            state.teazelsLocation.add(i * 100 + 32);
        }

        // 10
        for (int i = 31; i < 33; i++) {
            state.teazelsLocation.add(3700);
            state.teazelsLocation.add(i * 100 + 32);
        }

        // 11
        for (int i = 43; i < 46; i++) {
            state.teazelsLocation.add(i * 100);
            state.teazelsLocation.add(2832);
        }

        // 12
        for (int i = 11; i < 12; i++) {
            state.teazelsLocation.add(5300);
            state.teazelsLocation.add(i * 100 + 32);
        }

        // 13
        for (int i = 8; i < 9; i++) {
            state.teazelsLocation.add(5300);
            state.teazelsLocation.add(i * 100 + 32);
        }

    }

    /**
     * Get the required teazels for drawing in this coordinate
     *
     * @param x The x location
     * @param y The y location
     * @return The appropriate Teazels Location for drawing
     */
    public ArrayList<Integer> getTeazelsLocation(int x, int y, GameState state) {

        // Create array list for returning
        ArrayList<Integer> teazels = new ArrayList<>();

        // Set to the first value
        isTankInWall = false;

        for (int i = 0; i < state.teazelsLocation.size(); i += 2) {
            // Find appropriate walls for drawing
            if (Math.abs(y - state.teazelsLocation.get(i + 1)) < 400) {
                if (Math.abs(x - state.teazelsLocation.get(i)) < 850) {

                    // Add them to array list
                    teazels.add(400 + state.teazelsLocation.get(i) - x);
                    teazels.add(300 + state.teazelsLocation.get(i + 1) - y);

                    // Check that the tank is in wall or not
                    if (Math.abs((x + 50) - (state.teazelsLocation.get(i) + 50)) < 90 &&
                            Math.abs((y + 50) - (state.teazelsLocation.get(i + 1) + 50)) < 90) {
                        isTankInWall = true;
                    }
                }
            }
        }

        return teazels;
    }

    /**
     * Get a new Array list of shots
     *
     * @return The Array list
     */
    public ArrayList<Shot> getShotArray() {
        ArrayList<Shot> shots = new ArrayList<>();
        return shots;
    }

    /**
     * Draw tanks in map
     *
     * @param state An object of GameState
     */
    public void setTanksLocation(GameState state) {


        // 1
        state.enemyTanksLocation.add(new Tank(500, 1432, 1,
                0, 1250, 2000, false,
                90, state.locX, state.locY, getShotArray(), false,
                state.isEasy, state.isMedium, state.isHard));

        // 2
        state.enemyTanksLocation.add(new Tank(500, 2432, 2,
                0, 200, 800, true,
                0, state.locX, state.locY, getShotArray(), false,
                state.isEasy, state.isMedium, state.isHard));

        // 3
        state.enemyTanksLocation.add(new Tank(200, 2732, 3,
                0, 200, 200, true,
                0, state.locX, state.locY, getShotArray(), true,
                state.isEasy, state.isMedium, state.isHard));

        // 4
        state.enemyTanksLocation.add(new Tank(1400, 3632, 4, 0,
                state.locX, state.locY, false, true, false, getShotArray(),
                1100, 1800, 3032, 3732,
                state.isEasy, state.isMedium, state.isHard));

        // 5
        if ((!state.isEasy) || (!state.isMedium)) {
            state.enemyTanksLocation.add(new Tank(2400, 2732, 1,
                    0, 2500, 2900, false,
                    90, state.locX, state.locY, getShotArray(), false,
                    state.isEasy, state.isMedium, state.isHard));
        }

        // 6
        state.enemyTanksLocation.add(new Tank(2400, 1332, 3,
                0, 2400, 2400, true,
                0, state.locX, state.locY, getShotArray(), true,
                state.isEasy, state.isMedium, state.isHard));

        // 7
        if (!state.isEasy) {
            state.enemyTanksLocation.add(new Tank(1600, 1032, 1,
                    0, 800, 1500, false,
                    90, state.locX, state.locY, getShotArray(), false,
                    state.isEasy, state.isMedium, state.isHard));
        }

        // 8
        state.enemyTanksLocation.add(new Tank(1800, 1232, 1,
                0, 900, 1500, false,
                90, state.locX, state.locY, getShotArray(), false,
                state.isEasy, state.isMedium, state.isHard));

        // 9
        if ((!state.isEasy) || (!state.isMedium)) {
            state.enemyTanksLocation.add(new Tank(2000, 600, 2,
                    0, 1900, 2300, true,
                    0, state.locX, state.locY, getShotArray(), false,
                    state.isEasy, state.isMedium, state.isHard));
        }

        // 10
        state.enemyTanksLocation.add(new Tank(3500, 1032, 4, 0,
                state.locX, state.locY, false, true, false, getShotArray(),
                3000, 3600, 450, 1000,
                state.isEasy, state.isMedium, state.isHard));

        // 11
        if ((!state.isEasy) || (!state.isMedium)) {
            state.enemyTanksLocation.add(new Tank(3200, 2050, 2,
                    0, 3100, 3600, true,
                    0, state.locX, state.locY, getShotArray(), false,
                    state.isEasy, state.isMedium, state.isHard));
        }

        // 12
        state.enemyTanksLocation.add(new Tank(3300, 2200, 2,
                0, 3100, 3600, true,
                0, state.locX, state.locY, getShotArray(), false,
                state.isEasy, state.isMedium, state.isHard));

        // 13
        state.enemyTanksLocation.add(new Tank(3600, 2600, 3,
                0, 3600, 3600, true,
                0, state.locX, state.locY, getShotArray(), true,
                state.isEasy, state.isMedium, state.isHard));

        // 14
        if (!state.isEasy) {
            state.enemyTanksLocation.add(new Tank(2900, 3300, 4, 0,
                    state.locX, state.locY, true, true, false, getShotArray(),
                    2800, 3300, 2500, 3400,
                    state.isEasy, state.isMedium, state.isHard));
        }

        // 15
        state.enemyTanksLocation.add(new Tank(4500, 3300, 3,
                0, 4500, 4500, true,
                0, state.locX, state.locY, getShotArray(), true,
                state.isEasy, state.isMedium, state.isHard));

        // 16
        state.enemyTanksLocation.add(new Tank(4800, 2600, 1,
                0, 2100, 2700, false,
                90, state.locX, state.locY, getShotArray(), false,
                state.isEasy, state.isMedium, state.isHard));

        // 17
        state.enemyTanksLocation.add(new Tank(4400, 2100, 4, 0,
                state.locX, state.locY, false, false, false, getShotArray(),
                4000, 4800, 2300, 2700,
                state.isEasy, state.isMedium, state.isHard));

        // 18
        if ((!state.isEasy) || (!state.isMedium)) {
            state.enemyTanksLocation.add(new Tank(4500, 1332, 2,
                    0, 4200, 4500, true,
                    0, state.locX, state.locY, getShotArray(), false,
                    state.isEasy, state.isMedium, state.isHard));
        }

        // 19
        if (!state.isEasy) {
            state.enemyTanksLocation.add(new Tank(4200, 832, 3,
                    0, 4200, 4200, true,
                    0, state.locX, state.locY, getShotArray(), true,
                    state.isEasy, state.isMedium, state.isHard));
        }

        // 20
        state.enemyTanksLocation.add(new Tank(4800, 900, 1,
                0, 850, 1100, false,
                90, state.locX, state.locY, getShotArray(), false,
                state.isEasy, state.isMedium, state.isHard));

        // 21
        state.enemyTanksLocation.add(new Tank(5000, 1000, 1,
                0, 850, 1100, false,
                90, state.locX, state.locY, getShotArray(), false,
                state.isEasy, state.isMedium, state.isHard));

        // 22
        if (!state.isEasy) {
            state.enemyTanksLocation.add(new Tank(5600, 632, 3,
                    0, 5600, 5600, true,
                    0, state.locX, state.locY, getShotArray(), true,
                    state.isEasy, state.isMedium, state.isHard));
        }

        // 23
        state.enemyTanksLocation.add(new Tank(5700, 932, 3,
                0, 5700, 5700, true,
                0, state.locX, state.locY, getShotArray(), true,
                state.isEasy, state.isMedium, state.isHard));

        // 24
        state.enemyTanksLocation.add(new Tank(5700, 1032, 3,
                0, 5700, 5700, true,
                0, state.locX, state.locY, getShotArray(), true,
                state.isEasy, state.isMedium, state.isHard));

        // 25
        if (!state.isEasy) {
            state.enemyTanksLocation.add(new Tank(5600, 1332, 3,
                    0, 5600, 5600, true,
                    0, state.locX, state.locY, getShotArray(), true,
                    state.isEasy, state.isMedium, state.isHard));
        }

    }

    /**
     * Get the required tanks for drawing in this coordinate
     *
     * @param x     The x location
     * @param y     The y location
     * @param state An object of GameState
     * @return The appropriate Tank Location for drawing
     */
    public ArrayList<Tank> getTanksLocation(int x, int y, GameState state) {

        // Create array list for returning
        ArrayList<Tank> tanks = new ArrayList<>();

        // Set to the first value
        isTankInWall = false;

        for (int i = 0; i < state.enemyTanksLocation.size(); i++) {
            // Find appropriate tanks for drawing
            if (Math.abs(y - state.enemyTanksLocation.get(i).getFirstYPosition()) < 400) {
                if (Math.abs(x - state.enemyTanksLocation.get(i).getFirstXPosition()) < 850) {

                    // Add them to array list
                    if (state.enemyTanksLocation.get(i).getTankModelNumber() == 4) {
                        tanks.add(new Tank(400 + state.enemyTanksLocation.get(i).getFirstXPosition() - x,
                                300 + state.enemyTanksLocation.get(i).getFirstYPosition() - y,
                                state.enemyTanksLocation.get(i).getTankModelNumber(),
                                state.enemyTanksLocation.get(i).getTankRotationDegree(),
                                state.enemyTanksLocation.get(i).getLocX(), state.enemyTanksLocation.get(i).getLocY(),
                                state.enemyTanksLocation.get(i).isGoRight(), state.enemyTanksLocation.get(i).isGoUp(),
                                state.enemyTanksLocation.get(i).isFirstWhich(), state.enemyTanksLocation.get(i).getMyShots(),
                                state.enemyTanksLocation.get(i).getStartXMin(), state.enemyTanksLocation.get(i).getStartXMax(),
                                state.enemyTanksLocation.get(i).getStartYMin(), state.enemyTanksLocation.get(i).getStartYMax(),
                                state.enemyTanksLocation.get(i).isEasy(), state.enemyTanksLocation.get(i).isMedium(),
                                state.enemyTanksLocation.get(i).isHard()));
                    } else {
                        tanks.add(new Tank(400 + state.enemyTanksLocation.get(i).getFirstXPosition() - x,
                                300 + state.enemyTanksLocation.get(i).getFirstYPosition() - y,
                                state.enemyTanksLocation.get(i).getTankModelNumber(), state.enemyTanksLocation.get(i).getTankGunRotationDegree(),
                                state.enemyTanksLocation.get(i).getMinBound(), state.enemyTanksLocation.get(i).getMaxBound(),
                                state.enemyTanksLocation.get(i).isXChanging(), state.enemyTanksLocation.get(i).getTankRotationDegree(),
                                state.enemyTanksLocation.get(i).getLocX(), state.enemyTanksLocation.get(i).getLocY(),
                                state.enemyTanksLocation.get(i).getMyShots(), state.enemyTanksLocation.get(i).isStatic(),
                                state.enemyTanksLocation.get(i).isEasy(), state.enemyTanksLocation.get(i).isMedium(),
                                state.enemyTanksLocation.get(i).isHard()));
                    }

                    // Check that the tank is in tank
                    if (Math.abs((x + 50) - (state.enemyTanksLocation.get(i).getFirstXPosition() + 50)) < 90 &&
                            Math.abs((y + 50) - (state.enemyTanksLocation.get(i).getFirstYPosition() + 50)) < 90) {
                        isTankInWall = true;
                    }
                }
            }
        }

        return tanks;
    }

    /**
     * Set Helper Resources in map
     */
    public void setHelperResources(GameState state) {

        // 1
        state.helpersLocation.add(200);
        state.helpersLocation.add(2732);
        state.helpersLocation.add(4);

        // 2
        state.helpersLocation.add(2400);
        state.helpersLocation.add(1332);
        state.helpersLocation.add(3);

        // 3
        state.helpersLocation.add(3600);
        state.helpersLocation.add(2632);
        state.helpersLocation.add(1);

        // 4
        state.helpersLocation.add(5100);
        state.helpersLocation.add(2332);
        state.helpersLocation.add(4);

        // 5
        state.helpersLocation.add(5100);
        state.helpersLocation.add(2232);
        state.helpersLocation.add(3);

        // 6
        state.helpersLocation.add(5100);
        state.helpersLocation.add(1832);
        state.helpersLocation.add(2);

    }

    /**
     * Get appropriate Helper Resources Location
     *
     * @param x     The x location
     * @param y     The y location
     * @param state An object of GameState
     * @return Appropriate Helper Resources location
     */
    public ArrayList<Integer> getHelperResourcesLocation(int x, int y, GameState state) {

        ArrayList<Integer> sources = new ArrayList<>();

        for (int i = 0; i < state.helpersLocation.size(); i += 3) {

            if (Math.abs(y - state.helpersLocation.get(i + 1)) < 400 && Math.abs(x - state.helpersLocation.get(i)) < 850) {

                sources.add(400 + state.helpersLocation.get(i) - x);
                sources.add(300 + state.helpersLocation.get(i + 1) - y);
                sources.add(state.helpersLocation.get(i + 2));
            }
            if (Math.abs((x + 50) - (state.helpersLocation.get(i) + 50)) < 95 &&
                    Math.abs((y + 50) - (state.helpersLocation.get(i + 1) + 50)) < 95) {

                state.doHelperWorks(state.helpersLocation.get(i + 2), state.isLightGun);

                state.helpersLocation.remove(i + 2);
                state.helpersLocation.remove(i + 1);
                state.helpersLocation.remove(i);

            } else if (Math.abs((state.coLocX + 50) - (state.helpersLocation.get(i) + 50)) < 95 &&
                    Math.abs((state.coLocY + 50) - (state.helpersLocation.get(i + 1) + 50)) < 95 && GameLoop.server) {
                state.doHelperWorks(state.helpersLocation.get(i + 2), state.isLightGun);

                state.helpersLocation.remove(i + 2);
                state.helpersLocation.remove(i + 1);
                state.helpersLocation.remove(i);
            }
        }

        return sources;
    }

    /**
     * Get Destroyed Enemy location for drawing
     *
     * @param destroyedEnemysLocation Last Destroyed Enemy location
     * @param x                       The x location
     * @param y                       The y location
     * @return Destroyed Enemy location
     */
    public ArrayList<Integer> getDestroyedEnemy(ArrayList<Integer> destroyedEnemysLocation, int x, int y) {

        ArrayList<Integer> destroyedEnemy = new ArrayList<>();

        for (int i = 0; i < destroyedEnemysLocation.size(); i += 2) {
            // Find appropriate walls for drawing
            if (Math.abs(y - destroyedEnemysLocation.get(i + 1)) < 401) {
                if (Math.abs(x - destroyedEnemysLocation.get(i)) < 850) {

                    // Add them to array list
                    destroyedEnemy.add(400 + destroyedEnemysLocation.get(i) - x);
                    destroyedEnemy.add(300 + destroyedEnemysLocation.get(i + 1) - y);
                }
            }
        }
        return destroyedEnemy;
    }

    /**
     * Set the Plants Location in map
     */
    public void setPlantsLocation(GameState state) {

        // Model 1 :

        // 1
        for (int j = -2; j < 0; j += 2) {
            for (int i = -3; i < 60; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 2
        for (int j = 0; j < 18; j += 2) {
            if (!(j == 5)) {
                for (int i = -1; i < 0; i++) {
                    state.plantsLocation.add(100 * i);
                    state.plantsLocation.add(32 + 100 * j);
                }
            }
        }

        // 3
        for (int i = -3; i < 6; i += 3) {
            state.plantsLocation.add(100 * i);
            state.plantsLocation.add(532);
        }

        // 4
        for (int j = 18; j < 22; j += 2) {
            for (int i = -3; i < 3; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 5
        for (int j = 22; j < 29; j += 2) {
            for (int i = -2; i < 1; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 6
        for (int j = 29; j < 35; j += 2) {
            for (int i = -2; i < 5; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 7
        for (int j = 35; j < 39; j += 2) {
            for (int i = 0; i < 10; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 8
        for (int j = 39; j < 42; j += 2) {
            for (int i = 6; i < 60; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 9
        for (int j = 0; j < 4; j += 2) {
            for (int i = 11; i < 65; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 10
        for (int j = 4; j < 18; j += 2) {
            for (int i = 11; i < 14; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 11
        for (int j = 18; j < 22; j += 2) {
            for (int i = 9; i < 14; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 12
        for (int i = 9; i < 21; i += 3) {
            state.plantsLocation.add(100 * i);
            state.plantsLocation.add(2232);
        }

        // 13
        for (int j = 23; j < 33; j += 2) {
            for (int i = 18; i < 21; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 14
        for (int j = 9; j < 12; j += 2) {
            for (int i = 23; i < 30; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 15
        for (int j = 12; j < 18; j += 2) {
            for (int i = 26; i < 30; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 16
        for (int j = 18; j < 35; j += 2) {
            for (int i = 26; i < 28; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 17
        for (int j = 35; j < 39; j += 2) {
            for (int i = 26; i < 60; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 18
        for (int i = 37; i < 65; i += 3) {
            state.plantsLocation.add(100 * i);
            state.plantsLocation.add(432);
        }

        // 19
        for (int j = 5; j < 7; j += 2) {
            for (int i = 37; i < 53; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 20
        for (int j = 7; j < 12; j += 2) {
            for (int i = 37; i < 41; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 21
        for (int j = 12; j < 18; j += 2) {
            for (int i = 35; i < 41; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 22
        for (int i = 38; i < 41; i += 3) {
            state.plantsLocation.add(100 * i);
            state.plantsLocation.add(1832);
        }

        // 23
        for (int j = 19; j < 21; j += 2) {
            for (int i = 38; i < 43; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 24
        for (int j = 21; j < 28; j += 2) {
            for (int i = 38; i < 40; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 25
        for (int j = 28; j < 30; j += 2) {
            for (int i = 33; i < 40; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 26
        for (int j = 5; j < 13; j += 2) {
            if (!(j == 9 || j == 10)) {
                for (int i = 58; i < 75; i += 3) {
                    state.plantsLocation.add(100 * i);
                    state.plantsLocation.add(32 + 100 * j);
                }
            }
        }

        // 27
        for (int j = 13; j < 15; j += 2) {
            for (int i = 48; i < 53; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 28
        for (int j = 15; j < 17; j += 2) {
            for (int i = 48; i < 65; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 29
        for (int j = 17; j < 25; j += 2) {
            for (int i = 53; i < 60; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 30
        for (int j = 25; j < 29; j += 2) {
            for (int i = 50; i < 60; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // 31
        for (int j = 29; j < 35; j += 2) {
            for (int i = 47; i < 54; i += 3) {
                state.plantsLocation.add(100 * i);
                state.plantsLocation.add(32 + 100 * j);
            }
        }

        // Model 2 :

        // 1
        for (int i = 57; i < 75; i++) {
            state.plantsLocation.add(100 * i);
            state.plantsLocation.add(832);
        }

        // 2
        for (int i = 57; i < 75; i++) {
            state.plantsLocation.add(100 * i);
            state.plantsLocation.add(1132);
        }

    }

    /**
     * Get appropriate Plants Location
     *
     * @param x The x location
     * @param y The y location
     * @return Plants Location ArrayList
     */
    public ArrayList<Integer> getPlantsLocation(int x, int y, GameState state) {

        ArrayList<Integer> plants = new ArrayList<>();

        for (int i = 0; i < state.plantsLocation.size(); i += 2) {
            // Find appropriate walls for drawing
            if (Math.abs(y - state.plantsLocation.get(i + 1)) < 400) {
                if (Math.abs(x - state.plantsLocation.get(i)) < 850) {

                    // Add them to array list
                    plants.add(400 + state.plantsLocation.get(i) - x);
                    plants.add(300 + state.plantsLocation.get(i + 1) - y);
                }
            }
        }
        return plants;
    }

    /**
     * Set the mines in map
     */
    public void setMinesLocation(GameState state) {

        // 1
        state.minesLocation.add(2400);
        state.minesLocation.add(2668);

        // 2
        state.minesLocation.add(2700);
        state.minesLocation.add(732);

        // 3
        state.minesLocation.add(3600);
        state.minesLocation.add(2432);

        // 4
        state.minesLocation.add(5100);
        state.minesLocation.add(2032);

    }

    /**
     * Get an ArrayList of Mines for drawing
     *
     * @param x     The x location
     * @param y     The y location
     * @param state An object of game state
     * @return ArrayList of Mines
     */
    public ArrayList<Integer> getMinesLocation(int x, int y, GameState state) {

        ArrayList<Integer> mines = new ArrayList<>();

        for (int i = 0; i < state.minesLocation.size(); i += 2) {
            if (Math.abs(y - state.minesLocation.get(i + 1)) < 400) {
                if (Math.abs(x - state.minesLocation.get(i)) < 850) {

                    mines.add(400 + state.minesLocation.get(i) - x);
                    mines.add(300 + state.minesLocation.get(i + 1) - y);

                    if (Math.abs((x + 50) - (state.minesLocation.get(i) + 50)) < 95 &&
                            Math.abs((y + 50) - (state.minesLocation.get(i + 1) + 50)) < 95) {

                        state.playerTankHealth -= 7;

                        state.destroyedEnemysLocation.add(state.minesLocation.get(i));
                        state.destroyedEnemysLocation.add(state.minesLocation.get(i + 1));

                        state.minesLocation.remove(i + 1);
                        state.minesLocation.remove(i);

                    }
                }
            }
        }
        return mines;
    }

}
