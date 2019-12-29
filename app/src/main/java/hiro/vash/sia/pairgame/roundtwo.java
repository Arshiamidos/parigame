package hiro.vash.sia.pairgame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class roundtwo extends AppCompatActivity {

    ImageButton button01 ;
    ImageButton button02 ;
    ImageButton button03 ;
    ImageButton button04 ;
    ImageButton button05 ;
    ImageButton button06 ;
    ImageButton button07 ;
    ImageButton button08 ;

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
    TextView t;
    Handler handler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round2);



        //conter=0;
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


        button01.setTag("HIDE");
        button02.setTag("HIDE");
        button03.setTag("HIDE");
        button04.setTag("HIDE");
        button05.setTag("HIDE");
        button06.setTag("HIDE");
        button07.setTag("HIDE");
        button08.setTag("HIDE");


        buttonArray=new ArrayList<ImageButton>(4);
        buttonArray.add(button01);
        buttonArray.add(button02);
        buttonArray.add(button03);
        buttonArray.add(button04);
        buttonArray.add(button05);
        buttonArray.add(button06);
        buttonArray.add(button07);
        buttonArray.add(button08);

        RIDimagebutton=new ArrayList<Integer>(4);
        RIDimagebutton.add(R.id.ImageButton01);
        RIDimagebutton.add(R.id.ImageButton02);
        RIDimagebutton.add(R.id.ImageButton03);
        RIDimagebutton.add(R.id.ImageButton04);
        RIDimagebutton.add(R.id.ImageButton05);
        RIDimagebutton.add(R.id.ImageButton06);
        RIDimagebutton.add(R.id.ImageButton07);
        RIDimagebutton.add(R.id.ImageButton08);

        RDrawble=new ArrayList<Integer>(3);
        RDrawble.add(0);
        RDrawble.add(R.drawable.one);
        RDrawble.add(R.drawable.two);
        RDrawble.add(R.drawable.three);
        RDrawble.add(R.drawable.four);




        turn=0;//0 yani bare avale 1 yani yebar zade az ghabl
        turn_number=0;
        click_number=0;
        prev_number=0;
        prev_button=0;

        myArray = new ArrayList<Integer>(8);//shomare karta
        myArray.add(1);
        myArray.add(1);
        myArray.add(2);
        myArray.add(2);
        myArray.add(3);
        myArray.add(3);
        myArray.add(4);
        myArray.add(4);
        Collections.shuffle(myArray);

        button01.setOnClickListener(clk);
        button02.setOnClickListener(clk);
        button03.setOnClickListener(clk);
        button04.setOnClickListener(clk);
        button05.setOnClickListener(clk);
        button06.setOnClickListener(clk);
        button07.setOnClickListener(clk);
        button08.setOnClickListener(clk);


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


           // Log.i("---------------------",buttonArray.get(RIDimagebutton.indexOf(view.getId())).getDrawable(). );

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
                    if(correct==4)//tedade dorost
                    {
                        handler.removeCallbacks(updateData);
                        Intent myIntent = new Intent(roundtwo.this,
                                roundthree.class);
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
