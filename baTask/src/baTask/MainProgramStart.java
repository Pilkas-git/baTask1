package baTask;

import java.io.File;
import java.io.IOException;

public class MainProgramStart {

    public static void main(String []args) throws IOException {
        FileReader fileReader = new FileReader();
        FileBrowser fileBrowser = new FileBrowser();
        FileWritter fileWritter = new FileWritter();
        for(File file : fileBrowser.files)
        {
        	var comments = fileReader.FindComments(file.getAbsolutePath());
        	fileWritter.writeToFile(file.getName(),comments);
        }
        System.out.println("Finished");
        fileWritter.close();
        fileReader.close();
    }
}
