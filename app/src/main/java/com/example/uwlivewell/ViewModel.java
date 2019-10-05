package com.example.uwlivewell;

import android.media.Image;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.net.URI;

public class ViewModel {
    private String name;
    private ImageView image;
    private String description;

    public ViewModel(@NonNull String name, int image, String description) {
        setName(name);
        setDescription(description);
        this.image = null;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setDescription(@NonNull String name) {
        this.description = name;
    }

    public String getDescription() {
        return this.description;
    }

//    // TODO figure out how this does stuff
//    public void setPhoto(int image) {
//        this.photo.setImageResource(image);
//    }
//
//    public ImageView getPhoto() {
//        return this.photo;
//    }
}
