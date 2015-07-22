package spencer.nback;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NbackGenerator {

  private final static Random sRandom = new Random();
  private final int[] mNumbers;
  private final boolean[] mAnswers;
  private List<Nback> mResult;

  private NbackGenerator(Builder builder) {
    mResult = new ArrayList<>();
    mAnswers = createAnswers(builder);
    mNumbers = createNumbers(builder);
  }

  private int[] getNumbers() {
    return mNumbers;
  }

  private boolean[] getAnswers() {
    return mAnswers;
  }

  public List<Nback> getNbacks() {
    if (mResult.isEmpty()) {
      for (int i = 0; i < getNumbers().length; i++) {
        mResult.add(new Nback(getNumbers()[i], getAnswers()[i]));
      }
    }
    return mResult;
  }

  private boolean[] createAnswers(Builder builder) {
    boolean[] answers = new boolean[builder.mLength];
    for (int i = 0; i < answers.length; i++) {
      answers[i] = i >= builder.mNumberOfBack && getRandomAnswer(builder.mAnswerPercentage);
    }
    return answers;
  }

  private int[] createNumbers(Builder builder) {
    int[] result = new int[builder.mLength];
    for (int i = 0; i < builder.mLength; i++) {
      boolean isAnswer = getAnswers()[i];
      result[i] = isAnswer ? result[i - builder.mNumberOfBack] : getRandomDigit();
    }
    return result;
  }

  private int getRandomDigit() {
    return sRandom.nextInt(10);
  }

  private boolean getRandomAnswer(int percentage) {
    return (sRandom.nextInt(100) < percentage);
  }

  public static class Builder {

    private int mLength = 15;
    private int mNumberOfBack = 1;
    private int mAnswerPercentage = 40;

    public Builder setAnswerPercentage(int percentage) {
      mAnswerPercentage = percentage;
      return this;
    }

    public Builder setLength(int length) {
      mLength = length;
      return this;
    }

    public Builder setNumberOfBack(int n) {
      mNumberOfBack = n;
      return this;
    }

    public NbackGenerator build() {
      return new NbackGenerator(this);
    }
  }
}
