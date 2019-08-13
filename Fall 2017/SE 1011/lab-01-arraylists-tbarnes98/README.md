# Lab 1: ArrayLists
## Overview
In this assignment you will make use of the WavFile class to read and write .wav audio files.

## Details
### ArrayList Requirement
This assignment is meant as a review of material covered in SE1011. You are required to use at least one ArrayList object.

### Using a Supplied Class
For this assignment, you will need to make use of the WavFile.java file ([javadoc](http://msoe.us/taylor/se1021/WavFile.html)). You may change package for WavFile class or place it in the appropriate folder within your project.

### Basic Program Flow
You’ll need to create one class called Lab1 which should be in a package named the same as your MSOE username (e.g., taylor). Note: Do not place all of the functionality for your program in main. Prior to coding, decide on how you plan to encapsulate functionality into multiple methods. This class must contain your program that makes use of the WavFile class to do the following:

Ask the user to enter 0, 1, 2, or 3. If the user enters anything other than one of those four options, the program should reprompt the user to enter one of the four options (it should continue to do this forever).
If the user enters 0, the program should exit.
If the user enters 1, the program should prompt the user to enter a filename (without the .wav extension) and then read the file in and write a separate .wav file with all of the audio samples placed in reverse order. For example, if the user enters cymbal, the output file should be called cymbalRev.wav. Once this has been completed, the program should return to the prompt which asks the user to enter 0, 1, 2, or 3.

If the user enters 2, then the program should ask the user for a filename (without an extension) and a frequency. The program should then create a .wav file containing one second worth of audio that represents a tone at the specified frequency. Once this has been completed, the program should return to the prompt which asks the user to enter 0, 1, 2, or 3.
Optional: If the user enters 3, then the program should ask the user for a filename (without an extension) and two frequencies. The program should then create a .wav file containing one second worth of audio in stereo. One frequency should be on one channel and the other frequency on the other channel. Once this has been completed, the program should return to the prompt which asks the user to enter 0, 1, 2, or 3.

Note: Your program must not crash on menu selection regardless of what the user enters for a menu option.

### Hints
- To generate one second of audio, make sure that the numFrames and the sampleRate contain the same value.
- You may use cymbal.wav and ominous.wav as sample .wav files. You may wish to use the WavFile.toString() method to determine appropriate values to pass the multi-argument WavFile constructor.
- Place the .wav file in the project folder (in the same folder/directory that contains the src folder (not in the src folder)).
- To generate a tone at a given frequency you should generate a sine wave with values between -1.0 and 1.0 at the specified frequency. The formula to use for this is sin(2π×i×freqsampleRate)sin⁡(2π×i×freqsampleRate). Where ii is the counter in the loop generating samples. Since the sampleRatesampleRate is the number of samples per second, if you desire one second worth of sound, you’ll need to generate sampleRatesampleRate samples.
- To generate stereo audio you will need to set the number of channels to two and interleave the audio samples for each channel in the ArrayList of samples. Said another way, the samples for the first channel should be placed only at even indices and the samples for the second channel should be placed only at odd indices.
- Once you have placed the samples into the WavFile object, be sure to call .close() to be sure the file has been written completely.
