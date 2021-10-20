package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.EscritaNaoPermitidaException;
import models.MemoryData;
import models.TimeData;

public class FileService {
	
	public static String ParseStreamToString(FileInputStream fis, String encoding) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(fis, encoding))) {
			StringBuilder sb = new StringBuilder();
			String line;
			if((line = br.readLine()) != null) {
				sb.append(line);
			}
			while ((line = br.readLine()) != null) {
				sb.append('\n');
				sb.append(line);
			}
			return sb.toString();
		}
	}

	public static String ReadFileAsString(String path) throws IOException, ArquivoNaoEncontradoException {
		try {
			FileInputStream fis = new FileInputStream(path);
			String data = FileService.ParseStreamToString(fis, "UTF-8");
			return data;
		}
		catch(FileNotFoundException e) {
			throw new ArquivoNaoEncontradoException(path);
		}
	}
	
	public static void WriteStringInFile(String path, String content) throws IOException, EscritaNaoPermitidaException {
		try {
			Path fileName = Path.of(path);
			Files.writeString(fileName, content);
		}
		catch(AccessDeniedException e) {
			throw new EscritaNaoPermitidaException(path);
		}
	}
	
	public static void SaveMemoryDataAsLine(Vector<MemoryData> memoryDatas, String path, String delimiter) throws IOException, EscritaNaoPermitidaException {
		StringBuilder sb = new StringBuilder();
		for(MemoryData data:memoryDatas) {
			sb.append(data.Id);
			for(Double x:data.Values) {
				sb.append(delimiter);
				sb.append(x);
			}
			sb.append("\n");
		}
		String result = sb.toString();
		FileService.WriteStringInFile(path, result);
	}
	
	public static void SaveTimeDataAsLine(Vector<TimeData> memoryDatas, String path, String delimiter) throws IOException, EscritaNaoPermitidaException {
		StringBuilder sb = new StringBuilder();
		for(TimeData data:memoryDatas) {
			sb.append(data.Id);
			for(Integer x:data.Values) {
				sb.append(delimiter);
				sb.append(x);
			}
			sb.append("\n");
		}
		String result = sb.toString();
		FileService.WriteStringInFile(path, result);
	}
	
	public static void SaveMemoryDataAsColumn(Vector<MemoryData> memoryDatas, String path, String delimiter) throws IOException, EscritaNaoPermitidaException {
		StringBuilder sb = new StringBuilder();
		if(memoryDatas.size() == 0) {
			return;
		}
		sb.append(memoryDatas.get(0).Id);
		for(int i=1; i< memoryDatas.size(); i++) {
			sb.append(delimiter);
			sb.append(memoryDatas.get(i).Id);
		}
		sb.append("\n");
		int idx = 0;
		while(true) {
			StringBuilder line = new StringBuilder();
			boolean canBreak = true;
			if(memoryDatas.get(0).Values.size() > idx) {
				line.append(memoryDatas.get(0).Values.get(idx));
				canBreak = false;
			}
			for(int i=1; i< memoryDatas.size(); i++) {
				line.append(delimiter);
				if(memoryDatas.get(i).Values.size() > idx) {
					line.append(memoryDatas.get(i).Values.get(idx));
					canBreak = false;
				}
			}
			line.append("\n");
			idx++;
			if(canBreak) break;
			sb.append(line.toString());
		}
		String result = sb.toString();
		FileService.WriteStringInFile(path, result);
	}
}
