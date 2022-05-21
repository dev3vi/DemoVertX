package com.example.starter.verticle;

import com.example.starter.Service.GetAllEmployees;
import com.example.starter.model.Customer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.util.HashMap;

public class CustomerVerticle extends AbstractVerticle {


  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    Router router=Router.router(vertx);
    router.get("/api/employees").handler(new GetAllEmployees());
    vertx
      .createHttpServer()
      .requestHandler(router::accept)
      .listen(config().getInteger("http.port", 8080),
        result -> {
          if (result.succeeded()) {
            startPromise.complete();
          } else {
            startPromise.fail(result.cause());
          }
        }
      );
  }
}
