package com.example.t_helper21.problemclass;

import android.graphics.Bitmap;

public class Pain {

    private Bitmap pain_logo;
    private String painProblem;

    public Pain(Bitmap pain_logo, String painProblem) {
        this.pain_logo = pain_logo;
        this.painProblem = painProblem;
    }

    public Bitmap getPain_logo() {
        return pain_logo;
    }

    public String getPainProblem() {

        return painProblem;
    }
}
