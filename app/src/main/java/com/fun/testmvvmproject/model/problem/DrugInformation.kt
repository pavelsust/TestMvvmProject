package com.`fun`.testmvvmproject.model.problem

import android.os.Parcel
import android.os.Parcelable

data class DrugInformation(var name: String?, var dose: String?, var strength: String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(dose)
        parcel.writeString(strength)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DrugInformation> {
        override fun createFromParcel(parcel: Parcel): DrugInformation {
            return DrugInformation(parcel)
        }

        override fun newArray(size: Int): Array<DrugInformation?> {
            return arrayOfNulls(size)
        }
    }
}