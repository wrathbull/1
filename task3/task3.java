package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
	    double[] array1 = null;
		try (BufferedReader in = new BufferedReader(new FileReader(args[0] + "\\Cash1.txt"))) {
	        array1 = in.lines().mapToDouble(Double::parseDouble).toArray();
	        in.close();
	    }
	    catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
		
	    double[] array2 = null;
		try (BufferedReader in = new BufferedReader(new FileReader(args[0] + "\\Cash2.txt"))) {
	        array2 = in.lines().mapToDouble(Double::parseDouble).toArray();
	        in.close();
	    }
	    catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
		
	    double[] array3 = null;
		try (BufferedReader in = new BufferedReader(new FileReader(args[0] + "\\Cash3.txt"))) {
	        array3 = in.lines().mapToDouble(Double::parseDouble).toArray();
	        in.close();
	    }
	    catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
		
	    double[] array4 = null;
		try (BufferedReader in = new BufferedReader(new FileReader(args[0] + "\\Cash4.txt"))) {
	        array4 = in.lines().mapToDouble(Double::parseDouble).toArray();
	        in.close();
	    }
	    catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
		
	    double[] array5 = null;
		try (BufferedReader in = new BufferedReader(new FileReader(args[0] + "\\Cash5.txt"))) {
	        array5 = in.lines().mapToDouble(Double::parseDouble).toArray();
	        in.close();
	    }
	    catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
		
		double[] array_finish = new double[array1.length];
		for (int i = 0; i < array1.length; i++) {
			array_finish[i] = array1[i] + array2[i] + array3[i] + array4[i] + array5[i];
		}
        double max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            if (max < array_finish[i]) {
                max = array_finish[i];
                index = i;
            }
        }
        System.out.println(index + 1);
	}
}
