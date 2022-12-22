public class Category {
    String name;

    String description;
    boolean isExpenseCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpenseCategory() {
        return isExpenseCategory;
    }

    public void setExpenseCategory(boolean expenseCategory) {
        isExpenseCategory = expenseCategory;
    }
}
