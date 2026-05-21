import java.util.*;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Handle null accounts list safely
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {

            // FIX: Check dueDate for null before calling before()
            if (account.getDueDate() != null &&
                account.getDueDate().before(new Date())) {

                // FIX: Only include accounts with balance greater than zero
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
