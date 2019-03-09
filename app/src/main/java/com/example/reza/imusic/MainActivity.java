package com.example.reza.imusic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.marcinmoskala.arcseekbar.ProgressListener;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private CircleImageView imageView;
    private Animation animation;

    private TextView name_music;
    private ArcSeekBar seekBar_image;
    private TextView duration;
    private TextView current_duration;

    private FloatingActionButton btn_play;
    private ImageView btn_next;
    private ImageView btn_previous;
    public ImageView forward;
    public ImageView rewind;
    private ImageView shuffle;
    private ImageView repeat;

    private SeekBar seekBar_volume;

    private TextView name_next_music;
    private TextView time_next_music;

    private MediaPlayer mediaPlayer;
    private Timer timer;

    private Handler handler;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (CircleImageView) findViewById(R.id.image_poet);
        name_music = (TextView) findViewById(R.id.name_music);


        btn_next = (ImageView) findViewById(R.id.next_play);
        btn_previous = (ImageView) findViewById(R.id.previous_play);
        shuffle = (ImageView) findViewById(R.id.shffle);
        repeat = (ImageView) findViewById(R.id.repeat);

        seekBar_volume = (SeekBar) findViewById(R.id.seekbar_volume);

        name_next_music = (TextView) findViewById(R.id.library_next_track);
        time_next_music = (TextView) findViewById(R.id.library_duration);

        cardView = (CardView) findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,LibraryActivity.class);
            startActivity(intent);
            }
        });

        setupMediaPlayer();

    }

    private void rotateAnimation() {
        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        animation.setDuration(mediaPlayer.getDuration()/8);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    private void rotateImage(){
        if (mediaPlayer.isPlaying()) return;
        imageView.animate().setDuration(100).rotation(imageView.getRotation()+2f).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                rotateImage();
                super.onAnimationEnd(animation);
            }
        });
    }


    private void setupMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.godfather);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.stop();
                btn_play.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_play, null));
                seekBar_image.setProgress(0);
            }
        });
        setupView();

    }


    private void setupView() {
        btn_play = (FloatingActionButton) findViewById(R.id.playing);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    btn_play.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_play, null));

                } else {
                    mediaPlayer.start();
                    btn_play.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_pause, null));
                    rotateAnimation();
                }

            }

        });


        duration = (TextView) findViewById(R.id.duration);
        duration.setText(formatDuration(mediaPlayer.getDuration()));
        current_duration = (TextView) findViewById(R.id.current_duration);
        current_duration.setText(formatDuration(0));

        forward = (ImageView) findViewById(R.id.forward_play);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 10000);
            }
        });

        rewind = (ImageView) findViewById(R.id.rewind_play);
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 10000);
            }
        });

        seekBar_image = (ArcSeekBar) findViewById(R.id.seekbar_poet);
        seekBar_image.setMaxProgress(mediaPlayer.getDuration());
        seekBar_image.setOnProgressChangedListener(new ProgressListener() {
            @Override
            public void invoke(int i) {
                mediaPlayer.seekTo(i);
            }
        });
        seekBar_image.setOnStartTrackingTouch(new ProgressListener() {
            @Override
            public void invoke(int i) {

            }
        });
        seekBar_image.setOnStopTrackingTouch(new ProgressListener() {
            @Override
            public void invoke(int i) {

            }
        });

        timer = new Timer();
        timer.schedule(new MainTime(), 0, 1000);
    }

    private String formatDuration(long duration) {
        int seconds = (int) (duration / 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        return String.format(Locale.ENGLISH, "%02d", minutes) + ":" + String.format(Locale.ENGLISH, "%02d", seconds);

    }


    private class MainTime extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    seekBar_image.setProgress(mediaPlayer.getCurrentPosition());
                    current_duration.setText(formatDuration(mediaPlayer.getCurrentPosition()));
                }
            });

        }
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        timer.purge();
        timer.cancel();
        super.onDestroy();
    }

    private void controlClick(View view){

        int id = view.getId();
        switch (id){
            case R.id.next_play:

        }

    }
}

