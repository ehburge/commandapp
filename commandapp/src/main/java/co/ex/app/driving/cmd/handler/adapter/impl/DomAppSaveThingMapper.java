package co.ex.app.driving.cmd.handler.adapter.impl;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.domain.cmd.impl.DomainCommandSave;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DomAppSaveThingMapper {
  // DomAppSaveThingMapper INSTANCE = Mappers.getMapper(DomAppSaveThingMapper.class);

  DomainCommandSave appThingToDomainThing(AppCommandSave appThingCommandV1);

  @InheritInverseConfiguration
  AppCommandSave domainThingToAppThing(DomainCommandSave domainThingCommand000);
}
