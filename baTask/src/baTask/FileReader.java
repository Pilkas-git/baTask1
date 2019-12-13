package baTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileReader {
	BufferedReader bufferedReader;
    List<String> FindComments(String filePath)
    {
        String line;
        List<String> Comments = new ArrayList<>();
        String code = "";
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(new File(filePath)));
            while ((line = bufferedReader.readLine()) != null)
            {
            	code += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher = Pattern.compile("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/").matcher(code);
        while (matcher.find())
        {
            String comment = matcher.group();
            if(comment.startsWith("\"") && comment.endsWith("\"") || comment.startsWith("///")) {
            	continue;
            }
            //Removes string which contained simillarity to comments, which was created when the user wanted to comment a specific comment
            if(comment.contains("\",//")) { 
            	String tmp = comment.substring(comment.indexOf(",")+1);
            	tmp.trim();
            	comment = tmp;
            }
            Comments.add(comment);
        }
        return Comments;
    }
    
    public void close() {
    	try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
