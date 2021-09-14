import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chapter1 {
    private static final Pattern PATTERN = Pattern.compile(" +");

    //:my response
    public void duplicateCharacterss(String text) {
        List<Integer> numere = new ArrayList<>();
        List<Character> caractere = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (caractere.contains(text.charAt(i)) == false) {
                numere.add(1);
                caractere.add(text.charAt(i));
            } else {
                int index = getIndexList(caractere, text.charAt(i));
                int nr = numere.get(index);
                nr++;
                numere.set(index, nr);
            }
        }
        System.out.println(numere);
        System.out.println(caractere);
    }

    //book response1:
    public HashMap<Character, Integer> duplcateCharacter(String text) {
        HashMap<Character, Integer> container = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            container.compute(c, (key, value) -> (value == null) ? 1 : value + 1);
        }
        return container;
    }

    //book response2:
    public Map<Character, Long> duplcateCharacter1(String text) {

        Map<Character, Long> result = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }


    private int getIndexList(List<Character> lista, char a) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == a) {
                return i;
            }
        }
        return 0;
    }


    //todo find the first non repeated character
    //my response:
    public Character firstNonReapeted(String text) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (char c : text.toCharArray()) {
            result.compute(c, (value, key) -> (key == null) ? 1 : ++key);
        }
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();

            }
        }
        return null;
    }
    //my second response:

    public Character firstNonRepeated(String text) {
        Map<Character, Long> result = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        for (Map.Entry<Character, Long> a : result.entrySet()) {
            if (a.getValue() == 1) {
                return a.getKey();
            }
        }
        return ' ';
    }


    //reversing letters and words

    //my response:
    public StringBuilder reverse(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(text);
        return stringBuilder.reverse();
    }

    // my response2:
    public String reverse2(String text) {
        String a = new String();
        for (int i = text.length() - 1; i >= 0; i--) {
            a += text.charAt(i);
        }
        return a;
    }

    // book
    public String reverse3(String str) {
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse()).collect(Collectors.joining(" "));


    }

    //todo:check if a stirng contains only digits
    //my response
    public boolean isOnlyDigit(String str) {
        for (Character c : str.toCharArray()) {
            if (Character.isDigit(c) == false) {
                return false;
            }
        }
        return true;
    }

    //book response
    public boolean onlyDigit(String str) {
        return !str.chars().anyMatch(n -> !Character.isDigit(n));

    }


    //todo:counting vowels and consoants

    //my response
    public HashMap<String, Integer> countsVowCons(String str) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("vowels", 0);
        result.put("consoants", 0);
        String vowels = "aeiou";
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            String finalStr = str;
            int finalI = i;
            if (vowels.chars().anyMatch(caracter -> caracter == finalStr.charAt(finalI) == true)) {
                result.compute("vowels", (key, value) -> (value == null) ? 1 : ++value);
            } else if (vowels.chars().anyMatch(caracter -> caracter == finalStr.charAt(finalI) == false) && (str.charAt(i) >= 'a') && str.charAt(i) <= 'z') {
                result.compute("consoants", (key, value) -> (value == null) ? 1 : ++value);
            }
        }
        return result;
    }

    //book response
    private static final Set<Character> allVowels
            = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public void countVowelsAndConsonants(String str) {
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }
        System.out.println("Vowels:" + vowels);
        System.out.println("Consoants:" + consonants);
    }

    //book response2
    public void countVowelsAndConsonats(String str) {
        str = str.toLowerCase();
        long vowels = str.chars().filter(c -> allVowels.contains((char) c)).count();
        long consoants = str.chars().filter(c -> !allVowels.contains((char) c)).filter(ch -> (ch >= 'a' && ch <= 'z')).count();
        System.out.println("Vowels:" + vowels);
        System.out.println("Consoants:" + consoants);
    }


    //todo:counting the occurances of a certain character
    //my response:
    public long occurances(String str, char c) {
        return str.chars().filter(ch -> ch == c).count();
    }

    //book response:
    public int countOccurrencesOfACertainCharacter(
            String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }


    //todo:removing white spaces from string
    //my response
    public String removeWhiteSpace(String str) {
        return str.replace(" ", "");
    }

    //todo:joingin multiple string with a delimiter
    public String joinByDel(char delimiter, String... args) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < args.length - 1; i++) {
            stringBuilder.append(args[i]).append(delimiter);
        }

        stringBuilder.append(args[args.length - 1]);
        return stringBuilder.toString();
    }


    public String joinByDelimiter(char delimiter, String... args) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);
        }
        result.append(args[i]);
        return result.toString();
    }


    //todo:check whter a string is a palindrom
    //my response:
    public boolean checkPalindrom(String str) {

        return str.equals(new StringBuilder().append(str).reverse().toString());
    }
    //book response

    public static boolean isPalindrome(String str) {
        return IntStream.range(0, str.length() / 2)
                .noneMatch(p -> str.charAt(p) !=
                        str.charAt(str.length() - p - 1));
    }


    //todo:removing duplicate characters
    //my response:
    public String deleteDuplicateCharacters(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.compute(c, (key, value) -> (value == null) ? 1 : ++value);
        }
        for (Map.Entry<Character, Integer> a : map.entrySet()) {
            Character ex = a.getKey();
            if (str.contains(ex.toString()) && a.getValue() > 1) {
                str = str.replace(ex.toString(), "");
            }
        }
        return str;
    }

    //book response:
    public String deleteDuplcateCharacters(String str) {
        return Arrays.asList(str.split("")).stream()
                .distinct()
                .collect(Collectors.joining());
    }


    //todo:removing given character

    //my response:
    public String removeCharacter(String str, char ch) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(str.split("")).stream().filter(c -> !c.contains(String.valueOf(ch))).forEach(ex -> stringBuilder.append(ex));
        return stringBuilder.toString();
    }

    //book response
    public String removingGivenCharacter(String str, char c) {
        return str.chars().filter(ch -> ch != c).mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());

    }


    //todo:finding the character with the most appearcances
    //my response:
    public Character mostApparances(String str) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (Character c : str.toCharArray()) {
            if (c != ' ') {
                result.compute(c, (key, value) -> (value == null) ? 1 : ++value);
            }
        }
        int count = 0;
        char aux = ' ';
        for (Map.Entry<Character, Integer> a : result.entrySet()) {
            if (a.getValue() > count) {
                count = a.getValue();
                aux = a.getKey();
            }
        }
        System.out.println(result);
        return aux;
    }


    //todo:sorting an array of strings by length

    //my response
    public void sortArrayByLength(String[] strs, String direction) {
        if (direction.equals("crescator")) {
            Arrays.sort(strs, (String s1, String s2)
                    -> Integer.compare(s1.length(), s2.length()));
        } else {
            Arrays.sort(strs, (String s1, String s2)
                    -> (-1) * Integer.compare(s1.length(), s2.length()));
        }
        for (String s : strs) {
            System.out.println(s);
        }
    }

    //todo:Checking that a string contains a substring

    //my response
    public boolean checksubstring(String str, String substr) {
        return str.contains(substr);
    }


    //todo:counting substring occurrances in a string

    //my response
    public int countingoccurances(String str, String substr) {
        int count = 0, fromIndex = 0;

        while ((fromIndex = str.indexOf(substr, fromIndex)) != -1) {

            System.out.println("Found at index: " + fromIndex);
            count++;
            fromIndex++;

        }

        return count;
    }


    //book response
    public int countingOccurances(String str, String substr) {
        Pattern pattern = Pattern.compile(substr);
        Matcher matcher = pattern.matcher(str);
        int position = 0;
        int count = 0;
        while (matcher.find(position)) {
            position = matcher.start() + 1;
            count++;
        }
        return count;
    }

    //todo:check wheter two strings are anagrams

    //my response
    public boolean anagram(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        if (str1.length() != str2.length()) {
            return false;
        } else {
            for (Character s : str1.toCharArray()) {
                if (s != ' ') {
                    map1.compute(s, (key, value) -> (value == null) ? 1 : ++value);

                }

            }
            for (Character s2 : str2.toCharArray()) {
                if (s2 != ' ') {
                    map2.compute(s2, (key, value) -> (value == null) ? 1 : ++value);

                }
            }
        }
     if(map1.equals(map2)){
         return true;
     }else{
         return false;
     }

    }

    private static final int EXTENDED_ASCII_CODES = 256;
    public static boolean isAnagram(String str1, String str2) {
        int[] chCounts = new int[EXTENDED_ASCII_CODES];
        char[] chStr1 = str1.replaceAll("\\s",
                "").toLowerCase().toCharArray();
        char[] chStr2 = str2.replaceAll("\\s",
                "").toLowerCase().toCharArray();
        if (chStr1.length != chStr2.length) {
            return false;
        }
        for (int i = 0; i < chStr1.length; i++) {
            chCounts[chStr1[i]]++;
            chCounts[chStr2[i]]--;
        }
        for (int i = 0; i < chCounts.length; i++) {
            if (chCounts[i] != 0) {
                return false;
            }
        }
        return true;
    }

    //todo: concatenating the same string n times

    //my response
    public String concatNTime(String str,int n){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<n;i++){
            stringBuilder.append(str).append(" ");
        }
        return stringBuilder.toString();
    }

    //book response
    public String concatntime(String str,int n){
        return str.repeat(n);
    }

}


