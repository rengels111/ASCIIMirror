import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {

        long counter1 = list1.stream().filter(i -> i == elem).count();

        long counter2 = list2.stream().filter(i -> i == elem).count();

        return counter1 == counter2;

    }
}