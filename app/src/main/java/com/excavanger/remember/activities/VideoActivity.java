package com.excavanger.remember.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.excavanger.remember.R;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String videoUrl = "https://hssportsprepack.akamaized.net/videos/football/epl2022-23/vod/1540017641/in/eng/v1/hevc/hls/plain/master.m3u8?hdnea=st=1662233513~exp=1662234113~acl=/videos/football/epl2022-23/vod/1540017641/in/eng/v1/hevc/hls/plain/*~data=ip=r5C4KllMBbkJtmWYbHIEeV-userid=KEODebcksIaS5qwGjFoZofRDlYhWetjUgzUlY57rMgRy-did=vVxYSmXtV1aRq9FJxhnvUWNS1GTTH03f4AzmfjAhGkrEiRvov1706fI-cc=in-~hmac=20a1bbca43edee49a89208d1e9504105e3ff99cd0e534119e8b6a11edf468057";
        final HashMap<String, String> options;
        options = new HashMap<>();
        options.put("headers", "Referer: https://www.hotstar.com/\r\n");
        VideoView videoView = findViewById(R.id.cricket_video);
        videoView.setVideoURI(Uri.parse(videoUrl));

        try {
            Field field = VideoView.class.getDeclaredField("mHeaders");
            field.setAccessible(true);
            field.set(videoView, options);
        } catch (Exception e) {
            e.printStackTrace();
        }

// the rest is just standard VideoView stuff
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videoView.start();
    }
}