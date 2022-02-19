/*
package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class test {
    //Merge Sort
  public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[100000000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }

        System.out.println(new Date());

        mergeSort(numbers);

        System.out.println(new Date());
    }


    private static void mergeSort(person[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        person[] leftHalf = new person[midIndex];
        person[] rightHalf = new person[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge (person[] inputArray, person[] leftHalf, person[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i].name.compareTo(rightHalf[j].name)<=0) {
                inputArray[k] = leftHalf[i];
                i++;
            }
            else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    private static void printArray(String[] numbers) {
        for (String number : numbers) {
            System.out.println(number);
        }
    }
    private static void printArray(person[] numbers) {
        for (person number : numbers) {
            System.out.println(number.name);
        }
    }

    private static void printList(List<String> list){
        for (String number : list) {
            System.out.println(number);
        }
    }
    // Java program to implement Jump Search.
    // Driver program to test function
    public static void main(String[] args) throws IOException {
Long date1=new Date().getTime();
        String arr[] = {"Beckie Rufe","Camilla Lynnworth","Phedra Ander","Theadora Zelma","Aeriell Zaccaria","Sadye Kit","Masha Banerjee","Velma Dinah","Aline Jdavie","Magdalen Joyann"};
        String x = "Masha Banerjee";
        printArray(arr);
        mergeSort(arr);
        System.out.println();
        printArray(arr);
        Long date2=new Date().getTime();
        System.out.println(TimeUnit.MILLISECONDS.toMinutes(date2-date1)+"min. "+
                TimeUnit.MILLISECONDS.toSeconds(date2-date1)+"sec "+
                TimeUnit.MILLISECONDS.toMillis(date2-date1)+"mili ");


        // Find the index of 'x' using Jump Search
        int index = jumpSearch(arr, x);

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                " is at index " + index);
        date2=new Date().getTime();
        System.out.println(TimeUnit.MILLISECONDS.toMinutes(date2-date1)+"min. "+
                TimeUnit.MILLISECONDS.toSeconds(date2-date1)+"sec "+
                TimeUnit.MILLISECONDS.toMillis(date2-date1)+"mili ");


        String directoryPath = "C:\\Users\\pc\\Downloads\\directory.txt";
        List<String> directory = Files.readAllLines(Paths.get(directoryPath));
        person[] ppl=new person[directory.size()];
        for (int i = 0; i < directory.size(); i++) {
            String name = directory.get(i).replaceAll("[0-9]", "");
            String number = directory.get(i).replaceAll("[^0-9]", "");
            person p=new person(name,number);
            ppl[i]=p;
        }
    }


    public static int jumpSearch(String[] arr, String x) {
        int n = arr.length;

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));

        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n) - 1].compareTo(x) < 0) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev].compareTo(x) < 0) {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -2;
        }

        // If element is found
        if (arr[prev].compareTo(x) == 0)
            return prev;

        return -3;
    }
}

*/
