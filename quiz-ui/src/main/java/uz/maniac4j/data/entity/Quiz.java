package uz.maniac4j.data.entity;

import javax.persistence.Entity;

@Entity
public class Quiz extends AbstractEntity {

    private String text;
    private String answerFirst;
    private String answerSecond;
    private String answerThird;
    private String answerFourth;
    private Integer rate;
    private String rightAnswer;
    private String category;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getAnswerFirst() {
        return answerFirst;
    }
    public void setAnswerFirst(String answerFirst) {
        this.answerFirst = answerFirst;
    }
    public String getAnswerSecond() {
        return answerSecond;
    }
    public void setAnswerSecond(String answerSecond) {
        this.answerSecond = answerSecond;
    }
    public String getAnswerThird() {
        return answerThird;
    }
    public void setAnswerThird(String answerThird) {
        this.answerThird = answerThird;
    }
    public String getAnswerFourth() {
        return answerFourth;
    }
    public void setAnswerFourth(String answerFourth) {
        this.answerFourth = answerFourth;
    }
    public Integer getRate() {
        return rate;
    }
    public void setRate(Integer rate) {
        this.rate = rate;
    }
    public String getRightAnswer() {
        return rightAnswer;
    }
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

}
