package innova4b.empresaReparto.exceptions;

public class CocheNotFreeForReservationException extends Exception {

	private static final long serialVersionUID = 1L;

	public CocheNotFreeForReservationException(String message){
		super(message);
	}
}
