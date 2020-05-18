package com.example.hw1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw1.tasks.TaskListContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TaskFragment extends Fragment {


    private int mColumnCount = 1;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnListFragmentInteractionListener mListener;
    private MyTaskRecyclerViewAdapter mRecyclerViewAdapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TaskFragment() {
    }
    public static TaskFragment newInstance(int columnCount) {
        TaskFragment fragment = new TaskFragment ();
        Bundle args = new Bundle ();
        args.putInt ( ARG_COLUMN_COUNT, columnCount );
        fragment.setArguments ( args );
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        if (getArguments () != null) {
            mColumnCount = getArguments ().getInt ( ARG_COLUMN_COUNT );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.fragment_task_list, container, false );

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext ();
            RecyclerView recyclerView = ( RecyclerView ) view;
            recyclerView.setLayoutManager ( new LinearLayoutManager ( context ) );
            mRecyclerViewAdapter = new MyTaskRecyclerViewAdapter ( TaskListContent.ITEMS, mListener );
            recyclerView.setAdapter ( mRecyclerViewAdapter );
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnListFragmentInteractionListener {
        void OnDeleteClick(int position);
        void OnListFragmentClickInteraction(TaskListContent.Task task, int position); //click interaction
    }

    public void notifyDataChange()
    {
        mRecyclerViewAdapter.notifyDataSetChanged ();

    }
}
