
package com.airbitz.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbitz.R;
import com.airbitz.api.AirbitzAPI;
import com.airbitz.models.BusinessDetail;
import com.airbitz.models.Category;
import com.airbitz.models.Hour;
import com.airbitz.models.Location;
import com.airbitz.utils.Common;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 2/13/14.
 */
public class DirectoryDetailActivity extends Activity implements GestureDetector.OnGestureListener {

    private static final String TAG = DirectoryDetailActivity.class.getSimpleName();
    private TextView mAboutField;

    private Intent mIntent;

    private RelativeLayout mParentLayout;

    private TextView mTitleTextView;
    private ImageView mLogo;
    private ImageButton mBackButton;
    private ImageButton mHelpButton;
    private BusinessDetail mDetail;
    private ImageView mBackImage;

    private double mLat;
    private double mLon;

    private LinearLayout mHourContainer;
    private TextView mDaysTextView;
    private TextView mHoursTextView;
    private Button mAddressButton;
    private Button mPhoneButton;
    private Button mWebButton;
    private String mBusinessId;

    private TextView mCategoriesTextView;
    private TextView mDiscountTextView;
    private TextView mDistanceTextView;

    private GetBusinessDetailTask mTask;

    private GestureDetector mGestureDetector;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detail);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        mGestureDetector = new GestureDetector(this);

        mBusinessId = getIntent().getExtras().getString("bizId");
        mParentLayout = (RelativeLayout) findViewById(R.id.layout_parent);

        Log.d(TAG, "Business ID: " + mBusinessId);

        mCategoriesTextView = (TextView) findViewById(R.id.textview_categories);
        mDiscountTextView = (TextView) findViewById(R.id.textview_discount);
        mDistanceTextView = (TextView) findViewById(R.id.textview_distance);

        setDistance(getIntent().getStringExtra("bizDistance"));

        mParentLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View view, MotionEvent motionEvent) {
                return mGestureDetector.onTouchEvent(motionEvent);
            }
        });

        mTask = new GetBusinessDetailTask(DirectoryDetailActivity.this);
        mTask.execute(mBusinessId);

        int timeout = 5000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override public void run() {
                if (mTask.getStatus() == AsyncTask.Status.RUNNING)
                    mTask.cancel(true);
            }
        }, timeout);

        mAddressButton = (Button) findViewById(R.id.button_address);
        mPhoneButton = (Button) findViewById(R.id.button_phone);
        mWebButton = (Button) findViewById(R.id.button_web);
        mHourContainer = (LinearLayout) findViewById(R.id.LinearLayout_hourContainer);
        mDaysTextView = (TextView) findViewById(R.id.TextView_days);
        mHoursTextView = (TextView) findViewById(R.id.TextView_hours);
        mBackImage = (ImageView) findViewById(R.id.imageview_business);

        mAboutField = (TextView) findViewById(R.id.edittext_about);

        // Header
        mLogo = (ImageView) findViewById(R.id.logo);
        mTitleTextView = (TextView) findViewById(R.id.textview_title);
        mBackButton = (ImageButton) findViewById(R.id.button_back);
        mHelpButton = (ImageButton) findViewById(R.id.button_help);

        mTitleTextView.setTypeface(BusinessDirectoryActivity.montserratBoldTypeFace);
        mLogo.setVisibility(View.GONE);
        mBackButton.setVisibility(View.VISIBLE);

        String businessName = getIntent().getExtras().getString("bizName");
        if (!TextUtils.isEmpty(businessName)) {
            mTitleTextView.setText(businessName);
            mTitleTextView.setVisibility(View.VISIBLE);
        }

        mAddressButton.setTypeface(BusinessDirectoryActivity.helveticaNeueTypeFace);
        mPhoneButton.setTypeface(BusinessDirectoryActivity.helveticaNeueTypeFace);
        mWebButton.setTypeface(BusinessDirectoryActivity.helveticaNeueTypeFace);
        mDaysTextView.setTypeface(BusinessDirectoryActivity.helveticaNeueTypeFace);
        mHoursTextView.setTypeface(BusinessDirectoryActivity.helveticaNeueTypeFace);
        mAboutField.setTypeface(BusinessDirectoryActivity.helveticaNeueTypeFace);
        mCategoriesTextView.setTypeface(BusinessDirectoryActivity.helveticaNeueTypeFace);
        mDiscountTextView.setTypeface(BusinessDirectoryActivity.helveticaNeueTypeFace);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                finish();
            }
        });
        mHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Common.showHelpInfoDialog(DirectoryDetailActivity.this, "Info", "Business directory info");
            }
        });

    }

    @Override protected void onResume() {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onResume();
    }

    @Override protected void onPause() {
        super.onPause();
    }

    @Override protected void onStop() {
        super.onStop();
    }

    private void getMapLink() {
        String address = mDetail.getAddress();

        String daddr = buildLatLonToStr(String.valueOf(mLat), String.valueOf(mLon));
        String saddr = buildLatLonToStr(String.valueOf(getLatFromSharedPreference()),
                                        String.valueOf(getLonFromSharedPreference()));

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                   Uri.parse("http://maps.google.com/maps?saddr=" + saddr
                                             + "&daddr="
                                             + daddr
                                             + "&dirflg=d"));

        intent.setComponent(new ComponentName("com.google.android.apps.maps",
                                              "com.google.android.maps.MapsActivity"));

        startActivity(intent);
    }

    private void setDistance(String strDistance) {

        double businessDistance = 0;
        try {
            businessDistance = Double.parseDouble(strDistance);
            businessDistance = Common.metersToMiles(businessDistance);
            if (businessDistance < 1) {
                businessDistance = Math.ceil(businessDistance * 10) / 10;
                String distanceString = "" + businessDistance;
                distanceString = distanceString.substring(1, distanceString.length());
                mDistanceTextView.setText(distanceString + " miles");
            } else if (businessDistance >= 1000) {
                int distanceInInt = (int) businessDistance;
                mDistanceTextView.setText(String.valueOf(distanceInInt) + " miles");
            } else {
                businessDistance = Math.ceil(businessDistance * 10) / 10;
                mDistanceTextView.setText(String.valueOf(businessDistance) + " miles");
            }
        } catch (Exception e) {
            mDistanceTextView.setText("-");
        }
    }

    private String buildLatLonToStr(String lat, String lon) {
        StringBuilder builder = new StringBuilder();
        builder.append(lat);
        builder.append(",");
        builder.append(lon);

        return builder.toString();
    }

    private class GetBusinessDetailTask extends AsyncTask<String, Void, String> {
        AirbitzAPI mApi = AirbitzAPI.getApi();
        Context mContext;
        ProgressDialog mProgressDialog;

        public GetBusinessDetailTask(Context context) {
            mContext = context;
        }

        @Override protected void onPreExecute() {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setMessage("Getting venue data...");
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override protected String doInBackground(String... params) {
            return mApi.getBusinessById(params[0]);
        }

        @Override protected void onCancelled() {
            mProgressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Timeout retrieving data",
                           Toast.LENGTH_LONG).show();
            super.onCancelled();
        }

        @Override protected void onPostExecute(String results) {
            try {
                mDetail = new BusinessDetail(new JSONObject(results));
                Location location = mDetail.getLocationObjectArray();
                mLat = location.getLatitude();
                mLon = location.getLongitude();

//                setDistance(mDetail.getDistance());

                if ((mDetail.getAddress().length() == 0) || mDetail == null) {
                    if (location != null) {
                        mAddressButton.setText("Directions");
                    } else {
                        mAddressButton.setVisibility(View.GONE);
                    }
                } else {
                    mAddressButton.setText(mDetail.getPrettyAddressString());
                }

                if (TextUtils.isEmpty(mDetail.getPhone())) {
                    mPhoneButton.setVisibility(View.GONE);
                } else {
                    mPhoneButton.setText(mDetail.getPhone());
                    mPhoneButton.setVisibility(View.VISIBLE);
                }

                if (TextUtils.isEmpty(mDetail.getWebsite())) {
                    mWebButton.setVisibility(View.GONE);
                } else {
                    mWebButton.setText(mDetail.getWebsite());
                    mWebButton.setVisibility(View.VISIBLE);
                }

                if (mDetail.getHourObjectArray() == null || mDetail.getHourObjectArray().size() == 0) {
                    mHourContainer.setVisibility(View.GONE);
                } else {
                    setSchedule(mDetail.getHourObjectArray());
                    mHourContainer.setVisibility(View.VISIBLE);
                }

                if ((mDetail.getName().length() == 0) || mDetail.getName() == null) {
                    mTitleTextView.setVisibility(View.GONE);
                } else {
                    mTitleTextView.setText(mDetail.getName());
                    mTitleTextView.setVisibility(View.VISIBLE);
                }

                if (TextUtils.isEmpty(mDetail.getDescription())) {
                    mAboutField.setVisibility(View.GONE);
                } else {
                    mAboutField.setText(mDetail.getDescription());
                    mAboutField.setVisibility(View.VISIBLE);
                }

                // Set categories text
                final List<Category> categories = mDetail.getCategoryObject();
                if (categories == null || categories.size() == 0) {
                    mCategoriesTextView.setVisibility(View.GONE);
                } else {
                    final StringBuilder sb = new StringBuilder();
                    final Iterator<Category> iter = categories.iterator();
                    while (iter.hasNext()) {
                        final Category category = iter.next();
                        sb.append(category.getCategoryName());
                        if (iter.hasNext()) {
                            sb.append(" | ");
                        }
                    }
                    mCategoriesTextView.setText(sb.toString());
                    mCategoriesTextView.setVisibility(View.VISIBLE);
                }

                // Set discount text
                String discount = mDetail.getFlagBitcoinDiscount();
                double discountDouble = 0;
                try {
                    discountDouble = Double.parseDouble(discount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (discountDouble != 0) {
                    mDiscountTextView.setText("Discount " + (int) (discountDouble * 100) + "%");
                    mDiscountTextView.setVisibility(View.VISIBLE);
                } else {
                    mDiscountTextView.setVisibility(View.GONE);
                }

                // Set photo
                Picasso.with(DirectoryDetailActivity.this).load(mDetail.getPrimaryImage().getPhotoThumbnailLink()).into(mBackImage);
//                GetBackgroundImageTask task = new GetBackgroundImageTask(mBackImage);
//                task.execute(mDetail.getPrimaryImage().getPhotoLink());

                mAddressButton.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) {
                        getMapLink();
                    }
                });
                mPhoneButton.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) {

                        if ((mDetail.getPhone().length() != 0) && mDetail.getPhone() != null) {
                            mIntent = new Intent(Intent.ACTION_CALL);
                            mIntent.setData(Uri.parse("tel:" + mDetail.getPhone()));
                            startActivity(mIntent);
                        }

                    }
                });
                mWebButton.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) {
                        if ((mDetail.getWebsite().length() != 0) && mDetail.getWebsite() != null) {
                            mIntent = new Intent(Intent.ACTION_VIEW);
                            mIntent.setData(Uri.parse(mDetail.getWebsite()));
                            startActivity(mIntent);
                        }
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
                mAddressButton.setVisibility(View.GONE);
                mPhoneButton.setVisibility(View.GONE);
                mWebButton.setVisibility(View.GONE);
                mHourContainer.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Can not retrieve data",
                               Toast.LENGTH_LONG).show();
            }
            mProgressDialog.dismiss();
        }

        private void setSchedule(List<Hour> hours) {
            final Iterator<Hour> iter = hours.iterator();
            final StringBuilder daysSb = new StringBuilder();
            final StringBuilder hoursSb = new StringBuilder();
            while (iter.hasNext()) {
                final Hour hour = iter.next();

                // Day
                daysSb.append(hour.getDayOfWeek());

                // Hour
                hoursSb.append(hour.getPrettyStartEndHour());

                if (iter.hasNext()) {
                    daysSb.append("\n");
                    hoursSb.append("\n");
                }
            }

            mDaysTextView.setText(daysSb.toString());
            mHoursTextView.setText(hoursSb.toString());
        }

