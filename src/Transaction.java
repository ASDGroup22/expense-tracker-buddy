import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private double amount;
    private boolean isIncome;
    private String category;
    private String note;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    private boolean isRecurring;

    public Transaction(double amount, boolean isIncome, String category, String note, Date date, boolean isRecurring) {
        this.amount = amount;
        this.isIncome = isIncome;
        this.category = category;
        this.note = note;
        this.date = date;
        this.isRecurring = isRecurring;
    }

    @Override
    public String toString() {
        // Format the date using a SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(date);

        // Format the transaction information as a table row
        StringBuilder sb = new StringBuilder();
        sb.append("| ").append(formattedDate).append(" | ");
        sb.append(String.format("%10.2f", amount)).append(" | ");
        sb.append(isIncome ? " Income   " : " Expense  ").append(" | ");
        sb.append(String.format("%-20s", category)).append(" | ");
        sb.append(isRecurring ? " Yes   " : " No  ").append(" | ");
        sb.append(String.format("%-20s", note)).append(" |");

        return sb.toString();
    }
}
