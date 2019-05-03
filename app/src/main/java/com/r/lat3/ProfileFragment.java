package com.r.lat3;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class ProfileFragment extends Fragment implements OnMapReadyCallback {

    MaterialDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView txtphone = (TextView) view.findViewById(R.id.txtPhone);
        TextView txtig = (TextView) view.findViewById(R.id.txtInstagram);
        TextView txtemail = (TextView) view.findViewById(R.id.txtEmail);
        TextView txtfb = (TextView) view.findViewById(R.id.txtFacebook);

        txtemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:zainnardo123@gmail.com"));
                startActivity(intent);
            }
        });

        txtfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/zain.achmad.56"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/zain.achmad.56")));
                }
            }
        });

        txtig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/zainnardo");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/zainnardo/")));
                }
            }
        });

        txtphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:085950075448"));
                startActivity(intent);
            }
        });

        LinearLayout line = (LinearLayout) view.findViewById(R.id.linear);

        line.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                dialog = new MaterialDialog.Builder(getActivity())
                        .title("Information")
                        .content("Zain's App V1.0.1")
                        .positiveText("Oke")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                            }
                        })
                        .cancelable(false)
                        .titleColorRes(R.color.orangeold)
                        .contentColorRes(R.color.darkcho)
                        .backgroundColorRes(R.color.younggold)
                        .positiveColor(getResources().getColor(R.color.orangeold))
                        .show();

            }
        });

        SupportMapFragment mMapFragment = SupportMapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map, mMapFragment);
        fragmentTransaction.commit();
        mMapFragment.getMapAsync(this);

        return view;

    }

    public void onMapReady(GoogleMap googleMap) {
        LatLng zain = new LatLng(-6.8386324, 107.5619215);
        googleMap.addMarker(new MarkerOptions()
                .position(zain)
                .title("Lokasi Ku"));
        googleMap.setMinZoomPreference(6.0f);
        googleMap.setMaxZoomPreference(14.0f);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(zain));
    }
}
