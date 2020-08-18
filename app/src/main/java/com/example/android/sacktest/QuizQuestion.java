package com.example.android.sacktest;

import java.util.ArrayList;

/**
 * Created by Bill Tong on 3/13/2018.
 */

public class QuizQuestion {

    private static ArrayList<QuizQuestion> myQuestions;
    private int questionID;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String CorrectAnswer;


    public QuizQuestion(int questionID, String question, String option1, String option2, String option3, String option4, String correctAnswer) {
        this.questionID = questionID;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.CorrectAnswer = correctAnswer;
    }

    public static void iniData() {
        myQuestions = new ArrayList<>();
        myQuestions.add(new QuizQuestion(1, "Question1", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(2, "Question2", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(3, "Question3", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(4, "Question4", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(5, "Question5", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(6, "Question6", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(7, "Question7", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(8, "Question8", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(9, "Question9", "a1", "a2", "a3", "a4", "a1"));
        myQuestions.add(new QuizQuestion(10, "Question10", "a1", "a2", "a3", "a4", "a1"));

    }

    public static ArrayList<QuizQuestion> getMyQuestions() {
        return myQuestions;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
}
