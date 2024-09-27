import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        // Write your code here.
        List<Integer> integers = convertToList(number);

        Collections.sort(integers);

        System.out.println(integers);

    }

    public static List<Integer> convertToList(int number) {
        // Write your code here.
        return new ArrayList<>(Arrays.stream(String.valueOf(number)
                .split(""))
                .map(Integer::valueOf)
                .toList());
    }
}
