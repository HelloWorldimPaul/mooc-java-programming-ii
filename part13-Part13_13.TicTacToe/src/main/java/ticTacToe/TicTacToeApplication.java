
package ticTacToe;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private Button[][] board = new Button[3][3];
    private Label playerLabel = new Label("X");
    private Label statusLabel = new Label("Turn: X");

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();
        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        statusLabel.setFont(Font.font("Monospaced", 40));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));
                btn.setPrefSize(100, 100);
                int r = row;
                int c = col;
                btn.setOnAction(e -> handleMove(r, c));
                board[row][col] = btn;
                gridPane.add(btn, col, row); // col first, then row
            }
        }

        layout.setTop(statusLabel);
        BorderPane.setAlignment(statusLabel, Pos.CENTER);
        layout.setCenter(gridPane);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setTitle("Tic Tac Toe");
        window.show();


    }

    private void handleMove(int row, int col) {
        if (!board[row][col].getText().trim().isEmpty()) return;

        board[row][col].setText(playerLabel.getText());

        if (checkWin()) {
            //statusLabel.setText("Winner: " + playerLabel.getText());
            statusLabel.setText("The end!");
            disableBoard();
        } else if (isDraw()) {
            //statusLabel.setText("Draw!");
            disableBoard();
        } else {
            playerLabel.setText(playerLabel.getText().equals("X") ? "O" : "X");
            statusLabel.setText("Turn: " + playerLabel.getText());
        }
    }

    private boolean checkWin() {
        String p = playerLabel.getText();

        // Rows
        for (int row = 0; row < 3; row++) {
            if (p.equals(board[row][0].getText().trim()) &&
                    p.equals(board[row][1].getText().trim()) &&
                    p.equals(board[row][2].getText().trim())) {
                return true;
            }
        }

        // Columns
        for (int col = 0; col < 3; col++) {
            if (p.equals(board[0][col].getText().trim()) &&
                    p.equals(board[1][col].getText().trim()) &&
                    p.equals(board[2][col].getText().trim())) {
                return true;
            }
        }

        // Diagonals
        if (p.equals(board[0][0].getText().trim()) &&
                p.equals(board[1][1].getText().trim()) &&
                p.equals(board[2][2].getText().trim())) {
            return true;
        }
        if (p.equals(board[0][2].getText().trim()) &&
                p.equals(board[1][1].getText().trim()) &&
                p.equals(board[2][0].getText().trim())) {
            return true;
        }

        return false;
    }

    private boolean isDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].getText().trim().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].setDisable(true);
            }
        }
    }




    public static void main(String[] args) {

        System.out.println("Hello world!");
        launch(TicTacToeApplication.class);
    }

}







