package aidlservice;

import android.os.Parcel;
import android.os.Parcelable;

public class FavoriteModel implements Parcelable {
    private int id;
    private String name, number;

    public FavoriteModel() {
    }

    public FavoriteModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    protected FavoriteModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        number = in.readString();
    }

    public static final Creator<FavoriteModel> CREATOR = new Creator<FavoriteModel>() {
        @Override
        public FavoriteModel createFromParcel(Parcel in) {
            return new FavoriteModel(in);
        }

        @Override
        public FavoriteModel[] newArray(int size) {
            return new FavoriteModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(number);
    }
}
