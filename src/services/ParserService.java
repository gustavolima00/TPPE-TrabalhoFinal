package services;

import java.util.Vector;
import models.MemoryData;

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
}
