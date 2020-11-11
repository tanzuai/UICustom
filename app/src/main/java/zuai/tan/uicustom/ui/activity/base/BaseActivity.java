package zuai.tan.uicustom.ui.activity.base;

import android.app.Activity;
import android.os.Bundle;
import com.gyf.immersionbar.ImmersionBar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import zuai.tan.uicustom.R;


/**
* @ClassName:   BaseActivity
* @CreateDate:  2020/11/9 17:05
* @Description: baseActivity 公用activity方法和属性
* @Author:      TanZuai
*/
public abstract class BaseActivity  extends AppCompatActivity {
    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mActivity = this;
        //初始化沉浸式
        initImmersionBar();
        //初始化数据
        initData();
        //view与数据绑定
        initView();
        //设置监听
        setListener();
    }

    /**
     * 子类设置布局Id
     * @return the layout id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected void initImmersionBar() {
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        //设置共同沉浸式样式
        ImmersionBar.with(this).navigationBarColor(R.color.colorText).init();
    }

    protected void initData() {}

    protected void initView() {}

    protected void setListener() {}
}
