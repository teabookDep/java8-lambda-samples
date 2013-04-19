package com.nearinfinity.java8.samples;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReductionTest {

    private List<Integer> _numbers;
    private List<String> _names;

    @Before
    public void setUp() {
        _numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        _names = Arrays.asList("Bob", "Tom", "Jeff", "Scott", "Jennifer", "Steve");
    }

    @Test
    public void testSumOfSquaresReducer() {
        assertThat(_numbers.stream().map(value -> value * value).sum(), is(385L));
    }

    @Test
    public void testAverageOfSquaresReducer() {
        OptionalDouble result = _numbers.stream().map(value -> value * value).average();
        assertThat(result.getAsDouble(), is(38.5));
    }

    @Test
    public void testFindLongestNameReducer() {
        Optional<String> longestName = _names.stream().reduce((name1, name2) ->
            name1.length() >= name2.length() ? name1 : name2);
        assertThat(longestName.get(), is("Jennifer"));
    }
}