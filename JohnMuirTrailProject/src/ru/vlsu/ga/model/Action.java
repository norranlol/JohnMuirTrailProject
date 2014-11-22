package ru.vlsu.ga.model;

import java.util.Random;

public class Action {

	// оличество действий €вл€етс€ посто€нным
	private static final int COUNT_OF_ACTIONS = 4;
	
	public static final String ACTION_MOVE = "MOVE";
	public static final String ACTION_NOP = "NOP";
	public static final String ACTION_TURN_LEFT  = "TURN_LEFT";
	public static final String ACTION_TURN_RIGHT = "TURN_RIGHT";
	public static final String BITSTRING_MOVE = "00";
	public static final String BITSTRING_NOP = "01";
	public static final String BITSTRING_TURN_LEFT = "10";
	public static final String BITSTRING_TURN_RIGHT = "11";
	public static final int ACTION_MOVE_NUMBER = 0;
	public static final int ACTION_NOP_NUMBER = 1;
	public static final int ACTION_TURN_LEFT_NUMBER = 2;
	public static final int ACTION_TURN_RIGHT_NUMBER = 3;
	
	private String currentAction;
	private String bitValue;
	private int actionNumber;
	
	public Action(){
		getRandomAction();
		calculateBitValue();
	}
	
	public Action(String currentAction, String bitValue, int actionNumber){
		this.currentAction = currentAction;
		this.bitValue = bitValue;
		this.actionNumber = actionNumber;
	}
	
	public void getRandomAction(){
		actionNumber = new Random().nextInt(COUNT_OF_ACTIONS);
		switch (actionNumber){
			case ACTION_MOVE_NUMBER:
				currentAction = ACTION_MOVE;
				break;
			case ACTION_NOP_NUMBER:
				currentAction = ACTION_NOP;
				break;
			case ACTION_TURN_LEFT_NUMBER:
				currentAction = ACTION_TURN_LEFT;
				break;
			case ACTION_TURN_RIGHT_NUMBER:
				currentAction = ACTION_TURN_RIGHT;
				break;
		}
	}
	
	public void calculateBitValue(){
		switch (actionNumber){
			case ACTION_MOVE_NUMBER:
				bitValue = BITSTRING_MOVE;
				break;
			case ACTION_NOP_NUMBER:
				bitValue = BITSTRING_NOP;
				break;
			case ACTION_TURN_LEFT_NUMBER:
				bitValue = BITSTRING_TURN_LEFT;
				break;
			case ACTION_TURN_RIGHT_NUMBER:
				bitValue = BITSTRING_TURN_RIGHT;
				break;
		}
	}

	public String getCurrentAction() {
		return currentAction;
	}

	public String getBitValue() {
		return bitValue;
	}
}
