package com.maoyunfei.study;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 使用 runAsync() 运行异步计算并且无返回结果
 *
 * @author maoyunfei
 * @date 2018-11-27
 */
public class CompletableFutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                // 模拟一个耗时任务
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException(e);
                }
                System.out.println("I'll run in a separate thread than the main thread.");
            }
        });
        future.get();
    }
}
