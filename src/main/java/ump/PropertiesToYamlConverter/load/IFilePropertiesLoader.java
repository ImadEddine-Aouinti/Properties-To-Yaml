package ump.PropertiesToYamlConverter.load;

import ump.PropertiesToYamlConverter.exception.PropertiesLoadingException;

import java.util.Map;

public interface IFilePropertiesLoader {
    Map<String, String> load(String... filePaths) throws PropertiesLoadingException;
}
