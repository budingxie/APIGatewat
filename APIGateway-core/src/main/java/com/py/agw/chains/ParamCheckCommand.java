package com.py.agw.chains;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.py.agw.dao.model.ApiDO;
import com.py.agw.dao.model.ApiParamDO;
import com.py.agw.manager.ApiManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.py.agw.model.ErrorCode.PARAM_MISSING;

/**
 * description：检查业务参数，并组织参数
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/18
 */
public class ParamCheckCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParamCheckCommand.class);

    @Resource
    private ApiManager apiManager;

    @Override
    public boolean execute(CommonContext context) {
        String apiCode = context.getApiCode();
        ApiDO apiDO = apiManager.queryByCode(apiCode);
        List<ApiParamDO> apiParams = apiManager.queryApiParamsByApiId(apiDO.getId());

        Map<String, String> reqParams = context.getReqParams();

        for (ApiParamDO apiParam : apiParams) {
            if (!reqParams.containsKey(apiParam.getName())) {
                LOGGER.warn("param missing, param：{}", apiDO.getName());
                context.setRetCode(PARAM_MISSING.getCode());
                context.setRetMsg(PARAM_MISSING.getMsg());
                context.setSuccess(false);
                return true;
            }
        }

        int size = apiParams.size();
        String[] paramTypes = new String[size];
        Object[] params = new Object[size];

        for (int i = 0; i < apiParams.size(); i++) {
            String paramType = apiParams.get(i).getType();
            paramTypes[i] = paramType;

            params[i] = convertToActualType(paramType, reqParams.get(apiParams.get(i).getName()));
        }
        context.setParamTypes(paramTypes);
        context.setParams(params);
        context.setApiDO(apiDO);
        return false;
    }

    private Object convertToActualType(String paramType, String paramValue) {
        if (paramType == null) {
            return null;
        }
        if (String.class.getTypeName().equals(paramType)) {
            return paramValue;
        }

        if (Byte.class.getTypeName().equals(paramType)) {
            return Byte.valueOf(paramValue);
        }
        if (byte.class.getTypeName().equals(paramType)) {
            return Byte.parseByte(paramValue);
        }

        if (Short.class.getTypeName().equals(paramType)) {
            return Short.valueOf(paramValue);
        }
        if (short.class.getTypeName().equals(paramType)) {
            return Short.parseShort(paramValue);
        }

        if (Integer.class.getTypeName().equals(paramType)) {
            return Integer.valueOf(paramValue);
        }
        if (int.class.getTypeName().equals(paramType)) {
            return Integer.parseInt(paramValue);
        }

        if (Long.class.getTypeName().equals(paramType)) {
            return Long.valueOf(paramValue);
        }
        if (long.class.getTypeName().equals(paramType)) {
            return Long.parseLong(paramValue);
        }

        if (Float.class.getTypeName().equals(paramType)) {
            return Float.valueOf(paramValue);
        }
        if (float.class.getTypeName().equals(paramType)) {
            return Float.parseFloat(paramValue);
        }

        if (Double.class.getTypeName().equals(paramType)) {
            return Double.valueOf(paramValue);
        }
        if (double.class.getTypeName().equals(paramType)) {
            return Double.valueOf(paramValue);
        }

        if (Boolean.class.getTypeName().equals(paramType)) {
            return Boolean.valueOf(paramValue);
        }
        if (boolean.class.getTypeName().equals(paramType)) {
            return Boolean.parseBoolean(paramValue);
        }

        // 时间
        if (Date.class.getTypeName().equals(paramType)) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(paramValue);
            } catch (Exception e) {
                try {
                    long value = Long.parseLong(paramValue);
                    return new Date(value);
                } catch (Exception e1) {
                    e.printStackTrace();
                }
            }
        }

        Object jsonObject = JSON.parse(paramValue);
        if (jsonObject instanceof JSONObject) {
            return toMap((JSONObject) jsonObject);
        } else if (jsonObject instanceof JSONArray) {
            return toArray((JSONArray) jsonObject);
        } else {
            return jsonObject;
        }
    }

    private Object toMap(JSONObject jsonObject) {
        Map<String, Object> result = new HashMap<>(16);
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            if (entry.getValue() instanceof JSONObject) {
                result.put(entry.getKey(), toMap((JSONObject) entry.getValue()));
            } else if (entry.getValue() instanceof JSONArray) {
                result.put(entry.getKey(), toArray((JSONArray) entry.getValue()));
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    private Object toArray(JSONArray jsonArray) {
        List<Object> result = new ArrayList<>();
        for (Object object : jsonArray) {
            if (object instanceof JSONObject) {
                result.add(toMap((JSONObject) object));
            } else if (object instanceof JSONArray) {
                result.add(toArray((JSONArray) object));
            } else {
                result.add(object);
            }
        }
        return result;
    }

}
