package zuai.tan.uicustom.ui.activity;

import com.gyf.immersionbar.ImmersionBar;

import zuai.tan.uicustom.R;
import zuai.tan.uicustom.ui.activity.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(LoginActivity.this)
                .statusBarDarkFont(true)
                .fullScreen(true)
                .autoDarkModeEnable(true)
                .statusBarColor(R.color.colorTransparent)
                .init();
    }
}
