package com.yday72__7.reviewCodes.exceptionHandle;

// 检查型错误，抛出该错误的签名方法需添加throws ScoreException1
public class ScoreException1 extends Exception {
    public ScoreException1(String message) {
        super(message);    // 调用父类构造方法
    }
}
