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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class roundone extends AppCompatActivity {

     ImageButton button01 ;
     ImageButton button02 ;
     ImageButton button03 ;
     ImageButton button04 ;

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
    public static int conter;
    TextView t;
    Handler handler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round1);



        conter=0;
         t= (TextView) findViewById(R.id.timer);
         handler  = new Handler();




         button01 = (ImageButton) findViewById(R.id.imageButton01);
         button02 = (ImageButton) findViewById(R.id.imageButton02);
         button03 = (ImageButton) findViewById(R.id.imageButton03);
         button04 = (ImageButton) findViewById(R.id.imageButton04);


        button01.setTag("HIDE");
        button02.setTag("HIDE");
        button03.setTag("HIDE");
        button04.setTag("HIDE");


        buttonArray=new ArrayList<ImageButton>(4);
        buttonArray.add(button01);
        buttonArray.add(button02);
        buttonArray.add(button03);
        buttonArray.add(button04);

        RIDimagebutton=new ArrayList<Integer>(4);
        RIDimagebutton.add(R.id.imageButton01);
        RIDimagebutton.add(R.id.imageButton02);
        RIDimagebutton.add(R.id.imageButton03);
        RIDimagebutton.add(R.id.imageButton04);

        RDrawble=new ArrayList<Integer>(3);
        RDrawble.add(0);
        RDrawble.add(R.drawable.one);
        RDrawble.add(R.drawable.two);




         turn=0;//0 yani bare avale 1 yani yebar zade az ghabl
         turn_number=0;
         click_number=0;
         prev_number=0;
         prev_button=0;

        myArray = new ArrayList<Integer>(4);//shomare karta
        myArray.add(1);
        myArray.add(1);
        myArray.add(2);
        myArray.add(2);
        Collections.shuffle(myArray);

        button01.setOnClickListener(clk);
        button02.setOnClickListener(clk);
        button03.setOnClickListener(clk);
        button04.setOnClickListener(clk);




        new android.os.Handler().postDelayed(updateData, 1000);






    }
    final Runnable updateData=new Runnable() {
        @Override
        public void run() {

            t.setText(String.valueOf(++conter) );
            handler.postDelayed(updateData,1000);
        }
    };

    final View.OnClickListener clk=new View.OnClickListener() {
        @Override
        public void onClick(View view) {




            if(buttonArray.get(RIDimagebutton.indexOf(view.getId())).getTag()=="SHOW")
                return;
            //    return ;//age aks hast dobare set background nashe


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
                                buttonArray.get(prev_button).setTag("HIDE");
                                buttonArray.get(RIDimagebutton.indexOf(getid)).setTag("HIDE");
                                buttonArray.get(RIDimagebutton.indexOf(getid))
                                        .setBackgroundResource(R.drawable.chess);
                                turn=0;
                            }
                        },100);

                    }
                    else
                    {
                        correct++;


                        if(correct==2)//tedade dorost
                        {
                            handler.removeCallbacks(updateData);
                            Intent myIntent2 = new Intent(getApplicationContext(),
                                    roundtwo.class);
                            startActivity(myIntent2);
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
