package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by sajaved on 12/20/2017.
 */

public class BodyPartFragment extends Fragment {

    public  static  final String IMAGE_ID_LIST = "image_ids";
    public  static  final String LIST_INDEX = "list_index";
    private  static final   String TAG = "BodyPartFragment";
    private List<Integer> mImageIDs;
    private int mListIndex;

    //Mandator Constructor for instantiating the fragment
    public BodyPartFragment(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(savedInstanceState != null)
        {
            mImageIDs  = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView  = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageview = (ImageView)  rootView.findViewById(R.id.body_part_image_view);
        if(mImageIDs != null) {
            imageview.setImageResource(mImageIDs.get(mListIndex));
            imageview.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    if(mListIndex < mImageIDs.size()-1){
                        mListIndex++;

                    }
                    else{
                        mListIndex = 0;
                    }
                    imageview.setImageResource(mImageIDs.get(mListIndex));
                }
            });
        }
        else{
            Log.v(TAG, "This fragment has a null list of image id's");
        }
        return rootView;
    }

    public void setImageIDs(List<Integer> imageIDs)
    {
        mImageIDs = imageIDs;
    }

    public void setListIndex(int index)
    {
        mListIndex = index;
    }

    @Override
    public  void onSaveInstanceState(Bundle currentState){
         currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIDs);
         currentState.putInt(LIST_INDEX, mListIndex);
    }
}
