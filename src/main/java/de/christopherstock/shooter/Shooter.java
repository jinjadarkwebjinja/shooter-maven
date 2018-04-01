
    package de.christopherstock.shooter;

    import  de.christopherstock.shooter.base.*;

    /*******************************************************************************************************************
    *   The main class.
    *
    *   TODO    Fix inoperative sound loop.
    *   TODO    Prune all singleton patterns.
    *   TODO    Turn BulletHole.bulletHoles non static!
    *   TODO    Prefix 'Shooter' only for main and base classes!
    *   TODO    Stop sounds when the game is quit!
    *
    *   TODO    Add skybox!
    *
    *   TODO    Complete v.4.0.2
    *
    *   TODO    Optimize fields in ArtefactType!
    *   TODO    make new subclass:  Wearpon that derives from ArtefactKind!!
    *   TODO    only for FireArms! Move ArtefactType.fXImages to Firearms (Wearpons)!
    *   TODO    Move all CloseCombat constants to settings!
    *   TODO    let random assign different topping positions for ShooterWallCollection.createDeskOffice
    *   TODO    Refactor the Artefact-System.
    *   TODO    slow panning for zoomed glView?
    *   TODO    WearponKind.java - remove parentKind ?
    *   TODO    enum GiveTakeAnim to Gadget?
    *   TODO    Own class for FireFxOffset ?? (use Point2D or Distance-class?)
    *   TODO    suitable door textures
    *   TODO    different wall heights?
    *   TODO    new textures from http://www.cgtextures.com/
    *   TODO    wall type "two glassed wall-windows with one socket in the middle"
    *   TODO    door sockets have wrong tiling
    *   TODO    sprites for bot fire ( muzzle flash )!
    *   TODO    let bot drop multiple items on being killed
    *   TODO    improve collisions? ( make player collisions via ray casting? )
    *   TODO    create double-handed bots or artefacts? - 2 x currentArtefact?
    *******************************************************************************************************************/
    public class Shooter
    {
        /** The static preloader instance of the shooter game. */
        public      static                  ShooterGame                         game                = null;

        /***************************************************************************************************************
        *   The Project's main-method launched on the application's startup.
        *   The job is to instanciate and to start the {@link ShooterGame}.
        *
        *   @param  args    Arguments from the command-line.
        ***************************************************************************************************************/
        public static void main( String[] args )
        {
            // disable debug mode if run mode is production
            ShooterDebug.checkDebugMode( args );

            // acclaim
            ShooterDebug.major.out( "Welcome to the Shooter project [" + ShooterVersion.getCurrentVersionDesc() + "]" );

            //start main game thread
            game = new ShooterGame();
            game.start();
        }
    }
