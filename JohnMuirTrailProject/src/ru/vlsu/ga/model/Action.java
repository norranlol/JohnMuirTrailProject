package ru.vlsu.ga.model;

import java.util.Random;

public class Action {

	// оличество действий €вл€етс€ посто€нным
	private static final int COUNT_OF_ACTIONS = 4;
	
	private static String ACTION_MOVE = "MOVE";
	private static String ACTION_NOP = "NOP";
	private static String ACTION_TURN_LEFT  = "TURN_LEFT";
	private static String ACTION_TURN_RIGHT = "TURN_RIGHT";
	
	public static String getRandomAction(){
		int actionNumber = new Random().nextInt(COUNT_OF_ACTIONS);
		switch (actionNumber){
			case 0:
				return ACTION_MOVE;
			case 1:
				return ACTION_NOP;
			case 2:
				return ACTION_TURN_LEFT;
			case 3:
				return ACTION_TURN_RIGHT;
		}
		return null;
	}
}
