import java.io.IOException;
import java.util.Vector;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.EscritaNaoPermitidaException;
import models.AnalysisData;
import services.FileService;
import services.ParserService;

public class Main {
	public static void main(String[] args) throws IOException, ArquivoNaoEncontradoException, EscritaNaoPermitidaException {
		
		// Save analysisTime as column
		String fileContent1 = FileService.ReadFileAsString("src/files/analysisTime.out");
		Vector<AnalysisData<Integer>> result1 = ParserService.BuildTimeData(fileContent1);
		FileService.SaveAnalysisDataAsColumn(result1, "src/files/analysisTime.column.out", ";");
		
		// Save analysisTime as line
		String fileContent2 = FileService.ReadFileAsString("src/files/analysisTime.out");
		Vector<AnalysisData<Integer>> result2 = ParserService.BuildTimeData(fileContent2);
		FileService.SaveAnalysisDataAsLine(result2, "src/files/analysisTime.line.out", ";");
		
		// Save analysisMemory as column
		String fileContent3 = FileService.ReadFileAsString("src/files/analysisMemory.out");
		Vector<AnalysisData<Double>> result3 = ParserService.BuildMemoryData(fileContent3);
		FileService.SaveAnalysisDataAsColumn(result3, "src/files/analysisMemory.column.out", ";");
		
		// Save analysisMemory as line
		String fileContent4 = FileService.ReadFileAsString("src/files/analysisMemory.out");
		Vector<AnalysisData<Double>> result4 = ParserService.BuildMemoryData(fileContent4);
		FileService.SaveAnalysisDataAsLine(result4, "src/files/analysisMemory.line.out", ";");
    }
}
