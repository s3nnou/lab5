package IntegerWorks;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class IntWorks {
    public static  void main(String[] args) throws IOException {
       Integer[] arr = FileExtensions.readFileWithNumbers();
       Random random = new Random();
       System.out.println(Arrays.toString(arr));
       int size = arr.length;

       //task 1
        Integer max =  Arrays.stream(arr)
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);

        Integer min =  Arrays.stream(arr)
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);

        System.out.println("Max value " + max);
        System.out.println("Min value " + min);

        //task 2
        Integer[] arrLeftSide = Arrays.copyOfRange(arr, 0, arr.length/2);
        Integer[] arrRightSide = Arrays.copyOfRange(arr, arr.length/2, arr.length);

        Integer iMin1Value =  Arrays.stream(arrLeftSide)
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);

        Integer iMin2Value =  Arrays.stream(arrRightSide)
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);

        System.out.println("iMin1 value " + iMin1Value);
        System.out.println("iMin2 value " + iMin2Value);

        Integer iMin1 = IntStream.range(0, arr.length)
                .filter(i ->arr[i] == iMin1Value)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        Integer iMin2 = IntStream.range(0, arr.length)
                .filter(i ->arr[i] == iMin2Value)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("iMin1 index " +(iMin1));
        System.out.println("iMin2 index " +iMin2);

        //task 3
        Integer[] iArr = Arrays.copyOfRange(arr, iMin1, iMin2);
        System.out.println("iArray from iMin1 to iMin2 " + Arrays.toString(iArr));

        //task 4
        Integer iArrSum =  Arrays.stream(arrLeftSide)
                .mapToInt(v -> v)
                .sum();
        System.out.println("iArray sum " +iArrSum);

        //task 5
        Long iArrElements =  Arrays.stream(arrLeftSide)
                .mapToInt(v -> v)
                .count();
        System.out.println("iArray elements count " + iArrElements);

        //task 6
        OptionalDouble iArrAverage =  Arrays.stream(arrLeftSide)
                .mapToInt(v -> v)
                .average();
        System.out.println("iArray average " +iArrAverage.getAsDouble());

        //task 7
        int[] array1 = Arrays.stream(arr)
                .sorted(Comparator.reverseOrder())
                .mapToInt(v -> v)
                .toArray();
        System.out.println("Reverse sort order "+ Arrays.toString(array1));

        //task 8
        int[] array2 = Arrays.stream(arr)
                .mapToInt(v -> v)
                .sorted()
                .toArray();
        System.out.println("Natural sort order "+ Arrays.toString(array2));

        //task 9
        int[] arrayLimitBy5 = Arrays.stream(arr)
                .skip(5)
                .limit(5)
                .mapToInt(v -> v)
                .toArray();
        System.out.println("Skip 5, limit 5 array " + Arrays.toString(arrayLimitBy5));

        //task 10
        int[] array3 = Arrays.stream(array1)
                .limit(5)
                .toArray();
        System.out.println("Biggest values array "+ Arrays.toString(array3));

        //task 11
        int skip5GetSum = Arrays.stream(arr)
                .mapToInt(v -> v)
                .skip(5)
                .sum();
        System.out.println("Sum without 5 elements" + skip5GetSum);

        //task 12
        Integer iMaxValue =  Arrays.stream(arrLeftSide)
                .skip(3)
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
        System.out.println(iMaxValue);

        int wow = Arrays.stream(arr)
                .skip(3)
                .mapToInt(v -> v)
                .takeWhile(v -> v == iMaxValue)
                .sum();
        System.out.println("Skip 3, sum before Max Value " + wow);

        //task 13
        int k = random.nextInt(10);
         System.out.println("k = " + k);

        int[] takeByMinMinusArr = Arrays.stream(array1)
                .limit(5)
                .dropWhile(i -> i < max - k)
                .toArray();
        System.out.println("5 elements which lower then max - k" + Arrays.toString(takeByMinMinusArr));

        //task 14
        int[] array4 = Arrays.stream(array2)
                .limit(5)
                .toArray();
        System.out.println("5 smallest elements values "+ Arrays.toString(array4));

        //task 15
        int[] minMaxArr = IntStream.concat(Arrays.stream(array3),Arrays.stream(array3))
                .toArray();
        System.out.println("maxArr + minArr "+ Arrays.toString(minMaxArr));

        //task 16
        int[] newArr = Arrays.stream(arr)
                       .mapToInt(v -> v)
                       .toArray();


        int[] arrWithoutArr3 = Arrays.stream(arr)
                .mapToInt(v -> v)
                .filter(v->Collections.frequency(Arrays.asList(newArr),Arrays.asList(array3)) == 0)
                .toArray();
         System.out.println("og array without array 3 elements " + Arrays.toString(arrWithoutArr3));

        //task 17
        int[] uniqArr = Arrays.stream(arr)
                .mapToInt(v -> v)
                .distinct()
                .toArray();
       System.out.println(Arrays.toString(uniqArr));
    }
}
