package com.sahibindencourseproject.api.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class DailyForecastResponse() : Parcelable {

    @SerializedName("city")
    @Expose
    var city: City? = null
    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null
    @SerializedName("list")
    @Expose
    var weatherItem: ArrayList<WeatherItem>? = null

    constructor(parcel: Parcel) : this() {
        city = parcel.readParcelable(City::class.java.classLoader)
        cod = parcel.readString()
        message = parcel.readValue(Double::class.java.classLoader) as? Double
        cnt = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(city, flags)
        parcel.writeString(cod)
        parcel.writeValue(message)
        parcel.writeValue(cnt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DailyForecastResponse> {
        override fun createFromParcel(parcel: Parcel): DailyForecastResponse {
            return DailyForecastResponse(parcel)
        }

        override fun newArray(size: Int): Array<DailyForecastResponse?> {
            return arrayOfNulls(size)
        }
    }

}
