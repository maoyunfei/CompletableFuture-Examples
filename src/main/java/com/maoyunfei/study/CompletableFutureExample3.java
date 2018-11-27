package com.maoyunfei.study;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 使用 supplyAsync() 运行异步计算并且返回结果
 *
 * @author maoyunfei
 * @date 2018-11-27
 */
public class CompletableFutureExample3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                //模拟一个耗时任务
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException(e);
                }
                return "Result of the asynchronous computation";
            }
        });
        String result = future.get();
        System.out.println(result);
    }
}
