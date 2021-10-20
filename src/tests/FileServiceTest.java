package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.Vector;

import org.junit.Test;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.EscritaNaoPermitidaException;
import models.MemoryData;
import services.FileService;
import services.ParserService;

class CorrectMockData {
	static String FILE_PATH = "src/files/hello_world.txt";
	static String FILE_CONTENT = "hello_world";
}

class WrongMockData {
	static String FILE_PATH = "/bin/wrong.txt";
	static String EXPECTED_NOT_FOUND_MESSAGE = "O arquivo " + WrongMockData.FILE_PATH + " nao foi encontrado";
	static String EXPECTED_FORBIDDEN_MESSAGE = "A escrita no arquivo " + WrongMockData.FILE_PATH + " nao foi permitida";
}

public class FileServiceTest {
	
	@Test
	public void CanWriteFile1() throws IOException, EscritaNaoPermitidaException {
		FileService.WriteStringInFile(CorrectMockData.FILE_PATH, CorrectMockData.FILE_CONTENT);
	}
	
	@Test
	public void CanWriteFileAndThrowException1() throws IOException, EscritaNaoPermitidaException {
		EscritaNaoPermitidaException thrown = assertThrows(
				EscritaNaoPermitidaException.class,
		           () -> {FileService.WriteStringInFile(WrongMockData.FILE_PATH, CorrectMockData.FILE_CONTENT);}
		    );
		assertEquals(thrown.getMessage(), WrongMockData.EXPECTED_FORBIDDEN_MESSAGE);
	}
	
	@Test
	public void CanReadFile1() throws IOException, ArquivoNaoEncontradoException{
		String result = FileService.ReadFileAsString(CorrectMockData.FILE_PATH);
		assertEquals(result, CorrectMockData.FILE_CONTENT);
	}
	
	@Test
	public void CanReadFileAndThrowException1() throws IOException, ArquivoNaoEncontradoException{
		ArquivoNaoEncontradoException thrown = assertThrows(
				ArquivoNaoEncontradoException.class,
		           () -> {FileService.ReadFileAsString(WrongMockData.FILE_PATH);}
		    );
		assertEquals(thrown.getMessage(), WrongMockData.EXPECTED_NOT_FOUND_MESSAGE);
	}
	
	@Test
	public void CanWriteMemoryData() throws IOException, ArquivoNaoEncontradoException, EscritaNaoPermitidaException {
		String fileContent = FileService.ReadFileAsString("src/files/analysisMemory.out");
		Vector<MemoryData> result = ParserService.BuildMemoryData(fileContent);
		FileService.SaveMemoryDataAsLine(result, "src/files/analysisMemory.result.out", ",");
	}
	
}
