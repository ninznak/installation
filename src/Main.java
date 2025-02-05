import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    static Date localDateTime = new Date();

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        File parentFolder = new File("D://GamesNetology");
        File srcSubFold = new File(parentFolder, "/src");
        File resSubFold = new File(parentFolder, "/res");
        File srcMainFolder = new File(parentFolder.toString(), "/src/main");
        File mainFile = new File(srcMainFolder, "Main.java");
        File utilsFile = new File(srcMainFolder, "Utils.java");
        File fileLog = new File(parentFolder, "/temp/temp.txt");

        String[] foldersMain = {"src", "res", "savegames", "temp"};
        String[] srcSubfolders = {"main", "test"};
        String[] resSubfolders = {"drawables", "vectors", "icons"};

        if (parentFolder.exists()) {
            sb.append("Main folder exist, creation scipped. ")
                    .append(localDateTime).append("\n");
        } else {
            sb.append("Main folder 'GamesNetology' created: ")
                    .append(parentFolder.mkdir())
                    .append(dateTimeAdd());
        }

        for (String folder : foldersMain) {
            File folderInside = new File(parentFolder, folder);
            sb.append(folder).append(" создана: ")
                    .append(" ")
                    .append(folderInside.mkdir())
                    .append(dateTimeAdd());
        }

        for (String folder : srcSubfolders) {
            File folderInside = new File(srcSubFold, folder);
            sb.append(folder).append(" создана: ")
                    .append(" ")
                    .append(folderInside.mkdir())
                    .append(dateTimeAdd());
        }

        for (String folder : resSubfolders) {
            File folderInside = new File(resSubFold, folder);
            sb.append(folder).append(" создана: ")
                    .append(" ")
                    .append(folderInside.mkdir())
                    .append(dateTimeAdd());
        }

        try {
            sb.append("Создан новый лог файл: ")
                    .append(fileLog.createNewFile())
                    .append(dateTimeAdd());
            sb.append("Файл 'Main.java' создан: ")
                    .append(mainFile.createNewFile())
                    .append(dateTimeAdd())
                    .append("Файл 'Utils.java' создан: ")
                    .append(utilsFile.createNewFile())
                    .append(dateTimeAdd());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter fileWriter = new FileWriter(fileLog, true)) {
            fileWriter.write("\nTest writing to file " + localDateTime + "\n");
            fileWriter.write(sb.toString());
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong");
        }
    }

    private static String dateTimeAdd() {
        return String.format(" %s \n", localDateTime);
    }
}
