package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClicked=-1;

    int player=1;
    int [][]winningStages={{0,1,2},{3,4,5},{6,7,8}};
    int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){
        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        imageClicked=gameState[tag];
        if(isWinner==false && imageClicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.img);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }

            for (int i = 0; i < winningStages.length; i++) {
                if (gameState[winningStages[i][0]] == gameState[winningStages[i][1]] && gameState[winningStages[i][1]] == gameState[winningStages[i][2]] && gameState[winningStages[i][0]] >-1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }

            for (int i = 0; i < winningStages.length; i++) {
                if (gameState[winningStages[0][i]] == gameState[winningStages[1][i]] && gameState[winningStages[1][i]] == gameState[winningStages[2][i]] && gameState[winningStages[0][i]] >-1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }

              if (gameState[winningStages[0][0]] == gameState[winningStages[1][1]] && gameState[winningStages[1][1]] == gameState[winningStages[2][2]] && gameState[winningStages[0][0]] >-1) {
                Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                isWinner=true;
            }
              if (gameState[winningStages[0][2]] == gameState[winningStages[1][1]] && gameState[winningStages[1][1]] == gameState[winningStages[2][0]] && gameState[winningStages[0][2]] >-1) {
                Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                isWinner=true;
            }
        }
    }
    public void reset(View view){
        GridLayout gridlayout=findViewById(R.id.gridlayout);
        int total_images= gridlayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v=(ImageView) gridlayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageClicked=-1;
        player=1;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=-1;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}