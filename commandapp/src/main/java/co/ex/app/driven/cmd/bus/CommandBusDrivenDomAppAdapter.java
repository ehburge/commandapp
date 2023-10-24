package co.ex.app.driven.cmd.bus;

import co.ex.app.cmd.AppCommand;
import co.ex.app.cmd.AppCommandHandler;
import co.ex.domain.cmd.DomCommand;

public interface CommandBusDrivenDomAppAdapter<C extends AppCommand> extends AppCommandHandler {
  void perform(DomCommand domCommand);
}
