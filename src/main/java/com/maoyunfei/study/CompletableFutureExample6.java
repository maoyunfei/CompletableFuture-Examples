package com.maoyunfei.study;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 使用 thenCompose() 组合两个独立的future
 *
 * @author maoyunfei
 * @date 2018-11-27
 */
public class CompletableFutureExample6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> result = getUsersDetail("1")
                .thenCompose(user -> getCreditRating(user));

        System.out.println(result.get());

    }

    public static CompletableFuture<User> getUsersDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            return new User(1, "haha", 100.00);
        });
    }

    public static CompletableFuture<Double> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() -> {
            return user.getCreditRating();
        });
    }

    public static class User {
        private int id;
        private String name;
        private double creditRating;

        public User(int id, String name, double creditRating) {
            this.id = id;
            this.name = name;
            this.creditRating = creditRating;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCreditRating() {
            return creditRating;
        }

        public void setCreditRating(double creditRating) {
            this.creditRating = creditRating;
        }
    }

}
