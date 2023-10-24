package co.ex.app.driven.cmd.handler.impl;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.driven.cmd.handler.CommandHandlerDrivenApp;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CommandHandlerDrivenAppTestImpl implements CommandHandlerDrivenApp {

    AppCommandSave cmd;

    @Override
    public void handle( co.ex.app.cmd.AppCommand appCommand ) {
        cmd = (AppCommandSave) appCommand;
    }


    public AppCommandSave getAppThingCommandSave() {
        return cmd;
    }
}
