package repository;

import com.google.inject.Inject;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import models.Sensor;
import play.db.ebean.EbeanConfig;

import java.util.List;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class SensorRepository {
    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public SensorRepository(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<List<Sensor>> all() {
        return supplyAsync(() -> ebeanServer.find(Sensor.class).findList(), executionContext);
    }


}
