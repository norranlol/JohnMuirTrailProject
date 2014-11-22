package ru.vlsu.ga.model;

public class GeneticModel {
	
	private final double expectedFitness;
	private final int generationSize;
	private final int countOfStates; 
	
	public GeneticModel(double expectedFitness, int generationSize,
						int countOfStates){
		this.expectedFitness = expectedFitness;
		this.generationSize = generationSize;
		this.countOfStates = countOfStates;
	}
	
	
	
	
}
