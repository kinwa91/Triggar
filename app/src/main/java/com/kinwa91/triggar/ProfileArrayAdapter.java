package com.kinwa91.triggar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kinwa91 on 2014-09-18.
 */
public class ProfileArrayAdapter extends ArrayAdapter<Profile> {

    private int resource;
    private List<Profile> profiles;

    public ProfileArrayAdapter(Context context, int resource, List<Profile> profiles) {
        super(context, resource, profiles);
        this.resource = resource;
        this.profiles = profiles;
    }

    @Override
    public long getItemId(int position) {
        return profiles.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Profile profile = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        TextView profileName = (TextView) convertView.findViewById(R.id.profile_name);
        TextView actions = (TextView) convertView.findViewById(R.id.actions_list);

        profileName.setText(profile.getName());
        List<Action> actionsList = profile.getActions();
        String actionsListText = "";
        Log.d("Action size: ", ""+actionsList.size());
        for (Action a : actionsList)
            actionsListText = actionsListText + a.getName() + ":" + a.getState() +", ";
        actions.setText(actionsListText);
        return convertView;
    }
}
