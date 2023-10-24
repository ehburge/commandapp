package co.ex.app.driven.cmd.bus;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.driven.cmd.bus.impl.CommandBusDrivenDomAppAdapterImpl;
import co.ex.app.driven.cmd.handler.CommandHandlerDrivenApp;
import co.ex.app.driven.cmd.handler.impl.CommandBusDrivenFrmTester;
import co.ex.app.driven.cmd.handler.impl.CommandHandlerDrivenAppImpl;
import co.ex.domain.cmd.impl.DomainThingCommand000;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CommandBusDrivenDomAppAdapterTest {

    static Map< Class< ? extends co.ex.app.cmd.AppCommand>, CommandHandlerDrivenApp > chDrivenA_map = new HashMap<>();
    CommandBusDrivenApp cbDrivenAppAdapter;
    static CommandHandlerDrivenApp chDrivenA;
    static CommandBusDrivenFrm busDrivenFrm = new CommandBusDrivenFrmTester();
    static Map<Class<? extends co.ex.app.cmd.AppCommand>, CommandBusDrivenFrm> cbDrivenFrm_map = new HashMap<>();
    CommandBusDrivenFrmTester frmTester;

    @BeforeAll
    static void setupAll() {
        chDrivenA = new CommandHandlerDrivenAppImpl( cbDrivenFrm_map ); //frm
    chDrivenA_map.put(AppCommandSave.class, chDrivenA);
    }

    @BeforeEach
    void setUp() {
        frmTester = new CommandBusDrivenFrmTester();
        cbDrivenFrm_map.put( AppCommandSave.class,  frmTester);
        cbDrivenAppAdapter = new CommandBusDrivenDomAppAdapterImpl( chDrivenA_map );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void perform() {
        DomainThingCommand000 domainThingCommand000 = DomainThingCommand000.builder().build();
        cbDrivenAppAdapter.perform( domainThingCommand000 );
        assertNotNull(frmTester.getAppThingCommandSave());
    }
}