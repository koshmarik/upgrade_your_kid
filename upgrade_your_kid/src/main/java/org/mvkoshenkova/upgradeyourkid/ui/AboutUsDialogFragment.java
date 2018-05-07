package org.mvkoshenkova.upgradeyourkid.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;

import org.mvkoshenkova.upgradeyourkid.R;

/**
 * Created by Mariya Koshenkova on 05.05.18.
 */

public class AboutUsDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_about_us_title)
                .setMessage(R.string.dialog_about_us)
                .setPositiveButton("Ok", (dialog, id) -> {
                    super.dismiss();
                });
        return builder.create();
    }
}
