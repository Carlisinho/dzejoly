package com.github.carlisinho.dzejoly;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class DzejolyMain extends ActionBarActivity {
    private EditText poetry_field;
    private TextView option_field;
    private Poetizer handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzejoly_main);

        //Fetch relevant UI elements
        //  TODO: Do I even need to cast here?
        poetry_field = (EditText) findViewById(R.id.poetry_field);
        option_field = (TextView) findViewById(R.id.option_field);

        // I don't even need to store or use the option_field variable, actually.
        handler = new Poetizer(option_field);
        poetry_field.addTextChangedListener(handler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dzejoly_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
