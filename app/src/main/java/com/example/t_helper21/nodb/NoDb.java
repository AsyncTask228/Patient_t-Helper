package com.example.t_helper21.nodb;

import com.example.t_helper21.domain.Person;
import com.example.t_helper21.domain.Problem;

import java.util.ArrayList;
import java.util.List;

public class NoDb {

    private NoDb(){}

    public static final List<Problem> PROBLEM_LIST = new ArrayList<>();
    public static final List<Person> PERSON_LIST = new ArrayList<>();
}
