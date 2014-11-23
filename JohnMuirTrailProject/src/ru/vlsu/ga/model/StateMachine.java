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
