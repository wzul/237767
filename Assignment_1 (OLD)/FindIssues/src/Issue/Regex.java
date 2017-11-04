package Issue;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.LinkedList;

public class Regex {

    public static String[] grepClassName(String input, String regexe) {
        LinkedList<String> listClassName = new LinkedList();

        // Step 1: Allocate a Pattern object to compile a regexe
        Pattern pattern = Pattern.compile(regexe);
        //Pattern pattern = Pattern.compile(regexe, Pattern.CASE_INSENSITIVE);  // case-insensitive matching

        // Step 2: Allocate a Matcher object from the compiled regexe pattern,
        //         and provide the input to the Matcher
        Matcher matcher = pattern.matcher(input);

        // Step 3: Perform the matching and process the matching result
        // Use method find()
        while (matcher.find()) {     // find the next match
            String stringGroup = matcher.group();
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            int i = endIndex;

            String className = "";
            boolean shouldStop = false;
            while (true) {
                try {
                    if ((input.substring(i + 1, i + 2).equals(" ") || input.substring(i + 1, i + 2).equals("(") || input.substring(i + 1, i + 2).equals("{")) && shouldStop) {
                        break;
                    } else if (input.substring(i + 1, i + 2).equals(" ")) {
                        i++;
                        continue;
                    } else {
                        shouldStop = true;
                        className += input.substring(i + 1, i + 2);
                    }
                    i++;
                } catch (Exception e) {
                    break;
                }
            }
            listClassName.add(className);
        }
        return convertListClass(listClassName);
    }

    /**
     * Convert LinkedList of ClassName to String of Array
     *
     * @return
     */
    public static String[] convertListClass(LinkedList listClassName) {
        String arrayOfClassName[] = new String[listClassName.size()];

        for (int i = 0; i < listClassName.size(); i++) {
            arrayOfClassName[i] = listClassName.get(i).toString();
        }
        return arrayOfClassName;
    }

}
