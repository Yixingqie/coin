package com.example.yixing.coinflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button flip;
    ImageView coin;
    Random r;
    int coinSide; //0-heads, 1-heads


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "YixingQ.//7/22/17", Toast.LENGTH_SHORT).show();

        flip = ((Button)findViewById(R.id.flip));
        coin = ((ImageView)findViewById(R.id.coin));
        r = new Random();

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coinSide= r.nextInt(2);

                Animation anim_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
                RotateAnimation rotate = new RotateAnimation(0,720,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(500);
               // rotate.setRepeatCount(3);
                AnimationSet s = new AnimationSet(false);
                s.addAnimation(anim_up);
                s.addAnimation(rotate);
                coin.startAnimation(s);

                if (coinSide == 0) {
                    coin.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this, "Heads", Toast.LENGTH_SHORT).show();
                } else
                {
                    coin.setImageResource(R.drawable.tails);
                    Toast.makeText(MainActivity.this, "Tails", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
