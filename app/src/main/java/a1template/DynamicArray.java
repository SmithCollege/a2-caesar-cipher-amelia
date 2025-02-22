// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class DynamicArray<T> implements IndexAccess<T>{
    
    // What instance variables do you need?
    public T[] array;
    public int size;
    public int offset;

    // Write a constructor to make a new DynamicArray Object from an array
    DynamicArray (int offset, T[] baseArray) {
        this.array = baseArray;
        this.size = baseArray.length;
        this.offset = offset;
    }

    // Now implement the methods from IndexAccess?
    public T get(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("ERROR: Index out of bounds.");
        }
        T result = array[i];
        return result;
    }

    public T get(int i, int offset) {
        int adjustedI = i + offset;
        if (adjustedI < 0) {
            return array[size + adjustedI];
        } else if (adjustedI >= size){
            return array[adjustedI - size];
        } else {
            return this.array[adjustedI];
        }
    }

    public int getSize() {
        return size;
    }

    public void set(int i, T val) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("ERROR: Index not in range.");
        }
        this.array[i] = val;
    }

    public static void main(String[] args) {
        Integer[] baseArray = new Integer[10];
        for (int i = 0; i < 10; i++) {
            baseArray[i] = Integer.valueOf(i);
        }
        DynamicArray<Integer> testArray = new DynamicArray(0, baseArray);
        testArray.get(0);
        Class<?> thisClass = testArray.get(0).getClass();
        System.out.println(thisClass.getName());

    }

}