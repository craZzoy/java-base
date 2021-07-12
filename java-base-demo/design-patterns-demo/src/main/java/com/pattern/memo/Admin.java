package com.pattern.memo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员类
 */
public class Admin {

    private int cursorIdx = 0;

    private List<ConfigMemento> mementoList = new ArrayList<>();

    private Map<String, ConfigMemento> mementoMap = new HashMap<>(16);

    /**
     * 存放
     * @param memento
     */
    public void append(ConfigMemento memento){
        mementoList.add(memento);
        mementoMap.put(memento.getConfigFile().getVersionNum(), memento);
        cursorIdx ++ ;
    }

    /**
     * 回滚
     * @return
     */
    public ConfigMemento undo(){
        if (--cursorIdx <= 0){
            return mementoList.get(0);
        }
        return mementoList.get(cursorIdx);
    }

    /**
     * 返回
     * @return
     */
    public ConfigMemento redo(){
        if(++cursorIdx > mementoList.size()){
            return mementoList.get(mementoList.size() - 1);
        }
        return mementoList.get(cursorIdx);
    }

    /**
     * 定向获取
     * @param versionNum
     * @return
     */
    public ConfigMemento get(String versionNum){
        return mementoMap.get(versionNum);
    }


}
