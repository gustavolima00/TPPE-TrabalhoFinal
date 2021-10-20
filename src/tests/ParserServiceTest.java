package tests;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import exceptions.ArquivoNaoEncontradoException;
import services.FileService;
import services.ParserService;

public class ParserServiceTest {
	@Test
	public void Test1() throws IOException, ArquivoNaoEncontradoException{
		String fileContent = FileService.ReadFileAsString("src/files/analysisMemory.out");
		ParserService.BuildMemoryData(fileContent);
	}
}
