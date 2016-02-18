package com.example.un.dutch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by un on 16. 1. 27..
 */
public class OperationAdapter extends ArrayAdapter<Operation> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Operation> operations;

    private final int IDLE = 1;
    private final int BREWING = 2;

    public OperationAdapter(Context context, int resource, ArrayList<Operation> objects) {
        super(context, resource, objects);

        this.context = context;
        this.operations = objects;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.operation_list, null);
        }

        Operation operation = this.operations.get(position);

        TextView number = (TextView)convertView.findViewById(R.id.opertaion_number);

        if(number != null){
            number.setText(String.valueOf(operation.getNumber()) + "번");
        }

        TextView maintain = (TextView)convertView.findViewById(R.id.operation_maintain);

        if(maintain != null){
            maintain.setText("Maintain time: "+ String.valueOf(operation.getMaintain()) + " 초");
        }

        TextView interval = (TextView)convertView.findViewById(R.id.operation_interval);

        if(interval != null){
            interval.setText("Drop interval: " + String.valueOf(operation.getInterval()) + " 초");
        }

        return convertView;
    }
}
