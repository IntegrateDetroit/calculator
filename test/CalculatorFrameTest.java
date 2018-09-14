import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorFrameTest {



    CalculatorFrame calculatorFrame;
    JTextField textField;

    @BeforeEach
    public void setUp(){
        calculatorFrame = new CalculatorFrame();
        textField = calculatorFrame.getTextField();
    }


    @Test
    public void constructor_initializesFrame_withContent(){

        assertThat(calculatorFrame.getSize().height).isEqualTo(700);
        assertThat(calculatorFrame.getSize().width).isEqualTo(500);
        assertThat(calculatorFrame.getTitle()).isEqualTo("Calculator");

        JPanel display = calculatorFrame.getRoot();
        assertThat(display.getName()).isEqualTo("display");
        BorderLayout rootLayout = (BorderLayout) display.getLayout();

        JTextField textField = (JTextField) display.getComponent(0);
        assertThat(rootLayout.getConstraints(textField)).isEqualTo(BorderLayout.NORTH);
        assertThat(textField.getFont().getSize()).isEqualTo(24);

        JPanel buttonPanel = (JPanel) display.getComponent(1);
        assertThat(rootLayout.getConstraints(buttonPanel)).isEqualTo(BorderLayout.CENTER);
        assertThat(buttonPanel.getName()).isEqualTo("buttons");
        GridLayout buttonLayout = (GridLayout) buttonPanel.getLayout();
        assertThat(buttonLayout.getColumns()).isEqualTo(2);
        assertThat(buttonLayout.getRows()).isEqualTo(3);

        Component[] buttons =  buttonPanel.getComponents();
        assertThat(buttons.length).isEqualTo(6);
    }

    @Test
    public void addButton_addsAndDisplays(){
        JButton add = calculatorFrame.getAdd();

        textField.setText("1, 2, 3");
        add.doClick();
        assertThat(textField.getText()).isEqualTo("6");
    }

    @Test
    public void averageButton_averagesAndDisplays(){
        JButton average = calculatorFrame.getAverage();

        textField.setText("1, 2, 3");
        average.doClick();
        assertThat(textField.getText()).isEqualTo("2.0");
    }

    @Test
    public void modButton_modsAndDisplays(){
        JButton mod = calculatorFrame.getMod();

        textField.setText("10, 2");
        mod.doClick();
        assertThat(textField.getText()).isEqualTo("0");
    }

    @Test
    public void primeButton_determinesAndDisplays(){
        JButton prime = calculatorFrame.getPrime();

        textField.setText("10");
        prime.doClick();
        assertThat(textField.getText()).isEqualTo("Not prime");
    }

    @Test
    public void subtractButton_subtractsAndDisplays(){
        JButton subtract = calculatorFrame.getSubtract();

        textField.setText("10, 12");
        subtract.doClick();
        assertThat(textField.getText()).isEqualTo("-2");
    }

    @Test
    public void squareRoot_determinesAndDisplays(){
        JButton sqrt = calculatorFrame.getSquareRoot();

        textField.setText("16");
        sqrt.doClick();
        assertThat(textField.getText()).isEqualTo("4.0");
    }
}