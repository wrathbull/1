package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> square = new ArrayList<>();
		float[] square_fl = null;
		try (BufferedReader in = new BufferedReader(new FileReader
				(args[0]))) {
			
	         String line = in.readLine();
	         
	         while(line != null) {
	        	 
	             for (String retval : line.split(" ")) {
	                 square.add(retval);
	              }
	        	 line = in.readLine();
	         }
	         square_fl = new float[square.size() + 2];
	         for (int i = 0; i < square.size(); i++) {
	        	 square_fl[i] = Float.parseFloat(square.get(i));
	         }
	         square_fl[square.size()] = square_fl[0];
	         square_fl[square.size() + 1] = square_fl[1];
	    }
	    catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
		
		ArrayList<String> points = new ArrayList<>();
		float[] points_fl = null;
		try (BufferedReader in = new BufferedReader(new FileReader
				(args[1]))) {
			
	         String line = in.readLine();
	         
	         while(line != null) {
	        	 
	             for (String retval : line.split(" ")) {
	                 points.add(retval);
	              }
	        	 line = in.readLine();
	         }
	         points_fl = new float[points.size()];
	         for (int i = 0; i < points.size(); i++) {
	        	 points_fl[i] = Float.parseFloat(points.get(i));
	         }
	    }
	    catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
		
		int res = -1;
		int j = 0;
		float[] k = new float[points.size() / 2];
		for (int i = 0; i < points.size(); i += 2) {
			
			for (int cnt = 0; cnt < square.size(); cnt += 2) {
				k[j] = (((points_fl[i] - square_fl[cnt]) * (square_fl[cnt + 3] - square_fl[cnt + 1])) -
						(points_fl[i + 1] - square_fl[cnt + 1]) * (square_fl[cnt + 2] - square_fl[cnt]));
				if (k[j] > 0) {
					res = 2;
				} else if (k[j] == 0) {
					if ((points_fl[i] == square_fl[cnt] && points_fl[i + 1] == square_fl[cnt + 1]) ||
							points_fl[i] == square_fl[cnt + 2] && points_fl[i + 1] == square_fl[cnt + 3]) {
						res = 0;
						break;
					} else if ((points_fl[i] >= square_fl[cnt] && points_fl[i + 1] >= square_fl[cnt + 1]) &&
							points_fl[i] <= square_fl[cnt + 2] && points_fl[i + 1] <= square_fl[cnt + 3]) {
						res = 1;
						break;
					} else {
						res = 3;
						break;
					}
				} else if (k[j] < 0) {
					res = 3;
					break;
				}
			}
			System.out.println(res);
			j++;
		}
	}
}

