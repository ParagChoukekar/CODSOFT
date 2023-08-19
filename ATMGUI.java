import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMGUI extends JFrame {
    private BankAccount account = new BankAccount(1000.0); // Initial balance

    private JLabel balanceLabel = new JLabel("Balance: $1000.0");
    private JTextField amountField = new JTextField(10);
    private JLabel messageLabel = new JLabel();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATMGUI atm = new ATMGUI();
            atm.setVisible(true);
        });
    }

    public ATMGUI() {
        setTitle("ATM Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());
        
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        add(balanceLabel);
        add(amountField);
        add(depositButton);
        add(withdrawButton);
        add(messageLabel);
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            updateBalance();
            messageLabel.setText("Deposit successful.");
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid amount.");
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (account.withdraw(amount)) {
                updateBalance();
                messageLabel.setText("Withdrawal successful.");
            } else {
                messageLabel.setText("Insufficient balance.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid amount.");
        }
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
