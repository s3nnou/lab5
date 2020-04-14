package ClassWorks;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class ClassWorks {
    public static  void main(String[] args) throws IOException {
       Sportsman[] competition = FileExtensions.read();

       System.out.println(Arrays.toString(competition));

        Object[] filterBySportType = Arrays.stream(competition)
                .filter(v-> v.getType().equals("тяжелая атлетика"))
                .toArray();

        System.out.println(Arrays.toString(filterBySportType));

        Object[] sortedByScoreArr = Arrays.stream(competition)
                .sorted(new SortingRoutines.SortByScore())
                .toArray();

        System.out.println(Arrays.toString(sortedByScoreArr));

        Object[] sortedByTypeArr = Arrays.stream(competition)
                .sorted(new SortingRoutines.SortByScore())
                .toArray();

        System.out.println(Arrays.toString(sortedByTypeArr));

        Sportsman[] arrLeftSide = Arrays.copyOfRange(competition, 0, competition.length/2);
        Sportsman[] arrRightSide = Arrays.copyOfRange(competition, competition.length/2, competition.length);

        //stat by sport type
        Map<String, Integer> dups =  Arrays.stream(competition)
                       .collect(toMap(Sportsman::getType, v -> 1, Math:: addExact));
        System.out.println(dups);

        //stat by year
        Optional<Sportsman> maxAgeSportsman = Arrays.stream(competition)
                .min(Comparator.comparing(Sportsman::getBirthYear));

        Optional<Sportsman> minAgeSportsman = Arrays.stream(competition)
                .max(Comparator.comparing(Sportsman::getBirthYear));

        System.out.println(maxAgeSportsman.toString());
        System.out.println(minAgeSportsman.toString());

        Optional<Sportsman> Min1Age = Arrays.stream(arrLeftSide)
                .max(Comparator.comparing(Sportsman::getBirthYear));

        Optional<Sportsman> Min2Age = Arrays.stream(arrRightSide)
                .max(Comparator.comparing(Sportsman::getBirthYear));

        System.out.println(Min1Age.toString());
        System.out.println(Min2Age.toString());

        int iMin1Age = IntStream.range(0, competition.length)
                .filter(i ->competition[i] == (Min1Age.get()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        System.out.println(iMin1Age);

        int iMin2Age = IntStream.range(0, competition.length)
                .filter(i ->competition[i] == (Min2Age.get()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        System.out.println(iMin2Age);

        Sportsman[] iArrByAge = Arrays.copyOfRange(competition, iMin1Age, iMin2Age);
        System.out.println(Arrays.toString(iArrByAge));

        Integer iArrSumAge =  Arrays.stream(iArrByAge )
                .mapToInt(v -> v.getBirthYear())
                .sum();

        System.out.println(iArrSumAge);

        Long iArrElementsAge =  Arrays.stream(iArrByAge)
                .mapToInt(v -> v.getBirthYear())
                .count();

        System.out.println(iArrElementsAge);

        OptionalDouble iArrAverageAge =  Arrays.stream(iArrByAge)
                .mapToInt(v -> v.getBirthYear())
                .average();

        System.out.println(iArrAverageAge);

    }
}
