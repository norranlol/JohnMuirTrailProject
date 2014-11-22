package ru.vlsu.ga.data;

public class AntParameters {
	
	//Параметры карты
	public static final int DIMENSION_N = 32;
	public static final int DIMENSION_M = 32;
	
	//Ссылка на файл с координатами
	public static final String MAP_FILE = "foodCoordinates.txt";
	
	//Количество еды на карте
	public static final int COUNT_OF_FOOD = 89;
	
	//Ожидаемый фитнес
	public static final double EXPECTED_FITNESS = 80;
	
	//Количество поколений
	public static final int GENERATION_SIZE = 1000;
	
	//Количество состояний
	public static final int COUNT_OF_STATES = 4;

	//Количество вариантов входящей информации
	public static final int COUNT_OF_INPUT = 2;
	
	//Папка и наименование файла с результатами
	public static final String RESULT_FILE = "results/generation_.txt";
	
	//Количество поколений
	public static final int COUNT_OF_GENERATIONS = 10;
}
