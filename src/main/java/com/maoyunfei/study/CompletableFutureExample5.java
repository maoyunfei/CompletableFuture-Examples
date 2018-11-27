package com.maoyunfei.study;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 使用 thenAccept()、thenRun() 转换结果并且无返回
 *
 * @author maoyunfei
 * @date 2018-11-27
 */
public class CompletableFutureExample5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                //模拟一个耗时任务
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException(e);
                }
                return "Rajeev";
            }
        });
        whatsYourNameFuture.thenAccept(name -> {
            System.out.println("Hello " + name);
        });
        TimeUnit.SECONDS.sleep(5);
    }
}
