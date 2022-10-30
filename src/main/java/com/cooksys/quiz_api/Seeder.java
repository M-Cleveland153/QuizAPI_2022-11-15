package com.cooksys.quiz_api;

import java.util.Arrays;

import com.cooksys.quiz_api.entities.Answer;
import com.cooksys.quiz_api.entities.Question;
import com.cooksys.quiz_api.entities.Quiz;
import com.cooksys.quiz_api.repositories.AnswerRepository;
import com.cooksys.quiz_api.repositories.QuestionRepository;
import com.cooksys.quiz_api.repositories.QuizRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

  private final QuizRepository quizRepository;
  private final QuestionRepository questionRepository;
  private final AnswerRepository answerRepository;

  /**
   * This method seeds the database with 2 quizzes. Each quiz has 4 questions and
   * each question has 4 possible answers. Feel free to edit this seeder, but note
   * that the order in which you create and save quizzes/questions/answers to the
   * database does matter.
   */
  @Override
  public void run(String... args) throws Exception {
    Quiz quiz1 = new Quiz();
    quiz1.setQuizName("Quiz 1");

    Quiz quiz2 = new Quiz();
    quiz2.setQuizName("Quiz 2");

    quizRepository.saveAll(Arrays.asList(new Quiz[] { quiz1, quiz2 }));

    Question question1 = new Question();
    question1.setQuesText("1?");
    question1.setQuiz(quiz1);

    Question question2 = new Question();
    question2.setQuesText("2?");
    question2.setQuiz(quiz1);

    Question question3 = new Question();
    question3.setQuesText("3?");
    question3.setQuiz(quiz1);

    Question question4 = new Question();
    question4.setQuesText("4?");
    question4.setQuiz(quiz1);

    Question question5 = new Question();
    question5.setQuesText("5?");
    question5.setQuiz(quiz2);

    Question question6 = new Question();
    question6.setQuesText("6?");
    question6.setQuiz(quiz2);

    Question question7 = new Question();
    question7.setQuesText("7?");
    question7.setQuiz(quiz2);

    Question question8 = new Question();
    question8.setQuesText("8?");
    question8.setQuiz(quiz2);

    questionRepository.saveAll(Arrays.asList(
        new Question[] { question1, question2, question3, question4, question5, question6, question7, question8 }));

    Answer answer1 = new Answer();
    answer1.setAnsText("A");
    answer1.setCorrect(true);
    answer1.setQuestion(question1);

    Answer answer2 = new Answer();
    answer2.setAnsText("B");
    answer2.setQuestion(question1);

    Answer answer3 = new Answer();
    answer3.setAnsText("C");
    answer3.setQuestion(question1);

    Answer answer4 = new Answer();
    answer4.setAnsText("D");
    answer4.setQuestion(question1);

    Answer answer5 = new Answer();
    answer5.setAnsText("A");
    answer5.setQuestion(question2);

    Answer answer6 = new Answer();
    answer6.setAnsText("B");
    answer6.setCorrect(true);
    answer6.setQuestion(question2);

    Answer answer7 = new Answer();
    answer7.setAnsText("C");
    answer7.setQuestion(question2);

    Answer answer8 = new Answer();
    answer8.setAnsText("D");
    answer8.setQuestion(question2);

    Answer answer9 = new Answer();
    answer9.setAnsText("A");
    answer9.setCorrect(true);
    answer9.setQuestion(question3);

    Answer answer10 = new Answer();
    answer10.setAnsText("B");
    answer10.setQuestion(question3);

    Answer answer11 = new Answer();
    answer11.setAnsText("C");
    answer11.setQuestion(question3);

    Answer answer12 = new Answer();
    answer12.setAnsText("D");
    answer12.setQuestion(question3);

    Answer answer13 = new Answer();
    answer13.setAnsText("A");
    answer13.setQuestion(question4);

    Answer answer14 = new Answer();
    answer14.setAnsText("B");
    answer14.setCorrect(true);
    answer14.setQuestion(question4);

    Answer answer15 = new Answer();
    answer15.setAnsText("C");
    answer15.setQuestion(question4);

    Answer answer16 = new Answer();
    answer16.setAnsText("D");
    answer16.setQuestion(question4);

    Answer answer17 = new Answer();
    answer17.setAnsText("A");
    answer17.setCorrect(true);
    answer17.setQuestion(question5);

    Answer answer18 = new Answer();
    answer18.setAnsText("B");
    answer18.setQuestion(question5);

    Answer answer19 = new Answer();
    answer19.setAnsText("C");
    answer19.setQuestion(question5);

    Answer answer20 = new Answer();
    answer20.setAnsText("D");
    answer20.setQuestion(question5);

    Answer answer21 = new Answer();
    answer21.setAnsText("A");
    answer21.setQuestion(question6);

    Answer answer22 = new Answer();
    answer22.setAnsText("B");
    answer22.setCorrect(true);
    answer22.setQuestion(question6);

    Answer answer23 = new Answer();
    answer23.setAnsText("C");
    answer23.setQuestion(question6);

    Answer answer24 = new Answer();
    answer24.setAnsText("D");
    answer24.setQuestion(question6);

    Answer answer25 = new Answer();
    answer25.setAnsText("A");
    answer25.setCorrect(true);
    answer25.setQuestion(question7);

    Answer answer26 = new Answer();
    answer26.setAnsText("B");
    answer26.setQuestion(question7);

    Answer answer27 = new Answer();
    answer27.setAnsText("C");
    answer27.setQuestion(question7);

    Answer answer28 = new Answer();
    answer28.setAnsText("D");
    answer28.setQuestion(question7);

    Answer answer29 = new Answer();
    answer29.setAnsText("A");
    answer29.setQuestion(question8);

    Answer answer30 = new Answer();
    answer30.setAnsText("B");
    answer30.setCorrect(true);
    answer30.setQuestion(question8);

    Answer answer31 = new Answer();
    answer31.setAnsText("C");
    answer31.setQuestion(question8);

    Answer answer32 = new Answer();
    answer32.setAnsText("D");
    answer32.setQuestion(question8);

    answerRepository.saveAll(Arrays.asList(new Answer[] { answer1, answer2, answer3, answer4, answer5, answer6, answer7,
        answer8, answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18,
        answer19, answer20, answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29,
        answer30, answer31, answer32 }));
    

  }

}
