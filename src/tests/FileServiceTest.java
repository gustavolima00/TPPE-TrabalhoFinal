package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.Test;

import exceptions.ArquivoNaoEncontradoException;
import services.FileService;

class CorrectMockData {
	static String FILE_PATH = "src/files/hello_world.txt";
	static String FILE_CONTENT = "hello_world";
}

class WrongMockData {
	static String FILE_PATH = "wrong/file/path.txt";
	static String EXPECTED_MESSAGE = "O arquivo" + WrongMockData.FILE_PATH + " nao foi encontrado";
}

public class FileServiceTest {
	@Test
	public void CanReadFile1() throws IOException, ArquivoNaoEncontradoException{
		String result = FileService.ReadFileAsString(CorrectMockData.FILE_PATH);
		assertEquals(result, CorrectMockData.FILE_CONTENT);
	}
	
	@Test
	public void CanThrowException1() throws IOException, ArquivoNaoEncontradoException{
		ArquivoNaoEncontradoException thrown = assertThrows(
				ArquivoNaoEncontradoException.class,
		           () -> {FileService.ReadFileAsString(WrongMockData.FILE_PATH);}
		    );
		assertEquals(thrown.getMessage(), WrongMockData.EXPECTED_MESSAGE);
	}
	
}
