package com.university.soa.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningLocation = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8},{2,4,6},{0,4,8}};
    boolean gameOver = false;

    public void gameLogic(View view) {
        ImageView tappedView = (ImageView) view;

        int tappedLocation = Integer.parseInt(view.getTag().toString());

        if (gameState[tappedLocation] == 2) {
            gameState[tappedLocation] = activePlayer;


            tappedView.setTranslationY(-3000f);

            if (activePlayer == 0) {

                tappedView.setImageResource(R.drawable.broken1);
                activePlayer = 1;
            } else if (activePlayer == 1) {
                tappedView.setImageResource(R.drawable.heart);
                activePlayer = 0;
            }
            tappedView.animate().translationYBy(3000f).setDuration(500);

        }
        String msg = "";
        for (int[] winningPosition : winningLocation) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]]
                    && gameState[winningPosition[0]] != 2) {
                if (activePlayer == 0)
                    msg = "i love u";
                if (activePlayer == 1)
                    msg = "i hate u";
                gameOver = true;


                LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
                winnerLayout.setVisibility(View.VISIBLE);

                TextView winnermsg = (TextView) findViewById(R.id.textView);
                winnermsg.setText(msg);

            }

        }
    }
    public void playAgain(View view){
        LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);

        gameOver =  false;
        activePlayer = 0;

        for(int i =0;i < gameState.length;i++)
            gameState[i] = 2;
        GridLayout gridlayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i=0; i< gridlayout.getChildCount();i++)
            ((ImageView)gridlayout.getChildAt(i)).setImageResource(0);

    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);


    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}

