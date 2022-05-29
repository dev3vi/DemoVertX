package com.example.starter.verticle;

import com.example.starter.handler.ExcelGETHandlers;
import com.example.starter.handler.StudentGETHandlers;
import com.example.starter.handler.CreateNewCustomer;
import com.example.starter.handler.GetAllEmployees;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class CustomerVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    //map tầng service "GetAllEmployees()" với đầu api tương ứng
    Router router=Router.router(vertx);
//    router.get("/api/employees").handler(new GetAllEmployees());
    router.get("/api/get-employees").handler(new GetAllEmployees());
    router.route("/api/employees*").handler(BodyHandler.create());
    router.post("/api/employees").handler(new CreateNewCustomer());
    router.get("/api/connect").handler(new StudentGETHandlers());
    router.get("/api/excel").handler(new ExcelGETHandlers());
//    router.get("/api/report-ttv-assign-handler").handler(new ReportTVVAssignGETHandlers());
//    router.get("/api/report-ttv-daily-handler").handler(new ReportTVVDailyGETHandlers());
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
