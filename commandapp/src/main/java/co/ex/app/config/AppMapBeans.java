package co.ex.app.config;

import co.ex.app.cmd.AppCommand;
import co.ex.app.driven.cmd.bus.CommandBusDrivenFrm;
import co.ex.app.driven.cmd.bus.impl.CommandBusDrivenDomAppAdapterImpl;
import co.ex.app.driven.cmd.handler.CommandHandlerDrivenApp;
import co.ex.app.driven.cmd.handler.impl.CommandHandlerDrivenAppImpl;
import co.ex.app.driving.cmd.bus.CommandBusDrivingApp;
import co.ex.app.driving.cmd.bus.impl.CommandBusDrivingAppImpl;
import co.ex.app.driving.cmd.handler.adapter.CommandHandlerDrivingAppDomAdapter;
import co.ex.app.driving.cmd.handler.adapter.impl.CommandHandlerDrivingAppDomAdapterImpl;
import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.impl.DomainCommandSave;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenApp;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppMapBeans {

  @Getter
  private Map<Class<? extends AppCommand>, CommandBusDrivingApp> cbDrivingA_Map = new HashMap<>();
  @Getter
  private Map<Class<? extends AppCommand>, CommandHandlerDrivingAppDomAdapter> chDrivingA_map =
      new HashMap<>(); // ok

  @Getter
  private Map<Class<? extends DomCommand>, CommandBusDrivingDomain> cbDrivingD_map =
      new HashMap<>(); // ok

  @Getter
  private Map<Class<? extends AppCommand>, CommandHandlerDrivenApp> chDrivenA_map =
      new HashMap<>(); // ok

  @Getter
  private Map<Class<? extends DomCommand>, CommandBusDrivenApp> cbDrivenA_map = new HashMap<>();

  @Getter private Map<Class<? extends AppCommand>, CommandBusDrivenFrm> cbDrivenFrm_map = new HashMap<>(); // ok

  private CommandBusDrivingApp commandBusDrivingApp;
  private CommandHandlerDrivingAppDomAdapter handlerDrivingAppDomAdapter; // ok
  private CommandBusDrivenApp busDrivenDomAppAdapter;
  private CommandHandlerDrivenApp commandHandlerDrivenApp; // ok

  @PostConstruct
  public void postConstruct() {
    commandBusDrivingApp = new CommandBusDrivingAppImpl(chDrivingA_map);
    handlerDrivingAppDomAdapter = new CommandHandlerDrivingAppDomAdapterImpl(cbDrivingD_map);
    busDrivenDomAppAdapter = new CommandBusDrivenDomAppAdapterImpl(chDrivenA_map);
    commandHandlerDrivenApp = new CommandHandlerDrivenAppImpl(cbDrivenFrm_map); // ok
  }

  public void setCommandBusDrivingDomain(CommandBusDrivingDomain commandBusDrivingDomain) {

    cbDrivingD_map.put(DomainCommandSave.class, commandBusDrivingDomain);
  }

  public CommandBusDrivingApp getCommandBusDrivingApp() {
    return commandBusDrivingApp;
  }

  public void loadCommandBusDrivenFrm(Map<Class<? extends AppCommand>, CommandBusDrivenFrm> cbDrivenFrm_map) {

    this.cbDrivenFrm_map.putAll(cbDrivenFrm_map);
  }
}
