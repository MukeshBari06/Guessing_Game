package com.manit.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randNumber;
    int score=100;
    public void generateRandomNumber(){
        Random rand =new Random();
        randNumber=rand.nextInt(20)+1;
    }

    public void guess(View view){
        EditText editText=(EditText) findViewById(R.id.editText);
        int guessValue=Integer.parseInt(editText.getText().toString());

        String  message;
        if(guessValue<randNumber) {
            message = "Higher!";
            score=score/2;
        }
        else if(guessValue>randNumber) {
            message = "Lower!";
            score = score / 2;
        }
        else {
            message = "You got it!, Score: "+score+"\nTry again";
            generateRandomNumber();
            score=100;
        }

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        Log.i("Entered value: ",editText.getText().toString());
        Log.i("Random Number: ",Integer.toString(randNumber));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}
