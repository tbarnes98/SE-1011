/*
 * SE1021 – 091
 * Winter 2017
 * Lab 1 - ArrayLists
 * Name: Trevor Barnes
 * Created: 11/30/2017
 */

import edu.msoe.taylor.audio.WavFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Uses ArrayList to read and write .wav files.
 * @author barnestr
 * @version 1.0
 */
public class Lab1 {

    static Scanner in = new Scanner(System.in);
    static final int SAMPLE_RATE = 8000;
    static final int VALID_BITS = 8;

    public static void main(String[] args) {
        int option = introOption();
        if (option == 1){
            fileReverser();
        } else if (option == 2) {
            singleToneGenerator();
        } else if (option == 3) {
            doubleToneGenerator();
        } else {
            System.exit(0);
        }
    }

    static int option;

    /**
     * Displays options for user
     * @return option from user
     */
    private static int introOption() {
        do {
            System.out.println("Enter an option (0,1,2,3) to initiate.\n" +
                    "0. Exits Program\n" +
                    "1. Create a reversed version of a .wav file.\n" +
                    "2. Create a .wav file containing a one second tone at a given frequency.\n" +
                    "3. Create a .wav file containing a one second stereo sound with two tones given " +
                    "frequencies.\n");
            option = in.nextInt();
        } while (option < 0 || option > 3);
        return option;
    }

    /**
     * Reverses given file
     */
    public static void fileReverser() {
        System.out.println("Enter a .wav filename (without .wav extension) with audio samples to be placed in " +
                "reverse order.");
        String filename = in.next();
        WavFile original = new WavFile(filename + ".wav");
        ArrayList samples = original.getSamples();
        Collections.reverse(samples);
        WavFile file = new WavFile(filename + "Rev.wav", 1, original.getValidBits(),
                original.getValidBits(), original.getSampleRate());
        file.close();

    }

    /**
     * Generates a .wav file with a one second tone
     */
    public static void singleToneGenerator() {
        System.out.println("Enter a .wav filename (without .wav extension) to be created.");
        String filename = in.next();
        System.out.println("Enter the frequency of tone to be created.");
        int frequency = in.nextInt();
        ArrayList samples = new ArrayList();
        for (int i = 0; i<SAMPLE_RATE; i++) {
            samples.add(Math.sin(2*Math.PI*i*(frequency/SAMPLE_RATE)));
        }
        WavFile file = new WavFile(filename + ".wav", 1, SAMPLE_RATE, VALID_BITS, SAMPLE_RATE);
        file.setSamples(samples);
        file.close();
    }

    /**
     * Generates a .wav file with two one second tones in stereo
     */
    public static void doubleToneGenerator() {
        System.out.println("Enter a .wav filename (without .wav extension) of stereo file to be created.");
        String filename = in.next();
        System.out.println("Enter the first frequency of tone to be created.");
        int frequency1 = in.nextInt();
        System.out.println("Enter the second frequency of tone to be created.");
        int frequency2 = in.nextInt();
        ArrayList samples = new ArrayList();
        for (int i = 0; i<SAMPLE_RATE; i = i + 2) {
            samples.add(Math.sin(2*Math.PI*i*(frequency1/SAMPLE_RATE)));
        }
        for (int i = 1; i<SAMPLE_RATE; i = i + 2) {
            samples.add(Math.sin(2*Math.PI*i*(frequency2/SAMPLE_RATE)));
        }
        WavFile file = new WavFile(filename + ".wav", 2, SAMPLE_RATE, VALID_BITS, SAMPLE_RATE);
        file.setSamples(samples);
        file.close();
    }
}
