package com.example.hw1.tasks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>

 */
public class TaskListContent {

    public static final List<Task> ITEMS = new ArrayList<Task>();
    public static final Map<String, Task> ITEM_MAP = new HashMap<String, Task>();

    static {
        addItem ( new Task ( String.valueOf ( 1 ), "Miłosz", "Kwiatkowski", "17/11/1997", "165848659"));
        addItem ( new Task ( String.valueOf ( 2 ), "Shawn", "Murphy", "26/12/1995", "199999485"));
    }


    public static void addItem(Task item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }



    /**
     * A dummy item representing a piece of content.
     */
    public static class Task implements Parcelable {
        public final String id;
        public String picPath;
        public final String name;
        public final String date;
        public final String surname;
        public final String number;

        public Task(String id, String name,  String surname, String date, String number) {
            this.id = id;
            this.name =name;
            this.surname = surname;
            this.date = date;
            this.number = number;
            this.picPath="";

        }
        public Task(String id, String name,  String surname, String date, String number, String picPath) {
            this.id = id;
            this.name =name;
            this.surname = surname;
            this.date = date;
            this.picPath=picPath;
            this.number = number;
        }

        protected Task(Parcel in) {
            id = in.readString();
            picPath = in.readString();
            name = in.readString();
            date = in.readString();
            surname = in.readString();
            number = in.readString();
        }

        public static final Creator<Task> CREATOR = new Creator<Task>() {
            @Override
            public Task createFromParcel(Parcel in) {
                return new Task(in);
            }

            @Override
            public Task[] newArray(int size) {
                return new Task[size];
            }
        };


        @Override
        public String toString() {
            return name;
        }

        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(picPath);
            dest.writeString(name);
            dest.writeString(date);
            dest.writeString(surname);
            dest.writeString(number);
        }

    }
    public static void removeItem(int position)
    {
        String itemId = ITEMS.get ( position ).id;

        ITEMS.remove ( position );

        ITEM_MAP.remove ( itemId );
    }
    public static void clearList()
    {
        ITEMS.clear ();
        ITEM_MAP.clear ();
    }
}
