package co.ex.app.driving.cmd.bus;

import static org.junit.jupiter.api.Assertions.*;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.driving.cmd.bus.impl.CommandBusDrivingAppImpl;
import co.ex.app.driving.cmd.handler.adapter.CommandHandlerDrivingAppDomAdapter;
import co.ex.app.driving.cmd.handler.adapter.impl.CommandHandlerDrivingAppDomAdapterImpl;
import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.impl.DomainThingCommand000;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandBusDrivingAppTest {

  CommandBusDrivingApp cbDrivingApp;

  static Map<Class<? extends co.ex.app.cmd.AppCommand>, CommandHandlerDrivingAppDomAdapter>
      chDrivingAppDomAdapterMap = new HashMap<>();
  static Map<Class<? extends DomCommand>, CommandBusDrivingDomain> cbDrivingD_map = new HashMap<>();
  CommandBusDrivingDomainImplTester implTester;

  @BeforeAll
  static void setupAll() {
    CommandHandlerDrivingAppDomAdapter chDrivingAppDomAdapter =
        new CommandHandlerDrivingAppDomAdapterImpl(cbDrivingD_map);
    chDrivingAppDomAdapterMap.put(AppCommandSave.class, chDrivingAppDomAdapter);
  }

  @BeforeEach
  void setUp() {
    implTester = new CommandBusDrivingDomainImplTester();
    cbDrivingD_map.put(DomainThingCommand000.class, implTester);
    cbDrivingApp = new CommandBusDrivingAppImpl(chDrivingAppDomAdapterMap);
  }

  @AfterEach
  void tearDown() {
    cbDrivingApp = null;
  }

  @Test
  void perform() {
    AppCommandSave appThingCommandV1 = AppCommandSave.builder().build();
    cbDrivingApp.perform(appThingCommandV1);

    assertTrue(implTester.isReachedPerform());
  }

  class CommandBusDrivingDomainImplTester implements CommandBusDrivingDomain {

    private boolean reachedPerform = false;

    @Override
    public void perform(DomCommand command) {
      reachedPerform = true;
    }

    public boolean isReachedPerform() {
      return reachedPerform;
    }
  }
}
