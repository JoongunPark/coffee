package com.example.un.dutch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by un on 16. 1. 27..
 */
public class MachineActivity extends Activity implements AdapterView.OnItemClickListener{

    private final int EXTRA_OPERATION_DATA = 1;
    private Machine machine;

    private OperationAdapter operationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machine_info);

        Bundle bundle = getIntent().getExtras();
        int m_id = bundle.getInt("device_id");

        TextView textView = (TextView) findViewById(R.id.machine_id);
        textView.setText("Machine : " + String.valueOf(m_id) + "\nAdd your recipe!");

        Button add_button = (Button) findViewById(R.id.add_operation);

        add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MachineActivity.this, OperationActivity.class);
                startActivityForResult(intent, EXTRA_OPERATION_DATA);
            }
        });

        Button brew_button = (Button) findViewById(R.id.brew_button);

        brew_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });

        ListView listView = (ListView)findViewById(R.id.opertaion_list);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        if(listView != null) {
            ArrayList<Operation> items = new ArrayList<Operation>();
            operationAdapter = new OperationAdapter(this,0 ,items);
            listView.setAdapter(operationAdapter);
        }


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case EXTRA_OPERATION_DATA:

                int inverval_time = data.getIntExtra("EXTRA_INTERVAL_TIME", 0);
                int maintain_time = data.getIntExtra("EXTRA_MAINTAIN_TIME", 0);

                Operation oper = new Operation(operationAdapter.getCount()+1, maintain_time, inverval_time);

                //machine.getRecipe().add(oper);

                operationAdapter.add(oper);
                operationAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
