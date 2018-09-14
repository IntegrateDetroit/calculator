import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class CalculatorFrame extends JFrame {
    private JPanel root;
    private JTextField textField;

    JButton add;
    JButton subtract;
    JButton mod;
    JButton average;
    JButton squareRoot;
    JButton prime;

    public CalculatorFrame() {
        super();
        initialize();
    }

    private void initialize(){
        setUpFrame();

        createRootPanel();

        populateRootPanel();

        this.setVisible(true);
    }

    private void setUpFrame() {
        this.setSize(500, 700);
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createRootPanel() {
        root = new JPanel();
        root.setName("display");
        root.setLayout(new BorderLayout());
        this.setContentPane(root);
    }

    private void populateRootPanel() {
        addInputTextField();

        addButtons();
    }

    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setName("buttons");
        buttonPanel.setLayout(new GridLayout(3,2));

        createAndAddButtons(buttonPanel);

        addActionListeners();
        root.add(buttonPanel, BorderLayout.CENTER);
    }

    private void addActionListeners() {
        add.addActionListener((e)->{
            LinkedList<Integer> numbers = getNumbers();
            int sum = CalculatorController.add(numbers);
            setTextFieldContent(sum+"");
        });

        subtract.addActionListener((e)->{
            LinkedList<Integer> numbers = getNumbers();
            int result = CalculatorController.subtract(numbers);
            setTextFieldContent(result+"");
        });

        mod.addActionListener((e)->{
            LinkedList<Integer> numbers = getNumbers();
            int result = CalculatorController.mod(numbers.get(0), numbers.get(1));
            setTextFieldContent(result+"");

        });

        average.addActionListener((e)->{
            LinkedList<Integer> numbers = getNumbers();
            double result = CalculatorController.average(numbers);
            setTextFieldContent(result+"");

        });

        squareRoot.addActionListener((e)->{
            int number = getNumber();
            double result = CalculatorController.squareRoot(number);
            setTextFieldContent(result+"");
        });

        prime.addActionListener((e)->{
            int number = getNumber();
            boolean result = CalculatorController.prime(number);
            if (result) {
                setTextFieldContent("Prime");
            } else{
                setTextFieldContent("Not prime");
            }
        });
    }

    private void createAndAddButtons(JPanel buttonPanel) {
        add = new JButton("+");
        subtract = new JButton("-");
        mod = new JButton("%");
        average = new JButton("ave");
        squareRoot = new JButton("SQRT");
        prime = new JButton("prime?");

        buttonPanel.add(add);
        buttonPanel.add(subtract);
        buttonPanel.add(mod);
        buttonPanel.add(average);
        buttonPanel.add(squareRoot);
        buttonPanel.add(prime);
    }

    private void addInputTextField() {
        textField = new JTextField();
        textField.setFont(new Font("Arial", NORMAL, 24));
        root.add(textField, BorderLayout.NORTH);
    }

    private LinkedList<Integer> getNumbers() {
        String input = textField.getText();
        String[] split = input.split(", ");
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < split.length; i++){
            numbers.add(i, Integer.parseInt(split[i]));
        }
        return numbers;
    }

    private int getNumber() {
        String input = textField.getText();
        return Integer.parseInt(input);
    }

    public void setTextFieldContent(String content){
        this.textField.setText(content);
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getAverage() {
        return average;
    }

    public JButton getMod() {
        return mod;
    }

    public JButton getPrime() {
        return prime;
    }

    public JButton getSquareRoot() {
        return squareRoot;
    }

    public JButton getSubtract() {
        return subtract;
    }

    public JPanel getRoot() {
        return root;
    }

    public JTextField getTextField() {
        return textField;
    }
}