package com.github.carlisinho.dzejoly;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.view.View;

/**
 * A class that will parse text written in Latvian and attempt to suggest a word that rhymes
 * when, uh, well, we'll figure out the logic eventually. If anyone bothers to.
 *
 * Current tasks:
 *  Figure out how the TextWatcher class works
 *  Implement static methods that contain the actual text parsing logic, I guess.
 *  Read through https://source.android.com/source/code-style.html, because I sure haven't
 *  Figure out if there's a more suitable element type for the opt_field. Eventually we'll want a
 *      movable list of options for the user to tap on, presumably.
 *
 * Created by rtkat on 27.04.2015.
 */
public class Poetizer implements TextWatcher {
    // TODO: Check what's the correct class variable naming scheme for Java.
    TextView opt_field;

    public Poetizer(TextView field) {
        opt_field = field;
    }

    // TODO: Is @Override actually what I'm looking for here? Does it do anything?
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        opt_field.setVisibility(View.VISIBLE);
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() == 0) {
            opt_field.setVisibility(View.GONE);
        } else{
            String lines[] = s.toString().split("\\r?\\n");

            if(lines.length > 1 && !lines[lines.length - 2].isEmpty()) {
                String words[] = lines[lines.length - 2].split(" ");
                // TODO: Fetch any string literals from strings.xml, rather than typing them out
                opt_field.setText("You are on line : " + lines.length +
                                  "\n The previous line ended with:" + words[words.length-1]);
            } else {
                opt_field.setText("You are on line : " + lines.length);
            }
        }
    }
}
