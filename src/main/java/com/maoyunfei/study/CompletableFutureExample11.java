package com.maoyunfei.study;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 使用 handle() 方法处理异常
 *
 * @author maoyunfei
 * @date 2018-11-27
 */
public class CompletableFutureExample11 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            return res;
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }

}
