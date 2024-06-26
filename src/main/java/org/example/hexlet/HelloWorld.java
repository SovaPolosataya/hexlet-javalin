package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            if (name == null) {
                name = "World";
            }
            ctx.result("Hello, " + name + "!");
        });
        app.start(7070);
    }
}
