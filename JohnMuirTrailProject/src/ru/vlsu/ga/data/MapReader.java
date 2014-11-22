package ru.vlsu.ga.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MapReader {
	
	//Карта, по которой будет двигаться муравей
	private int[][] map;
	
	public MapReader(){
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(AntParameters.MAP_FILE));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		map = new int[AntParameters.DIMENSION_N][AntParameters.DIMENSION_M];
		for (int i = 0; i < AntParameters.COUNT_OF_FOOD; i++){
			String str = scanner.next();
			String[] mas = str.split(Pattern.quote(","));
			if (mas.length > 1){
				int m = parseToInteger(mas[0]);
				int n = parseToInteger(mas[1]);
				map[n][m] = 1;
			}
		}
	}
	
	private int parseToInteger(String digit){
		return Integer.parseInt(digit);
	}
	
	//Вспомогательный метод
	private void printCountOfFoods(){
		int counter = 0;
		for (int i = 0; i < AntParameters.DIMENSION_N; i++){
			for (int j = 0; j < AntParameters.DIMENSION_M; j++){
				if (map[i][j] == 1)
					counter++;
			}
		}
		System.out.println("Counter = " + counter);
	}

	public int[][] getMap() {
		return map;
	}
}