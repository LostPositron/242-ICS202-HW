// Loay Shqair, 202365030
public class q2Test {
    public static void main(String[] args) {
        LabQueue<String> q = new LabQueue<>();
        String example;

        example = "Check this {example out 1} now";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));

        example = "Here is {another tricky test 2} example";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));

        example = "{one two three four 3} outside {five six 1}";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));

        example = "No curly braces here!";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));

        example = "Unmatched {example 2 or missing number}";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));

        example = "Spaces are preserved {Yes    they  are 2}";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));

        example = "Mismatched or nested {braces{ are3 } weird 5} and ugly";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));

        example = "Imagine a number {not preceding a closing }brace character";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));

        example = "So many {rotations make me dizzy 1911} wooo";
        System.out.println("Example = "+example);
        System.out.println(q.transform(example));
        }

    }
