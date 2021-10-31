package services;

import java.util.Vector;
import java.util.function.Function;

import models.AnalysisData;

public class ParserService {
	
	static <T> Vector<AnalysisData<T>> BuildAnalysisData(String fileContent, Function<String,T> parseNumber){
		Vector<AnalysisData<T>> result = new Vector<AnalysisData<T>>();
		String[] lines = fileContent.split("\n");
		int idx = 0;
		Vector<T> vs = new Vector<T>();
		
		for(String line:lines) {
			if(line.contains("Evolution")) {
				if(idx != -1) {
					result.add(new AnalysisData<T>(idx, vs));
					vs.clear();
				}
				idx+=1;
			}
			else {
				vs.add(parseNumber.apply(line));
			}
		}
		result.add(new AnalysisData<T>(idx, vs));
		return result;
	}
	
	public static Vector<AnalysisData<Double>> BuildMemoryData(String fileContent){
		return BuildAnalysisData(fileContent, st -> Double.parseDouble(st));
	}
	
	public static Vector<AnalysisData<Integer>> BuildTimeData(String fileContent){
		return BuildAnalysisData(fileContent, st -> Integer.parseInt(st));
	}
}
