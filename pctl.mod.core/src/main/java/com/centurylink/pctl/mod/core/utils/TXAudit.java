package com.centurylink.pctl.mod.core.utils;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TXAudit class
 * @author Begin
 */
public class TXAudit {

    /**
     * simple date format
     */
    public static final SimpleDateFormat TX_ID_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * _TX_ID
     */
    public static final String TX_ID = "_TX_ID";

    /**
     * CLIENT_ID
     */
    public static final String CLIENT_ID = "_CLIENT_ID";

    /**
     * SCHEDULING_ORDER_ID
     */
    public static final String SCHEDULING_ORDER_ID = "_SCHEDULING_ORDER_ID";

    /**
     * _UPSTREAM_PRODUCTION_TIME
     */
    public static final String UPSTREAM_PRODUCTION_TIME = "_UPSTREAM_PRODUCTION_TIME";

    /**
     * _CONSUMPTION_START_TIME
     */
    public static final String CONSUMPTION_START_TIME = "_CONSUMPTION_START_TIME";

    /**
     * _EVENT
     */
    public static final String EVENT = "_EVENT";

    private static final ThreadLocal<Map<String, Object>> auditMap = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    /**
     * getAuditData()
     * @param fieldName
     * @return
     */
    public static Object getAuditData(String fieldName) {
        return auditMap.get().get(fieldName);
    }

    /**
     * init() method
     * @param map
     */
    public static void init(Map<String, Object> map) {
        auditMap.set(map);
    }

    /**
     * remove()
     */
    public static void remove() {
        auditMap.remove();
    }

    /**
     * getClientId()
     * @return
     */
    public static String getClientId() {
        return (String) getAuditData(TXAudit.CLIENT_ID);
    }

    /**
     * getTXId()
     * @return string
     */
    public static String getTXId() {
        return (String) getAuditData(TXAudit.TX_ID);
    }

    /**
     * getSchedulingOrderId()
     * @return string
     */
    public static String getSchedulingOrderId() {
        return (String) getAuditData(TXAudit.SCHEDULING_ORDER_ID);
    }

    /**
     * getUpstreamProductionTime()
     * @return long
     */
    public static long getUpstreamProductionTime() {
        return (Long) getAuditData(TXAudit.UPSTREAM_PRODUCTION_TIME);
    }

    /**
     * getMessageLatency()
     * @return long
     */
    public static long getMessageLatency(){
        return getConsumptionStartTime() - getUpstreamProductionTime();
    }

    /**
     * getConsumptionStartTime
     * @return long
     */
    public static long getConsumptionStartTime() {
        return (Long) getAuditData(TXAudit.CONSUMPTION_START_TIME);
    }

    /**
     * getSchedulingEventName()
     * @return string
     */
    public static String getSchedulingEventName() {
        return (String) getAuditData(TXAudit.EVENT);
    }
}
