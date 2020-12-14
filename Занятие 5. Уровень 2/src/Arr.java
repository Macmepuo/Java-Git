import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Arr {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    public float[] calculate(float @NotNull [] arr)
    {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void CheckTimeOfCycle()
    {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0F;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("First method ends: " + (System.currentTimeMillis() - a));
    }

    public void CheckTimeOfCopy() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);

        new Thread(() -> {
            float[] a1 = calculate(arr1);
            System.arraycopy(a1, 0, arr1, 0, a1.length);
        }).start();

        new Thread(() -> {
            float[] a2 = calculate(arr2);
            System.arraycopy(a2, 0, arr2, 0, a2.length);
        }).start();


        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println(arr[1]);
        System.out.println("Second method ends: " + (System.currentTimeMillis() - a));
    }
}

