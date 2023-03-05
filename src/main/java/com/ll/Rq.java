package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;
    private Map<String, String> params;
    public Rq(String cmd){
        //삭제?id=1&authorName=홍길동 일 때
        //물음표를 기준으로 2개
        String[] cmdBits = cmd.split("\\?", 2);
        actionCode = cmdBits[0]; //삭제

        params = new HashMap<>();
        if(cmdBits.length == 1){
            return; //1이면 더이상 진행 안함
        }
        //cmdBits[1]에는 id=1&authorName=홍길동이 들어있고 이걸 &를 기준으로 나눔
        //paramBits = [id=1, authorName=홍길동]
        String[] paramBits = cmdBits[1].split("&");

        for(String paramStr : paramBits){
            String[] paramStrBits = paramStr.split("=", 2);

            if(paramStrBits.length == 1) continue;

            String key = paramStrBits[0];   //id
            String value = paramStrBits[1]; //1

            params.put(key, value);
        }
    }
    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }

    public int getIntParam(String id, int defaultValue) {
        try{
            return Integer.parseInt(getParam("id"));
        }catch (NumberFormatException e){

        }

        return defaultValue;
    }
}
