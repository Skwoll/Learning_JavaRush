package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.Controller;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private String levels;
    public LevelLoader(String levels) {
        this.levels = levels;
    }
    public GameObjects getLevel(int level){
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        Player player = null;
        int realLvl = level % 60 ;
        realLvl = realLvl == 0 ? 60 : realLvl;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Controller.class.getResourceAsStream(levels)))) {
            int readLevel = 0;
            int x;
            int y = Model.FIELD_CELL_SIZE / 2;
            boolean isLevelMap = false;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Maze:")) {
                    readLevel = Integer.parseInt(line.split(" ")[1]);
                    continue;
                }
                if (readLevel == realLvl) {
                    if (line.length() == 0) {
                        boolean isEnd = isLevelMap;

                        isLevelMap = !isLevelMap;

                        if (isEnd) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    if (isLevelMap) {
                        x = Model.FIELD_CELL_SIZE / 2;

                        char[] chars = line.toCharArray();
                        for (char c : chars) {
                            switch (c) {
                                case 'X':
                                    walls.add(new Wall(x, y));
                                    break;
                                case '*':
                                    boxes.add(new Box(x, y));
                                    break;
                                case '.':
                                    homes.add(new Home(x, y));
                                    break;
                                case '&':
                                    boxes.add(new Box(x, y));
                                    homes.add(new Home(x, y));
                                    break;
                                case '@':
                                    player = new Player(x, y);
                            }
                            x += Model.FIELD_CELL_SIZE;
                        }
                        y += Model.FIELD_CELL_SIZE;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls,boxes,homes,player);

    }
}
