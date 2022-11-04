package javacore.third.foldersCreation;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileAndFoldersManipulation {

    private static StringBuilder log = new StringBuilder();


    public void writeToFile(String dir, String file) {
        try (FileWriter writer = new FileWriter(dir + '/' + file)) {
            String timeStamp = getTimestamp();
            String message = timeStamp + " Логи " + " записаны в файл " + file;
            log.append(System.getProperty("line.separator") + message);
            writer.write(log.toString());
        } catch (IOException ex) {
            System.out.println("Время - " + getTimestamp() + " Ошибка " + ex + "При попытке записи - " + "Файл" + file + "Директория " + dir);

        }


    }

    private static boolean createFolder(String directoryPath, String dir) {

        File newDir = new File(directoryPath + '/' + dir);
        boolean result = newDir.mkdirs();
        return result;


    }

    private static boolean createFile(String directoryPath, String file) {

        try {
            File newFile = new File(directoryPath + '/' + file);
            boolean result = newFile.createNewFile();
            return result;

        } catch (IOException ex) {
            System.out.println(ex);
            String timeStamp = getTimestamp();
            String message = "Время - " + timeStamp + " Ошибка " + " " + ex + "Файл " + file + "Директория " + directoryPath;
            log.append(System.getProperty("line.separator") + message);


        }

        return false;
    }

    private static String getTimestamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public void createMultipleFolders(String directoryPath, String[] dirs) {
        for (String dir : dirs) {
            boolean result = createFolder(directoryPath, dir);
            if (result) {
                String timeStamp = getTimestamp();
                String message = "Время - " + timeStamp + " В " + directoryPath + " создана папка " + dir;
                log.append(System.getProperty("line.separator") + message);

            } else {
                String timeStamp = getTimestamp();
                String message = "Время - " + timeStamp + " В " + directoryPath + "  НЕ создана папка " + dir;
                log.append(System.getProperty("line.separator") + message);

            }
        }


    }

    public void createMultipleFiles(String directoryPath, String[] files) {
        for (String file : files) {
            boolean result = createFile(directoryPath, file);
            if (result) {
                String timeStamp = getTimestamp();
                String message = "Время - " + timeStamp + " В " + directoryPath + " создан файл " + file;
                log.append(System.getProperty("line.separator") + message);

            } else {
                String timeStamp = getTimestamp();
                String message = "Время - " + " В " + directoryPath + "  НЕ создан файл " + file;
                log.append(System.getProperty("line.separator") + message);


            }
        }

    }


}
