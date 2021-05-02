/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad2;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fname = System.getProperty("user.home") + "/tab.txt";
        List<Long> numbers = new ArrayList<>();
        FileReader reader;

        try {
            reader = new FileReader(fname);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                String number = scanner.next();
                try {
                    long l = Long.parseLong(number);
                    numbers.add(l);
                } catch (NumberFormatException exception) {
                    System.out.println("***");
                    System.exit(0);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("***");
            System.exit(0);
        }

        if (numbers.size() == 0) {
            System.out.println("***");
            System.exit(0);
        }

        for (Long number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Long max = numbers.get(0);
        for (Long number : numbers) {
            if (max < number)
                max = number;
        }
        System.out.println(max);

        for (int i = 0; i < numbers.size(); ++i) {
            if (max.equals(numbers.get(i)))
                System.out.print(i + " ");
        }
    }
}
