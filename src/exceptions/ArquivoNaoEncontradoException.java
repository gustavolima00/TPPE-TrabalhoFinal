package exceptions;

public class ArquivoNaoEncontradoException extends Exception{
	public ArquivoNaoEncontradoException(String filePath) {
        super("O arquivo " + filePath + " nao foi encontrado");
    }
}
