package co.ex.app.driving.cmd.bus;

import co.ex.app.cmd.AppCommand;
import co.ex.app.cmd.AppCommandBus;

public interface CommandBusDrivingApp {
  void perform(AppCommand command);
}
