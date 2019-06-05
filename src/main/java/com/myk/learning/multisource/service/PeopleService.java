package com.myk.learning.multisource.service;

import com.myk.learning.multisource.model.test.People;

import java.util.List;

/**
 * The interface People service.
 * <p/>
 * Created in 2018.11.09
 * <p/>
 *
 * @author myk
 */
public interface PeopleService {
    /**
     * Select all list.
     *
     * @return the list
     */
    List<People> selectAll();

    /**
     * Insert people boolean.
     *
     * @param people the people
     * @return the boolean
     */
    Boolean insertPeople(People people);
}
