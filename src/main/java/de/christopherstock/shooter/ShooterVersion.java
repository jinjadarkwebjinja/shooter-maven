
    package de.christopherstock.shooter;

    /*******************************************************************************************************************
    *   The current version enumeration.
    *******************************************************************************************************************/
    enum ShooterVersion
    {
        V_0_3_12(   "0.3.12",   "23.03.2018 17:16:12 GMT+2" ),
        V_0_3_11(   "0.3.11",   "29.03.2012 00:51:41 GMT+2" ),
        V_0_3_10(   "0.3.10",   "12.03.2012 20:45:02 GMT+2" ),
        V_0_3_9(    "0.3.9",    "03.03.2012 01:04:27 GMT+2" ),
        V_0_3_8(    "0.3.8",    "19.02.2012 02:32:41 GMT+2" ),
        V_0_3_7(    "0.3.7",    "30.01.2012 23:27:35 GMT+2" ),
        V_0_3_6(    "0.3.6",    "11.11.2011 18:23:13 GMT+2" ),
        V_0_3_5(    "0.3.5",    "28.05.2011 00:45:12 GMT+2" ),
        V_0_3_4(    "0.3.4",    "04.05.2011 23:35:54 GMT+2" ),
        V_0_3_3(    "0.3.3",    "22.04.2011 23:40:17 GMT+2" ),
        V_0_3_2(    "0.3.2",    "13.04.2011 16:40:14 GMT+2" ),
        V_0_3_1(    "0.3.1",    "17.03.2011 22:42:08 GMT+2" ),
        V_0_3(      "0.3",      "11.02.2011 20:41:02 GMT+2" ),
        V_0_2_3(    "0.2.3",    "25.01.2011 18:06:33 GMT+2" ),
        V_0_2_2(    "0.2.2",    "09.11.2010 19:48:12 GMT+2" ),
        V_0_2_1(    "0.2.1",    "07.11.2010 17:13:32 GMT+2" ),
        V_0_2(      "0.2",      "17.10.2010 00:02:52 GMT+2" ),
        V_0_1_1(    "0.1.1",    "27.06.2010 00:30:06 GMT+2" ),
        V_0_1(      "0.1",      "27.06.2010 23:44:21 GMT+2" ),
        ;

        private     String  version = null;
        private     String  date    = null;

        private ShooterVersion( String aVersion, String aDate )
        {
            this.version = aVersion;
            this.date = aDate;
        }

        public static String getCurrentVersionDesc()
        {
            return "v. " + values()[ 0 ].version + ", " + values()[ 0 ].date;
        }
    }
