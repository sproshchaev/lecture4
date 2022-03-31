package sbp.compare;

/**
 * Написать компаратор CustomDigitComparator, который реализует интерфейс Comparator<Integer>.
 * Класс CustomDigitComparator определяет следующий порядок:
 * Сначала четные числа, затем нечетные;
 * На вход подаются числа, отличные от null;
 */
import java.util.*;

public class CustomDigitComparator implements Comparator<Integer>  {

    @Override
    public int compare(Integer o1, Integer o2)  {

        if (o1 == o2) { return 0; }

        if (o1 % 2 == 0) {
            return -1;
        } else {
            if (o2 % 2 != 0) {
                return -1;
            } else {
                return 1;
            }
        }

    }

}
