package be.pxl.houses.exceptions;

public class HouseNotFoundException extends RuntimeException
{
    public HouseNotFoundException (String message) {
        super(message);
    }
}
