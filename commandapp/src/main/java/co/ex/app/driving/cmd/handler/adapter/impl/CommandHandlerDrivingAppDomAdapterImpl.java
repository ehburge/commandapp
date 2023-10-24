package co.ex.app.driving.cmd.handler.adapter.impl;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.driving.cmd.handler.adapter.CommandHandlerDrivingAppDomAdapter;
import co.ex.app.model.JsonMapper;
import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.impl.DomainCommandSave;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/** Boundary mapping app -> dom */
@RequiredArgsConstructor
public class CommandHandlerDrivingAppDomAdapterImpl implements CommandHandlerDrivingAppDomAdapter {
  private static Logger LOGGER =
      LoggerFactory.getLogger(CommandHandlerDrivingAppDomAdapterImpl.class);

  private DomAppSaveThingMapper domAppSaveThingMapper =
      Mappers.getMapper(DomAppSaveThingMapper.class);
  private final Map<Class<? extends DomCommand>, CommandBusDrivingDomain> cbDriving;

  @Override
  public void handle(co.ex.app.cmd.AppCommand appCommand) {
    // 2
    LOGGER.debug(
        "CommandHandlerDrivingAppDomAdapterImpl.handle()"
            .concat(System.lineSeparator())
            .concat(appCommand.getClass().getName())
            .concat(System.lineSeparator())
            .concat(JsonMapper.toJson(appCommand)));

    DomainCommandSave domainCommandSave =
        domAppSaveThingMapper.appThingToDomainThing((AppCommandSave) appCommand);

    CommandBusDrivingDomain commandBusDrivingDomain =
        cbDriving.get(domainCommandSave.getClass());

    commandBusDrivingDomain.perform(domainCommandSave);
  }
}
