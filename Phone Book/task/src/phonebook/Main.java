package phonebook;

import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        String directoryPath = "C:\\Users\\pc\\Downloads\\directory.txt";
        String findPath = "C:\\Users\\pc\\Downloads\\find.txt";

        // Get all the lines from the files into lists
        List<String> directory = Files.readAllLines(Paths.get(directoryPath));
        List<String> find = Files.readAllLines(Paths.get(findPath));
        Map<String,String> hDirectory= new HashMap<>();
        System.out.println("Start searching (linear search)...");
        int counter = 0;
        // Start time in milliseconds
        long startTime = new Date().getTime();

        //Linear Search in the beginning

        for (String findLine : find) {
            for (String directoryLine : directory) {
                if (directoryLine.contains(findLine)) {
                    counter++;
                    break;
                }
            }
        }
        // Output
        System.out.printf("Found %d / %d entries. ", counter, find.size());
        System.out.printf("Time taken: %2d min. %2d sec. %2d ms.\n"
                , toUnit(new Date().getTime() - startTime)[2]
                , toUnit(new Date().getTime() - startTime)[1]
                , toUnit(new Date().getTime() - startTime)[0]);
        out.println();
        //End of first linear search
        // Beginning of Sorting (Bubble sort)

        System.out.println("Start searching (bubble sort + jump search)...");
        String temp;
        boolean tookAlot = false;
        long sortingTime = 0L;
        long searchingTime = 0L;
        //Start bubble sort
        startTime = new Date().getTime();
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
            //If bubble sort took too much time
            if (TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime) > 10) {
                sortingTime = new Date().getTime();
                tookAlot = true;
                counter = 0;
                for (String findLine : find) {
                    for (String directoryLine : directory) {
                        if (directoryLine.contains(findLine)) {
                            counter++;
                            break;
                        }
                    }
                }
                searchingTime = new Date().getTime();
                break;
            }
            sortingTime = new Date().getTime();
        }
        //End Bubble sort
        if (tookAlot) {
            out.printf("Found %2d / %2d entries.", counter, find.size());
            sortingTime = sortingTime - startTime;
            searchingTime = searchingTime - startTime;
            System.out.printf("Time taken: %2d min. %2d sec. %2d ms.\n"
                    , toUnit(sortingTime + searchingTime)[2]
                    , toUnit(sortingTime + searchingTime)[1]
                    , toUnit(sortingTime + searchingTime)[0]);

            System.out.printf("Sorting time: %2d min. %2d sec. %2d ms. -STOPPED,moved to linear search\n"
                    , toUnit(sortingTime)[2]
                    , toUnit(sortingTime)[1]
                    , toUnit(sortingTime)[0]);
            // Output
            System.out.printf("Searching time: %2d min. %2d sec. %2d ms.\n"
                    , toUnit(searchingTime)[2]
                    , toUnit(searchingTime)[1]
                    , toUnit(searchingTime)[0]);
        } else {
            //Beginning of Searching (Jump search)
            for (String f : find) {
                if (jumpSearch(directory, f) != -1)
                    counter++;
            }
            //End Jump search
            searchingTime = new Date().getTime();
            sortingTime = sortingTime - startTime;
            searchingTime = searchingTime - startTime;
            out.printf("Found %d / %d entries.", counter, find.size());
            System.out.printf("Time taken: %2d min. %2d sec. %2d ms.\n"
                    , toUnit(sortingTime + searchingTime)[2]
                    , toUnit(sortingTime + searchingTime)[1]
                    , toUnit(sortingTime + searchingTime)[0]);

            System.out.printf("Sorting time: %2d min. %2d sec. %2d ms.\n"
                    , toUnit(sortingTime)[2]
                    , toUnit(sortingTime)[1]
                    , toUnit(sortingTime)[0]);

            System.out.printf("Searching time: %2d min. %2d sec. %2d ms.\n"
                    , toUnit(searchingTime)[2]
                    , toUnit(searchingTime)[1]
                    , toUnit(searchingTime)[0]);
        }
        out.println();
        //Beginning of Sorting (Quick sort)
        System.out.println("Start searching (quick sort + binary search)...");
        startTime = new Date().getTime();
        sort(directory, 0, directory.size() - 1);
        sortingTime = new Date().getTime() - startTime;
        startTime = new Date().getTime();
        counter = 0;
        for (String f : find) {
            if (binarySearch(directory, f) >= 0)
                counter++;
        }
        searchingTime = new Date().getTime();
        searchingTime = searchingTime - startTime;
        out.printf("Found %2d / %2d entries.", counter, find.size());
        System.out.printf("Time taken: %2d min. %2d sec. %2d ms.\n"
                , toUnit(sortingTime + searchingTime)[2]
                , toUnit(sortingTime + searchingTime)[1]
                , toUnit(sortingTime + searchingTime)[0]);

        System.out.printf("Sorting time: %2d min. %2d sec. %2d ms.\n"
                , toUnit(sortingTime)[2]
                , toUnit(sortingTime)[1]
                , toUnit(sortingTime)[0]);
        // Output
        System.out.printf("Searching time: %2d min. %2d sec. %2d ms.\n"
                , toUnit(searchingTime)[2]
                , toUnit(searchingTime)[1]
                , toUnit(searchingTime)[0]);
        /*      long sortingTime=System.currentTimeMillis();
        if(tokeAlot){
            totalMilliseconds = System.currentTimeMillis() - startTime;

            // Convert milliseconds into our time format
            minutes = (totalMilliseconds / 1000) / 60;
            seconds = (totalMilliseconds / 1000) % 60;
            millis = totalMilliseconds - seconds * 1000;

            // Output
            System.out.printf("Sorting time: %2d min. %2d sec. %2d ms. -STOPPED,moved to linear search\n", minutes, seconds, millis);
            counter=0;
            //Doing another linear search cuz sorting took alot
            for (String findLine : find) {
                for (String directoryLine : directory) {
                    if (directoryLine.contains(findLine)) {
                        counter++;
                        break;
                    }
                }
            }
            totalMilliseconds = System.currentTimeMillis() - startTime;
            minutes = (totalMilliseconds / 1000) / 60;
            seconds = (totalMilliseconds / 1000) % 60;
            millis = totalMilliseconds - seconds * 1000;
            // Output
            System.out.printf("Found %d / %d entries. ", counter, find.size());
            System.out.printf("Time taken: %2d min. %2d sec. %2d ms.", minutes, seconds, millis);
        }
        else {
            //In case sorting didn t take alot searching by jump
            counter=0;
            for (String findstring : find){
                if(jumpSearch(directory,findstring).equals("none")){
                    counter++;
                }
            }
            totalMilliseconds = System.currentTimeMillis() - sortingTime;
            minutes = (totalMilliseconds / 1000) / 60;
            seconds = (totalMilliseconds / 1000) % 60;
            millis = totalMilliseconds - seconds * 1000;
            // Output
            System.out.printf("Found %d / %d entries. ", counter, find.size());
            System.out.printf("Time taken: %2d min. %2d sec. %2d ms.\n", minutes, seconds, millis);

            //Sorting
            totalMilliseconds = sortingTime-startTime;
            minutes = (totalMilliseconds / 1000) / 60;
            seconds = (totalMilliseconds / 1000) % 60;
            millis = totalMilliseconds - seconds * 1000;
            // Output
            System.out.printf("Sorting time: %2d min. %2d sec. %2d ms.\n", minutes, seconds, millis);

            //Searching
            totalMilliseconds = System.currentTimeMillis()-sortingTime;
            minutes = (totalMilliseconds / 1000) / 60;
            seconds = (totalMilliseconds / 1000) % 60;
            millis = totalMilliseconds - seconds * 1000;
            // Output
            System.out.printf("Searching time: %2d min. %2d sec. %2d ms.\n", minutes, seconds, millis);

        }*/

        out.println();
        //Beginning of Sorting (Quick sort)
        System.out.println("Start searching (hash table)...");
        long creationTime=new Date().getTime();
        startTime=new Date().getTime();
        for (String d : directory){
            String name=stringPart(d);
            String number=d.replaceAll("[0-9]", "").trim();
            hDirectory.put(name,number);
        }
        creationTime=new Date().getTime()-startTime;
        counter=0;
        startTime=new Date().getTime();
        for (String f : find){
            if(hDirectory.get(f)!=null)
                counter++;
        }
        searchingTime=new Date().getTime();
        searchingTime = searchingTime - startTime;
        out.printf("Found %2d / %2d entries.", counter, find.size());
        System.out.printf("Time taken: %2d min. %2d sec. %2d ms.\n"
                , toUnit(creationTime + searchingTime)[2]
                , toUnit(creationTime + searchingTime)[1]
                , toUnit(creationTime + searchingTime)[0]);

        System.out.printf("Creating time: %2d min. %2d sec. %2d ms.\n"
                , toUnit(creationTime)[2]
                , toUnit(creationTime)[1]
                , toUnit(creationTime)[0]);
        // Output
        System.out.printf("Searching time: %2d min. %2d sec. %2d ms.\n"
                , toUnit(searchingTime)[2]
                , toUnit(searchingTime)[1]
                , toUnit(searchingTime)[0]);
    }

    public static int jumpSearch(List<String> list, String x) {
        int n = list.size();

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));

        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (list.get(Math.min(step, n) - 1).compareTo(x) < 0) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (list.get(prev).compareTo(x) < 0) {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (list.get(prev).compareTo(x) == 0)
            return prev;

        return -1;
    }

    public static int[] toUnit(Long time) {
        int[] array = new int[3];
        array[0] = (int) (time % 1000);
        array[1] = (int) (TimeUnit.MILLISECONDS.toSeconds(time) % 60);
        array[2] = (int) TimeUnit.MILLISECONDS.toMinutes(time);
        return array;
    }

    public static void sort(List<String> list, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            String pivotValue = stringPart(list.get(pivot));
            while (left <= right) {
                // left <= to -> limit protection
                while (left <= to && pivotValue.compareTo(stringPart(list.get(left))) >= 0) {
                    left++;
                }
                // right > from -> limit protection
                while (right > from && pivotValue.compareTo(stringPart(list.get(right))) < 0) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, pivot, left - 1);
            sort(list, from, right - 1); // <-- pivot was wrong!
            sort(list, right + 1, to);   // <-- pivot was wrong!
        }
    }

    public static String stringPart(String str) {
        return str.replaceAll("[0-9]", "").trim();
    }

    public static int binarySearch(List<String> list, String x) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (stringPart(list.get(mid)).compareTo(x) == 0)
                return mid;
            else if (x.compareTo(stringPart(list.get(mid))) < 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}