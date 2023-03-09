package melvincarl.pote.n01483399.lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        TextView passedText = view.findViewById(R.id.textView7);
        Switch toggleSwitch = view.findViewById(R.id.switch1);
        getParentFragmentManager().setFragmentResultListener("requestEmail", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                passedText.setText(result.getString("email"));
            }
        });

        toggleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Snackbar ourSnackBar = Snackbar.make(view,getResources().getString(R.string.onSwitch),Snackbar.LENGTH_INDEFINITE);
                    ourSnackBar.setAction(getResources().getString(R.string.closeSnackBar), new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                    ourSnackBar.show();
                }
                else {
                    Snackbar ourSnackBar = Snackbar.make(view,getResources().getString(R.string.offSwitch),Snackbar.LENGTH_INDEFINITE);
                    ourSnackBar.setAction(getResources().getString(R.string.closeSnackBar), new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                    ourSnackBar.show();
                }
            }
        });
        return view;
    }
}