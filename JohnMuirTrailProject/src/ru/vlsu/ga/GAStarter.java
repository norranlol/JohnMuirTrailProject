package ru.vlsu.ga;

import ru.vlsu.ga.data.AntParameters;
import ru.vlsu.ga.data.MapReader;
import ru.vlsu.ga.model.GeneticModel;

public class GAStarter {
	
	public static void main(String[] args) {
		MapReader mapReader = new MapReader();
		GeneticModel model = new GeneticModel(AntParameters.EXPECTED_FITNESS, 
				AntParameters.GENERATION_SIZE, AntParameters.COUNT_OF_STATES);
	}
	
}
