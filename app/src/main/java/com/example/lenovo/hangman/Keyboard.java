package com.example.lenovo.hangman;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Keyboard extends Fragment {
    @Bind({R.id.a_btn, R.id.b_btn, R.id.c_btn, R.id.d_btn, R.id.e_btn, R.id.f_btn, R.id.g_btn, R.id.h_btn, R.id.i_btn, R.id.j_btn, R.id.k_btn, R.id.l_btn, R.id.m_btn, R.id.n_btn, R.id.o_btn, R.id.p_btn, R.id.q_btn, R.id.r_btn, R.id.s_btn, R.id.t_btn, R.id.u_btn, R.id.v_btn, R.id.w_btn, R.id.x_btn, R.id.y_btn, R.id.z_btn})
    List<ImageButton> keyboard_keys;

    boolean[] keys = new boolean[26];
    MediaPlayer click;
    GameZaki zz;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.keyboard, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        click = MediaPlayer.create(getActivity(), R.raw.bubble_clap);
        if (savedInstanceState != null) {
            keys = savedInstanceState.getBooleanArray("key");
            for (int i = 0; i < 26; i++)
                if (keys[i])
                    keyboard_keys.get(i).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save state
        outState.putBooleanArray("key", keys);
    }

    @OnClick({R.id.a_btn, R.id.b_btn, R.id.c_btn, R.id.d_btn, R.id.e_btn, R.id.f_btn, R.id.g_btn, R.id.h_btn, R.id.i_btn, R.id.j_btn, R.id.k_btn, R.id.l_btn, R.id.m_btn, R.id.n_btn, R.id.o_btn, R.id.p_btn, R.id.q_btn, R.id.r_btn, R.id.s_btn, R.id.t_btn, R.id.u_btn, R.id.v_btn, R.id.w_btn, R.id.x_btn, R.id.y_btn, R.id.z_btn})
    public void onClick(View v) {
        click.start();
        switch (v.getId()) {
            case R.id.a_btn:
                keyboard_keys.get(0).setVisibility(View.INVISIBLE);
                keys[0] = true;
                GameZaki.choice = "a";
                break;
            case R.id.b_btn:
                keyboard_keys.get(1).setVisibility(View.INVISIBLE);
                keys[1] = true;
                GameZaki.choice = "b";
                break;
            case R.id.c_btn:
                keyboard_keys.get(2).setVisibility(View.INVISIBLE);
                keys[2] = true;
                GameZaki.choice = "c";
                break;
            case R.id.d_btn:
                keyboard_keys.get(3).setVisibility(View.INVISIBLE);
                keys[3] = true;
                GameZaki.choice = "d";
                break;
            case R.id.e_btn:
                keyboard_keys.get(4).setVisibility(View.INVISIBLE);
                keys[4] = true;
                GameZaki.choice = "e";
                break;
            case R.id.f_btn:
                keyboard_keys.get(5).setVisibility(View.INVISIBLE);
                keys[5] = true;
                GameZaki.choice = "f";
                break;
            case R.id.g_btn:
                keyboard_keys.get(6).setVisibility(View.INVISIBLE);
                keys[6] = true;
                GameZaki.choice = "g";
                break;
            case R.id.h_btn:
                keyboard_keys.get(7).setVisibility(View.INVISIBLE);
                keys[7] = true;
                GameZaki.choice = "h";
                break;
            case R.id.i_btn:
                keyboard_keys.get(8).setVisibility(View.INVISIBLE);
                keys[8] = true;
                GameZaki.choice = "i";
                break;
            case R.id.j_btn:
                keyboard_keys.get(9).setVisibility(View.INVISIBLE);
                keys[9] = true;
                GameZaki.choice = "j";
                break;
            case R.id.k_btn:
                keyboard_keys.get(10).setVisibility(View.INVISIBLE);
                keys[10] = true;
                GameZaki.choice = "k";
                break;
            case R.id.l_btn:
                keyboard_keys.get(11).setVisibility(View.INVISIBLE);
                keys[11] = true;
                GameZaki.choice = "l";
                break;
            case R.id.m_btn:
                keyboard_keys.get(12).setVisibility(View.INVISIBLE);
                keys[12] = true;
                GameZaki.choice = "m";
                break;
            case R.id.n_btn:
                keyboard_keys.get(13).setVisibility(View.INVISIBLE);
                keys[13] = true;
                GameZaki.choice = "n";
                break;
            case R.id.o_btn:
                keyboard_keys.get(14).setVisibility(View.INVISIBLE);
                keys[14] = true;
                GameZaki.choice = "o";

                break;
            case R.id.p_btn:
                keyboard_keys.get(15).setVisibility(View.INVISIBLE);
                keys[15] = true;
                GameZaki.choice = "p";
                break;
            case R.id.q_btn:
                keyboard_keys.get(16).setVisibility(View.INVISIBLE);
                keys[16] = true;
                GameZaki.choice = "q";
                break;
            case R.id.r_btn:
                keyboard_keys.get(17).setVisibility(View.INVISIBLE);
                keys[17] = true;
                GameZaki.choice = "r";
                break;
            case R.id.s_btn:
                keyboard_keys.get(18).setVisibility(View.INVISIBLE);
                keys[18] = true;
                GameZaki.choice = "s";
                break;
            case R.id.t_btn:
                keyboard_keys.get(19).setVisibility(View.INVISIBLE);
                keys[19] = true;
                GameZaki.choice = "t";
                break;
            case R.id.u_btn:
                keyboard_keys.get(20).setVisibility(View.INVISIBLE);
                keys[20] = true;
                GameZaki.choice = "u";
                break;
            case R.id.v_btn:
                keyboard_keys.get(21).setVisibility(View.INVISIBLE);
                keys[21] = true;
                GameZaki.choice = "v";
                break;
            case R.id.w_btn:
                keyboard_keys.get(22).setVisibility(View.INVISIBLE);
                keys[22] = true;
                GameZaki.choice = "w";
                break;
            case R.id.x_btn:
                keyboard_keys.get(23).setVisibility(View.INVISIBLE);
                keys[23] = true;
                GameZaki.choice = "x";
                break;
            case R.id.y_btn:
                keyboard_keys.get(24).setVisibility(View.INVISIBLE);
                keys[24] = true;
                GameZaki.choice = "y";
                break;
            case R.id.z_btn:
                keyboard_keys.get(25).setVisibility(View.INVISIBLE);
                keys[25] = true;
                GameZaki.choice = "z";
                break;
        }
        ((GameZaki)getActivity()).checkk();
        ((GameZaki)getActivity()).win();

    }
}