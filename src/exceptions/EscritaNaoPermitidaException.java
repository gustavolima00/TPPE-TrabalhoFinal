package exceptions;

public class EscritaNaoPermitidaException extends Exception{
	public EscritaNaoPermitidaException(String filePath) {
        super("A escrita no arquivo " + filePath + " nao foi permitida");
    }
}
