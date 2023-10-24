package co.ex.app.driven.cmd.handler.impl;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.driven.cmd.bus.CommandBusDrivenFrm;

public class CommandBusDrivenFrmTester implements CommandBusDrivenFrm {

    AppCommandSave appThingCommandV1;

    @Override
    public void perform( co.ex.app.cmd.AppCommand appCommand ) {
        // 9
        appThingCommandV1 = (AppCommandSave) appCommand;
    }

    public AppCommandSave getAppThingCommandSave() {
        return appThingCommandV1;
    }
}
