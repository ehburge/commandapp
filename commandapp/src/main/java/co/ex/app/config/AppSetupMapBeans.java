package co.ex.app.config;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.driven.cmd.bus.CommandBusDrivenFrm;
import co.ex.app.driven.cmd.bus.impl.CommandBusDrivenDomAppAdapterImpl;
import co.ex.app.driven.cmd.handler.impl.CommandHandlerDrivenAppImpl;
import co.ex.app.driving.cmd.bus.CommandBusDrivingApp;
import co.ex.app.driving.cmd.bus.impl.CommandBusDrivingAppImpl;
import co.ex.app.driving.cmd.handler.adapter.impl.CommandHandlerDrivingAppDomAdapterImpl;
import co.ex.domain.cmd.impl.DomainCommandSave;
import co.ex.domain.config.SetupMapBeans;
import jakarta.annotation.PostConstruct;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppSetupMapBeans {

  private final AppMapBeans appMapBeans;
  private final SetupMapBeans setupMapBeans;

  @PostConstruct
  public void setup() {

    appMapBeans
        .getCbDrivingA_Map()
        .put(AppCommandSave.class, new CommandBusDrivingAppImpl(appMapBeans.getChDrivingA_map()));

    appMapBeans
        .getCbDrivingD_map()
        .put(DomainCommandSave.class, setupMapBeans.getCommandBusDrivingDomain());

    appMapBeans
        .getChDrivingA_map()
        .put(
            AppCommandSave.class,
            new CommandHandlerDrivingAppDomAdapterImpl(appMapBeans.getCbDrivingD_map()));

    appMapBeans
        .getCbDrivenA_map()
        .put(
                DomainCommandSave.builder().build().getClass(),
            new CommandBusDrivenDomAppAdapterImpl(appMapBeans.getChDrivenA_map()));

    appMapBeans
        .getChDrivenA_map()
        .put(
            AppCommandSave.class,
            new CommandHandlerDrivenAppImpl(appMapBeans.getCbDrivenFrm_map()));

    setupMapBeans.setCommandHandlerDrivenDomain(appMapBeans.getCbDrivenA_map());
  }

  public void putCommandBusDrivenFrm(Map<Class<? extends co.ex.app.cmd.AppCommand>, CommandBusDrivenFrm> cbDrivenFrm_map) {
    appMapBeans.loadCommandBusDrivenFrm(cbDrivenFrm_map);
  }

  public Map<Class<? extends co.ex.app.cmd.AppCommand>, CommandBusDrivingApp> getCommandBusDrivingAppMap() {
    return appMapBeans.getCbDrivingA_Map();
  }
}
