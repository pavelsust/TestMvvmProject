package com.`fun`.testmvvmproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.`fun`.testmvvmproject.utils.AppUtils
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.content_login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_login)

    }


    public fun checkLoginButton(view: View) {
        if (isInfoValid()) {
            Toasty.success(applicationContext, "Login Success", Toast.LENGTH_SHORT, false).show()
        }
    }

    private fun isInfoValid(): Boolean {
        var err = false
        err = AppUtils.isValidText(edit_email, "Email not found")
        err = err and AppUtils.isValidText(edit_password, "Password not found")
        return err
    }

}
