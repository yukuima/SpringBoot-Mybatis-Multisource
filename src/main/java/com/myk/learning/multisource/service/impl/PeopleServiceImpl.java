package com.myk.learning.multisource.service.impl;

import com.myk.learning.multisource.mapper.test.PeopleMapper;
import com.myk.learning.multisource.model.test.People;
import com.myk.learning.multisource.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * People service
 * <p/>
 * Created in 2018.11.09
 * <p/>
 *
 * @author myk
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    /**
     * The People mapper.
     */
    @Autowired
    PeopleMapper peopleMapper;

    @Override
    public List<People> selectAll() {
        return peopleMapper.findAll();
    }

    @Override
    public Boolean insertPeople(People people) {
        return peopleMapper.insertSelective(people);
    }
}
