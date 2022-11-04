package javacore.third.foldersCreation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public static void saveGame(String path, String fileName, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(path + '/' + fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void zipFiles(String filePath, String[] fileNames, String zipName) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(filePath + "/" + zipName));


        ) {
            for (String fileName : fileNames) {
                try {
                    FileInputStream fis = new FileInputStream(filePath + '/' + fileName);
                    ZipEntry entry = new ZipEntry("/packed_" + fileName);
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }


    public static void deleteFiles(String path, String[] fileNames) {
        for (String file : fileNames) {
            File delFiles = new File(path + "/" + file);
            boolean result = delFiles.delete();
            System.out.println("Файл удален - " + result);
        }
    }
}
