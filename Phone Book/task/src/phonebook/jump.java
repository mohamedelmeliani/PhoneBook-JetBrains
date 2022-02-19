/*
package phonebook;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class jump {
    public static void main(String[] args) throws IOException {
        */
/*String directoryPath = "C:\\Users\\pc\\Downloads\\small_directory.txt";
        String findPath = "C:\\Users\\pc\\Downloads\\small_find.txt";*//*

        System.out.println(TimeUnit.MINUTES.toMillis(1)+TimeUnit.SECONDS.toMillis(6)+
                TimeUnit.SECONDS.toMillis(32)+TimeUnit.SECONDS.toMillis(49)+454+471+
                179);
        Your estimated time is not similar to real time the program works. Real time: 82987ms, estimated
        time: 148104ms


        */
/*//*
/ Get all the lines from the files into lists
        List<String> directory = Files.readAllLines(Paths.get(directoryPath));
        List<String> find = Files.readAllLines(Paths.get(findPath));
        String temp;
        for (int j = 0; j < directory.size() - 1; j++) {
            for (int i = j; i < directory.size(); i++) {
                String name1 = directory.get(j).replaceAll("[0-9]", "");
                String name = directory.get(i).replaceAll("[0-9]", "");
                if (name1.compareTo(name) > 0) {
                    temp = directory.get(j);
                    directory.set(j, directory.get(i));
                    directory.set(i, temp);
                }
                }
            }
        int counter=0;
        for (String d :find){
            System.out.println(SearchJump(directory,d));
            counter++;
        }
        System.out.println(counter);


for (String f : find){
            int n = directory.size();
            int step = (int)Math.floor(Math.sqrt(n));
            int prev = 0;
            while (!directory.contains(f))
            {
                prev = step;
                step += (int)Math.floor(Math.sqrt(n));
                if (prev >= n)
                    System.out.println("none1");
            }
            while (!directory.contains(f))
            {
                prev++;
                if (prev == Math.min(step, n))
                    System.out.println("none2");
            }
            if (directory.contains(f))
                System.out.println(directory.get(prev));

            System.out.println("none3");
        }
        final Scanner scanner = new Scanner(System.in);
        printReverseCharByChar(scanner.nextLine());

        List<String> str= Arrays.asList("Beckie Rufe",
                "Camilla Lynnworth",
                "Phedra Ander",
                "Theadora Zelma",
                "Aeriell Zaccaria",
                "Sadye Kit",
                "Masha Banerjee",
                "Velma Dinah",
                "Aline Jdavie",
                "Magdalen Joyann");
        Collections.sort(str);
        for (String s:str){
            System.out.println(s);
        }
        System.out.println(binarySearch(str,"Magdalen Joyann"));*//*

    }
    public static int binarySearch(List<String>array,String  x){
        int left=0;
        int right= array.size()-1;
        while(left<=right){
            int mid=left+((right-left)/2);
            if(array.get(mid).compareTo(x)==0)
                return mid;
            else if(x.compareTo(array.get(mid))<0)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }

    public static String SearchJump(List<String>list,String s) {
        int n = list.size();
        // block size through which jumps take place
        int step = (int) Math.floor(Math.sqrt(n));
        // search in the block
        int prev = 0;
        while (list.get(Math.min(step, n) - 1).compareTo(s) > 0) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return "none";
        }
        // Doing a linear search for x in block
        while (list.get(prev).compareTo(s) > 0) {
            prev++;
            if (prev == Math.min(step, n))
                return "none";
        }
        // If element is found
        if (list.get(prev).compareTo(s) == 0)
            return list.get(prev);
        // element not found
        return "none";
    }

    public static void printReverseCharByChar(String str) {
        if ((str==null)||(str.length() <= 1))
            System.out.println(str);
        else
        {
            System.out.print(str.charAt(str.length()-1));
            printReverseCharByChar(str.substring(0,str.length()-1));
        }
    }
    public static boolean isPalindrome(String s) {
        if (s.length() == 2 || s.length() == 1) { // (1)
            return true; // (2)
        }

        int lastIndex = s.length() - 1; // (3)
        boolean r = s.charAt(0) == s.charAt(lastIndex); // (4)

        return r || isPalindrome(s.substring(1, lastIndex)); // (5)
    }

}
*/
