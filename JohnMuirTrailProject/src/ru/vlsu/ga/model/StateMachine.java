package ru.vlsu.ga.model;

import java.io.PrintStream;
import java.util.Random;

import ru.vlsu.ga.data.AntParameters;
import ru.vlsu.ga.utils.BitStringUtils;

public class StateMachine {
	
	//Начальное состояние
	private int initialState;
	
	private Transition[][] transitions;
	
	private String bitStringStateMachine;
	
	public StateMachine(Transition[][] transitions, int initialState){
		this.transitions = transitions;
		this.initialState = initialState;
	}
	
	public StateMachine(Transition[][] transitions, int initialState, String bitString){
		this.transitions = transitions;
		this.initialState = initialState;
		this.bitStringStateMachine = bitString;
	}
	
	public static StateMachine createRandomStateMachine(){
		Random random = new Random();
		int initialState = random.nextInt(AntParameters.COUNT_OF_STATES);
		Transition[][] transitions = new Transition[AntParameters.COUNT_OF_STATES][AntParameters.COUNT_OF_INPUT];
		for (int i = 0; i < AntParameters.COUNT_OF_STATES; i++){
			for (int j = 0; j < AntParameters.COUNT_OF_INPUT; j++){
				int outputState = random.nextInt(AntParameters.COUNT_OF_STATES);
				Action action = new Action();
				boolean isFood = false;
				if (j == 1)
					isFood = true;
				transitions[i][j] = new Transition(i, outputState, isFood, action);
			}
		}
		return new StateMachine(transitions, initialState);
	}
	
	public static void printStateMachineToFile(PrintStream fileStream, StateMachine stateMachine){
		String stateMachineBitString = "";
		Transition[][] transitions = stateMachine.getTransitions();
		fileStream.println("Initial state = " + stateMachine.getInitialState());
		//Битовое представление начального состояния
		stateMachineBitString += Transition.calculateBitString(stateMachine.getInitialState()) + " ";
		for (int i = 0; i < AntParameters.COUNT_OF_STATES; i++){
			for (int j = 0; j < AntParameters.COUNT_OF_INPUT; j++){
				fileStream.println(transitions[i][j].toString());
				//Битовое представление исходного состояния
				stateMachineBitString += transitions[i][j].getFromStateNumberBitString();
				//Битовое представление нового состояния
				stateMachineBitString += transitions[i][j].getToStateNumberBitString();
				//Битовое представление действия
				stateMachineBitString += transitions[i][j].getAction().getBitValue() + " ";
			}
		}
		stateMachine.setBitStringStateMachine(stateMachineBitString);
		fileStream.println("BitString - " + stateMachine.getBitStringStateMachine());
		fileStream.println("============================================");
	}

	public Transition[][] getTransitions() {
		return transitions;
	}

	public int getInitialState() {
		return initialState;
	}

	public String getBitStringStateMachine() {
		return bitStringStateMachine;
	}

	public void setBitStringStateMachine(String bitStringStateMachine) {
		this.bitStringStateMachine = bitStringStateMachine;
	}
}
