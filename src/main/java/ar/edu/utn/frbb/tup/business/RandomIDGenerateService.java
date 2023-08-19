package ar.edu.utn.frbb.tup.business;

import java.util.Random;

public class RandomIDGenerateService {

    private static RandomIDGenerateService instance;
    private static Random random ;
    private RandomIDGenerateService() {
        random = new Random();

    }

    public static synchronized RandomIDGenerateService getInstance() {
        if (instance == null) {
            instance = new RandomIDGenerateService();
        }
        return instance;
    }


    public static String generateId(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(10); // Genera un número aleatorio entre 0 y 9
            sb.append(randomNumber);
        }

        return String.valueOf(sb);
    }
}

