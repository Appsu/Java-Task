import java.sql.*;
import java.util.*;

public class Task4 {

    private DataSource dataSource;

    public List<ReportEntry> fetchMonthlyReport(String accountId,
                                                int month,
                                                int year) throws SQLException {

        List<ReportEntry> entries = new ArrayList<>();

        // FIX: Use try-with-resources for automatic resource cleanup
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM report_entries " +
                "WHERE account_id = ? AND MONTH(entry_date) = ? " +
                "AND YEAR(entry_date) = ?")) {

            ps.setString(1, accountId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            // FIX: ResultSet also closed automatically
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    entries.add(mapRow(rs));
                }
            }
        }

        return entries;
    }

    private ReportEntry mapRow(ResultSet rs) {
        return null;
    }
}
