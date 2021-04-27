/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fname = System.getProperty("user.home") + "/iter.txt";

        try {
            Scanner scan = new Scanner(new File(fname));
            int start = scan.nextInt(), end = scan.nextInt(), limit = scan.nextInt();
            end = (int) Math.max(start, Math.min(end, Math.ceil(0.5 * (Math.sqrt(1 + 4 * start * (start - 1) + 8 * limit) - 1))));
            System.out.println((int) (0.5 * (end + start) * (end - start + 1)));
        } catch (FileNotFoundException exc) {
            System.out.println("***");
        }

    }
}
