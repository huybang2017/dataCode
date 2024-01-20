package HandleList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Stream {
    private BufferedReader input;
    private FileWriter myWriter;

    public Stream() {
        super();
    }

    public ArrayList<String> read(String filePath) throws IOException {
        input = new BufferedReader(new FileReader(filePath));
        ArrayList<String> output = new ArrayList<>();
        String line;
        while ((line = input.readLine()) != null) {
            output.add(line);
        }
        input.close();
        return output;
    }

    public void addOneLine(String filePath, String text) throws IOException {
        myWriter = new FileWriter(filePath, true);
        myWriter.write(text + "\n");
        myWriter.close();
        
    }

    public void addAll(String filePath, ArrayList<String> data) throws IOException {
        myWriter = new FileWriter(filePath);
        for (String line : data) {
            myWriter.write(line + "\n");
        }
        myWriter.close();
    }


}
