package com.example.t_helper21.problemclass;

import android.graphics.Bitmap;

public class Physiology {

    private Bitmap logo_physiology;
    private String name_physiology;

    public Physiology(Bitmap logo_physiology, String name_physiology) {
        this.logo_physiology = logo_physiology;
        this.name_physiology = name_physiology;
    }

    public Bitmap getLogo_physiology() {
        return logo_physiology;
    }

    public String getName_physiology() {

        return name_physiology;
    }
}
