package ru.vlsu.ga.model;

public class Transition {
	
	public static final String BITSTRING_0 = "00";
	public static final String BITSTRING_1 = "01";
	public static final String BITSTRING_2 = "10";
	public static final String BITSTRING_3 = "11";
	public static final int STATENUMBER_0 = 0;
	public static final int STATENUMBER_1 = 1;
	public static final int STATENUMBER_2 = 2;
	public static final int STATENUMBER_3 = 3;
	
	//Исходное состояние
	private int fromStateNumber;
	
	//Будущее состояние
	private int toStateNumber;
	
	//Исходное состояние в битовом представлении
	private String fromStateNumberBitString;
	
	//Будущее состояние в битовом представлении
	private String toStateNumberBitString;
	
	//Есть ли еда в клетке перед муравьем
	private boolean isFoodInForwardCell;
	
	//Действие, выполняемое при переходе из состояния в состояние
	private Action action;
	
	public Transition(int fromStateNumber, int toStateNumber, boolean isFoodInForwardCell,
			Action action){
		this.fromStateNumber = fromStateNumber;
		this.toStateNumber = toStateNumber;
		this.isFoodInForwardCell = isFoodInForwardCell;
		this.action = action;
		this.fromStateNumberBitString = calculateBitString(this.fromStateNumber);
		this.toStateNumberBitString = calculateBitString(this.toStateNumber);
	}

	public int getFromStateNumber() {
		return fromStateNumber;
	}

	public int getToStateNumber() {
		return toStateNumber;
	}

	public boolean isFoodInForwardCell() {
		return isFoodInForwardCell;
	}

	public Action getAction() {
		return action;
	}
	
	public String getFromStateNumberBitString() {
		return fromStateNumberBitString;
	}

	public String getToStateNumberBitString() {
		return toStateNumberBitString;
	}

	public String toString(){
		return "FROM STATE = " + fromStateNumber + ", TO STATE = " + toStateNumber + ", FOOD = "
				+ isFoodInForwardCell + ", ACTION = " + action.getCurrentAction();
	}
	
	public static String calculateBitString(int toStateNumber){
		switch (toStateNumber){
			case STATENUMBER_0:
				return BITSTRING_0;
			case STATENUMBER_1:
				return BITSTRING_1;
			case STATENUMBER_2:
				return BITSTRING_2;
			case STATENUMBER_3:
				return BITSTRING_3;
		}
		return null;
	}
}
