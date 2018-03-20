
    package de.christopherstock.shooter.game.objects;

    import  de.christopherstock.lib.io.d3ds.LibD3dsFile;
    import  de.christopherstock.shooter.*;
    import  de.christopherstock.shooter.base.*;
    import  de.christopherstock.shooter.base.ShooterD3ds.*;
    import  de.christopherstock.shooter.game.objects.ItemToPickUp.*;
    import  de.christopherstock.shooter.io.sound.*;

    /**************************************************************************************
    *   All different item kinds.
    *
    *   @author     Christopher Stock
    *   @version    0.3.11
    **************************************************************************************/
    public enum ItemKind
    {
        EAmmoBullet9mm(     ItemType.ECircle, ShooterSettings.ItemSettings.AMMO_RADIUS,    Items.EAmmoBullet9mm,       ShooterStrings.HUDMessages.PICKED_UP_BULLETS_9MM   , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainAmmo20Bullet9mm,         }, true   ),
        EAmmoShotgunShell(  ItemType.ECircle, ShooterSettings.ItemSettings.AMMO_RADIUS,    Items.EAmmoShotgunShell,    ShooterStrings.HUDMessages.PICKED_UP_SHOTGUN_SHELLS, SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainAmmo40ShotgunShells,     }, true   ),
        EAmmoBullet44mm(    ItemType.ECircle, ShooterSettings.ItemSettings.AMMO_RADIUS,    Items.EAmmoBullet44mm,      ShooterStrings.HUDMessages.PICKED_UP_BULLETS_44MM  , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainAmmo20Bullet44mm,        }, true   ),
        EAmmoBullet51mm(    ItemType.ECircle, ShooterSettings.ItemSettings.AMMO_RADIUS,    Items.EAmmoBullet51mm,      ShooterStrings.HUDMessages.PICKED_UP_BULLETS_51MM  , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainAmmo20Bullet51mm,        }, true   ),
        EAmmoBullet792mm(   ItemType.ECircle, ShooterSettings.ItemSettings.AMMO_RADIUS,    Items.EAmmoBullet792mm,     ShooterStrings.HUDMessages.PICKED_UP_BULLETS_792MM , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainAmmo20Bullet792mm,       }, true   ),
        EAmmoBulletMagnum(  ItemType.ECircle, ShooterSettings.ItemSettings.AMMO_RADIUS,    Items.EAmmoBulletMagnum,    ShooterStrings.HUDMessages.PICKED_UP_MAGNUM_BULLETS, SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainAmmo18MagnumBullet,      }, true   ),

        EWearponPistol9mm(  ItemType.ECircle, ShooterSettings.ItemSettings.WEARPON_RADIUS, Items.EPistol1,             ShooterStrings.HUDMessages.PICKED_UP_PISTOL_9MM    , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainWearponWaltherPPK,       }, true   ),
        EWearponPistol2(    ItemType.ECircle, ShooterSettings.ItemSettings.WEARPON_RADIUS, Items.EPistol1,             ShooterStrings.HUDMessages.PICKED_UP_PISTOL_2      , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainWearponMagnum357,        }, true   ),
        EWearponKnife(      ItemType.ECircle, ShooterSettings.ItemSettings.WEARPON_RADIUS, Items.EKnife,               ShooterStrings.HUDMessages.PICKED_UP_KNIFE         , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainWearponKnife,                   }, true   ),
        EItemBottle1(       ItemType.ECircle, ShooterSettings.ItemSettings.ITEM_RADIUS,    Items.EPistol1,             ShooterStrings.HUDMessages.PICKED_UP_BOTTLE        , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainGadgetBottle1,           }, true   ),

        EItemCrackers(      ItemType.ECircle, ShooterSettings.ItemSettings.ITEM_RADIUS,    Items.ECrackers,            ShooterStrings.HUDMessages.PICKED_UP_CRACKERS      , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainGadgetCrackers,                }, true   ),

        EWearponShotgun(    ItemType.ECircle, ShooterSettings.ItemSettings.WEARPON_RADIUS, Items.EShotgun1,            ShooterStrings.HUDMessages.PICKED_UP_SHOTGUN       , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainWearponShotgun,          }, true   ),
        EItemHandset1(      ItemType.ECircle, ShooterSettings.ItemSettings.ITEM_RADIUS,    Items.EPistol1,             ShooterStrings.HUDMessages.PICKED_UP_HANDSET       , SoundFg.EPickUpItem1, new ItemEvent[] { ItemEvent.EGainGadgetHandset1,          }, true   ),

        EGameEventLevel1AcclaimPlayer(              ItemType.ECircle, ShooterSettings.ItemSettings.EVENT_RADIUS,           null,   null, null, new GameEvent[] { BotEvent.ELevel1AcclaimPlayer,             }, false   ),
        EGameEventLevel1ExplainAction(              ItemType.ECircle, ShooterSettings.ItemSettings.EVENT_RADIUS,           null,   null, null, new GameEvent[] { BotEvent.ELevel1ExplainAction,             }, false   ),
        EGameEventLevel1ChangeToNextSection(        ItemType.ECircle, ShooterSettings.ItemSettings.LEVEL_CHANGE_RADIUS,    null,   null, null, new GameEvent[] { ItemEvent.ELevel1ChangeToNextLevel,        }, false   ),
        EGameEventLevel1ChangeToPreviousLevel(      ItemType.ECircle, ShooterSettings.ItemSettings.LEVEL_CHANGE_RADIUS,    null,   null, null, new GameEvent[] { ItemEvent.ELevel1ChangeToPreviousLevel,    }, false   ),

        ;

        protected           ItemType        iType                   = null;

        protected           float           iRadius                 = 0.0f;
        protected           LibD3dsFile        iMeshFile               = null;
        protected           String          iHudMessage             = null;
        protected           SoundFg    iPickupSound            = null;
        protected           GameEvent[]     iItemEvents             = null;
        protected           boolean         iSingleEvent            = false;

        private ItemKind( ItemType aType, float aRadius, LibD3dsFile aMeshFile, String aHudMessage, SoundFg aPickupSound, GameEvent[] aItemEvents, boolean aSingleEvent )
        {
            iType                   = aType;
            iRadius                 = aRadius;
            iMeshFile               = aMeshFile;
            iHudMessage             = aHudMessage;
            iPickupSound            = aPickupSound;
            iItemEvents             = aItemEvents;
            iSingleEvent            = aSingleEvent;
        }
    }
