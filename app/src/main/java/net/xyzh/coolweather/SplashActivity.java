//package net.xyzh.coolweather;
//
//import android.Manifest;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SplashActivity extends AppCompatActivity {
//
//    private RelativeLayout container;
//
//    //判断是否可以跳过广告,进入MainActivity
//    private boolean canJump;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
//
//        container = (RelativeLayout) findViewById(R.id.container);
//
//        //运行时进行权限处理
//        List<String> permissionList = new ArrayList<>();
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
//        }
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.READ_PHONE_STATE);
//        }
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        }
//        if (!permissionList.isEmpty()) {
//            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
//            ActivityCompat.requestPermissions(this,permissions,1);
//        }else {
//            requestAds();
//        }
//
//    }
//
//    /**
//     * 请求开屏广告
//     */
//    private void requestAds() {
//        String appId = "";
//        String adId = "";
//
//        new SplashAD(this,container,appId,adId,new SplashADListener(){
//
//            @Override
//            public void onADDismissed() {
//                //广告显示完毕
//                forward();
//            }
//
//            @Override
//            public void onNoAD(int i) {
//                //广告加载失败
//                forward();
//            }
//
//            @Override
//            public void onADPresent() {
//                //广告加载成功
//            }
//
//            @Override
//            public void onADClicked() {
//                //广告被点击
//            }
//
//        });
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        canJump = false;
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (canJump) {
//            forward();
//        }
//        canJump = true;
//    }
//
//    private void forward() {
//        if (canJump) {
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//            finish();
//        }else {
//            canJump = true;
//        }
//    }
//
//    @Override
//    public void onRequestPermissionResult(int requestCode,String[] permissions,int[] grantResults) {
//        switch (requestCode) {
//            case 1:
//                if (grantResults.length > 0) {
//                    for (int result : grantResults) {
//                        if (result != PackageManager.PERMISSION_GRANTED) {
//                            Toast.makeText(this,"必须同意所有权限才能使用本程序",Toast.LENGTH_SHORT).show();
//                            finish();
//                            return;
//                        }
//                    }
//                    requestAds();
//                }else  {
//                    Toast.makeText(this,"发生未知错误",Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//                break;
//            default:
//        }
//    }
//
//}
