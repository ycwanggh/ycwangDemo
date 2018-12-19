package com.demo.ycwang.ycwangdemo.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.demo.ycwang.ycwangdemo.R;

public class SpaceEditText extends AppCompatEditText {

    private int divideSpace = 4;


    /**
     * 上次输入框中的内容
     */
    private String lastString;
    /**
     * 光标的位置
     */
    private int selectPosition;
    /**
     * 输入内容回调
     */
    private TextChangeListener listener;


    public SpaceEditText(Context context) {
        super(context);
    }

    public SpaceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SpaceEditText);
        divideSpace = a.getInt(R.styleable.SpaceEditText_divideSpace, 4);
        a.recycle();

        initView();
    }

    public SpaceEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SpaceEditText);
        divideSpace = a.getInt(R.styleable.SpaceEditText_divideSpace, 4);
        a.recycle();

        initView();
    }


    private void initView() {

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (start == 0 && count > 1) {
                    return;
                }

                String textTrim = getText().toString().replaceAll(" ", "");
                if (TextUtils.isEmpty(textTrim)) {
                    return;
                }
                if (before > 0) {
                    // 删除操作
                    selectPosition = start;
                    if (TextUtils.isEmpty(lastString)) {
                        return;
                    }
                    if (TextUtils.equals(textTrim, lastString.replaceAll(" ", "")) && start >= 1) {
                        StringBuilder stringBuffer = new StringBuilder(lastString);
                        stringBuffer.deleteCharAt(start - 1);
                        selectPosition = start - 1;
                        setText(stringBuffer.toString());
                    }
                } else {
                    // 添加
                    if (start % (divideSpace + 1) == divideSpace) {
                        selectPosition = start + count + 1;
                    } else {
                        selectPosition = start + count;
                    }
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String etContent = getText().toString();
                if (TextUtils.isEmpty(etContent)) {
                    if (listener != null) {
                        listener.textChange("");
                    }
                    return;
                }

                String newContent = addSpace(etContent);
                lastString = newContent;
                if (!TextUtils.equals(newContent, etContent)) {
                    setText(newContent);
                    // 保证光标的位置
                    setSelection(selectPosition > newContent.length() ? newContent.length() : selectPosition);
                }

                // 触发回调内容
                if (listener != null) {
                    listener.textChange(newContent);
                }
            }
        });
    }


    public interface TextChangeListener {
        void textChange(String text);
    }

    public void setTextChangeListener(TextChangeListener listener) {
        this.listener = listener;
    }


    /**
     * 每4位添加一个空格
     *
     * @param content
     * @return
     */
    private String addSpace(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        content = content.replaceAll(" ", "");
        if (TextUtils.isEmpty(content)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if (i > 0 && i % divideSpace == 0) {
                sb.append(" ");
            }
            sb.append(content.charAt(i));
        }
        return sb.toString();
    }
}
