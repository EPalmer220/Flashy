package com.example.flashy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    private Vocab vocabBank = new Vocab();
    private Vocab comparisonBank = new Vocab(); // the bank which will remain unchanged for index comparisons
    private TextView defView;
    private EditText answerText;
    private Button nextButton;
    public int numCorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        defView = findViewById(R.id.defView);
        play();

    }

    /**
     * runs the play activity, in which the user provides the corresponding term to a definition
     */
    public void play() {
        // as more definitions are present, this branch of code will be activated
        if(vocabBank.getDefsLength() > 0){
            defView.setText(vocabBank.getDefinition((int) (Math.random() * vocabBank.getDefsLength())));
            nextButton = findViewById(R.id.nextButton);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    checkIfCorrect(defView);
                    play();
                }
            });
        }

       else{ // when the game has completed
           defView.setText("You got " + percentCorrect() + "% correct.");
            nextButton = findViewById(R.id.nextButton);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    openMainActivity();
                }
            });
        }
    }

    /**
     * verifies that the user has matched the correct term with the given definition
     * @param defView the text box containing an item from String[] definitions
     */
    public void checkIfCorrect(TextView defView) {
        answerText = findViewById(R.id.answerText);
        String answer = answerText.getText().toString();
        String definition = defView.getText().toString();

        //if user answers correctly
        if(answer.equalsIgnoreCase(comparisonBank.getTerm(comparisonBank.getIndexOfDefinition(defView.getText())))) {
            numCorrect++;
            vocabBank.remove(definition);
            popupTrackerGood();
        }

        //if user answers incorrectly
        else {
            vocabBank.remove(definition);
            popupTrackerBad();
        }
    }

    /**
     * Returns user to the MainActivity page
     */
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * @return the percentage of correct responses the user inputted during the game
     */
    public double percentCorrect(){
        return ((double) numCorrect / comparisonBank.getDefsLength()) * 100;
    }

    /**
     * Notifies user that their answer was correct, + how many terms are remaining
     */
    public void popupTrackerGood(){
        Context context = getApplicationContext();
        CharSequence text = "Correct! " + vocabBank.getDefsLength() + " terms left!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }

    /**
     * Notifies user that their answer was incorrect, + how many terms are remaining
     */
    public void popupTrackerBad(){
        Context context = getApplicationContext();
        CharSequence text = "Incorrect. " + vocabBank.getDefsLength() + " terms left!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }
}

