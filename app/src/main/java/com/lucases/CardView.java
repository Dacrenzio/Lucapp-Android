package com.lucases;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CardView {
    public static final String NomePG = "com.lucases.MESSAGE";
    private int imageResource;
    private String text;

    public CardView(int imageResource, String text){
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }

    public void click(Context c){
        Toast.makeText(c, "Clicked on " + this.text, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(c, DataShowActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(NomePG, this.text);
        c.startActivity(intent);
    }
}
