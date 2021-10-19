package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import services.FileService;

class MockData {
	static String FILE_PATH = "src/files/hello_world.txt";
	static String FILE_CONTENT = "hello_world";
}

public class FileServiceTest {
	@Test
	public void CanReadFile1() throws IOException{
		String result = FileService.ReadFileAsString(MockData.FILE_PATH);
		assertEquals(result, MockData.FILE_CONTENT);
	}
	
}
