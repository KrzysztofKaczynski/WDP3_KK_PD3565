/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad3;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        String fname = System.getProperty("user.home") + "/pakiety.txt";

        int rozmiarPakietu;
        int pojemnoscHd;
        int pojemnoscHdWBajtach;
        int licznikPak = 1;
        int sumaPak = 0;

        ArrayList<Integer> rozmPakList = new ArrayList<>();

        try {
            File file = new File(fname);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String wierszZmiennych = bufferedReader.readLine();
            StringTokenizer tokenize = new StringTokenizer(wierszZmiennych, " ");

            rozmiarPakietu = Integer.parseInt(tokenize.nextToken());
            pojemnoscHd = Integer.parseInt(tokenize.nextToken());

            pojemnoscHdWBajtach = pojemnoscHd * 1024 * 1024;

            if (rozmiarPakietu < 0 || pojemnoscHd < 0)
                throw new Exception();

            while (sumaPak < pojemnoscHdWBajtach) {
                if (licznikPak == 1) {
                    rozmPakList.add(rozmiarPakietu);
                    sumaPak += rozmiarPakietu;
                }
                if (licznikPak > 1 && licznikPak < 6) {
                    rozmPakList.add(rozmPakList.get(rozmPakList.size() - 1) * 2);
                    sumaPak += rozmPakList.get(rozmPakList.size() - 1);
                }
                if (licznikPak >= 6) {
                    rozmPakList.add(rozmPakList.get(rozmPakList.size() - 1) * 3);
                    sumaPak += rozmPakList.get(rozmPakList.size() - 1);
                }
                licznikPak++;
            }

            sumaPak -= rozmPakList.get(rozmPakList.size() - 1);
            rozmPakList.remove(rozmPakList.size() - 1);

            System.out.println(rozmPakList.size());

            int i = 1;
            for (int list : rozmPakList) {
                System.out.println(i + " " + list);
                i++;
            }

            System.out.println(sumaPak);

        } catch (Exception e) {
            System.out.println("***");
            System.exit(1);
        }
    }
}
