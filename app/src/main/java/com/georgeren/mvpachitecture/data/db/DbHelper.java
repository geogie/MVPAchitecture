package com.georgeren.mvpachitecture.data.db;

import com.georgeren.mvpachitecture.data.db.model.Option;
import com.georgeren.mvpachitecture.data.db.model.Question;
import com.georgeren.mvpachitecture.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by georgeRen on 2017/9/4.
 * db抽出
 */

public interface DbHelper {
    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();

    Observable<List<Question>> getAllQuestions();

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveOption(Option option);

    Observable<Boolean> saveQuestionList(List<Question> questionList);

    Observable<Boolean> saveOptionList(List<Option> optionList);
}
