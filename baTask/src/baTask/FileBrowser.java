package baTask;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileBrowser {
    public List<File> files = new ArrayList<>();
    public FileBrowser()
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to extract comments from: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                listf(jfc.getSelectedFile().getAbsolutePath());
            }
        }else {
        	System.exit(0);
        }
    }

    public void listf(String directoryName)
    {
        File directory = new File(directoryName);
        File[] fileList = directory.listFiles();
        if(fileList != null) {
            for (File file : fileList) {
            	//ignores hidden files (and github files)
                if (file.isFile() && !file.getName().startsWith(".")) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    listf(file.getAbsolutePath());// recursion
                }
            }
        }
    }
}




