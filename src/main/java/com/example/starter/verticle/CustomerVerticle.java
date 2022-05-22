package com.example.starter.verticle;

import com.example.starter.Service.CreateNewCustomer;
//import com.example.starter.Service.GetAllEmployees;
//import com.example.starter.Service.GetAllEmployeesSort;
import com.example.starter.model.Customer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.HashMap;

public class CustomerVerticle extends AbstractVerticle {


  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    //map tầng service "GetAllEmployees()" với đầu api tương ứng
    Router router=Router.router(vertx);
//    router.get("/api/employees").handler(new GetAllEmployees());
//    router.get("/api/employees-sort").handler(new GetAllEmployeesSort());
    router.route("/api/employees*").handler(BodyHandler.create());
    router.post("/api/employees").handler(new CreateNewCustomer());
    //tạo 1 máy chủ http kèm với 1 request xử lý
    vertx
      .createHttpServer()
      .requestHandler(router::accept)
      .listen(config().getInteger("http.port", 8080),
        result -> {
        //nếu liên kết với cổng 8080 thành công
          if (result.succeeded()) {
            startPromise.complete();
        //nếu liên kết với cổng 8080 thất bại(có thể do cổng đã được sử dụng)
          } else {
            startPromise.fail(result.cause());
          }
        }
      );
  }
}
