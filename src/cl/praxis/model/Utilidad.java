package cl.praxis.model;

public class Utilidad {
    public void loading(String mensage, int sleepTimer) {
        System.out.print("" + mensage + "");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.print(".");
                Thread.sleep(sleepTimer);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

}