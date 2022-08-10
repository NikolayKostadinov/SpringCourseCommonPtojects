import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

public class test {
    public static void main(String[] args) {
        // AtomicReference with value
        AtomicReference<Integer> ref
                = new AtomicReference<>(3456);

        // Value to apply getAndAccumulate
        int x = 45654;

        // Declaring the accumulatorFunction
        // applying function to add value as string
        BinaryOperator add
                = (u, v) -> u.toString() + v.toString();

        // apply getAndAccumulate()
        int value = ref.getAndAccumulate(x, add);

        // print AtomicReference
        System.out.println(
                "The AtomicReference previous value: "
                        + value);
        System.out.println(
                "The AtomicReference new value: "
                        + ref.get());
    }
}
