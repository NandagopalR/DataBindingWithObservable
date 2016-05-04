package com.nanda.databinding.utils;

import android.content.Context;
import android.widget.Toast;

public class MethodUtils {

    public static void makeToast(Context context, String input) {
        Toast.makeText(context, "" + input, Toast.LENGTH_SHORT).show();
    }

}
