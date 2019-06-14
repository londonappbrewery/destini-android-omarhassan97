package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button TopButton ;
    Button BottomButton;
    TextView StoryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
         TopButton = findViewById(R.id.buttonTop);
         BottomButton = findViewById(R.id.buttonBottom);
         StoryText = findViewById(R.id.storyTextView);

         if (savedInstanceState != null)
         {
             StoryText.setText(savedInstanceState.getString("StoryKey"));
             TopButton.setText(savedInstanceState.getString("TopKey"));
             BottomButton.setText(savedInstanceState.getString("BottomKey"));

         }else
         {
             StoryText.setText(R.string.T1_Story);
             TopButton.setText(R.string.T1_Ans1);
             BottomButton.setText(R.string.T1_Ans2);
         }
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = getString(R.string.T1_Story);


                if(StoryText.getText().toString().equals(getString(R.string.T1_Story)) )
                {
                    changeStory(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2);

                }
                else if (StoryText.getText().toString().equals(getString(R.string.T3_Story)))
                {
                    changeStory(R.string.T6_End,R.string.empty,R.string.empty);
                    EndOfStory();

                }
                else if (StoryText.getText().toString().equals(getString(R.string.T2_Story)))
                {
                    changeStory(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2);

                }else
                {
                    Log.d("a7a15", "onClick: a7a ");
                    Log.d("a7a15 main string", string + "a7a");
                    Log.d(" a7a15 main string", StoryText.getText().toString() +"a7a");
                }

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        BottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(StoryText.getText().toString().equals(getString(R.string.T1_Story)))
                {
                    changeStory(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2);

                }
                else if (StoryText.getText().toString().equals(getString(R.string.T3_Story)))
                {
                    changeStory(R.string.T5_End,R.string.empty,R.string.empty);
                    EndOfStory();

                }
                else if (StoryText.getText().toString().equals(getString(R.string.T2_Story)))
                {
                    changeStory(R.string.T4_End,R.string.empty,R.string.empty);
                    EndOfStory();

                }else
                {
                    Log.d("CHECK", "onClick: a7a ");
                }

            }
        });

    }

    private void changeStory(int storyID,int ANS1,int ANS2)
    {
        StoryText.setText(storyID);
        TopButton.setText(ANS1);
        BottomButton.setText(ANS2);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("StoryKey",StoryText.getText().toString());
        outState.putString("TopKey",TopButton.getText().toString());
        outState.putString("BottomKey",BottomButton.getText().toString());



    }

    private void EndOfStory(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("THE END");
        alert.setCancelable(false);
        alert.setMessage("your story was ended");
        alert.setPositiveButton("Close APP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
            }
        });
        BottomButton.setVisibility(View.INVISIBLE);
        TopButton.setVisibility(View.INVISIBLE);
        alert.show();
    }
}
