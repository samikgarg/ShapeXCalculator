package com.samazebra.mathematicalgeometrycalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.DialogFragment;


public class SquareFormulaeDialog extends DialogFragment
{
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate (R.layout.dialog_square_formulae, null);

        builder.setMessage("Square Formulae")
                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dismiss();
                    }
                });

        builder.setView (dialogView);

        return builder.create();
    }

}
