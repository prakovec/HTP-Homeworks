package by.htp.krozov.homework.arrayutil;

public class Main {

    public static void main(String[] args) {
    }

    public static void print(Object[] array) {
        if (array == null) {
            System.out.print("null");
        } else {
            for (int i = 0, lastItem = array.length - 1; i < array.length; i++) {
                System.out.print(array[i]);
                if (i != lastItem) {
                    System.out.print(", ");
                }
            }
        }
    }

    public static int endsWithCount(String[] array, String suffix) {
        int endsWithCount = 0;
        for (String item : array) {
            if (item.endsWith(suffix)) {
                endsWithCount++;
            }
        }
        return endsWithCount;
    }

    public static int startsWithCount(String[] array, String prefix) {
        int startsWithCount = 0;
        for (String item : array) {
            if (item.startsWith(prefix)) {
                startsWithCount++;
            }
        }
        return startsWithCount;
    }

    public static int containsCount(String[] array, String s) {
        int containsCount = 0;
        for (String item : array) {
            if (item.contains(s)) {
                containsCount++;
            }
        }
        return containsCount;
    }

    public static Object[] concat(Object[] array1, Object[] array2, Object[]... arrays) {
        int resultLength = array1.length + array2.length;
        for (Object[] array : arrays) {
            resultLength += array.length;
        }
        Object[] resultArray = new Object[resultLength];

        System.arraycopy(array1, 0, resultArray, 0, array1.length);
        System.arraycopy(array2, 0, resultArray, array1.length, array2.length);

        for (int i = 0, destPos = array1.length + array2.length;
             i < arrays.length;
             destPos += arrays[i].length, i++) {
            System.arraycopy(arrays[i], 0, resultArray, destPos, arrays[i].length);
        }

        return resultArray;
    }

    public static String toString(Object[] array) {
        StringBuilder builder = new StringBuilder();
        for (Object item : array) {
            builder.append(item);
        }
        return builder.toString();
    }

    public static boolean contains(Object[] array, Object... items) {
        if (array == null && items == null) {
            return true;
        } else if (array != null && items != null) {
            if (items.length == 0) {
                return true;
            } else if (array.length == 0) {
                return false;
            } else {
                for (Object item : items) {
                    boolean hasItem = false;
                    for (Object arrayItem : array) {
                        if (item.equals(arrayItem)) {
                            hasItem = true;
                        }
                    }

                    if (!hasItem) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }
}
