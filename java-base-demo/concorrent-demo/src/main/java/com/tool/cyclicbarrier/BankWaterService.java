package com.tool.cyclicbarrier;


import java.util.Map;
import java.util.concurrent.*;

/**
 * {@link java.util.concurrent.CyclicBarrier} 示例
 * 计算银行流水
 */
public class BankWaterService implements Runnable {

    /**
     * 创建4个屏障
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                //省略计算每个sheet结果过程
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> entry : sheetBankWaterCount.entrySet()) {
            result += entry.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

}
