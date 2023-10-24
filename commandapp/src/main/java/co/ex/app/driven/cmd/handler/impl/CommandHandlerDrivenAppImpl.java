package co.ex.app.driven.cmd.handler.impl;

import co.ex.app.cmd.AppCommand;
import co.ex.app.driven.cmd.bus.CommandBusDrivenFrm;
import co.ex.app.driven.cmd.handler.CommandHandlerDrivenApp;
import co.ex.app.model.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

// @RequiredArgsConstructor
public class CommandHandlerDrivenAppImpl implements CommandHandlerDrivenApp {
  private static Logger LOGGER = LoggerFactory.getLogger(CommandHandlerDrivenAppImpl.class);
  private final Map<Class<? extends AppCommand>, CommandBusDrivenFrm> commandBusDrivenFrmMap;

  public CommandHandlerDrivenAppImpl(Map<Class<? extends AppCommand>, CommandBusDrivenFrm> commandBusDrivenFrmMap) {
    this.commandBusDrivenFrmMap = commandBusDrivenFrmMap;
  }

  @Override
  public void handle(AppCommand appCommand) {
    // 8
    LOGGER.debug(
        "CommandHandlerDrivenAppImpl.handle()"
            .concat(System.lineSeparator())
            .concat(JsonMapper.toJson(appCommand)));

    CommandBusDrivenFrm commandBusDrivenFrm = commandBusDrivenFrmMap.get(appCommand.getClass());
    commandBusDrivenFrm.perform(appCommand);
  }
}
