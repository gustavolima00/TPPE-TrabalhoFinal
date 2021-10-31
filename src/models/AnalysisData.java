package models;

import java.util.Vector;

public class AnalysisData<T> {
	public int Id;
	public Vector<T> Values;
	
	public AnalysisData(int id, Vector<T> values) {
		this.Id = id;
		this.Values = values;
	}
}
