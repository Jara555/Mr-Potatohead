package com.jara.mrpotatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // create class variable with image id's
    protected int[] imageIds = new int[]{R.id.arms, R.id.ears, R.id.eyebrows, R.id.eyes,
            R.id.glasses, R.id.hat, R.id.mouth, R.id.mustache, R.id.nose, R.id.shoes};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Shows images according to checkbox input */
    public void checkClicked(View v) {
        CheckBox checkbox = (CheckBox) v;

        // get id of image based on id of checkbox and store image view
        int imageId = returnImageId(v.getId());
        ImageView image = (ImageView) findViewById(imageId);

        // show image if checked
        if (checkbox.isChecked()) {
            image.setVisibility(View.VISIBLE);
        }
        // hide image if unchecked
        else {
            image.setVisibility(View.INVISIBLE);
        }
    }

    /* Stores information in bundle when method is called */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // iterate over image id's
        for (int id : imageIds) {
            // retrieve image view and store if visible
            ImageView image = (ImageView) findViewById(id);
            boolean imageVis = (image.getVisibility() == View.VISIBLE);

            // store info in bundle
            outState.putBoolean(Integer.toString(id), imageVis);
        }
    }

    /* Restores information out of bundle */
    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        // iterate over image id's
        for (int id : imageIds) {
            // if image was visible (true) show again
            if (inState.getBoolean(Integer.toString(id))) {
                ImageView image = (ImageView) findViewById(id);
                image.setVisibility(View.VISIBLE);
            }
        }
    }

    /* Gives back the id of the image corresponding to the checkbox */
    public int returnImageId(int id) {
        switch (id) {
            case R.id.check_arms:
                return R.id.arms;
            case R.id.check_ears:
                return R.id.ears;
            case R.id.check_eyebrows:
                return R.id.eyebrows;
            case R.id.check_eyes:
                return R.id.eyes;
            case R.id.check_glasses:
                return R.id.glasses;
            case R.id.check_hat:
                return R.id.hat;
            case R.id.check_mouth:
                return R.id.mouth;
            case R.id.check_mustache:
                return R.id.mustache;
            case R.id.check_nose:
                return R.id.nose;
            case R.id.check_shoes:
                return R.id.shoes;
            default:
                return 0;
        }
    }
}
