package net.xyzh.coolweather.gson;

import com.google.gson.annotations.SerializedName;

public class Basic {

    //@SerializedName注解的方式,使JSON字段、Java字段之间建立映射关系
    @SerializedName("id")
    public String weatherId;

    @SerializedName("city")
    public String cityName;

    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updateTime;

    }

}
