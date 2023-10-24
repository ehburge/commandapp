package co.ex.app;

import static org.junit.jupiter.api.Assertions.*;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.config.AppSetupMapBeans;
import co.ex.app.driven.cmd.bus.CommandBusDrivenFrm;
import co.ex.app.driving.cmd.bus.CommandBusDrivingApp;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommandBusDrivingAppTestInteg {

  @Autowired AppSetupMapBeans setupMapBeans;

  @Test
  void perform() {

    Long startTime = System.currentTimeMillis();
    CommandBusDrivenFrmTester commandBusDrivenFrmTester = new CommandBusDrivenFrmTester();
    Map<Class<? extends co.ex.app.cmd.AppCommand>, CommandBusDrivenFrm> cbDrivenFrm_map = new HashMap<>();
    cbDrivenFrm_map.put(AppCommandSave.class, commandBusDrivenFrmTester);
    setupMapBeans.putCommandBusDrivenFrm(cbDrivenFrm_map);

    AppCommandSave appCommandSave = AppCommandSave.builder().thingNbr(1L).build();

    CommandBusDrivingApp commandBusDrivingApp =
        setupMapBeans.getCommandBusDrivingAppMap().get(appCommandSave.getClass());

    commandBusDrivingApp.perform(appCommandSave);

    Long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
    assertNotNull(commandBusDrivenFrmTester.appThingCommandV1);
  }

  class CommandBusDrivenFrmTester implements CommandBusDrivenFrm {

    AppCommandSave appThingCommandV1;

    @Override
    public void perform(co.ex.app.cmd.AppCommand appCommand) {
      appThingCommandV1 = (AppCommandSave) appCommand;
    }
  }
}
