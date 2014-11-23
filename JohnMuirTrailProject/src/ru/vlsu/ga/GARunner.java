package ru.vlsu.ga;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import ru.vlsu.ga.data.AntParameters;
import ru.vlsu.ga.data.MapReader;
import ru.vlsu.ga.model.GeneticGeneration;
import ru.vlsu.ga.model.StateMachine;
import ru.vlsu.ga.model.Transition;
import ru.vlsu.ga.utils.BitStringUtils;
import ru.vlsu.ga.utils.FileUtils;

public class GARunner {
		
	public static void main(String[] args) throws FileNotFoundException{
		MapReader mapReader = new MapReader();
		
		StateMachine[] testGeneration = new StateMachine[AntParameters.GENERATION_SIZE];
		
		for (int i = 0; i < AntParameters.COUNT_OF_GENERATIONS; i++){
			String fileTitle = FileUtils.getValidTitleOfFileForGeneration(i);
			PrintStream fileStream = new PrintStream(new File(fileTitle));
			GeneticGeneration model = new GeneticGeneration(AntParameters.EXPECTED_FITNESS, 
					AntParameters.GENERATION_SIZE, AntParameters.COUNT_OF_STATES);
			StateMachine[] currentGeneration = model.getCurrentGeneration();
			for (StateMachine sm : currentGeneration){
				sm = BitStringUtils.calculateBitStringForStateMachine(sm);
				FileUtils.printStateMachineToFile(fileStream, sm);
			}
			fileStream.close();
			if (i == 0)
				testGeneration = currentGeneration;
		}
		
		//Конвертация автоматов в битовые строки
		String[] bitStrings = new String[AntParameters.GENERATION_SIZE];
		StateMachine[] resultSM = new StateMachine[AntParameters.GENERATION_SIZE];
		
		for (int i = 0; i < testGeneration.length; i++)
			bitStrings[i] = testGeneration[i].getBitStringStateMachine();
		
		for (int i = 0; i < bitStrings.length; i++)
			resultSM[i] = BitStringUtils.createStateMachineFromBitString(bitStrings[i]);
		

			
		//Проверим соответствие автоматов битовым строкам
		StateMachine sm = testGeneration[0];
		StateMachine SMafterConverting = resultSM[0];
		
		Transition[][] tr1 = sm.getTransitions();
		Transition[][] tr2 = SMafterConverting.getTransitions();
		
		System.out.println("testtst");
	}
}
