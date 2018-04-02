
    package de.christopherstock.shooter.g3d;

    import  de.christopherstock.lib.LibTransformationMode;
    import  de.christopherstock.lib.g3d.LibVertex;
    import  de.christopherstock.lib.game.LibGameObject;
    import  de.christopherstock.lib.game.LibHitPoint;
    import  de.christopherstock.lib.io.d3ds.LibD3dsFile;
    import  de.christopherstock.lib.math.LibMatrix;
    import  de.christopherstock.shooter.ShooterDebug;
    import  de.christopherstock.shooter.ShooterSetting;
    import  de.christopherstock.shooter.g3d.wall.Wall;
    import  de.christopherstock.shooter.game.objects.Bot;
    import  java.util.Vector;

    /*******************************************************************************************************************
    *   Manages all bullet holes.
    *******************************************************************************************************************/
    public class BulletHoleManager
    {
        public      static          Vector<BulletHole>      bulletHoles                     = new Vector<BulletHole>();

        public static void drawAll()
        {
            //draw all points
            for ( BulletHole bulletHole : BulletHoleManager.bulletHoles )
            {
                if ( bulletHole.projectileTemplate != null )
                {
                    //projectile
                    if ( bulletHole.projectile != null )
                    {
                        bulletHole.projectile.draw();
                    }
                }
                else
                {
                    //bullet hole
                    bulletHole.face.draw();
                }
            }
        }

        public static void translateAll(LibGameObject bhc, float transX, float transY, float transZ )
        {
            //browse all bullet-holes
            for ( BulletHole bulletHole : BulletHoleManager.bulletHoles )
            {
                //check if this bullet hole belongs to the specified bot
                if ( bulletHole.hitPoint.carrier == bhc )
                {
                    //translate it!
                    bulletHole.position.x           += transX;
                    bulletHole.position.y           += transY;
                    bulletHole.position.z           += transZ;
                    bulletHole.originalPosition.x   += transX;
                    bulletHole.originalPosition.y   += transY;
                    bulletHole.originalPosition.z   += transZ;
                    bulletHole.updateFace( false );

                    //translate projectile
                    if ( bulletHole.projectile != null )
                    {
                        bulletHole.projectile.translate( transX, transY, transZ, LibTransformationMode.ETransformedToTransformed );
                    }
                }
            }
        }

        //only z-rotation are allowed for bullet-holes!
        public static void rotateForBot(Bot bhc, float rotZ )
        {
            //browse all bullet-holes
            for ( BulletHole bulletHole : BulletHoleManager.bulletHoles )
            {
                //check if this bullet hole belongs to the specified bot
                if ( bulletHole.hitPoint.carrier == bhc )
                {
                    //reverse last translation
                    LibMatrix transformationMatrix = new LibMatrix( 0.0f, 0.0f, rotZ - bulletHole.carriersLastFaceAngle);
                    LibVertex translatedHitPoint = transformationMatrix.transformVertexF( bulletHole.position, bhc.getAnchor() );

                    //assign new face angle
                    bulletHole.hitPoint.horzFaceAngle += ( rotZ - bulletHole.carriersLastFaceAngle);

                    //asssign new hit-point and update face
                    bulletHole.position = translatedHitPoint;
                    bulletHole.updateFace( false );

                    //assign new rotations
                    bulletHole.carriersLastFaceAngle = rotZ;
                }
            }
        }

        public static void rotateForWall(Wall bhc, float rotX, float rotY, float rotZ )
        {
            //browse all bullet-holes
            for ( BulletHole bulletHole : BulletHoleManager.bulletHoles )
            {
                //check if this bullet hole belongs to the specified mersh
                if ( bulletHole.hitPoint.carrier == bhc )
                {
                    //rotate bulletHole for mesh
                    bulletHole.rotateAroundVertex( bhc.getAnchor(), rotX, rotY, rotZ );

                    //rotate projectile
                    if ( bulletHole.projectile != null )
                    {
                        bulletHole.projectile.translateAndRotateXYZ( 0.0f, 0.0f, 0.0f, rotX, rotY, rotZ, bhc.getAnchor(), LibTransformationMode.ETransformedToTransformed );
                    }
                }
            }
        }

        public static void removeForWall(Wall bhc )
        {
            //browse all bullet-holes reversed
            for (int i = BulletHoleManager.bulletHoles.size() - 1; i >= 0; --i )
            {
                //check if this bullet hole belongs to the specified mersh
                if ( BulletHoleManager.bulletHoles.elementAt( i ).hitPoint.carrier == bhc )
                {
                    //remove this bullet hole
                    BulletHoleManager.bulletHoles.removeElementAt( i );
                }
            }
        }

        public static void darkenAll(Wall bhc, float opacity )
        {
            //browse all bullet-holes reversed
            for (int i = BulletHoleManager.bulletHoles.size() - 1; i >= 0; --i )
            {
                //check if this bullet hole belongs to the specified mersh
                if ( BulletHoleManager.bulletHoles.elementAt( i ).hitPoint.carrier == bhc )
                {
                    //darken bulletHole
                    BulletHoleManager.bulletHoles.elementAt( i ).darken( opacity );
                }
            }
        }

        public static void clearBulletHoles()
        {
            BulletHoleManager.bulletHoles.removeAllElements();
        }

        public static void addBulletHole(LibHitPoint hitPoint, LibD3dsFile aProjectile )
        {
            //add to bullet-hole-stack, prune stack if overflowing
            BulletHoleManager.bulletHoles.add( new BulletHole( hitPoint, aProjectile ) );
            if ( BulletHoleManager.bulletHoles.size() > ShooterSetting.Performance.MAX_NUMBER_BULLET_HOLES ) BulletHoleManager.bulletHoles.removeElementAt( 0 );

            ShooterDebug.bulletHole.out( " new bullet hole count: [" + BulletHoleManager.bulletHoles.size() + "]" );
        }
    }
