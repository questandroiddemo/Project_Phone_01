package aidlservice;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class RecentModel implements Parcelable {


    private int id;
    private String name, number, date;

    protected RecentModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        number = in.readString();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(number);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RecentModel> CREATOR = new Creator<RecentModel>() {
        @Override
        public RecentModel createFromParcel(Parcel in) {
            return new RecentModel(in);
        }

        @Override
        public RecentModel[] newArray(int size) {
            return new RecentModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RecentModel(String name, String number, String date) {
        this.name = name;
        this.number = number;
        this.date = date;
    }

    public RecentModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy MMMM dd hh:mm:ss");
        this.date = dateFormat.format(date);
    }

    public static Comparator<RecentModel> recentsModelDateComparator = new Comparator<RecentModel>() {
        @Override
        public int compare(RecentModel recent1, RecentModel recent2) {
            return Integer.parseInt(recent1.getDate()) - Integer.parseInt(recent2.getDate());
        }
    };
}