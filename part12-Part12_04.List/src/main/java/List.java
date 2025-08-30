import java.util.Objects;

public class List<T> {

    private T[] values;
    private int availableIndex;

    public List() {

        this.values = (T[]) new Object[10];
        this.availableIndex = 0;

    }

    public void add(T value) {

        if (this.availableIndex == this.values.length) {
            grow();
        }
        this.values[this.availableIndex] = value;
        this.availableIndex++;
    }

    private void grow() {

        int newSize = this.values.length + this.values.length / 2;

        T[] newValues = (T[]) new Object[newSize];

        for (int i = 0; i < this.values.length; i++) {

            newValues[i] = this.values[i];

        }
        this.values = newValues;

    }

    public boolean contains(T value) {

        return indexOfValue(value) >= 0;

    }

    public void remove(T value) {

        int indexOfValue = indexOfValue(value);

        if (indexOfValue < 0) {

            return;
        }
        moveToLeft(indexOfValue);
        this.availableIndex--;
    }

    public int indexOfValue(T value) {

        for (int i = 0; i < availableIndex; i++) {

            if (Objects.equals(this.values[i], value)) {

                return i;

            }

        }
        return -1;


    }

    private void moveToLeft(int indexFrom) {

        for (int i = indexFrom; i < availableIndex - 1; i++) {

            this.values[i] = this.values[i + 1];
        }
        this.values[availableIndex - 1] = null;

    }

    public T value(int index) {

        if (index < 0 || index >= this.availableIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.availableIndex + "]");

        }
        return this.values[index];
    }

    public int size() {

        return this.availableIndex;
    }

}


