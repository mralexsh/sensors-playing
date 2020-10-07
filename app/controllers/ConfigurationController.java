package controllers;

import com.google.inject.Inject;
import models.Sensor;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import repository.SensorRepository;
import scala.reflect.api.Internals;

import java.util.concurrent.CompletionStage;


public class ConfigurationController extends Controller {

    private final SensorRepository sensorRepository;
    private final HttpExecutionContext httpExecutionContext;

    @Inject
    public ConfigurationController(SensorRepository sensorRepository,
                                   HttpExecutionContext httpExecutionContext) {
        this.sensorRepository = sensorRepository;
        this.httpExecutionContext = httpExecutionContext;
    }

    public CompletionStage<Result> index() {
        return sensorRepository.all().thenApplyAsync(
                list -> ok(views.html.configuration.index.render(list)),
                httpExecutionContext.current()
        );
    }

    public Result newSensor() {
        return ok(views.html.configuration.newsensor.render());
    }

    public Result editSensor() {
        return ok(views.html.configuration.editsensor.render());
    }

}
