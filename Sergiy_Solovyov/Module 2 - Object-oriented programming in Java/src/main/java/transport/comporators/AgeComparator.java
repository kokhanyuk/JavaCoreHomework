package transport.comporators;

import transport.carriages.Carriage;

import java.util.Comparator;

/**
 * @author Sergey Solovyov
 * @version 1.0
 * @since 07.03.2016
 */
public class AgeComparator implements Comparator<Carriage> {
    @Override
    public int compare(Carriage o1, Carriage o2) {

        if (o1 == null || o2 == null) return 0;
        return o1.getAge() - o2.getAge();
    }
}
