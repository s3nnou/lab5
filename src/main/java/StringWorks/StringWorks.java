package StringWorks;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringWorks {
    public static  void main(String[] args) throws IOException {
        Random random = new Random();

        String[] arr = FileExtensions.readFileWithLetters();
        System.out.println(Arrays.toString(arr));

        //task 1
        Optional<String> max = Arrays.stream(arr).max((str1, str2) ->
                Integer.compare(str1.length(), str2.length()));
        Optional<String> min = Arrays.stream(arr).min((str1, str2) ->
                Integer.compare(str1.length(), str2.length()));

        System.out.println(max.get());
        System.out.println(min.get());

        //task 2

        //task 2
        String[] arrLeftSide = Arrays.copyOfRange(arr, 0, arr.length/2);
        String[] arrRightSide = Arrays.copyOfRange(arr, arr.length/2, arr.length);

        Optional<String> iMin1Value = Arrays.stream(arrLeftSide).min((str1, str2) ->
                Integer.compare(str1.length(), str2.length()));

        Optional<String> iMin2Value = Arrays.stream(arrRightSide).min((str1, str2) ->
                Integer.compare(str1.length(), str2.length()));

        System.out.println(iMin1Value.get());
        System.out.println(iMin2Value.get());

        int iMin1 = IntStream.range(0, arr.length)
                .filter(i ->arr[i] == (iMin1Value.get()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        int iMin2 = IntStream.range(0, arr.length)
                .filter(i ->arr[i] == (iMin2Value.get()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        System.out.println(iMin1);
        System.out.println(iMin2);
        //task 3
        String[] iArr = Arrays.copyOfRange(arr, iMin1, iMin2);
        System.out.println(Arrays.toString(iArr));

        //task 4
        int iArrSum = Arrays.stream(iArr)
                    .mapToInt(v -> v.length())
                    .sum();
        System.out.println(iArrSum);

        //task 5
        int iArrCount = (int) Arrays.stream(iArr)
                .mapToInt(v -> v.length())
                .count();
        System.out.println(iArrCount);

        //task 6
        OptionalDouble iArrAverage =  Arrays.stream(iArr)
                .mapToInt(v -> v.length())
                .average();
        System.out.println(iArrAverage.getAsDouble());

        //task 7
        String[] array1 = Arrays.stream(arr)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array1));

        //task 8
        String[] array2 = Arrays.stream(arr)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array2));

        //task 9
        String[] arrayLimitBy5 = Arrays.stream(arr)
                .skip(5)
                .limit(5)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(arrayLimitBy5));

        //task 10
        String[] array3 = Arrays.stream(array1)
                .limit(5)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array3));

        //task 11
        int skip5GetSum = Arrays.stream(arr)
                .skip(5)
                .mapToInt(v -> v.length())
                .sum();
        System.out.println(skip5GetSum);

        //task 12
        Optional<String> iMaxValue = Arrays.stream(arrLeftSide)
                .skip(3)
                .max((str1, str2) ->
                Integer.compare(str1.length(), str2.length()));

        int wow = Arrays.stream(arr)
                .skip(3)
                .takeWhile(v -> v == iMaxValue.get())
                .mapToInt(v -> v.length())
                .sum();
        System.out.println(wow);

        //task 13
        int k = random.nextInt(10);

        String[] takeByMinMinuskArr = Arrays.stream(arr)
                .limit(5)
                .dropWhile(v -> v.length() <= max.get().length() - k)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(takeByMinMinuskArr));

        //task 14
        String[] array4 = Arrays.stream(array2)
                .limit(5)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array3));

        //task 15
        String[] minMaxArr = Stream.concat(Arrays.stream(array4),Arrays.stream(array3))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(minMaxArr));

        //task 16
        String[] arrWithoutArr3 = Arrays.stream(arr)
                .filter(v->Collections.frequency(Arrays.asList(arr),array3) == 1)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(arrWithoutArr3));

        //task 17
        String[] uniqArr = Arrays.stream(arr)
                .distinct()
                .toArray(String[]::new);
        System.out.println(Arrays.toString(uniqArr));

        //task 18
        String[] onlyBArr = Arrays.stream(arr)
                .filter(v->v.charAt(0) == 'Б')
                .toArray(String[]::new);

        System.out.println(Arrays.toString(onlyBArr));

        //task 19
        String[] withoutBArr = Arrays.stream(arr)
                .filter(v->v.charAt(0) != 'Б')
                .toArray(String[]::new);

        System.out.println(Arrays.toString(withoutBArr));
    }
}
