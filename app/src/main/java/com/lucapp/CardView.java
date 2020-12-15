package com.lucapp;

import android.content.Context;
import android.content.Intent;

import com.lucapp.ui.main.RecyclerView.DataShowActivity;

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
        //go to the character page
        //Toast.makeText(c, "Clicked on " + this.text, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(c, DataShowActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(NomePG, this.text);
        c.startActivity(intent);
    }
}
