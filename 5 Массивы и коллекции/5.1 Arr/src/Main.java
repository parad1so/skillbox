public class Main {
    public static final int PATIENT = 30;
    public static final float MIN_TEMP = 36.2f;
    public static final float MAX_TEMP = 36.9f;
    public static final float MIN_HEAL = 32f;
    public static final float MAX_HEAL = 40f;


    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";

        String[] textArr = text.split(",?\\s+");
        String[] newArr = new String[textArr.length];

        int n = 0;
        //добавляю каждый элемент с конца в новый массив
        for (int i = textArr.length - 1; i >= 0; i--) {
            newArr[n] = textArr[i];
            n++;
        }

        //читаю новый массив
        for (int j = 0; j <= newArr.length - 1; j++) {
            System.out.println(newArr[j]);
        }

        //5.1_2
        System.out.println("");

        System.out.print("Температура пациентов: ");
        float[] temperatureArr = new float[PATIENT];
        for (int a = 0; a <= temperatureArr.length - 1; a++) {
            temperatureArr[a] = (float) (MIN_HEAL + Math.random() * (MAX_HEAL - MIN_HEAL));
            System.out.print(temperatureArr[a] + ", ");
        }

        System.out.println("");

        float sum = 0;
        int healthy = 0;
        for (int b = 0; b <= temperatureArr.length - 1; b++) {
            sum = sum + temperatureArr[b];
            if (temperatureArr[b] > MIN_TEMP && temperatureArr[b] > MAX_TEMP) {
                healthy++;
            }
        }
        System.out.println("Средняя по больнице = " + sum/PATIENT);
        System.out.println("Кол-во здоровых пациентов = " + healthy);


        //star
        System.out.println("");

        String[][] pluse = new String[7][7];
        int count = 0;

        for (int i = 0; i <= pluse.length - 1; i++) {
            for (int g = 0; g <= pluse[i].length - 1; g++) {
                pluse[i][g] = " ";
            }
            pluse[i][count] = "X";
            pluse[i][pluse[i].length - count - 1] = "X";
            count++;
        }

        for (int i = 0; i <= pluse.length - 1; i++) {
            System.out.println("");
            for (int j = 0; j <= pluse[i].length - 1; j++) {
                System.out.print(pluse[i][j]);
            }
        }



    }
}
