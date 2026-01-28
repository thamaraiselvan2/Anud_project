package service;

import model.Expense;

public interface ExpenseService {
	  void addExpense(Expense expense);

	    void viewAllExpenses();

	    void deleteExpense(int id);

	    void totalExpense();
}
