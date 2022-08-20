import java.util.Arrays;
import java.util.Random;

class Box<T> {
    protected T[] items;
    Random random = new Random();
    int filled = 0;

    public Box(int maxItems) {
        this.items = (T[]) new Object[maxItems];
    }

    public boolean add(T item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                filled += 1;
                System.out.println(Arrays.toString(items));
                return true;
            }
        }
        return false;
    }

    public T pick() {
        for (int i = 0; i < items.length; i++) {
            if (filled < items.length) {
                throw new RuntimeException("свободных ячеек: " + (items.length - filled) + ", их надо заполнить.");
            }
        }
        for (int i = 0; i < items.length; i++) {
            if (filled == items.length) {
                int randomInt = random.nextInt(items.length);
                System.out.println("коробка заполнена.");
                System.out.println("случайный элемент из коробки: " + items[randomInt]);
                System.out.println();
                return items[randomInt];
            }
        }
        return null;
    }
}
