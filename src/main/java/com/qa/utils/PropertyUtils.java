package com.qa.utils;
import com.qa.constants.FrameWorkConstants;
import com.qa.enums.ConfigProperties;
import com.qa.exceptions.InvalidPathForExcelException;
import com.qa.exceptions.InvalidPathForPropertyFileException;
import com.qa.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private static final Properties property = new Properties();
    private static final HashMap<Object,Object> CONFIGMAP = new HashMap<>();

    static {
        try(FileInputStream file = new FileInputStream(FrameWorkConstants.getConfigfilepath());) {
            property.load(file);
            for (Map.Entry<Object,Object> entry : property.entrySet())
            {
              CONFIGMAP.put(entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private PropertyUtils() {

    }

    public static String get(ConfigProperties key){
        if(Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key.name().toLowerCase())) {
            throw new PropertyFileUsageException("Property key - " + key + " is not found");
        }
        return property.getProperty(key.name().toLowerCase());
    }


}
