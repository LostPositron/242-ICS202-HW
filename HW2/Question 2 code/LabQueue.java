// Loay Shqair, 202365030
import java.util.LinkedList;
public class LabQueue<T> {
    LinkedList<T> pool;

    public LabQueue() {
        pool = new LinkedList<T>();
    }

    public void clear() {
        pool.clear();
    }

    public boolean isEmpty() {
        return pool.isEmpty();
    }

    public T firstEl() {

        return pool.getFirst();
    }

    public T dequeue() {

        return pool.removeFirst();
    }

    public void enqueue(T el) {

        pool.add(el);
    }

    public String toString() {

        return pool.toString();
    }


    public void rotate(int rot) {
        for (int i = 0; i < rot; i++) {
            enqueue(dequeue());
        }
    }


    //transformable ensures:
    // 1- an opening brace is not followed by another opening brace before it is closed
    // 2- a closing brace is immediately preceded by a number immediately preceded by a space
    // 3- a closing brace is always preceded by an opening brace
    // If these conditions are not satisfied, the transform method will return the input string unmodified
    public boolean transformable(String example) {
        int count = 0;
        for (int i = 0; i < example.length(); i++) {
            if (example.charAt(i) == '{')
                count++;
            else if (example.charAt(i) == '}') {
                int j = 1;
                while (Character.isDigit(example.charAt(i - j)))
                    j++;
                if (!Character.isSpaceChar(example.charAt(i - j)) || j == 1)
                    return false;
                count--;
            }
                if (count < 0 || count > 1)
                    return false;
        }
        return true;
    }

    // No example was given for multiple spaces between 2 words, so I assumed the liberty of choosing how to deal with such a case
    // The extra spaces are included with the word that they follow (they come to the left of);
    public String transform(String example) {

        if (!transformable(example))
            return example;

        // if transformable, transform
        StringBuilder sb = new StringBuilder();
        int end = 0;
        int start = end;
        boolean process = false;
        char readChar;
        String rotString;
        int rotations;

        while (end < example.length()) {
            readChar = example.charAt(end);

            if (readChar == '{') {
                process = true;
                start = end+1;
                end++;
                continue;
            }
            if (process) {
                if (readChar == ' ') {
                    if (example.charAt(end + 1) != ' ') {
                        this.enqueue((T) example.substring(start, end+1));
                        start = end+1;
                    }
                }
            } else {
                sb.append(readChar);
            }

            if (readChar == '}') {
                rotString = example.substring(start, end);
                rotations = Integer.parseInt(rotString);
                this.rotate(rotations);
                while (!this.isEmpty()) {
                    sb.append(this.dequeue());
                }
                process = false;
            }

            end++;
        }
        while (!this.isEmpty()) {
            System.out.println(this.dequeue());
        }
        return sb.toString();
    }
}
