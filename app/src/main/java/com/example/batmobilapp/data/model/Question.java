package com.example.batmobilapp.data.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    private int id;
    private String title;
    private String description;

    public String getAnswerUsername() {
        return answerUsername;
    }

    public void setAnswerUsername(String answerUsername) {
        this.answerUsername = answerUsername;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String answerUsername;
    private String answerDate;
    private String answer;

    public Question(int id, String title, String description, String answerUsername, String answerDate, String answer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.answerUsername = answerUsername;
        this.answerDate = answerDate;
        this.answer = answer;
    }

    protected Question(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
    }
}
