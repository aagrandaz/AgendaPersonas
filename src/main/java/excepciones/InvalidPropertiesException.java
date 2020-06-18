package excepciones;

public class InvalidPropertiesException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidPropertiesException(String errorMessage)
	{
		super(errorMessage);
	}
}
