package ru.vsuetapp.original_project_11.Fragments_root;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;

import ru.vsuetapp.original_project_11.Fragments_fik.Fragment_econom;
import ru.vsuetapp.original_project_11.Fragments_fik.Fragment_eixt;
import ru.vsuetapp.original_project_11.Fragments_fik.Fragment_fbo;
import ru.vsuetapp.original_project_11.Fragments_fik.Fragment_fspo;
import ru.vsuetapp.original_project_11.Fragments_fik.Fragment_pma;
import ru.vsuetapp.original_project_11.Fragments_fik.Fragment_tex;
import ru.vsuetapp.original_project_11.Fragments_fik.Fragment_uits;
import ru.vsuetapp.original_project_11.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_fik.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_fik#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_fik extends Fragment {
    Fragment_uits fuits;
    Fragment_pma fpma;
    Fragment_econom feconom;
    Fragment_tex ftex;
    Fragment_eixt feixt;
    Fragment_fspo ffspo;
    Fragment_fbo ffbo;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment_fik() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_fik.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_fik newInstance(String param1, String param2) {
        Fragment_fik fragment = new Fragment_fik();
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
        View view = inflater.inflate(R.layout.fragment_fik, container, false);

        ImageButton IBuits = (ImageButton) view.findViewById(R.id.IBuits);
        ImageButton IBpma = (ImageButton) view.findViewById(R.id.IBpma);
        ImageButton IBeconom = (ImageButton) view.findViewById(R.id.IBeconom);
        ImageButton IBtex = (ImageButton) view.findViewById(R.id.IBtex);
        ImageButton IBeixt = (ImageButton) view.findViewById(R.id.IBeixt);
        ImageButton IBfspo = (ImageButton) view.findViewById(R.id.IBfspo);
        ImageButton IBfbo = (ImageButton) view.findViewById(R.id.IBfbo);
        Button button3 = (Button) view.findViewById(R.id.button3);

        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.scale);

        button3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(animScale);
            }
        });

        fuits = new Fragment_uits();
        fpma = new Fragment_pma();
        feconom = new Fragment_econom();
        ftex = new Fragment_tex();
        feixt = new Fragment_eixt();
        ffspo = new Fragment_fspo();
        ffbo = new Fragment_fbo();


        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view1) {
                switch (view1.getId()) {
                    case R.id.IBuits:
                        ft.replace(R.id.container, fuits);
                        ft.commit();
                        break;
                    case R.id.IBpma:
                        ft.replace(R.id.container, fpma);
                        ft.commit();
                        break;
                    case R.id.IBtex:
                        ft.replace(R.id.container, ftex);
                        ft.commit();
                        break;
                    case R.id.IBeixt:
                        ft.replace(R.id.container, feixt);
                        ft.commit();
                        break;
                    case R.id.IBeconom:
                        ft.replace(R.id.container, feconom);
                        ft.commit();
                        break;
                    case R.id.IBfspo:
                        ft.replace(R.id.container, ffspo);
                        ft.commit();
                        break;
                    case R.id.IBfbo:
                        ft.replace(R.id.container, ffbo);
                        ft.commit();
                        break;
                    case R.id.tv2:
                        ft.replace(R.id.container, ffbo);
                        ft.commit();
                }
            }
        };

        IBuits.setOnClickListener( onClickListener);
        IBpma.setOnClickListener( onClickListener);
        IBeconom.setOnClickListener( onClickListener);
        IBtex.setOnClickListener( onClickListener);
        IBeixt.setOnClickListener( onClickListener);
        IBfspo.setOnClickListener( onClickListener);
        IBfbo.setOnClickListener( onClickListener);

        TabHost tabHost = view.findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");

        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Факультеты");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Институты");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Кафедры");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
        return view;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
