package ws;

import java.io.*;
import java.nio.*;
import java.nio.file.Path;

public class Contents {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String inputFile = args[0];
        String outputFile = args[1];

        try {
            Reader reader = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(reader);

            Writer writer = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write(inputFile);
            bw.newLine();

            String line;
            while ((line = br.readLine()) != null) {

                bw.write(line);
                bw.newLine();

            }   
            
            bw.close();
            writer.close();
            br.close();
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
