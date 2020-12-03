import exceptions.ArrayDataException;
import exceptions.ArraySizeException;

public class Main
{
    public static void main(String[] args)
    {
        final String[][] arrayWithSizeError =
        {
            {"1","2","3","4"},
            null,
            {"9","2","3"},
            {"1","2","3"},
        };
        final String[][] arrayWithDataError =
        {
            {"1","2","3","4"},
            {"1","2","2","4"},
            {"1","2","4","4"},
            {"1","2","3","null"},
        };

        final String[][] arrayWithoutError =
        {
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
        };

        printResult(arrayWithSizeError, "Size ERROR");
        printResult(arrayWithDataError, "Data ERROR");
        printResult(arrayWithoutError, "NORMAL");
    }

    public static int getStringArraySum(String [][] stringArray)
    {
        if (stringArray == null || stringArray.length !=4)
        {
            throw new ArraySizeException();
        }
        int result=0;
        for (int i=0; i< stringArray.length;i++)
        {
            if(stringArray[i]==null || stringArray[i].length !=4)
            {
                throw new ArraySizeException();
            }
            else
            {
                for (int j=0;j<stringArray[i].length;j++)
                {
                    try{
                        result +=Integer.parseInt(stringArray[i][j]);
                    }
                    catch (NumberFormatException ex)
                    {
                        throw new ArrayDataException(i,j);
                    }
                }
            }
        }
        return result;
    }

    public static void printResult(String[][] stringsArray, String arrayName)
    {
        System.out.println(System.lineSeparator()+ arrayName +":");
        try{
            System.out.println("Result :" + getStringArraySum(stringsArray));
        }
        catch (ArraySizeException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (ArrayDataException ex)
        {
            System.out.println(ex.getFulMessage());
        }
    }

}
