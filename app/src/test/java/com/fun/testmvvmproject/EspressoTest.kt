package com.`fun`.testmvvmproject


import android.content.Context
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import com.`fun`.testmvvmproject.utils.AppUtils
import com.`fun`.testmvvmproject.utils.lifecycleOwner
import com.`fun`.testmvvmproject.viewmodel.ProblemViewModel
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class EspressoTest {


    val context = ApplicationProvider.getApplicationContext<Context>()

    val problem = ProblemViewModel()

    @Test
    fun problemResponse() {
        val result = problem.init(context).getProblem()
        Assert.assertNotNull(result)
    }


    @Test
    fun problemResponseCount() {
        val result = problem.init(context).getProblem()
        Assert.assertNotNull(result)
    }

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(AppUtils.isEmailValid("name_@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(AppUtils.isEmailValid("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(AppUtils.isEmailValid("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(AppUtils.isEmailValid("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(AppUtils.isEmailValid("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(AppUtils.isEmailValid(""))
    }

}