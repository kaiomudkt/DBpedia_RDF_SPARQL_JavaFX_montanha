
package controle;

import java.io.*;
import java.util.*;

public class Desvio {

	public static double mean(ArrayList<Integer> table) {
		int total = 0;

		for (int i = 0; i < table.size(); i++) {
			int currentNum = table.get(i);
			total += currentNum;
		}
		return total / table.size();
	}

	public static void selectionSort(ArrayList<Integer> table) {
		int count = table.size();
		for (int pos = 0; pos < count - 1; pos++) {
			int locMin = pos;
			for (int i = pos + 1; i < count; i++) {
				if (table.get(i) < table.get(locMin))
					locMin = i;
			}

			int temp = table.get(pos);
			table.set(pos, table.get(locMin));
			table.set(locMin, temp);
		}
	}

	public static double sd(ArrayList<Integer> table) {
		// Step 1:
		double mean = mean(table);
		double temp = 0;

		for (int i = 0; i < table.size(); i++) {
			int val = table.get(i);

			// Step 2:
			double squrDiffToMean = Math.pow(val - mean, 2);

			// Step 3:
			temp += squrDiffToMean;
		}

		// Step 4:
		double meanOfDiffs = (double) temp / (double) (table.size());

		// Step 5:
		return Math.sqrt(meanOfDiffs);
	}

public static void main(String[] args)
{
    ArrayList<Integer> values = new ArrayList<Integer>();
    int count = 0;
    int total = 0;
    Random r = new Random();

    for (int i = 1; i <= 10; i++) {
        values.add(r.nextInt(90)+ 1);

        System.out.println(values);

    }

    System.out.println("Media: " +mean(values));
    System.out.printf("Desvio: %.2f\n" ,sd(values));
}
}