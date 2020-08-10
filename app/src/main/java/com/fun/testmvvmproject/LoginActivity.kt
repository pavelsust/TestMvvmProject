package com.`fun`.testmvvmproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.`fun`.testmvvmproject.other.activity.DashboardActivity
import com.`fun`.testmvvmproject.utils.AppUtils
import com.`fun`.testmvvmproject.utils.USER_EMAIL
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_login)
    }

    fun checkLoginButton(view: View) {
        if (isInfoValid()) {
            if (AppUtils.isEmailValid(edit_email.text.toString())) {
                var intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra(USER_EMAIL, edit_email.text.toString());
                Toasty.success(applicationContext, "Login Success", Toast.LENGTH_SHORT, false)
                    .show()
                startActivity(intent)
            } else {
                Toasty.error(applicationContext, "Email is not valid", Toast.LENGTH_SHORT, false)
                    .show()
                edit_email.setText("")
            }
        }
    }

    private fun isInfoValid(): Boolean {
        var err = false
        err = AppUtils.isValidText(edit_email, "Email not found")
        err = err and AppUtils.isValidText(edit_password, "Password not found")
        return err
    }

}
