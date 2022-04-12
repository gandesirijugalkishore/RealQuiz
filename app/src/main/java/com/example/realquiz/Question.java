package com.example.realquiz;
// question actions options activity
public class Question {
    String question; // string for question
    String option1,option2,option3,option4; // string for options
    String answer; // string for answer
    Question(String question,String option1,String option2,String option3,String option4,String answer){
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    } // to get answer of question

    public String getOption1() {
        return option1;
    } // to get option 1 for question

    public String getOption2() {
        return option2;
    } // to get option 2 for question

    public String getOption3() {
        return option3;
    }// to get option 3 for question

    public String getOption4() {
        return option4;
    } // to get option 4 for question

    public String getQuestion() {
        return question;
    } // to get question

}
