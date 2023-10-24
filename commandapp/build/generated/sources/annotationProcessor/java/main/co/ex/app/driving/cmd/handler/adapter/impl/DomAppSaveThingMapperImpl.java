package co.ex.app.driving.cmd.handler.adapter.impl;

import co.ex.app.cmd.impl.AppCommandSave;
import co.ex.app.model.AppComments;
import co.ex.app.model.AppPart;
import co.ex.app.model.AppParts;
import co.ex.app.model.AppRole;
import co.ex.domain.cmd.impl.DomainCommandSave;
import co.ex.domain.model.DomRole;
import co.ex.domain.model.DomThingComments;
import co.ex.domain.model.DomThingPart;
import co.ex.domain.model.DomThingParts;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-24T12:18:05-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.0.2.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class DomAppSaveThingMapperImpl implements DomAppSaveThingMapper {

    @Override
    public DomainCommandSave appThingToDomainThing(AppCommandSave appThingCommandV1) {
        if ( appThingCommandV1 == null ) {
            return null;
        }

        DomainCommandSave.DomainCommandSaveBuilder domainCommandSave = DomainCommandSave.builder();

        domainCommandSave.uuid( appThingCommandV1.getUuid() );
        domainCommandSave.id( appThingCommandV1.getId() );
        domainCommandSave.role( appRoleToDomRole( appThingCommandV1.getRole() ) );
        domainCommandSave.eventKind( appThingCommandV1.getEventKind() );
        domainCommandSave.promoCodes( appThingCommandV1.getPromoCodes() );
        domainCommandSave.comments( appCommentsToDomThingComments( appThingCommandV1.getComments() ) );
        domainCommandSave.parts( appPartsToDomThingParts( appThingCommandV1.getParts() ) );

        return domainCommandSave.build();
    }

    @Override
    public AppCommandSave domainThingToAppThing(DomainCommandSave domainThingCommand000) {
        if ( domainThingCommand000 == null ) {
            return null;
        }

        AppCommandSave.AppCommandSaveBuilder appCommandSave = AppCommandSave.builder();

        appCommandSave.uuid( domainThingCommand000.getUuid() );
        appCommandSave.id( domainThingCommand000.getId() );
        appCommandSave.role( domRoleToAppRole( domainThingCommand000.getRole() ) );
        appCommandSave.eventKind( domainThingCommand000.getEventKind() );
        appCommandSave.promoCodes( domainThingCommand000.getPromoCodes() );
        appCommandSave.comments( domThingCommentsToAppComments( domainThingCommand000.getComments() ) );
        appCommandSave.parts( domThingPartsToAppParts( domainThingCommand000.getParts() ) );

        return appCommandSave.build();
    }

    protected DomRole appRoleToDomRole(AppRole appRole) {
        if ( appRole == null ) {
            return null;
        }

        Long actorId = null;
        String groupId = null;
        String loyaltyCode = null;

        actorId = appRole.getActorId();
        groupId = appRole.getGroupId();
        loyaltyCode = appRole.getLoyaltyCode();

        DomRole domRole = new DomRole( actorId, groupId, loyaltyCode );

        return domRole;
    }

    protected DomThingComments appCommentsToDomThingComments(AppComments appComments) {
        if ( appComments == null ) {
            return null;
        }

        DomThingComments.DomThingCommentsBuilder domThingComments = DomThingComments.builder();

        List<String> list = appComments.getComments();
        if ( list != null ) {
            domThingComments.comments( new ArrayList<String>( list ) );
        }

        return domThingComments.build();
    }

    protected DomThingPart appPartToDomThingPart(AppPart appPart) {
        if ( appPart == null ) {
            return null;
        }

        DomThingPart.DomThingPartBuilder domThingPart = DomThingPart.builder();

        domThingPart.partId( appPart.getPartId() );
        domThingPart.qty( appPart.getQty() );
        domThingPart.lineAction( appPart.getLineAction() );
        domThingPart.promoCodes( appPart.getPromoCodes() );

        return domThingPart.build();
    }

    protected List<DomThingPart> appPartListToDomThingPartList(List<AppPart> list) {
        if ( list == null ) {
            return null;
        }

        List<DomThingPart> list1 = new ArrayList<DomThingPart>( list.size() );
        for ( AppPart appPart : list ) {
            list1.add( appPartToDomThingPart( appPart ) );
        }

        return list1;
    }

    protected DomThingParts appPartsToDomThingParts(AppParts appParts) {
        if ( appParts == null ) {
            return null;
        }

        DomThingParts.DomThingPartsBuilder domThingParts = DomThingParts.builder();

        domThingParts.partsCompatibility( appParts.getPartsCompatibility() );
        domThingParts.parts( appPartListToDomThingPartList( appParts.getParts() ) );

        return domThingParts.build();
    }

    protected AppRole domRoleToAppRole(DomRole domRole) {
        if ( domRole == null ) {
            return null;
        }

        Long actorId = null;
        String groupId = null;
        String loyaltyCode = null;

        actorId = domRole.getActorId();
        groupId = domRole.getGroupId();
        loyaltyCode = domRole.getLoyaltyCode();

        AppRole appRole = new AppRole( actorId, groupId, loyaltyCode );

        return appRole;
    }

    protected AppComments domThingCommentsToAppComments(DomThingComments domThingComments) {
        if ( domThingComments == null ) {
            return null;
        }

        AppComments.AppCommentsBuilder appComments = AppComments.builder();

        List<String> list = domThingComments.getComments();
        if ( list != null ) {
            appComments.comments( new ArrayList<String>( list ) );
        }

        return appComments.build();
    }

    protected AppPart domThingPartToAppPart(DomThingPart domThingPart) {
        if ( domThingPart == null ) {
            return null;
        }

        AppPart.AppPartBuilder appPart = AppPart.builder();

        appPart.partId( domThingPart.getPartId() );
        appPart.qty( domThingPart.getQty() );
        appPart.lineAction( domThingPart.getLineAction() );
        appPart.promoCodes( domThingPart.getPromoCodes() );

        return appPart.build();
    }

    protected List<AppPart> domThingPartListToAppPartList(List<DomThingPart> list) {
        if ( list == null ) {
            return null;
        }

        List<AppPart> list1 = new ArrayList<AppPart>( list.size() );
        for ( DomThingPart domThingPart : list ) {
            list1.add( domThingPartToAppPart( domThingPart ) );
        }

        return list1;
    }

    protected AppParts domThingPartsToAppParts(DomThingParts domThingParts) {
        if ( domThingParts == null ) {
            return null;
        }

        AppParts.AppPartsBuilder appParts = AppParts.builder();

        appParts.partsCompatibility( domThingParts.getPartsCompatibility() );
        appParts.parts( domThingPartListToAppPartList( domThingParts.getParts() ) );

        return appParts.build();
    }
}
