package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button i00, i01, i02, i10, i11, i12, i20, i21, i22, res, next;
    TextView pX, pO, turn;
    int count1 = 0, count2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i00 = (Button) findViewById(R.id.i00);
        i01 = (Button) findViewById(R.id.i01);
        i02 = (Button) findViewById(R.id.i02);
        i10 = (Button) findViewById(R.id.i10);
        i11 = (Button) findViewById(R.id.i11);
        i12 = (Button) findViewById(R.id.i12);
        i20 = (Button) findViewById(R.id.i20);
        i21 = (Button) findViewById(R.id.i21);
        i22 = (Button) findViewById(R.id.i22);

        res = (Button) findViewById(R.id.Res);

        pX = (TextView) findViewById(R.id.playerX);
        pO = (TextView) findViewById(R.id.playerO);
        turn = (TextView) findViewById(R.id.turn);


    }

    public void Check() {
        String c00 = (String) i00.getText();
        String c01 = (String) i01.getText();
        String c02 = (String) i02.getText();
        String c10 = (String) i10.getText();
        String c11 = (String) i11.getText();
        String c12 = (String) i12.getText();
        String c20 = (String) i20.getText();
        String c21 = (String) i21.getText();
        String c22 = (String) i22.getText();

        String playerturn = (String) turn.getText();
        Boolean bool_checkwin = false;

        if ((c00 == c10 && c10 == c20) && (c00 == "X"||c00 == "O")) {
            bool_checkwin = true;
        } else if ((c01 == c11 && c11 == c21) && (c01 == "X"||c01 == "O")) {
            bool_checkwin = true;
        } else if ((c02 == c12 && c12 == c22) && (c02 == "X"||c02 == "O")) {
            bool_checkwin = true;
        } else if ((c00 == c01 && c01 == c02) && (c00 == "X"||c00 == "O")) {
            bool_checkwin = true;
        } else if ((c10 == c11 && c11 == c12) && (c10 == "X"||c10 == "O")) {
            bool_checkwin = true;
        } else if ((c20 == c21 && c21 == c22) && (c20 == "X"||c20 == "O")) {
            bool_checkwin = true;
        } else if ((c00 == c11 && c11 == c22) && (c00 == "X"||c00 == "O")) {
            bool_checkwin = true;
        } else if ((c02 == c11 && c11 == c20) && (c02 == "X"||c02 == "O")) {
            bool_checkwin = true;
        }

        if (bool_checkwin) {
            if (playerturn.contains("X")) {
                Toast.makeText(this, "PLAYER X IS THE WINNER", Toast.LENGTH_LONG).show();
                count1++;
                String counttext = (String) pX.getText();
                counttext = counttext.substring(0, counttext.length() - 1) + count1;
                pX.setText(counttext);

            } else {
                Toast.makeText(this, "PLAYER O IS THE WINNER", Toast.LENGTH_LONG).show();
                count2++;
                String text = (String) pO.getText();
                text = text.substring(0, text.length() - 1) + count2;
                pO.setText(text);
            }
            i00.setText("");
            i01.setText("");
            i02.setText("");
            i10.setText("");
            i11.setText("");
            i12.setText("");
            i20.setText("");
            i21.setText("");
            i22.setText("");
        }


    }

    public void Restart(){
        i00.setText("");
        i01.setText("");
        i02.setText("");
        i10.setText("");
        i11.setText("");
        i12.setText("");
        i20.setText("");
        i21.setText("");
        i22.setText("");
        turn.setText("turn: playerX");
        count1 = 0;
        count2 = 0;
        pX.setText("player X: 0");
        pO.setText("player O: 0");
    }

    public void Click(TextView t, Button b) {

        String text = (String) t.getText();
        String full = (String) b.getText();

        if (!full.contains("X")&&!full.contains("O"))
        {
            if (text.contains("X"))
            {
                b.setText("X");
            }
            else if (text.contains("O"))
            {
                b.setText("O");
            }
            Check();
            Draw();
            Change(t);

        }
    }

    public void Change(TextView t) {
        String text = (String) t.getText();
        if (text.contains("X")) {
            t.setText("turn: playerO");
        } else if (text.contains("O")) {
            t.setText("turn: playerX");
        }
    }

    public void Draw() {
        String c00 = (String) i00.getText();
        String c01 = (String) i01.getText();
        String c02 = (String) i02.getText();
        String c10 = (String) i10.getText();
        String c11 = (String) i11.getText();
        String c12 = (String) i12.getText();
        String c20 = (String) i20.getText();
        String c21 = (String) i21.getText();
        String c22 = (String) i22.getText();

        // check if all buttons are filled with value
        Boolean f = false;
        if (!c00.contains("X")&&!c00.contains("O"))
            f = true;
        if (!c01.contains("X")&&!c01.contains("O"))
            f = true;
        if (!c02.contains("X")&&!c02.contains("O"))
            f = true;
        if (!c10.contains("X")&&!c10.contains("O"))
            f = true;
        if (!c11.contains("X")&&!c11.contains("O"))
            f = true;
        if (!c12.contains("X")&&!c12.contains("O"))
            f = true;
        if (!c20.contains("X")&&!c20.contains("O"))
            f = true;
        if (!c21.contains("X")&&!c21.contains("O"))
            f = true;
        if (!c22.contains("X")&&!c22.contains("O"))
            f = true;
        if (!f) {
            i00.setText("");
            i01.setText("");
            i02.setText("");
            i10.setText("");
            i11.setText("");
            i12.setText("");
            i20.setText("");
            i21.setText("");
            i22.setText("");
            Toast.makeText(this, "THE GAME END WITH A TIE, THE BOARD HAS BEEN CLEANED", Toast.LENGTH_LONG).show();

        }
    }

    public void onClick(View v)
    {
        if (v==i00)
            Click(turn, i00);
        else if (v==i01)
            Click(turn, i01);
        else if (v==i02)
            Click(turn, i02);
        else if (v==i10)
            Click(turn, i10);
        else if (v==i11)
            Click(turn, i11);
        else if (v==i12)
            Click(turn, i12);
        else if (v==i20)
            Click(turn, i20);
        else if (v==i21)
            Click(turn, i21);
        else if (v==i22)
            Click(turn, i22);
        else if (v==res)
            Restart();
        }
    }



