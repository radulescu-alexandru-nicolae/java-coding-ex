import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Chapter1Test {
    Chapter1 chapter1=new Chapter1();

    @Test
    void countingCharacters(){

//    chapter1.duplicateCharacterss("afoasasafasft");

//    System.out.println(chapter1.duplcateCharacter("asdasa"));
    System.out.println(chapter1.duplcateCharacter1("asasda"));


}

@Test
    void firstNonRepeatedCharacter(){
    System.out.println(chapter1.firstNonReapeted("asda"));
    System.out.println(chapter1.firstNonRepeated("asda"));
    }

    @Test
    void reverse(){
        System.out.println(chapter1.reverse("asad"));
        System.out.println(chapter1.reverse2("asad"));
    }

    @Test
    void onlyDigit(){
        System.out.println(chapter1.onlyDigit("123"));
        System.out.println(chapter1.onlyDigit("123a"));
        System.out.println(chapter1.isOnlyDigit("123a"));
        System.out.println(chapter1.isOnlyDigit("123"));

    }

    @Test
    void countVowelsCons(){
        System.out.println(chapter1.countsVowCons("asasaadfast"));
    }

    @Test
    void countOccurances(){

        System.out.println(chapter1.occurances("asaa",'a'));
        System.out.println(chapter1.countOccurrencesOfACertainCharacter("asa",'a'));
    }
    @Test
    void replaceWhiteSpace(){
        System.out.println(chapter1.removeWhiteSpace("asa asa asa"));
    }

    @Test
    void joinginMultipleString(){
        System.out.println(chapter1.joinByDelimiter('/',"abc","def"));
        System.out.println(chapter1.joinByDel('/',"abc","def"));
    }
    @Test
    void checkPalindrom(){
        assertEquals(true,chapter1.checkPalindrom("ana"));
        assertEquals(true,chapter1.checkPalindrom("canac"));
    }
    @Test
    void deleteDuplicateCharacter(){
        System.out.println(chapter1.deleteDuplicateCharacters("strasamg"));
    }
    @Test
    void removingCharacter(){
        System.out.println(chapter1.removingGivenCharacter("alabama",'a'));
        System.out.println(chapter1.removeCharacter("alabama",'a'));
    }
    @Test
    void mostApparences(){
        System.out.println(chapter1.mostApparances("alababbbbma"));
    }
    @Test
    void sortArrayOfStrings(){
        String[] a={"aaa","bb","cccc","e","ffffff"};
        chapter1.sortArrayByLength(a,"crescator");
//        chapter1.sortArrayByLength(a,"descrescator");
    }

    @Test
    void containsSubstring(){
        assertEquals(true,chapter1.checksubstring("alabama","al"));
    }
    @Test
    void anagram(){
//   assertEquals(true,chapter1.anagram("abalec","leceba"));
        assertEquals(true,chapter1.isAnagram("abalec","lecaba"));
    }
}