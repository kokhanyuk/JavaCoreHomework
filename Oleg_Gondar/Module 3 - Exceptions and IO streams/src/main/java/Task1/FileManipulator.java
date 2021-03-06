package Task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Oleg on 14.03.2016.
 */
public class FileManipulator {

    private File file;
    private FileWriter fileWriter;

    public void setFileWriter(File file, boolean append) {
        try {
            this.fileWriter = new FileWriter(file, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileManipulator(String fileName) {
        file = new File(fileName);
    }

    public String showFile() throws IOException {
        FileReader fileReader = new FileReader(file);
        char[] buffer = new char[(int) file.length()];
        fileReader.read(buffer);
        //System.out.println(buffer);
        fileReader.close();
        return new String(buffer);
    }

    public void deleteFile() {
        Path path = Paths.get(file.getAbsolutePath());
        try {

            Files.delete(path);
        } catch (IOException e) {
            System.out.println("File not deleted");
        }
    }

    public void writeFile(String wrstr) throws IOException {
        setFileWriter(file, false);
        filePerformWrite(fileWriter, wrstr);
    }

    public void appendFile(String appstr) throws IOException {
        setFileWriter(file, true);
        filePerformWrite(fileWriter, appstr);

    }


    private void filePerformWrite(FileWriter fileWriter, String stringToWrite) throws IOException {
        fileWriter.write(stringToWrite);
        fileWriter.flush();
        fileWriter.close();
    }

}
