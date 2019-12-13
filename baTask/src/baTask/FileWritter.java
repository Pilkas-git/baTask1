package baTask;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWritter
{
    private final String SEPARATOR = "=========";
    BufferedWriter bufferedWriter;
    {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Comments.txt", false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String filename, List<String> comments)
    {
        if(comments.isEmpty())
        {
            return;
        }
        try {
            bufferedWriter.newLine();
            bufferedWriter.write(SEPARATOR + filename + SEPARATOR);
            bufferedWriter.newLine();
            int counter = 1;
            for(String comment : comments)
            {
                bufferedWriter.write(counter + comment);
                counter++;
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
    	try {
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

