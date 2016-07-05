
public class DynamicStringList implements SimpleList{
    public static void main(String[] args) {
        DynamicStringList list = new DynamicStringList();
        list.add("aaa aaa");
        list.add("bbb bbb bbb");
        list.add("cc cc cc cc cc");
        list.add("dddd dddd");
        list.add("e e e");
        System.out.println("Добавление:");
        System.out.println(list);
        System.out.println("Извлечение последнего элемента:");
        System.out.println(list.get());
        System.out.println("Извлечение 2 элемента:");
        System.out.println(list.get(2));
        System.out.println("Удаление последнего элемента:");
        list.remove();
        System.out.println(list);
        System.out.println("Удаление 0 элемента:");
        list.remove(0);
        System.out.println(list);
        System.out.println("Удаление всех элементов:");
        list.delete();
        System.out.println(list);

    }
    private static final int DEFAULT_CAPACITY = 10; // начальный размер массива
    private String[] elements;
    private int index;

    public DynamicStringList() {
        elements = new String [DEFAULT_CAPACITY];
    }

    public DynamicStringList(int capacity) {
        elements = new String[capacity];
    }

    public void add(String element) {
        if (index == elements.length)
            growArray();
        elements[index++] = element;
    }

    private void growArray() {
        String[] newArray = new String[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index - 1);
        elements = newArray;
    }

    public String get() {
        return elements[index - 1];
    }


    public String get(int id) {

        return elements[id];
    }

    public String remove() {
        String result = elements[index - 1];
        index--;
        return result;
    }

    public String remove(int id) {
        String result = get(id);
        System.arraycopy(elements, id+1 , elements, id, index - id -1);
        index--;
        return result;
    }

    public boolean delete() {
        if (index == 0)
            return false;

        index = 0;
        elements = new String[DEFAULT_CAPACITY];
        return true;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < index; i++) {
            result += elements[i] + " |";
        }
        result += "]";
        return result;
    }


}
