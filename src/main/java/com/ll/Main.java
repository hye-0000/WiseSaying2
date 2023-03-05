package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //공통적으로 사용되는 것들을 모아두는 공간(Container) 초기화
        Container.init();

        //기본적으로 스캐너를 가지고 있는 app
        new App().run();

        //공통적으로 사용되는 것들을 모아두는 공간(Container) 자원해제
        Container.close();
    }
}