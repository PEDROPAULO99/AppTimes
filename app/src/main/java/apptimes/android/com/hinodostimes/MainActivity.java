package apptimes.android.com.hinodostimes;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//Herança AppCompatActivity
//Interface View.OnClickListener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//classe abstrata
    private ImageView corinthians;
    private ImageView palmeiras;
    private ImageView gremio;
    private ImageView inter;
    private ImageView sp;
    private ImageView atleticomg;

    private MySons sons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        corinthians = (ImageView) findViewById(R.id.timaoid);
        palmeiras = (ImageView) findViewById(R.id.palmeirasid);
        gremio = (ImageView) findViewById(R.id.gremioid);
        inter = (ImageView) findViewById(R.id.interid);
        sp = (ImageView) findViewById(R.id.saopauloid);
        atleticomg = (ImageView) findViewById(R.id.atleticoid);

        sons = MySons.getInstance();

        corinthians.setOnClickListener(this);
        palmeiras.setOnClickListener(this);
        gremio.setOnClickListener(this);
        inter.setOnClickListener(this);
        sp.setOnClickListener(this);
        atleticomg.setOnClickListener(this);

    }


    //polimorfismo
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.timaoid:
                sons.trocarSom(this, R.raw.corinthians);
                break;
            case R.id.palmeirasid:
                sons.trocarSom(this, R.raw.palmeiras);
                break;
            case R.id.gremioid:
                sons.trocarSom(this, R.raw.gremio);
                break;
            case R.id.interid:
                sons.trocarSom(this, R.raw.inter);
                break;
            case R.id.saopauloid:
                sons.trocarSom(this, R.raw.sao_paulo);
                break;
            case R.id.atleticoid:
                sons.trocarSom(this, R.raw.atletico_mineiro);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        sons.desligarSom();
        super.onDestroy();
    }
}
