package CodeJam.Y2016.CodysJams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodyJam {

    PrintWriter p;

    private void processFile(String filePath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            int i = 0;
            String T = br.readLine();
            String N = "";
            while (i < Integer.parseInt(T)) {
                N = br.readLine();
                String P = br.readLine();

                List<Integer> allPrices = Arrays.stream(P.split(" ")).map(Integer::valueOf).collect(Collectors.toList());

                getDiscountPrices(allPrices, i + 1);

                i++;
            }
        } finally {
            br.close();
        }
    }

    public static void main(String[] args) {
        try {
            CodyJam p1 = new CodyJam();

            //p1.p = new PrintWriter("C:\\CodeJam\\CodyJam\\codyJamOutputSmall.txt", "UTF-8");
            // p1.processFile("C:\\CodeJam\\CodyJam\\A-small-practice.in");
            p1.p = new PrintWriter("C:\\CodeJam\\CodyJam\\A-codyJamOutputLarge.txt", "UTF-8");
            p1.processFile("C:\\CodeJam\\CodyJam\\A-large-practice.in");
            p1.p.close();
            //p1.test();
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    private void getDiscountPrices(List<Integer> allPrices, int i) {
        List<Integer> discounts = new ArrayList<>();
        List<Integer> originalPrices = new ArrayList<>();
        p.print("Case #" + i + ": ");
   //     System.out.println("Case #" + i);
        ////     System.out.println("processing " + allPrices);
        while (allPrices.size() > 1) {
            Integer discountedPrice = allPrices.get(0);
            for (int j = allPrices.size() - 1; j >= 1; j--) {
                Double t = (allPrices.get(j) - (allPrices.get(j) * 0.25));
                //   System.out.println("Comparing " + t + " with " + discountedPrice);
                if (discountedPrice.compareTo(t.intValue()) == 0) {
                    //     System.out.println("Match found: " + allPrices.get(0) + " " + allPrices.get(j));
                    discounts.add(allPrices.get(0));
                    allPrices.remove(j);
                    allPrices.remove(0);
                    break;
                }
            }
        }
        for (Integer d : discounts) {
            p.print(d + " ");

        }
        p.println();
        System.out.println(discounts);

    }
}
