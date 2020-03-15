import java.io.*;

public class Main {
	
	public static void main(String[] args) {
	    int[] array = null;
		try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
	        array = in.lines().mapToInt(Integer::parseInt).toArray();
	        in.close();
	    }
	    catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
		
		class Sort {

			public void selectionSort(int[] arr){
			    for (int i = 0; i < arr.length; i++) {
			        int min = arr[i];
			        int min_i = i;
			        for (int j = i+1; j < arr.length; j++) {
			            if (arr[j] < min) {
			                min = arr[j];
			                min_i = j;
			            }
			        }
			        if (i != min_i) {
			            int tmp = arr[i];
			            arr[i] = arr[min_i];
			            arr[min_i] = tmp;
			        }
			     }
			}
		}
	    
	    if (array != null) {
	        //percentile
	        Sort sort = new Sort();
	        sort.selectionSort(array);
	        double n = (90.0 / 100.0) * (array.length - 1) + 1;
	        double res = (double)array[(int)n - 1] + (n % (int)n) *
	        		((double)array[(int)n] - (double)array[(int)n - 1]);
	        String percentile = String.format("%.2f", res).replace(',', '.');
	        System.out.println(percentile);
	        
	        //median
	        double med;
	        if (array.length % 2 != 0) {
	        	med = array[array.length / 2];
	        } else {
	        	med = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
	        }
	        String median = String.format("%.2f", med).replace(',', '.');
	        System.out.println(median);
	    	
		    //max
	        double max = Integer.MIN_VALUE;
	        for (int i = 0; i < array.length; i++) {
	            if (max < array[i]) {
	                max = array[i];
	            }
	        }
	        String max_value = String.format("%.2f", max).replace(',', '.');
	        System.out.println(max_value);
	        
	        //min
	        double min = Integer.MAX_VALUE;
	        for (int i = 0; i < array.length; i++) {
	            if (min > array[i]) {
	                min = array[i];
	            }
	        }
	        String min_value = String.format("%.2f", min).replace(',', '.');
	        System.out.println(min_value);
	        
	        //mean
	        double mean = 0;
	        for (int i = 0; i < array.length; i++) {
	        	mean += array[i];
	        }
	        mean /= array.length;
	        String mean_value = String.format("%.2f", mean).replace(',', '.');
	        System.out.println(mean_value);
	    }
	}
}
