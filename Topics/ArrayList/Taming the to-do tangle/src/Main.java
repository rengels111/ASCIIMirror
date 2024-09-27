import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String operation = scanner.nextLine();

            if (operation.equals("add")) {
                taskList.add(scanner.nextLine());
            } else if (operation.equals("remove")) {
                taskList.remove(scanner.nextInt());
            } else if (operation.equals("display")) {
                System.out.println(taskList);
            }
        }

        scanner.close();
    }
}