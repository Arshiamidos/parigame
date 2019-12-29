package hiro.vash.sia.pairgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fin);



        SharedPreferences prefs = this.getSharedPreferences(
                "sia.vash.hiro", Context.MODE_PRIVATE);
        long l = prefs.getLong("HI_SCORE", 0);
        if(l<roundone.conter)
        {
            prefs.edit().putLong("HI_SCORE", roundone.conter).apply();

        }
        ((TextView)findViewById(R.id.hiscore)).setText("  بیشترین امتیاز قبلی : "+l);

        Button button=(Button)findViewById(R.id.button2);
        TextView t=(TextView)findViewById(R.id.timer);
        t.setText(String.valueOf(roundone.conter) );


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(fin.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
