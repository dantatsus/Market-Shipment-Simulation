package FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
	
    private String[] stringsFromFiles;

    public String[] getDatasFromFile(String path){
        try {
            int lengthOfFile;

            //Take the file from path
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));

            //Get the number of lines in the file and create the array with that size
            lengthOfFile = getLengthOfFile(path);
            stringsFromFiles = new String[lengthOfFile];

            //Put each line as one String element in array
            for (int i = 0; i<lengthOfFile; i++) {
                stringsFromFiles[i] = reader.readLine();
                
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured (FileNotFoundException");
        } catch (IOException e) {
            System.out.println("An error occured (IOException");
        }
        
        return stringsFromFiles;
    }

    public int getLengthOfFile(String path){
        int lenght = 0;

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));

            //Pass the first element
            String lineCounter = reader.readLine();

            //If line is not empty add one to length
            while(lineCounter != null) {
                lenght++;
                lineCounter = reader.readLine(); }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured (FileNotFoundException");
        } catch (IOException e) {
            System.out.println("An error occured (IOException");
        }

        return lenght;
    }
}