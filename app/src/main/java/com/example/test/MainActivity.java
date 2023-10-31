package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 游戏面板布局
    private GridLayout gameBoard;

    // 数独矩阵，0 表示空
    private int[][] matrix = new int[9][9];

    // 数独求解器
    private SudokuSolver solver = new SudokuSolver();

    // 游戏计时器
    private CountDownTimer timer;

    /*private void displayMatrix(int[][] matrix, GridLayout gameBoard) {
        // 先清空面板
        for (int i = 0; i < gameBoard.getChildCount(); i++) {
            gameBoard.getChildAt(i).setText("");
        }

        // 填充新的数独矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ((EditText) gameBoard.getChildAt(i * 9 + j)).setText(String.valueOf(matrix[i][j]));
            }
        }
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化游戏面板
        gameBoard = findViewById(R.id.game_board);
        gameBoard.setAlignmentMode(GridLayout.ALIGN_MARGINS);
        gameBoard.setColumnOrderPreserved(false);
        gameBoard.setUseDefaultMargins(true);
        gameBoard.setPadding(1, 1, 1, 1);

        // 新游戏按钮s
        Button buttonNewGame = findViewById(R.id.button_new_game);
        buttonNewGame.setOnClickListener(v -> {/*
            // 生成新的数独矩阵
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    matrix[i][j] = generateNumber(); // 你需要实现 generateNumber 方法来生成1-9之间的随机数
                }
            }
            // 解决数独矩阵
            solver.solve(matrix);
            // 将数独矩阵显示在游戏面板上
            displayMatrix(matrix,gameBoard); // 你需要实现 displayMatrix 方法来将数独矩阵显示在游戏面板上
        */});

        // 检查按钮
        Button buttonCheck = findViewById(R.id.button_check);
        buttonCheck.setOnClickListener(v -> {
            // 检查数独矩阵是否正确
            boolean isCorrect = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    EditText editText = (EditText) gameBoard.getChildAt(i * 9 + j);
                    if (matrix[i][j] != Integer.parseInt(editText.getText().toString())) {
                        isCorrect = false;
                        editText.setTextColor(Color.RED);
                    } else {
                        editText.setTextColor(Color.BLACK);
                    }
                }
            }
            if (isCorrect) {
                // 这里可以添加数独解法的逻辑，或者弹出消息提示数独已经完成等操作。
                Toast.makeText(MainActivity.this, "正确!", Toast.LENGTH_SHORT).show();
            } else {
                // 这里可以添加数独不正确的逻辑，或者弹出消息提示数独有误等操作。
                Toast.makeText(MainActivity.this, "不正确!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}