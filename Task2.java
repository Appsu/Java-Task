
public class Task2Analysis {

    /*
     * 1. What is the exact cause of ConcurrentModificationException in Java?
     *
     * ConcurrentModificationException occurs when a collection
     * is modified while it is being iterated using an Iterator
     * or enhanced for-loop, except through iterator.remove().
     */

    /*
     * 2. What code pattern at line 142 most likely triggered this error?
     *
     * Example:
     *
     * for (Transaction tx : transactions) {
     *     if (tx.isInvalid()) {
     *         transactions.remove(tx);
     *     }
     * }
     *
     * The collection is modified during iteration.
     */

    /*
     * 3. Minimal safe fix
     *
     * Iterator<Transaction> iterator = transactions.iterator();
     *
     * while (iterator.hasNext()) {
     *     Transaction tx = iterator.next();
     *
     *     if (tx.isInvalid()) {
     *         iterator.remove();
     *     }
     * }
     *
     * iterator.remove() safely removes elements during iteration.
     */
}
