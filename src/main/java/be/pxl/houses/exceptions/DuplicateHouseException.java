package be.pxl.houses.exceptions;

public class DuplicateHouseException extends RuntimeException
{
    public DuplicateHouseException (String message) {
        super(message);
    }
}
