package ru.vlsu.ga.utils;

import java.util.regex.Pattern;

import ru.vlsu.ga.data.AntParameters;

public class FileUtils {

	public static String getValidTitleOfFileForGeneration(int numberOfGeneration){
		String[] titleMas = AntParameters.RESULT_FILE.split(Pattern.quote("."));
		if (titleMas.length > 1){
			String newFileName = titleMas[0] + numberOfGeneration + "." + titleMas[1];
			return newFileName;
		} else 
			return null;
	}
	
}
