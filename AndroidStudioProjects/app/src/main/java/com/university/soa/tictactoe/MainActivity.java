package com.university.soa.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



        int activePlayer = 0;
        int[] gameState = (2,2,2,2,2,2,2,2,2);
        int[][] winningLocations = ((0,1,2),(3,4,5),(6,7,8),(0,3,6),(1,4,7),(2,5,8),(0,4,8),(2,4,6));
        boolean gameOver = false;

        public void gamelogic(View view) {

            ImageView tappedView = (ImageView) view;
            int tappedLocation = Integer.parseInt(view.getTag().toString());
            if (gameState[tappedLocation] == 2 && !gameOver) {
                boolean b = gameState[tappedLocation] == activePlayer;
            }
            tappedView.setTranslationY(-3000f);
            if (activePlayer == 0) {
                tappedView.setImageResource(R.drawable.heart)
                activePlayer = 1;
            } else if (activePlayer == 1) {
                tappedView.setImageResource(R.drawable.tick);
                activePlayer = 0;
            }
            tappedView.animate().translationYBy(3000f).setDuration(500);

        }
    for(int[] winningPosition :winningLocations)

        {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                    && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                    && gameState[winningPosition[0]] != 2) {
                if (activePlayer == 0)
                    Toast.makeText(getApplicationContext(), "i hate u", Toast.LENGTH_LONG).show();
                if (activePlayer == 1)
                    Toast.makeText(getApplicationContext(), "i love u", Toast.LENGTH_SHORT).show();
                gameOver = true;
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
        winnerLayout.setVisiblity(View.INVISIBLE);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
