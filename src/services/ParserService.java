package services;

import java.util.Vector;
import models.MemoryData;
import models.TimeData;

public class ParserService {
	
	public static Vector<MemoryData> BuildMemoryData(String fileContent){
		Vector<MemoryData> result = new Vector<MemoryData>();
		String[] lines = fileContent.split("\n");
		int idx = 0;
		Vector<Double> vs = new Vector<Double>();
		
		for(String line:lines) {
			if(line.contains("Evolution")) {
				if(idx != -1) {
					result.add(new MemoryData(idx, vs));
					vs.clear();
				}
				idx+=1;
			}
			else {
				vs.add(Double.parseDouble(line));
			}
		}
		result.add(new MemoryData(idx, vs));
		return result;
	}
	
	public static Vector<TimeData> BuildTimeData(String fileContent){
		Vector<TimeData> result = new Vector<TimeData>();
		String[] lines = fileContent.split("\n");
		int idx = 0;
		Vector<Integer> vs = new Vector<Integer>();
		
		for(String line:lines) {
			if(line.contains("Evolution")) {
				if(idx != -1) {
					result.add(new TimeData(idx, vs));
					vs.clear();
				}
				idx+=1;
			}
			else {
				vs.add(Integer.parseInt(line));
			}
		}
		result.add(new TimeData(idx, vs));
		return result;
	}
}
