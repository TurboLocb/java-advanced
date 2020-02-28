package objects;

public class ObjectWithFinalize {

    /*
    * Пускай объект хранит некоторый Sting, а очистке поддается, когда этот String = null
    * */

    String s = null;

    public ObjectWithFinalize(String s) {
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void finalize(){
        if (s == null){
            try {
                System.out.println("Очищаем объект");
                super.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
