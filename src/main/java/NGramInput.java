import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by wyatt on 12/11/16. This class is designed to simply ask a user for a file to ingest and identify the NGram Size.
 */
public class NGramInput {


    public static String[] getFileAndNGramInput() {
        int tokenCount = 0;
        String file = "";
        String[] input = new String[2];
        int nGram = 0;

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter the file path and N-Gram Number(space between entries): ");


        //Using a scanner ensures results are independent of order in which user enters data.
        while (reader.hasNextLine() && tokenCount < 2) {

            if (reader.hasNextInt()) {
                nGram = reader.nextInt();
                input[1] = Integer.toString(nGram);
            } else {
                file = reader.next();
                input[0] = file;
            }
            tokenCount++;

        }
        reader.close();

        System.out.println("Using file located at " + file +  " and N-Gram size of " + Integer.toString(nGram));

        //Returns a String Array with the path of the text file and the N-Gram size.
        return input;
    }

}
