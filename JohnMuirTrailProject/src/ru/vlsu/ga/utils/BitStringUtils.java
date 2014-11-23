package ru.vlsu.ga.utils;

import java.util.regex.Pattern;

import ru.vlsu.ga.data.AntParameters;
import ru.vlsu.ga.model.Action;
import ru.vlsu.ga.model.StateMachine;
import ru.vlsu.ga.model.Transition;

public class BitStringUtils {

	public static StateMachine createStateMachineFromBitString(String bitString){
		String[] bitStringMas = bitString.split(Pattern.quote(" "));
		String[] transitionsMasBits = new String[AntParameters.COUNT_OF_STATES *2];
		if (bitStringMas.length == (AntParameters.COUNT_OF_STATES * 2 + 1)){
			String initialStateBitString = bitStringMas[0];
			int initialState = getNumberOfStateByBitString(initialStateBitString);
			for (int i = 1; i < bitStringMas.length; i++)
				transitionsMasBits[i-1] = bitStringMas[i];
			Transition[] transitionMas = new Transition[transitionsMasBits.length];
			
			//Конвертация bitString в состояния автомата
			for (int i = 0; i < transitionsMasBits.length; i++){
				boolean isFoodForward = false;
				if (i % 2 == 1)
					isFoodForward = true;
				String fromStateBit = transitionsMasBits[i].substring(0, 2);
				String toStateBit = transitionsMasBits[i].substring(2, 4);
				String actionBit = transitionsMasBits[i].substring(4, 6);
				
				int fromStateNumber = getNumberOfStateByBitString(fromStateBit);
				int toStateNumber = getNumberOfStateByBitString(toStateBit);
				Action action = createActionFromBitString(actionBit);
				
				Transition transition = new Transition(fromStateNumber, toStateNumber, isFoodForward, action);
				transitionMas[i] = transition;
			}
			//Получение матрицы переходов для нового автомата
			Transition[][] transitionsForSM = new Transition[AntParameters.COUNT_OF_STATES][AntParameters.COUNT_OF_INPUT];
			for (int i = 0; i < transitionMas.length; i++){
				if (i % 2 == 0){
					transitionsForSM[i/2][0] = transitionMas[i];
					transitionsForSM[i/2][1] = transitionMas[i + 1];
				}
			}
			return new StateMachine(transitionsForSM, initialState, bitString);
		}
		return null;
	}
	
	public static StateMachine calculateBitStringForStateMachine(StateMachine stateMachine){
		String stateMachineBitString = "";
		Transition[][] transitions = stateMachine.getTransitions();
		//Битовое представление начального состояния
		stateMachineBitString += Transition.calculateBitString(stateMachine.getInitialState()) + " ";
		for (int i = 0; i < AntParameters.COUNT_OF_STATES; i++){
			for (int j = 0; j < AntParameters.COUNT_OF_INPUT; j++){
				//Битовое представление исходного состояния
				stateMachineBitString += transitions[i][j].getFromStateNumberBitString();
				//Битовое представление нового состояния
				stateMachineBitString += transitions[i][j].getToStateNumberBitString();
				//Битовое представление действия
				stateMachineBitString += transitions[i][j].getAction().getBitValue() + " ";
			}
		}
		stateMachine.setBitStringStateMachine(stateMachineBitString);
		return stateMachine;
	}
	
	private static int getNumberOfStateByBitString(String bitString){
		switch (bitString){
			case Transition.BITSTRING_0:
				return Transition.STATENUMBER_0;
			case Transition.BITSTRING_1:
				return Transition.STATENUMBER_1;
			case Transition.BITSTRING_2:
				return Transition.STATENUMBER_2;
			case Transition.BITSTRING_3:
				return Transition.STATENUMBER_3;
		}
		return -1;
	}
	
	private static Action createActionFromBitString(String bitString){
		String currentAction = null;
		int actionNumber = -1;
		switch (bitString){
			case Action.BITSTRING_MOVE:
				currentAction = Action.ACTION_MOVE;
				actionNumber = Action.ACTION_MOVE_NUMBER;
				break;
			case Action.BITSTRING_NOP:
				currentAction = Action.ACTION_NOP;
				actionNumber = Action.ACTION_NOP_NUMBER;
				break;
			case Action.BITSTRING_TURN_LEFT:
				currentAction = Action.ACTION_TURN_LEFT;
				actionNumber = Action.ACTION_TURN_LEFT_NUMBER;
				break;
			case Action.BITSTRING_TURN_RIGHT:
				currentAction = Action.ACTION_TURN_RIGHT;
				actionNumber = Action.ACTION_TURN_RIGHT_NUMBER;
				break;
		}
		return new Action(currentAction, bitString, actionNumber);
	}
	
}
