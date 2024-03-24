import java.util.Stack;

public final class StringBuilderTest {
    private StringBuilder stringBuilder;
    private Stack<StringBuilder> stack;

    public StringBuilderTest() {
        stringBuilder = new StringBuilder();
        stack = new Stack<StringBuilder>();
    }

    public StringBuilderTest append(String str) {
        stack.add(new StringBuilder(stringBuilder));
        stringBuilder.append(str);
        return this;
    }

    public StringBuilderTest delete(int start, int end) {
        try {
            stack.add(new StringBuilder(stringBuilder));
            stringBuilder.delete(start, end);
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    public StringBuilderTest replace(int start, int end, String str) {
        try {
            stack.add(new StringBuilder(stringBuilder));
            stringBuilder.replace(start, end, str);
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    public StringBuilderTest insert(int offset, Object obj) {
        try {
            stack.add(new StringBuilder(stringBuilder));
            stringBuilder.insert(offset, obj);
        } catch (Exception e) {
            stack.pop();
            System.err.println(e.getMessage());
        }
        return this;
    }

    public StringBuilderTest reverse() {
        stack.add(new StringBuilder(stringBuilder));
        stringBuilder.reverse();
        return this;
    }

    public void undo() {
        if(!stack.isEmpty()){
            stringBuilder = stack.pop();
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
