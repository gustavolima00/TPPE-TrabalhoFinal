package models;

import java.util.Vector;

public class TimeData extends AnalysisData<Integer>{
	public TimeData(int id, Vector<Integer> values) {
		super.Id = id;
		super.Values = values;
	}

	@Override
	Integer parseValue(String valueString) {
		return Integer.parseInt(valueString);
	}
}
