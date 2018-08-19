import java.util.Arrays;
import java.util.stream.Collectors;

public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        return Arrays.stream(words).map(word -> Arrays.stream(word.split("")).map(ch -> morse[getIndex(ch)])
                .collect(Collectors.joining())).collect(Collectors.toSet()).size();

    }

    public int getIndex(String ch) {
        return ch.charAt(0) - 'a';
    }
}
