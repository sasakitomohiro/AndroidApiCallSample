package t0mat0ts.com.apisample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Prefectures implements Serializable {

    private static final long serialVersionUID = 1693460270197203475L;

    @SerializedName("message")
    public String message;

    @SerializedName("result")
    public List<Result> result;

    public static class Result {
        @SerializedName("prefCode")
        String prefCode;

        @SerializedName("prefName")
        String prefName;
    }
}
