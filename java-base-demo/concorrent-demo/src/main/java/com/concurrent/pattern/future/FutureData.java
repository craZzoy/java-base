package com.concurrent.pattern.future;


/**
 * @Description: realData代理，可快速返回的虚拟数据
 * @Author : 郑玮泽
 * @Date : 9:53 2020/7/3
 */
public class FutureData implements Data{
    protected RealData realData = null;
    protected Boolean isReady = false;

    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        //通知可以取数据
        notifyAll();
    }


    @Override
    public synchronized String getResult(){
        while (!isReady) {
            try {
                //等待数据
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }

}
