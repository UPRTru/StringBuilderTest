import java.util.Stack;

public final class StringBuilderTest implements java.io.Serializable, CharSequence {
    char[] value;
    int count;
    Stack<StringBuilderTest> stack;

    public StringBuilderTest() {
        value = new char[0];
        stack = new Stack<StringBuilderTest>();
    }

    public StringBuilderTest(String str) {
        value = new char[0];
        stack = new Stack<StringBuilderTest>();
        newStringBuilderTest(str);
    }

    public StringBuilderTest(StringBuilderTest sbt) {
        value = new char[0];
        stack = new Stack<StringBuilderTest>();
        newStringBuilderTest(sbt.toString());
    }

    public void newStringBuilderTest(String str) {
        try {
            if (str == null) {
                throw new NullPointerException();
            }
            int length = str.toCharArray().length;
            ensureCapacityInternal(count + length);
            str.getChars(0, length, value, count);
            count += length;
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }

    }

    public int compareTo(StringBuilderTest another) {
        return toString().compareTo(another.toString());
    }

    public StringBuilderTest append(Object obj) {
        return append(String.valueOf(obj));
    }

    public StringBuilderTest append(String str) {
        try {
            stack.add(new StringBuilderTest(toString()));
            if (str == null) {
                throw new NullPointerException();
            }
            int length = str.length();
            ensureCapacityInternal(count + length);
            str.getChars(0, length, value, count);
            count += length;
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        char[] newValue = new char[minimumCapacity];
        System.arraycopy(value,  0, newValue,  0, count);
        value = newValue;
    }

    public StringBuilderTest delete(int start, int end) {
        try {
            stack.add(new StringBuilderTest(toString()));
            int count = this.count;
            if (end > count) {
                end = count;
            }
            int len = end - start;
            if (len > 0) {
                shift(end, -len);
                this.count = count - len;
                ensureCapacityInternal(this.count);
            }
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    public StringBuilderTest deleteCharAt(int index) {
        try {
            stack.add(new StringBuilderTest(toString()));
            shift(index + 1, -1);
            count--;
            ensureCapacityInternal(this.count);
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    public StringBuilderTest replace(int start, int end, String str) {
        try {
            stack.add(new StringBuilderTest(toString()));
            int count = this.count;
            if (end > count) {
                end = count;
            }
            if (end - start == str.length()) {
                int len = str.length();
                str.getChars(0, end, value, start);
            } else {
                throw new StringIndexOutOfBoundsException();
            }
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    public StringBuilderTest replace(int start, int end, Object obj) {
        try {
            stack.add(new StringBuilderTest(toString()));
            replace(start, end, String.valueOf(obj));
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    private void shift(int offset, int n) {
        System.arraycopy(value, offset, value, offset + n, count - offset);
    }

    public StringBuilderTest insert(int offset, String str) {
        try {
            stack.add(new StringBuilderTest(toString()));
            int len = str.length();
            ensureCapacityInternal(count + len);
            if (offset > 0 && offset != count) {
                System.arraycopy(value, 0, value, 0, offset);
                System.arraycopy(value, offset, value, offset + len, count - offset);
            } else {
                System.arraycopy(value, 0, value, offset + len, count);
            }
            str.getChars(0, len, value, offset);
            count += len;
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    public StringBuilderTest insert(int offset, Object obj) {
        try {
            stack.add(new StringBuilderTest(toString()));
            insert(offset, String.valueOf(obj));
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    public StringBuilderTest reverse() {
        stack.add(new StringBuilderTest(toString()));
        char[] val = this.value;
        int count = this.count;
        int n = count - 1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = val[j];
            val[j] = val[k];
            val[k] = cj;
        }
        return this;
    }

    public void undo() {
        if(!stack.isEmpty()){
            StringBuilderTest oldStringBuilder = stack.pop();
            count = oldStringBuilder.count;
            value = oldStringBuilder.value;
            stack = oldStringBuilder.stack;
        }
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        return value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }
}
