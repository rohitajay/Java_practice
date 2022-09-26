package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Q9 {
    static boolean anagram1(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        String str = str1.toUpperCase();
        String strt = str2.toUpperCase();

        int freq[] = new int[256];
        for(int i=0; i< str.length(); i++){
            freq[str.charAt(i)] ++;
            freq[strt.charAt(i)]--;
        }
        for(int i=0; i < 256; i++) {
            if(freq[i] != 0)
                return false;
        }
        return true;
    }

    public static List<String> listAnagrams(List<String> list, String w) {
        List<String> subList = new ArrayList<>();
        for(String i: list) {
            if(anagram1(i,w) == true) {
                subList.add(i);
            }
        }
        return subList;
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("enlists");
        list.add("google");
        list.add("inlets");
        list.add("banana");
        String word= "listen";
        List<String> ans = listAnagrams(list,word);
        System.out.print(ans);
    }
}
