public class Main {

    public static void main(String[] args) {
        StringBuilderTest sbt = new StringBuilderTest();
        sbt.append("test");
        System.out.println(sbt.toString());
        sbt.append(2);
        StringBuilderTest sbt2 = new StringBuilderTest(sbt);
        System.out.println(sbt2.toString());
        StringBuilderTest sbt3 = new StringBuilderTest("test3");
        System.out.println(sbt3.toString());

        System.out.println(sbt.delete(4, 5).toString());

        System.out.println(sbt3.compareTo(sbt));
        System.out.println(sbt.compareTo(sbt3));
        System.out.println(sbt3.compareTo(sbt2));
        System.out.println(sbt3.deleteCharAt(4).toString());
        System.out.println(sbt3.compareTo(sbt));

        System.out.println(sbt2.replace(0, 3, "aaa").toString());

        System.out.println(sbt2.insert(0, "nnn").toString());
        System.out.println(sbt2.insert(2, 333).toString());


        StringBuilderTest sbt4 = new StringBuilderTest("12345");
        System.out.println(sbt4.toString());
        System.out.println(sbt4.reverse());
        sbt4.undo();
        System.out.println(sbt4.toString());
    }
}
