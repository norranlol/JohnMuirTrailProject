package ru.vlsu.ga.model;

public class GeneticGeneration {
	
	private final double expectedFitness;
	private final int generationSize;
	private final int countOfStates; 
	
	private StateMachine[] currentGeneration;
	
	public GeneticGeneration(double expectedFitness, int generationSize,
						int countOfStates){
		this.expectedFitness = expectedFitness;
		this.generationSize = generationSize;
		this.countOfStates = countOfStates;
		
		currentGeneration = new StateMachine[generationSize];
		for (int i = 0; i < generationSize; i++){
			StateMachine stateMachine = StateMachine.createRandomStateMachine();
			currentGeneration[i] = stateMachine;
		}
	}

	public StateMachine[] getCurrentGeneration() {
		return currentGeneration;
	}
}
