package models;

import java.util.Vector;

public class MemoryData {
	public int Id;
	public Vector<Double> Values;
	public MemoryData(int id, Vector<Double> values) {
		this.Id = id;
		this.Values = values;
	}
}
