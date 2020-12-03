package exceptions;

public class ArrayDataException extends BaseException {
    private final int x;
    private final int y;

    public ArrayDataException(int x,int y)
    {
        super("Неверный формат данных");
        this.x= x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getFulMessage()
    {
        return this.getMessage()+"ячейка массива[" + x + "," + y + "]";
    }

}
