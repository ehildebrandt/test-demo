package com.example.spock.demo_09_separate_data_from_logic;

import io.reactivex.Observable;

public interface StreamSource<T> {

    <T> Observable connect();

}
