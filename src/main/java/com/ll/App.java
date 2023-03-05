package com.ll;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;
import com.ll.wiseSaying.entity.WiseSaying;

import java.util.*;

public class App {
    //final이 붙으면 재할당 불가
    public App(){
    }
    public void run() {
        System.out.println("==명언 앱==");


        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while(true){
            System.out.print("명령) ");
            //trim(): 혹시 있을지 모를 좌우공백 제거
            String cmd = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getActionCode()){
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.delete(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
            }
        }
    }
}
