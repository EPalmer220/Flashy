package com.example.flashy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class StudyActivity extends AppCompatActivity  {
    private LinearLayout myList;
    private Vocab vocabBank = new Vocab(); // word bank containing terms + definitions
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        tableLayout = findViewById(R.id.tableLayout1);
        prepareTable();
    }

    /**
     * programmatically prepares a scrollable list using terms and definitions
     */
    public void prepareTable(){
        int numRows = vocabBank.getTermsLength();
        int count = 1; // differentiates between text-filled and blank rows

        // iterates through array to create TableRows
        for(int i = 0; i < numRows; i++) {
            if(count % 2 != 0){
                TableRow tableEntry = new TableRow(this);
                TextView term = new TextView(this);
                TextView definition = new TextView(this);
                term.setWidth(0);
                definition.setWidth(0);
                term.setText(vocabBank.getTerm(i));
                definition.setText(vocabBank.getDefinition(i));
                tableLayout.addView(tableEntry);
                tableEntry.addView(term);
                tableEntry.addView(definition);

            }

            // creates spaces for legibility
            else{
                TableRow tableEntry = new TableRow(this);
                TextView term = new TextView(this);
                TextView definition = new TextView(this);
                tableLayout.addView(tableEntry);
                tableEntry.addView(term);
                tableEntry.addView(definition);
                i--;
            }
            count++;
        }
    }
}
