
    package de.christopherstock.shooter.game.artefact.firearm;

    import  java.util.*;

    /*******************************************************************************************************************
    *   Represents the ammunition for the player, a bot or a device.
    *******************************************************************************************************************/
    public class AmmoSet
    {
        public                  Hashtable<AmmoType,Integer>     ammo                    = null;

        public AmmoSet()
        {
            ammo    = new Hashtable<AmmoType,Integer>();

            for ( AmmoType at : AmmoType.values() )
            {
                ammo.put( at, new Integer( 0 ) );
            }
        }

        public int getAmmo( AmmoType at )
        {
            return ammo.get(at);
        }

        public void substractAmmo( AmmoType at, int substraction )
        {
            int oldAmmo = ammo.get(at);
            oldAmmo -= substraction;
            ammo.put( at, new Integer( oldAmmo ) );
        }

        public void addAmmo( AmmoType at, int addition )
        {
            int oldAmmo = ammo.get(at);
            oldAmmo += addition;
            if ( oldAmmo > at.iMaxAmmo ) oldAmmo = at.iMaxAmmo;
            ammo.put( at, new Integer( oldAmmo ) );
        }

        public static void loadImages()
        {
            for ( AmmoType ammo : AmmoType.values() )
            {
                ammo.loadImage();
            }
        }
    }
