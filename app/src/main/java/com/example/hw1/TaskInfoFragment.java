package com.example.hw1;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hw1.tasks.TaskListContent;


/**
 * A simple {@link Fragment} subclass.
 */
/**
 * A simple {@link Fragment} subclass.
 */
public class TaskInfoFragment extends Fragment {

    private TaskListContent.Task mDiplayedTask;

    public TaskInfoFragment() { }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        FragmentActivity activity = getActivity ();
        super.onActivityCreated ( savedInstanceState );
        activity.findViewById(R.id.displayFragment).setVisibility(View.INVISIBLE);
        activity.findViewById(R.id.taskInfoImage);
        Intent intent = getActivity ().getIntent ();
        if(intent!=null)
        {
            TaskListContent.Task receivedTask = intent.getParcelableExtra ( MainActivity.taskExtra );
            if(receivedTask!= null)
            {
                displayTask ( receivedTask );
            }
        }
    }

    public void displayTask(TaskListContent.Task task)
    {
        FragmentActivity activity = getActivity ();
        (activity.findViewById ( R.id.displayFragment )).setVisibility ( View.VISIBLE );
        TextView taskInfoModel = activity.findViewById ( R.id.taskInfoContact);
        TextView taskInfoDescription = activity.findViewById ( R.id.taskInfoDescription );
        final ImageView taskInfoImage = activity.findViewById ( R.id.taskInfoImage );


        taskInfoModel.setText ( task.name + " " + task.surname);
        taskInfoDescription.setText ( "Urodziny: "+ task.date + "\n\nNumer telefonu: "+ task.number);
        if(task.picPath!=null && !task.picPath.isEmpty ())
        {
            if(task.picPath.contains ( "drawable" ))
            {
                Drawable taskDrawable;
                switch (task.picPath)
                {
                    case "drawable 1":
                        taskDrawable = activity.getResources ().getDrawable ( R.drawable.avatar_1 );
                        break;
                    case "drawable 2":
                        taskDrawable = activity.getResources ().getDrawable ( R.drawable.avatar_2 );
                        break;
                    case "drawable 3":
                        taskDrawable = activity.getResources ().getDrawable ( R.drawable.avatar_3 );
                        break;
                    default:
                        taskDrawable = activity.getResources ().getDrawable ( R.drawable.avatar_4 );
                }
                taskInfoImage.setImageDrawable ( taskDrawable );
            }
        }
        else
        {
            taskInfoImage.setImageDrawable ( activity.getResources ().getDrawable ( R.drawable.avatar_1 ) );
        }
        mDiplayedTask = task;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate ( R.layout.fragment_task_info, container, false );
    }
}
