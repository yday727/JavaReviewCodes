package com.yday72__7.reviewCodes.exceptionHandle;

// 非检查型错误，签名方法无需抛出错误
public class ScoreException2 extends RuntimeException {
    public ScoreException2(String message) {
        super(message);    // 调用父类构造方法
    }
}
