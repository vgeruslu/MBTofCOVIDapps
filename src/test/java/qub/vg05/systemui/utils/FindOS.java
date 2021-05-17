package qub.vg05.systemui.utils;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindOS {

    private static final Logger logger = LoggerFactory.getLogger(FindOS.class);

    public static String getOperationSystemName(){

        logger.info(System.getProperty("os.name"));
        if(SystemUtils.IS_OS_WINDOWS){
            return "WINDOWS";
        }else if(SystemUtils.IS_OS_MAC){
            return "MAC";
        }else if (SystemUtils.IS_OS_LINUX){
            return "LINUX";
        }else
            return "null";
    }
}
