package com.example.un.dutch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by un on 16. 1. 27..
 */
public class OperationActivity extends Activity {

    private final int EXTRA_OPERATION_DATA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operation_setting);


        Button regi_buuton = (Button) findViewById(R.id.register_operation);

        regi_buuton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                // Create the result Intent and include the MAC address
                int interval = 0;
                int maintain = 0;

                EditText interval_text = (EditText)findViewById(R.id.time_inverval_input);
                if(interval_text != null)
                    interval = Integer.parseInt(interval_text.getText().toString().trim());

                EditText maintain_text = (EditText)findViewById(R.id.Maintain_time_input);
                if(maintain_text != null)
                    maintain = Integer.parseInt(maintain_text.getText().toString().trim());

                Intent intent = new Intent();
                //setResult(EXTRA_OPERATION_DATA);
                //intent.putExtra("RESULT_CODE", );
                intent.putExtra("EXTRA_INTERVAL_TIME", interval);
                intent.putExtra("EXTRA_MAINTAIN_TIME", maintain);

                // Set result and finish this Activity
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
