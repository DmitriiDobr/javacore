package javacore.third.foldersCreation;


import java.io.File;

public class Main {

    public static void main(String[] args) {
        String baseDir = "/Users/dmitriidobr/Games";

        String[] dirsToCreate =  new String[]{ "src", "res", "savegames", "temp"};
        String[] subdirsToCreate = new String[]{"drawables", "vectors", "icons"};
        FileAndFoldersManipulation creator = new FileAndFoldersManipulation();
        creator.createMultipleFolders(baseDir,dirsToCreate);
        creator.createMultipleFolders(baseDir+"/src",new String[]{"main","test"});
        creator.createMultipleFiles(baseDir+"/src/main", new String[]{"Main.java", "Utils.java"} );
        creator.createMultipleFolders(baseDir+"/res",subdirsToCreate);
        creator.createMultipleFiles(baseDir+"/temp",new String[]{"temp.txt"});
        creator.writeToFile(baseDir+"/temp","temp.txt");
        String gamePath = baseDir+"/"+"savegames";
       GameProgress game1 = new GameProgress(1,5,4,4.4);
       GameProgress game2 = new GameProgress(3,7,3,5.4);
       GameProgress game3 = new GameProgress(5,8,6,4.9);

       GameProgress.saveGame(gamePath,"game1.dat",game1);
       GameProgress.saveGame(gamePath,"game2.dat",game2);
       GameProgress.saveGame(gamePath,"game3.dat",game3);

       GameProgress.zipFiles(gamePath,new String[]{"game1.dat","game2.dat","game3.dat"},"games_zip.zip");
       GameProgress.deleteFiles(gamePath,new String[]{"game1.dat","game2.dat","game3.dat"});






    }
}
