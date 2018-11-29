package apptimes.android.com.hinodostimes;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;


//banco
public class MySons {

    private static MySons instance;
    private MediaPlayer mediaPlayer;

    private MySons() {
        setMediaPlayer(new MediaPlayer());
    }

    public static synchronized MySons getInstance() {
        if (instance == null)
            instance = new MySons();
        return instance;
    }

    // encapsulamento
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    // encapsulamento
    private void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }



    public void tocarSom() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void desligarSom() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void trocarSom(AppCompatActivity activity, int id) {
        desligarSom();
        setMediaPlayer(MediaPlayer.create(activity, id));
        tocarSom();
    }
}
