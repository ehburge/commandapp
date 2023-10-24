package co.ex.app.driven.cmd.handler;

import co.ex.app.cmd.AppCommand;
import co.ex.app.cmd.AppCommandHandler;

public interface CommandHandlerDrivenApp<C extends AppCommand> extends AppCommandHandler {
  void handle(C command);
}
