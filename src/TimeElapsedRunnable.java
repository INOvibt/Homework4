class TimeElapsedRunnable implements Runnable {
    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            while (true) {
                Thread.sleep(1000);
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Пройшло часу: " + (elapsedTime / 1000) + " секунд.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TimeElapsedRunnable timeElapsedRunnable = new TimeElapsedRunnable();

        Thread timeThread = new Thread(timeElapsedRunnable);
        timeThread.start();

        Thread messageThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        messageThread.start();
    }
}
