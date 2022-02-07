public class Array {

    protected long[] a;
    protected int nElem;

    public Array(int maxSize) {
        a = new long[maxSize];
        nElem = 0;
    }

    public int getSize() {
        return a.length;
    }

    public int getIndex(long searchKey) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == searchKey)
                return i;

        return -1;
    }

    public boolean insert(long value) {
        if (nElem != a.length) {
            a[nElem] = value;
            nElem++;
            return true;
        }
        return false;
    }

    public boolean delete(long value) {
        int index = getIndex(value);

        if (index == -1)
            return false;

        for (int i = index; i < a.length-1; i++)
            a[i] = a[i + 1];

        nElem--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nElem; i++)
            sb.append(a[i]).append(" ");

        return sb.toString().trim();
    }
}
