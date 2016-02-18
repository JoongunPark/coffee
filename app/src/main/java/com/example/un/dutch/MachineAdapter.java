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
public class MachineAdapter extends ArrayAdapter<Machine> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Machine> machines;

    private final int IDLE = 1;
    private final int BREWING = 2;

    public MachineAdapter(Context context, int resource, ArrayList<Machine> objects) {
        super(context, resource, objects);

        this.context = context;
        this.machines = objects;
        this.inflater = LayoutInflater.from(context);
    }

    public ArrayList<Machine> getMachines(){
        return machines;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.machine_list, null);
        }

        Machine machine = this.machines.get(position);

        TextView name = (TextView)convertView.findViewById(R.id.machine_name);
        if(name != null)
        {
            name.setText(String.valueOf(machine.getId()) + " 번");
        }
        TextView status = (TextView)convertView.findViewById(R.id.machine_status);

        switch(machine.getStatus()){
            case IDLE:
                status.setText("STATUS: IDLE");
                break;
            case BREWING:
                status.setText("STATUS: BREWING");
                break;
            default:
                break;
        }

        TextView recipe = (TextView)convertView.findViewById(R.id.recipe_name);

        if(recipe != null){
            recipe.setText(machine.getRecipe().getName());
        }
        return convertView;
    }
}
