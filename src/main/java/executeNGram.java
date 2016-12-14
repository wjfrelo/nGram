import java.io.*;
import java.util.*;

/**
 * Created by wyatt on 12/11/16.
 */
public class executeNGram {

    public static void main(String[] args) throws IOException, NullPointerException {

        //Map is used as lookup against unique NGrams
        Map<String, Integer> uniqueNGrams = new HashMap();

        //Get text file and NGram size for NGram
        String[] input = NGramInput.getFileAndNGramInput();

        //Get text file "input[0]" and stream through process
        FileInputStream targetStream = new FileInputStream(input[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(targetStream, "UTF-8"));

        while (reader.ready()) {
            // Line parse will pass in each line upto "\n"(new line) character.
            String[] line = Parser.sentenceParser(reader.readLine());
            for (String sentence : line) {
                List<String> ngram = NGram.generateNgramsUpto(sentence, Integer.parseInt(input[1]));
                //Place each nGram into a map that will ensure uniqueness and count the number of entries.
                for (String list : ngram) {
                    if (!uniqueNGrams.containsKey(list)) {
                        uniqueNGrams.put(list, 1);
                    } else {
                        uniqueNGrams.put(list, uniqueNGrams.get(list) + 1);
                    }
                }
            }
        }
        // First sort by word frequency
        List<String> sortedList = sortByFreqOrder(uniqueNGrams);
        // Secondly, sort alphabetically
        Collections.sort(sortedList);

        //Print out List
        for (String entry: sortedList){
            System.out.println(entry);
        }
    }

    // Creates custom comparator to sort by word frequency
    private static List<String> sortByFreqOrder(Map<String, Integer> wordCount) {

        // Convert map to list of <String,Integer> entries
        List<Map.Entry<String, Integer>> list =
                new ArrayList<Map.Entry<String, Integer>>(wordCount.entrySet());

        // Sort list by integer values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // compare o2 to o1, instead of o1 to o2, to get descending freq. order
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // Populate the result into a list
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey());
        }
        return result;
    }
}
