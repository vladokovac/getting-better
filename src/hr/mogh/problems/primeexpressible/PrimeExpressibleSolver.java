package hr.mogh.problems.primeexpressible;

import java.util.*;

/**
 * Solves the following problem:
 * <p/>Given a prime set, we call "prime expressible" if a number can be factorized only using given prime numbers.
 * Find n-th big expressible number.
 * <p/>
 * E.g., prime set = {2, 3}
 * expressible number = {1,2,3,4,6,8, 9, 12...}
 * non-expressible number = {5, 10... }
 * <p/>
 * The primes in the prime set are ordered in an increasing order, and can include a prime < 10^4 (don't remember the
 * exact range), and n can also be as large as 1-10^6.
 * Created by vlado on 1.11.2015.
 */
public class PrimeExpressibleSolver {
    public static Double getNthExpressibleNumber(Set<Double> primeSet, int n) {
        Double nthNumber = 0.0;

        Set<Double> uniqueNumbersSet = new HashSet<>();
        uniqueNumbersSet.add(1.0);
        uniqueNumbersSet.addAll(primeSet);
        List<Double> allNumbersList = new ArrayList<>();
        allNumbersList.addAll(uniqueNumbersSet);

        int requiredListSize = -1;
        while (requiredListSize < n) {
            requiredListSize++;
            requiredListSize = requiredListSize * (requiredListSize + 1) / 2;
        }

        int i = 0;
        while (allNumbersList.size() < requiredListSize) {
            for (int j = i; j >= 0; j--) {
                double factorizedNumber = allNumbersList.get(j) * allNumbersList.get(i);
                if (!uniqueNumbersSet.contains(factorizedNumber)) {
                    uniqueNumbersSet.add(factorizedNumber);
                    allNumbersList.add(factorizedNumber);
                }
            }
            i++;
        }

        Collections.sort(allNumbersList);
        nthNumber = allNumbersList.get(n - 1);
        return nthNumber;
    }

}
