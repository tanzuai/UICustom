package zuai.tan.uicustom.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import androidx.core.content.ContextCompat;
import zuai.tan.uicustom.R;


/**
 * @ClassName: DeleteContent_Edit
 * @Description:
 * @Author: 谭祖爱
 */
@SuppressLint("AppCompatCustomView")
public class DeleteContent_Edit extends EditText {

    private Context mContext;
    private Drawable deleteImage;
    private Paint mPaint;
    private boolean isShowLine;

    public DeleteContent_Edit(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(attrs);
    }

    public DeleteContent_Edit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(attrs);
    }


    private void init(AttributeSet attrs) {
        mPaint = new Paint();
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.EditStyle);
        deleteImage = a.getDrawable(R.styleable.EditStyle_deleteImage);
        isShowLine=a.getBoolean(R.styleable.EditStyle_isShowLine,false);
        if(isShowLine){
            mPaint = new Paint();//设置画笔的属性
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(ContextCompat.getColor(mContext,R.color.colorWhiteHui));//设置画笔颜色为红色
            mPaint.setStrokeWidth(4);
        }
        a.recycle();

        if (deleteImage != null) {//判断是否添加了删除按钮
            addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    setDeleteImg();
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });
        }
    }

    private void setDeleteImg() {//设置删除按钮，输入字符串大于1时显示
        if (length()< 1){
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }else {
            setCompoundDrawablesWithIntrinsicBounds(null,null,deleteImage,null);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(isShowLine) canvas.drawLine(0, this.getHeight()-2, this.getWidth()-2, this.getHeight()-2, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            if (deleteImage != null  && (event.getX() > getWidth() - getPaddingRight() - deleteImage.getIntrinsicWidth()))
                getText().clear();
        }

        return super.onTouchEvent(event);
    }
}

