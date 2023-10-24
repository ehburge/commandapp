package co.ex.app.cmd.impl;

import co.ex.app.cmd.AppCommand;
import co.ex.app.model.AppParts;
import co.ex.app.model.AppRole;
import co.ex.app.model.AppComments;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class AppCommandSave implements AppCommand {

  private UUID uuid;
  @Setter private Long id;
  private AppRole role;
  private String eventKind;
  private String promoCodes;
  private AppComments comments;
  private AppParts parts;
}
