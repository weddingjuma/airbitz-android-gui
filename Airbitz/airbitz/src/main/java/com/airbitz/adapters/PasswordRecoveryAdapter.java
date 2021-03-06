/**
 * Copyright (c) 2014, Airbitz Inc
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms are permitted provided that 
 * the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Redistribution or use of modified source code requires the express written
 *    permission of Airbitz Inc.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies, 
 * either expressed or implied, of the Airbitz Project.
 */

package com.airbitz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.airbitz.R;
import com.airbitz.activities.NavigationActivity;

import java.util.List;

/**
 * Created on 3/6/14.
 */
public class PasswordRecoveryAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> mQuestions;

    public PasswordRecoveryAdapter(Context context, List<String> questions) {
        super(context, R.layout.item_password_recovery_spinner, questions);
        mContext = context;
        mQuestions = questions;
    }

    @Override
    public int getCount() {
        return mQuestions.size() - 1;
    }

    @Override
    public String getItem(int position) {
        return mQuestions.get(position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.item_password_recovery_spinner_dropdown, parent, false);

        TextView textView = (TextView) convertView.findViewById(R.id.textview_dropdown_question);
        textView.setText(mQuestions.get(position));
        textView.setTypeface(NavigationActivity.latoRegularTypeFace);
        final TextView finalTextView = textView;
        textView.post(new Runnable() {
            @Override
            public void run() {
                finalTextView.setSingleLine(false);
            }
        });
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.item_password_recovery_spinner, parent, false);

        TextView textView = (TextView) convertView.findViewById(R.id.textview_question);
        textView.setText(mQuestions.get(position));
        textView.setTypeface(NavigationActivity.latoRegularTypeFace);
        return convertView;
    }
}
