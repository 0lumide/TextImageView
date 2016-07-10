package co.mide.sample.textimageview;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.github.danielnilsson9.colorpickerview.dialog.ColorPickerDialogFragment;
import com.github.danielnilsson9.colorpickerview.view.ColorPanelView;

import co.mide.textimageview.TextImageView;

public class MainActivity extends AppCompatActivity  implements ColorPickerDialogFragment.ColorPickerDialogListener {

    private static final int TEXT_PREFERENCE_DIALOG_ID = 1;
    private static final int BACK_PREFERENCE_DIALOG_ID = 2;
    private ColorPanelView textPanel;
    private ColorPanelView backPanel;
    private TextImageView textImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textImageView = (TextImageView) findViewById(R.id.textimageview);
        textPanel = (ColorPanelView)findViewById(R.id.textcolorpicker);
        backPanel = (ColorPanelView)findViewById(R.id.backcolorpicker);

        textPanel.setColor(textImageView.getTextColor());
        backPanel.setColor(textImageView.getImageBackgroundColor());

        EditText editText = (EditText)findViewById(R.id.text);
        if(editText != null) {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s != null) {
                        String text = s.toString();
                        if (!text.isEmpty())
                            textImageView.setText(text.trim());
                        else
                            textImageView.setText(null);
                    }else{
                        textImageView.setText(null);
                    }
                }
            });
        }

        textPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPickerDialogFragment dialog = ColorPickerDialogFragment
                        .newInstance(TEXT_PREFERENCE_DIALOG_ID, getResources().getString(R.string.text_color),
                                null, textPanel.getColor(), true);

                dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.LightPickerDialogTheme);
                dialog.show(getFragmentManager(), "pre_dialog");
            }
        });
        backPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPickerDialogFragment dialog = ColorPickerDialogFragment
                        .newInstance(BACK_PREFERENCE_DIALOG_ID, getResources().getString(R.string.background_color),
                                null, backPanel.getColor(), true);

                dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.LightPickerDialogTheme);
                dialog.show(getFragmentManager(), "pre_dialog");
            }
        });
    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        switch (dialogId){
            case TEXT_PREFERENCE_DIALOG_ID:
                textPanel.setColor(color);
                break;
            case BACK_PREFERENCE_DIALOG_ID:
                backPanel.setColor(color);
                break;
        }
        textImageView.setTextColor(textPanel.getColor());
        textImageView.setImageBackgroundColor(backPanel.getColor());
    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }
}
