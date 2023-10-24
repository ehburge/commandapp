package co.ex.app.driving.cmd.bus.impl;

import co.ex.app.cmd.AppCommand;
import co.ex.app.driving.cmd.bus.CommandBusDrivingApp;
import co.ex.app.driving.cmd.handler.adapter.CommandHandlerDrivingAppDomAdapter;
import co.ex.app.model.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@RequiredArgsConstructor
public class CommandBusDrivingAppImpl implements CommandBusDrivingApp {
  private static Logger LOGGER = LoggerFactory.getLogger(CommandBusDrivingAppImpl.class);

  private final Map<Class<? extends AppCommand>, CommandHandlerDrivingAppDomAdapter> chMap;

  @Override
  public void perform(AppCommand appCommand) {
    // 1
    LOGGER.debug(
        "CommandBusDrivenDomainImpl.perform()"
            .concat(System.lineSeparator())
            .concat(appCommand.getClass().getName())
            .concat(System.lineSeparator()),
        JsonMapper.toJson(appCommand));

    chMap.get(appCommand.getClass()).handle(appCommand);
  }
}
