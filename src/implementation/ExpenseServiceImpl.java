package implementation;
import java.sql.*;
import model.Expense;
import service.ExpenseService;
import util.DBConnection;
public class ExpenseServiceImpl implements ExpenseService {
	 Connection con = DBConnection.getConnection();

	    @Override
	    public void addExpense(Expense expense) {

	        try {
	            String query = "INSERT INTO expenses VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, expense.getId());
	            ps.setString(2, expense.getCategory());
	            ps.setDouble(3, expense.getAmount());
	            ps.setString(4, expense.getDate());
	            ps.setString(5, expense.getDescription());

	            ps.executeUpdate();
	            System.out.println("✅ Expense Added Successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void viewAllExpenses() {

	        try {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM expenses");

	            System.out.println("\n--- Expense List ---");

	            while (rs.next()) {
	                System.out.println(
	                    rs.getInt(1) + " | " +
	                    rs.getString(2) + " | " +
	                    rs.getDouble(3) + " | " +
	                    rs.getString(4) + " | " +
	                    rs.getString(5)
	                );
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteExpense(int id) {

	        try {
	            String query = "DELETE FROM expenses WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, id);
	            ps.executeUpdate();

	            System.out.println("🗑 Expense Deleted Successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void totalExpense() {

	        try {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT SUM(amount) FROM expenses");

	            if (rs.next()) {
	                System.out.println("💰 Total Expense: " + rs.getDouble(1));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
