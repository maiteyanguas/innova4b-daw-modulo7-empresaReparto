package innova4b.empresaReparto.exceptions;

public class LastDateNotFutureOfFirstDateException extends Exception {

	private static final long serialVersionUID = 1L;

	public LastDateNotFutureOfFirstDateException(String message){
		super(message);
	}
}
