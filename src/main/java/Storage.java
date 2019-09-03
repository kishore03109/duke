import java.io.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Storage {



    public static void main(String item) {

        // The name of the file to open.
        String fileName = "text.txt";

        try {
            BufferedWriter output;
            output = new BufferedWriter(new FileWriter(fileName, true)); //clears file every time

            output.append(item);
            output.newLine();
            output.close();



        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
