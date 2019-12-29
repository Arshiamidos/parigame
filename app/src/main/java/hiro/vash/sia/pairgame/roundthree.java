package hiro.vash.sia.pairgame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class roundthree extends AppCompatActivity {

    ImageButton button01 ;
    ImageButton button02 ;
    ImageButton button03 ;
    ImageButton button04 ;
    ImageButton button05 ;
    ImageButton button06 ;
    ImageButton button07 ;
    ImageButton button08 ;
    ImageButton button09 ;
    ImageButton button10 ;
    ImageButton button11 ;
    ImageButton button12 ;
    ImageButton button13 ;
    ImageButton button14 ;
    ImageButton button15 ;
    ImageButton button16 ;

    int turn;
    int turn_number;
    int click_number;
    int prev_number;
    int prev_button;
    List<Integer> myArray;
    List<ImageButton> buttonArray;
    List<Integer> RIDimagebutton;
    List<Integer> RDrawble;
    int correct;
    int timer;

    TextView t;
    Handler handler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round3);



        timer=0;
        t= (TextView) findViewById(R.id.timer);
        handler  = new Handler();

        button01 = (ImageButton) findViewById(R.id.ImageButton01);
        button02 = (ImageButton) findViewById(R.id.ImageButton02);
        button03 = (ImageButton) findViewById(R.id.ImageButton03);
        button04 = (ImageButton) findViewById(R.id.ImageButton04);
        button05 = (ImageButton) findViewById(R.id.ImageButton05);
        button06 = (ImageButton) findViewById(R.id.ImageButton06);
        button07 = (ImageButton) findViewById(R.id.ImageButton07);
        button08 = (ImageButton) findViewById(R.id.ImageButton08);
        button09 = (ImageButton) findViewById(R.id.ImageButton09);
        button10 = (ImageButton) findViewById(R.id.ImageButton10);
        //button11 = (ImageButton) findViewById(R.id.ImageButton11);
        //button12 = (ImageButton) findViewById(R.id.ImageButton12);
        //button13 = (ImageButton) findViewById(R.id.ImageButton13);
        //button14 = (ImageButton) findViewById(R.id.ImageButton14);
        //button15 = (ImageButton) findViewById(R.id.ImageButton15);
        //button16 = (ImageButton) findViewById(R.id.ImageButton16);

        button01.setTag("HIDE");
        button02.setTag("HIDE");
        button03.setTag("HIDE");
        button04.setTag("HIDE");
        button05.setTag("HIDE");
        button06.setTag("HIDE");
        button07.setTag("HIDE");
        button08.setTag("HIDE");
        button09.setTag("HIDE");
        button10.setTag("HIDE");
        //button11.setTag("HIDE");
        //button12.setTag("HIDE");
        //button13.setTag("HIDE");
        //button14.setTag("HIDE");
        //button15.setTag("HIDE");

        buttonArray=new ArrayList<ImageButton>(16);

        buttonArray.add(button01);
        buttonArray.add(button02);
        buttonArray.add(button03);
        buttonArray.add(button04);
        buttonArray.add(button05);
        buttonArray.add(button06);
        buttonArray.add(button07);
        buttonArray.add(button08);
        buttonArray.add(button09);
        buttonArray.add(button10);
        //buttonArray.add(button11);
        //buttonArray.add(button12);
        //buttonArray.add(button13);
        //buttonArray.add(button14);
        //buttonArray.add(button15);
        //buttonArray.add(button16);

        RIDimagebutton=new ArrayList<Integer>(16);
        RIDimagebutton.add(R.id.ImageButton01);
        RIDimagebutton.add(R.id.ImageButton02);
        RIDimagebutton.add(R.id.ImageButton03);
        RIDimagebutton.add(R.id.ImageButton04);
        RIDimagebutton.add(R.id.ImageButton05);
        RIDimagebutton.add(R.id.ImageButton06);
        RIDimagebutton.add(R.id.ImageButton07);
        RIDimagebutton.add(R.id.ImageButton08);
        RIDimagebutton.add(R.id.ImageButton09);
        RIDimagebutton.add(R.id.ImageButton10);
        //RIDimagebutton.add(R.id.ImageButton11);
        //RIDimagebutton.add(R.id.ImageButton12);
        //RIDimagebutton.add(R.id.ImageButton13);
        //RIDimagebutton.add(R.id.ImageButton14);
        //RIDimagebutton.add(R.id.ImageButton15);
        //RIDimagebutton.add(R.id.ImageButton16);

        RDrawble=new ArrayList<Integer>(9);
        RDrawble.add(0);
        RDrawble.add(R.drawable.one);
        RDrawble.add(R.drawable.two);
        RDrawble.add(R.drawable.three);
        RDrawble.add(R.drawable.four);
        RDrawble.add(R.drawable.five);
        //RDrawble.add(R.drawable.six);
        //RDrawble.add(R.drawable.seven);
        //RDrawble.add(R.drawable.eight);




        turn=0;//0 yani bare avale 1 yani yebar zade az ghabl
        turn_number=0;
        click_number=0;
        prev_number=0;
        prev_button=0;

        myArray = new ArrayList<Integer>(16);//shomare karta
        myArray.add(1);
        myArray.add(1);
        myArray.add(2);
        myArray.add(2);
        myArray.add(3);
        myArray.add(3);
        myArray.add(4);
        myArray.add(4);
        myArray.add(5);
        myArray.add(5);
        //myArray.add(6);
        //myArray.add(6);
        //myArray.add(7);
        //myArray.add(7);
        //myArray.add(8);
        //myArray.add(8);
        Collections.shuffle(myArray);

        button01.setOnClickListener(clk);
        button02.setOnClickListener(clk);
        button03.setOnClickListener(clk);
        button04.setOnClickListener(clk);
        button05.setOnClickListener(clk);
        button06.setOnClickListener(clk);
        button07.setOnClickListener(clk);
        button08.setOnClickListener(clk);
        button09.setOnClickListener(clk);
        button10.setOnClickListener(clk);
        //button11.setOnClickListener(clk);
        //button12.setOnClickListener(clk);
        //button13.setOnClickListener(clk);
        //button14.setOnClickListener(clk);
        //button15.setOnClickListener(clk);
        //button16.setOnClickListener(clk);

        new android.os.Handler().postDelayed(updateData, 1000);

    }

    final Runnable updateData=new Runnable() {
        @Override
        public void run() {

            t.setText(String.valueOf(++roundone.conter) );
            handler.postDelayed(updateData,1000);
        }
    };


    final View.OnClickListener clk=new View.OnClickListener() {
        @Override
        public void onClick(View view) {




            if(buttonArray.get(RIDimagebutton.indexOf(view.getId())).getTag()=="SHOW")
                return;


            if(turn==0)
            {
                //if(myArray.get(RIDimagebutton.indexOf(view.getId()))==1)// adade tasadofi toie buttoni ke click shode
                {
                    //index shomare dar khoneie adade tasafi ro barmigardoone bar hasb button ke click shode ba r.id.image
                    buttonArray.get(RIDimagebutton.indexOf(view.getId())).setBackgroundResource(RDrawble.get(myArray.get(RIDimagebutton.indexOf(view.getId()))));
                    buttonArray.get(RIDimagebutton.indexOf(view.getId())).setTag("SHOW");
                    prev_number=myArray.get(RIDimagebutton.indexOf(view.getId()));
                    prev_button=RIDimagebutton.indexOf(view.getId());//id 0 1 2 3
                }

                turn=1;
            }
            else
            {

                //if(myArray.get(RIDimagebutton.indexOf(view.getId()))==1)// adade tasadofi toie buttoni ke click shode
                //index shomare dar khoneie adade tasafi ro barmigardoone bar hasb button ke click shode ba r.id.image
                buttonArray.get(RIDimagebutton.indexOf(view.getId())).setBackgroundResource(RDrawble.get(myArray.get(RIDimagebutton.indexOf(view.getId()))));
                buttonArray.get(RIDimagebutton.indexOf(view.getId())).setTag("SHOW");
                if(    prev_number!=myArray.get(RIDimagebutton.indexOf(view.getId()))  )
                {
                    final  int getid=view.getId();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            buttonArray.get(prev_button).setBackgroundResource(R.drawable.chess);
                            buttonArray.get(RIDimagebutton.indexOf(getid))
                                    .setBackgroundResource(R.drawable.chess);
                            buttonArray.get(prev_button).setTag("HIDE");
                            buttonArray.get(RIDimagebutton.indexOf(getid)).setTag("HIDE");
                            turn=0;
                        }
                    },100);

                }
                else
                {
                    correct++;
                    if(correct==5)//tedade dorost
                    {
                        handler.removeCallbacks(updateData);
                        Intent myIntent = new Intent(roundthree.this,
                                fin.class);
                        startActivity(myIntent);
                    }
                    turn=0;//mosavist
                    prev_number=0;
                    prev_button=0;
                }


            }


            //
        }
    };
}
