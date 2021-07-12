package com.pattern.memo;

/**
 * 记录者类
 */
public class ConfigOriginator {

    private ConfigFile configFile;

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigMemento saveConfigMemento(){
        return new ConfigMemento(configFile);
    }

    public void getMemento(ConfigMemento memento){
        this.configFile = memento.getConfigFile();
    }

    @Override
    public String toString() {
        return "ConfigOriginator{" +
                "configFile=" + configFile.toString() +
                '}';
    }
}
