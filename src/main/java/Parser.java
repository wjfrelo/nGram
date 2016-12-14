import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * This class finds and parse sentences from paragraphs passed. Each paragraph will be split into sentences and passed into
 * array elements.
 */
public class Parser {



    public static String[] sentenceParser(String line) throws IOException {

            line = line.replace("\n", "");
            //Split lines at the end of the sentence
            String [] fields = line.split("^\\s+[a-zA-Z\\s]+[.?!]$");

        return fields;
    }

}
