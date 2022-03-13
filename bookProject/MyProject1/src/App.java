import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {

        // String str = "A Beginners Guide to Transfiguration by Emeric";
        // String str2 = "A Beginners Guide to Transfiguration by Emeric";

        // ArrayList<String> splitString = new ArrayList<>();
        // ArrayList<String> globalArrayList = new ArrayList<>();

        // String[] strArray = str.split(" ");

        // for (String s : strArray) {

        // splitString.add(s.toLowerCase());
        // }
        // Collections.sort(splitString);

        // for (String s : splitString) {
        // globalArrayList.add(s);
        // }

        // System.out.println(splitString);

        FileReader fr = new FileReader("Book 1 - The Philosopher's Stone.txt");
        BufferedReader reader = new BufferedReader(fr);
        ArrayList<String> globalList = new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        while ((line = reader.readLine()) != null) {
            if (!line.equals("")) {
                line = line.replaceAll("[^a-zA-Z]", " ");
                line = line.trim();
                line.toLowerCase();
                String[] arry = line.split(" ");
                for (String s : arry) {
                    globalList.add(s);
                }
                str.add(line.toLowerCase());
            }

        }
        for (String s : str) {
            s.replaceAll("[^\\p{L}]", "");

        }

        reader.close();
        Collections.sort(str);
        FileWriter writer = new FileWriter("newFile");
        for (String s : str) {
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();
    }
}