//        String createScheduleString(List<Hour> hours) {
//            String schedule = "";
//            for (Hour hour : hours) {
//                String startHour = hour.getHourStart();
//                String endHour = hour.getHourEnd();
//
//                String hourString = "";
//
//                if (startHour.equalsIgnoreCase("null")) {
//                    if (!endHour.equalsIgnoreCase("null")) {
//                        hourString = endHour;
//                    }
//                } else if (endHour.equalsIgnoreCase("null")) {
//                    hourString = startHour;
//                }
//
//                schedule += hour.getDayOfWeek() + " " + hourString + "\n";
//            }
//            schedule = schedule.substring(0, schedule.length() - 1);
//            return schedule;
//        }
    }

    private class GetBackgroundImageTask extends AsyncTask<String, Void, Bitmap> {

        ImageView mTargetView;

        public GetBackgroundImageTask(ImageView targetView) {
            mTargetView = targetView;
        }

        @Override protected Bitmap doInBackground(String... params) {
            Bitmap image = null;

            try {
                InputStream in = new URL(params[0]).openStream();
                image = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e(TAG, "" + e.getMessage());
                e.printStackTrace();
            }

            return image;
        }

        @Override protected void onPostExecute(Bitmap bitmap) {
            mTargetView.setImageBitmap(bitmap);
        }
    }

    private float getStateFromSharedPreferences(String key) {
        SharedPreferences pref = getSharedPreferences(BusinessDirectoryActivity.PREF_NAME,
                                                      Context.MODE_PRIVATE);
        return pref.getFloat(key, -1);
    }

    private double getLatFromSharedPreference() {
        return (double) getStateFromSharedPreferences(BusinessDirectoryActivity.LAT_KEY);
    }

    private double getLonFromSharedPreference() {
        return (double) getStateFromSharedPreferences(BusinessDirectoryActivity.LON_KEY);
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override public void onShowPress(MotionEvent motionEvent) {

    }

    @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        return false;
    }

    @Override public void onLongPress(MotionEvent motionEvent) {

    }

    @Override public boolean onFling(MotionEvent start, MotionEvent finish, float v, float v2) {
        if (start != null & finish != null) {

            float yDistance = Math.abs(finish.getY() - start.getY());

            if ((finish.getRawX() > start.getRawX()) && (yDistance < 10)) {
                float xDistance = Math.abs(finish.getRawX() - start.getRawX());

                if (xDistance > 100) {
                    finish();
                    return true;
                }
            }
        }
        return false;
    }
}
