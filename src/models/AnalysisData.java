package models;

import java.util.Vector;

public abstract class AnalysisData<T> {
	public int Id;
	public Vector<T> Values;
	
	abstract T parseValue(String valueString);
}
