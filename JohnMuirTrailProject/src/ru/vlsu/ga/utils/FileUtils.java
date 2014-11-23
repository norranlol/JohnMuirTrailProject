package ru.vlsu.ga.utils;

import java.io.PrintStream;
import java.util.regex.Pattern;

import ru.vlsu.ga.data.AntParameters;
import ru.vlsu.ga.model.StateMachine;
import ru.vlsu.ga.model.Transition;

public class FileUtils {

	public static String getValidTitleOfFileForGeneration(int numberOfGeneration){
		String[] titleMas = AntParameters.RESULT_FILE.split(Pattern.quote("."));
		if (titleMas.length > 1){
			String newFileName = titleMas[0] + numberOfGeneration + "." + titleMas[1];
			return newFileName;
		} else 
			return null;
	}
	
	public static void printStateMachineToFile(PrintStream fileStream, StateMachine stateMachine){
		String stateMachineBitString = "";
		Transition[][] transitions = stateMachine.getTransitions();
		fileStream.println("Initial state = " + stateMachine.getInitialState());
		for (int i = 0; i < AntParameters.COUNT_OF_STATES; i++){
			for (int j = 0; j < AntParameters.COUNT_OF_INPUT; j++){
				fileStream.println(transitions[i][j].toString());
			}
		}
		fileStream.println("BitString = " + stateMachine.getBitStringStateMachine());
		fileStream.println("============================================");
	}
		
}