/*
package ticTacToe;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();
        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        Label player = new Label("X");

        Label label = new Label("Turn: " + player.getText());
        label.setFont(Font.font("Monospaced", 40));

        Button btn1 = new Button(" ");
        btn1.setFont(Font.font("Monospaced", 40));

        Button btn2 = new Button(" ");
        btn2.setFont(Font.font("Monospaced", 40));

        Button btn3 = new Button(" ");
        btn3.setFont(Font.font("Monospaced", 40));

        Button btn4 = new Button(" ");
        btn4.setFont(Font.font("Monospaced", 40));

        Button btn5 = new Button(" ");
        btn5.setFont(Font.font("Monospaced", 40));

        Button btn6 = new Button(" ");
        btn6.setFont(Font.font("Monospaced", 40));

        Button btn7 = new Button(" ");
        btn7.setFont(Font.font("Monospaced", 40));

        Button btn8 = new Button(" ");
        btn8.setFont(Font.font("Monospaced", 40));

        Button btn9 = new Button(" ");
        btn9.setFont(Font.font("Monospaced", 40));

        gridPane.add(btn1, 0, 0);
        gridPane.add(btn2, 0, 1);
        gridPane.add(btn3, 0, 2);
        gridPane.add(btn4, 1, 0);
        gridPane.add(btn5, 1, 1);
        gridPane.add(btn6, 1, 2);
        gridPane.add(btn7, 2, 0);
        gridPane.add(btn8, 2, 1);
        gridPane.add(btn9, 2, 2);

        layout.setTop(label);
        layout.setCenter(gridPane);

        btn1.setOnMouseClicked(e -> {
            if (!btn1.getText().trim().isEmpty()) {

                return;
            }
            btn1.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");
                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());

            }

            boolean gameOver = true;

            boolean allSame = (btn1.getText().trim().equals(btn2.getText().trim()) && btn1.getText().trim().equals(btn3.getText().trim())) ||
                    (btn1.getText().trim().equals(btn4.getText().trim()) && btn1.getText().trim().equals(btn7.getText().trim())) ||
                    (btn1.getText().trim().equals(btn5.getText().trim()) && btn1.getText().trim().equals(btn9.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }

        });

        btn2.setOnMouseClicked(e -> {
            if (!btn2.getText().trim().isEmpty()) {

                return;
            }
            btn2.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");
                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());

            }

            boolean gameOver = true;

            boolean allSame = (btn2.getText().trim().equals(btn5.getText().trim()) && btn2.getText().trim().equals(btn8.getText().trim())) ||
                    (btn2.getText().trim().equals(btn1.getText().trim()) && btn2.getText().trim().equals(btn3.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }

        });

        btn3.setOnMouseClicked(e -> {
            if (!btn3.getText().trim().isEmpty()) {

                return;
            }
            btn3.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");
                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());

            }

            boolean gameOver = true;

            boolean allSame = (btn1.getText().trim().equals(btn6.getText().trim()) && btn3.getText().trim().equals(btn9.getText().trim())) ||
                    (btn3.getText().trim().equals(btn2.getText().trim()) && btn3.getText().trim().equals(btn1.getText().trim())) ||
                    (btn3.getText().trim().equals(btn5.getText().trim()) && btn3.getText().trim().equals(btn7.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }
        });

        btn4.setOnMouseClicked(e -> {
            if (!btn4.getText().trim().isEmpty()) {

                return;
            }
            btn4.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");
                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());

            }

            boolean gameOver = true;

            boolean allSame = (btn4.getText().trim().equals(btn1.getText().trim()) && btn4.getText().trim().equals(btn7.getText().trim())) ||
                    (btn4.getText().trim().equals(btn5.getText().trim()) && btn4.getText().trim().equals(btn6.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }

        });

        btn5.setOnMouseClicked(e -> {
            if (!btn5.getText().trim().isEmpty()) {

                return;
            }
            btn5.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");
                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());

            }

            boolean gameOver = true;

            boolean allSame = (btn5.getText().trim().equals(btn2.getText().trim()) && btn5.getText().trim().equals(btn8.getText().trim())) ||
                    (btn5.getText().trim().equals(btn4.getText().trim()) && btn5.getText().trim().equals(btn6.getText().trim())) ||
                    (btn5.getText().trim().equals(btn1.getText().trim()) && btn5.getText().trim().equals(btn9.getText().trim())) ||
                    (btn5.getText().trim().equals(btn7.getText().trim()) && btn5.getText().trim().equals(btn3.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }

        });

        btn6.setOnMouseClicked(e -> {
            if (!btn6.getText().trim().isEmpty()) {

                return;
            }
            btn6.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");
                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());

            }
            boolean gameOver = true;

            boolean allSame = (btn6.getText().trim().equals(btn3.getText().trim()) && btn6.getText().trim().equals(btn9.getText().trim())) ||
                    (btn6.getText().trim().equals(btn5.getText().trim()) && btn6.getText().trim().equals(btn4.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }

        });

        btn7.setOnMouseClicked(e -> {
            if (!btn7.getText().trim().isEmpty()) {

                return;
            }
            btn7.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");
                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());

            }

            boolean gameOver = true;

            boolean allSame = (btn7.getText().trim().equals(btn4.getText().trim()) && btn7.getText().trim().equals(btn1.getText().trim())) ||
                    (btn7.getText().trim().equals(btn8.getText().trim()) && btn7.getText().trim().equals(btn9.getText().trim())) ||
                    (btn7.getText().trim().equals(btn5.getText().trim()) && btn7.getText().trim().equals(btn3.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }

        });

        btn8.setOnMouseClicked(e -> {
            if (!btn8.getText().trim().isEmpty()) {

                return;
            }
            btn8.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");
                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());
            }
            boolean gameOver = true;

            boolean allSame = (btn8.getText().trim().equals(btn7.getText().trim()) && btn8.getText().trim().equals(btn9.getText().trim())) ||
                    (btn8.getText().trim().equals(btn5.getText().trim()) && btn8.getText().trim().equals(btn2.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }

        });

        btn9.setOnMouseClicked(e -> {
            if (!btn9.getText().trim().isEmpty()) {

                return;
            }
            btn9.setText(player.getText());

            if (player.getText().equals("X")) {
                player.setText("O");

                label.setText("Turn: " + player.getText());

            } else {
                player.setText("X");
                label.setText("Turn: " + player.getText());
            }

            boolean gameOver = true;

            boolean allSame = (btn9.getText().trim().equals(btn8.getText().trim()) && btn9.getText().trim().equals(btn7.getText().trim())) ||
                    (btn9.getText().trim().equals(btn6.getText().trim()) && btn9.getText().trim().equals(btn3.getText().trim())) ||
                    (btn9.getText().trim().equals(btn5.getText().trim()) && btn9.getText().trim().equals(btn1.getText().trim()));

            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    if (btn.getText().trim().isEmpty()) {
                        gameOver = false;
                        break;
                    }
                }
            }

            if (gameOver) {
                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            } else if (allSame) {

                label.setText("The end!");

                for (Node btn : gridPane.getChildren()) {

                    btn.setDisable(true);

                }

            }

        });

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {

        System.out.println("Hello world!");
        launch(TicTacToeApplication.class);
    }

}


 */
