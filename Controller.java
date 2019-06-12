package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import javax.swing.*;

public class Controller {

    Forza4 forza4 = new Forza4();

    @FXML
    private HBox horizontal;

    @FXML
    private ToggleButton player1;

    @FXML
    private ToggleButton player2;

    public void initialize(){
        this.player1.fire();
    }

    public void refresh(){
        ObservableList<Node> vBoxes = horizontal.getChildren();
        for(int i=0;i<7;i++) {
            VBox vbox = (VBox) vBoxes.get(i);
            for (int j = 0; j < 6; j++) {
                Circle circle = (Circle) (vbox.getChildren().get(5-j));
                if (this.forza4.grid[j][i] == 1)
                    circle.setFill(Color.RED);
                else if (this.forza4.grid[j][i] == 5)
                    circle.setFill(Color.YELLOW);
                else
                    circle.setFill(Color.WHITE);
            }
        }
    }

    public void choice(String message){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                Object[] options = {"YES", "NO"};

                int choice =JOptionPane.showOptionDialog(null, message+",PLAY AGAIN?", "Result",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(choice == 0){
                    forza4.reset();
                    refresh();
                }
                else
                    System.exit(0);

            }
        });
        t1.start();

    }

    public void addCoin(int i){
        try {
            this.player1.fire();
            this.player2.fire();
            Boolean result = forza4.addCoin(i, forza4.nextPlayer());
            if (result == null)
                choice("DRAW");
            else if (result == true)
                choice("YOU WIN");
            refresh();
        } catch (Exception e){}
    }

    public void click1(MouseEvent mouseEvent){
        addCoin(0);
    }

    public void click2(MouseEvent mouseEvent){
        addCoin(1);
    }

    public void click3(MouseEvent mouseEvent){
        addCoin(2);
    }

    public void click4(MouseEvent mouseEvent){
        addCoin(3);
    }

    public void click5(MouseEvent mouseEvent){
        addCoin(4);
    }

    public void click6(MouseEvent mouseEvent){
        addCoin(5);
    }

    public void click7(MouseEvent mouseEvent){
        addCoin(6);
    }

    public void clickButton(ActionEvent actionEvent) {
        forza4.reset();
        refresh();
    }
}
