package Layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.Freedom.ForgetActivity;
import com.example.Freedom.Login2Activity;
import com.example.Freedom.MeActivity;
import com.example.Freedom.OrderActivity;
import com.example.Freedom.UserSession;
import com.example.androidproject.ChoiceOption;
import com.example.androidproject.MainActivity;
import  com.example.androidproject.R;


/**
 * Created by MECHREVO on 2018/4/26.
 */

public class ContentAccountLayout extends Fragment {

    //UI相关
    private TextView mTextMessage;
    private ImageButton mImageButton;
    private RelativeLayout relativeLayout;
    private TextView mTextViewLogin;
    private TextView mTextViewOrder;
    private TextView mTextViewLogout;

    //session相关
    private UserSession usersession;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_me,container,false);


        usersession = (UserSession) getActivity().getApplicationContext();

        if(usersession.getUsername() == null) {
            Log.e("我的界面","session为空");
            mTextViewOrder = (TextView) view.findViewById(R.id.textView_order);
            mTextViewOrder.setVisibility(View.GONE);
            mTextViewLogout = (TextView) view.findViewById(R.id.textView_logout);
            mTextViewLogout.setVisibility(View.GONE);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.login_relativelayout);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Login2Activity.class);
                    startActivity(intent);
                }
            });
        }
        else
        {
            Log.e("我的界面","session不为空");
            mTextViewLogin = (TextView) view.findViewById(R.id.textView_login);
            mTextViewLogin.setText(usersession.getUsername());
            mTextViewLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ForgetActivity.class);
                    startActivity(intent);
                }
            });
            mTextViewOrder = (TextView) view.findViewById(R.id.textView_order);
            mTextViewOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), OrderActivity.class);
                    startActivity(intent);
                }
            });
            mTextViewLogout = (TextView) view.findViewById(R.id.textView_logout);
            mTextViewLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usersession.setUsername(null);
                    usersession.setPassword(null);
                    Intent intent = new Intent(getContext(), ChoiceOption.class);
                    startActivity(intent);
                }
            });
        }



        return view;
    }
}
