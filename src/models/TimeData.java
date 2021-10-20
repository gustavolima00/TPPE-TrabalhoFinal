package models;

import java.util.Vector;

public class TimeData {
	public int Id;
	public Vector<Integer> Values;
	public TimeData(int id, Vector<Integer> values) {
		this.Id = id;
		this.Values = values;
	}
}
