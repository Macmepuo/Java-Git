package exceptions;

public class ArraySizeException extends BaseException
{
    public ArraySizeException()
    {
        super("Недопустимый размер массива: требуется размер 4х4");
    }
}
