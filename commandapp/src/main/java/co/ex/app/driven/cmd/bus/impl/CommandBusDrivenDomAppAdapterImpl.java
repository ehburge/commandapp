package co.ex.app.driven.cmd.bus.impl;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.driven.cmd.handler.CommandHandlerDrivenApp;
import co.ex.app.driving.cmd.handler.adapter.impl.DomAppSaveThingMapper;
import co.ex.app.model.JsonMapper;
import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.impl.DomainCommandSave;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenApp;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CommandBusDrivenApp is in Domain DomCommand -> AppCommand mapping here. Dom does not have
 * visibility into App App has visibility into Dom.
 */
@RequiredArgsConstructor
public class CommandBusDrivenDomAppAdapterImpl implements CommandBusDrivenApp {
  private static Logger LOGGER = LoggerFactory.getLogger(CommandBusDrivenDomAppAdapterImpl.class);

  private final Map<Class<? extends co.ex.app.cmd.AppCommand>, CommandHandlerDrivenApp>
      commandHandlerDrivenAppMap;
  private DomAppSaveThingMapper domAppSaveThingMapper =
      Mappers.getMapper(DomAppSaveThingMapper.class);

  @Override
  public void perform(DomCommand domCommand) {
    // 7
    LOGGER.debug(
        "CommandBusDrivenDomainImpl.perform()"
            .concat(System.lineSeparator())
            .concat(domCommand.getClass().getName())
            .concat(System.lineSeparator()),
        JsonMapper.toJson(domCommand));

    AppCommandSave appThingCommandV1 =
        domAppSaveThingMapper.domainThingToAppThing((DomainCommandSave) domCommand);

    CommandHandlerDrivenApp commandHandlerDrivenApp =
        commandHandlerDrivenAppMap.get(appThingCommandV1.getClass());

    commandHandlerDrivenApp.handle(appThingCommandV1);
  }
}
