package com.example.t_helper21.problemclass;

import android.graphics.Bitmap;

public class Problem {

    private Bitmap illustration;
    private Bitmap next;
    private String reason;

    public Problem(Bitmap illustration, String reason, Bitmap next) {
        this.illustration = illustration;
        this.next = next;
        this.reason = reason;
    }

    public Bitmap getNext() {

        return next;
    }

    public Bitmap getNum() {

        return illustration;
    }

    public String getReason() {

        return reason;
    }
}
