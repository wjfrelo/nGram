import java.util.*;

/**
 * Created by wyatt on 12/11/16.
 */
public class NGram {


    /**
     *
     * @param sentences should have at least one string
     * @param maxGramSize should be 1 at least
     * @return set of continuous word n-grams up to maxGramSize from the sentence
     */
    public static List<String> generateNgramsUpto(String sentences, int maxGramSize) {

        List<String> sentence = Arrays.asList(sentences.split("[\\W+]"));

        List<String> ngrams = new ArrayList<String>();
        int ngramSize = 0;
        StringBuilder sb = null;

        //sentence becomes ngrams
        for (ListIterator<String> it = sentence.listIterator(); it.hasNext();) {
            String word = (String) it.next();

            //add the word itself
            sb = new StringBuilder(word);
            ngrams.add(word);
            ngramSize=1;
            it.previous();

            //Check for previous entry in list and verifees if current size doesn't exceed the desired NGram size.
            //If it holds true, build Ngram
            while(it.hasPrevious() && ngramSize<maxGramSize){
                sb.insert(0,' ');
                sb.insert(0,it.previous());
                ngrams.add(sb.toString());
                ngramSize++;
            }

            //While ngram size is greater than 0, decrease current size and move to the next word
            while(ngramSize>0){
                ngramSize--;
                it.next();
            }
        }
        return ngrams;
    }
}
