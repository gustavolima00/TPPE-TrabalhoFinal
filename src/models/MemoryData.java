package models;

import java.util.Vector;

public class MemoryData extends AnalysisData<Double>{
	public MemoryData(int id, Vector<Double> values) {
		super.Id = id;
		super.Values = values;
	}

	@Override
	Double parseValue(String valueString) {
		return Double.parseDouble(valueString);
	}
}
