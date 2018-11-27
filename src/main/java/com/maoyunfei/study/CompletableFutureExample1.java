package com.maoyunfei.study;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Description
 *
 * @author maoyunfei
 * @date 2018-11-27
 */
public class CompletableFutureExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        completableFuture.get(1, TimeUnit.SECONDS);
        completableFuture.complete("Future's Result");
    }
}
