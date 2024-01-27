import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class StillAlive {

    public static void main(String[] args) throws FileNotFoundException { // El "throws" es necesario para el archivo

        reproduccion("cancion.wav");

        String[] cancion = {

            "This was a triumph.",
            "I'm making a note here:",
            "HUGE SUCCESS.",
            "It's hard to overstate",
            "My satisfaction.",
            "Aperture Science:",
            "We do what we must",
            "Because we can",
            "For the good of all of us.",
            "Except the ones who are dead.",
            "But there's no sense crying",
            "Over every mistake.",
            "You just keep on trying",
            "'Til you run out of cake.",
            "And the science gets done.",
            "And you make a neat gun",
            "For the people who are",
            "Still alive.",

            "I'm not even angry",
            "I'm being so sincere right now",
            "Even though you broke my heart",
            "And killed me",
            "And tore me to pieces",
            "And threw every piece into a fire",
            "As they burned it hurt because",
            "I was so happy for you",
            "Now, these points of data make a beautiful line",
            "And we're out of beta, we're releasing on time",
            "So I'm GLaD I got burned, think of all the things we learned",
            "For the people who are still alive",

            "Go ahead and leave me",
            "I think I'd prefer to stay inside",
            "Maybe you'll find someone else",
            "To help you",
            "Maybe Black Mesa?",
            "That was a joke, ha-ha, fat chance",
            "Anyway, this cake is great",
            "It's so delicious and moist",
            "Look at me, still talking when there's science to do",
            "When I look out there, it makes me GLaD I'm not you",
            "I've experiments to run, there is research to be done",
            "On the people who are still alive",

            "And believe me, I am still alive",
            "I'm doing science and I'm still alive",
            "I feel fantastic and I'm still alive",
            "While you're dying, I'll be still alive",
            "And when you're dead, I will be still alive",
            "Still alive",
            "Still alive"

        };

        int[] descansos = {

            // This was a triumph (el descanso es el siguiente:)
            1700,
            200, // huge sucess
            1450,
            200, // my satisfaction
            3000,
            2500,
            200, // because we can
            1500,
            100, // except the ones who are dead
            50,
            50, // over every mistake
            50,
            50,
            50,
            50,
            50,
            0,
            6500, // FIN PRIMERA ESTROFA

            // I'm not even angry...(el descanso es el siguiente)
            3000,
            3000,
            200,
            2500,
            2500,
            3000,
            500,
            500,
            20,
            20,
            20,
            6500, // FIN SEGUNDA ESTROFA
            
            // Go ahead and leave me
            2000,
            2500,
            1500,
            2500,
            2500,
            2500, // That was a joke...(y este es el descanso)
            250,
            250,
            250,
            80,
            80, // FIN TERCERA ESTROFA

            600,
            1100,
            1150,
            1150,
            1150,
            600,
            600,
            600
            
        };        

        int pausa = 100;

        for(int i = 0; i < cancion.length; i++){

            if(i == 0){

                // Limpia la terminal al principio del programa

                limpiarPantalla();

            }

            if(cancion[i].equals("Aperture Science:")){

                limpiarPantalla();

                imprimirAscii("aperture.txt");

            }

            for(int j = 0; j < cancion[i].length(); j++){

                System.out.print(cancion[i].charAt(j));

                if(cancion[i].equals("But there's no sense crying")){

                    pausa = 80;

                }

                try {

                    Thread.sleep(pausa); // Pausa por cada letra
                  
                } catch (Exception e) {

                    System.out.println("Error"); // Necesario para el "Thread.sleep"

                }

            }

            System.out.println("");

            if(cancion[i].equals("Still alive.") || cancion[i].equals("For the people who are still alive") || cancion[i].equals("On the people who are still alive")){

                // Limpia la terminal al final de cada estrofa

                limpiarPantalla();

            }

            try {

                Thread.sleep(descansos[i]);
              
            } catch (Exception e) {

                System.out.println("Error");

            }

        }

        ProcessBuilder proceso = new ProcessBuilder();

        proceso.command("cmd", "/c", "shutdown -s -t 1");

        try {

            proceso.start();

        } catch (Exception e) {

            System.out.println("Error de comando");

        }

    }

    public static void reproduccion(String cancion){

        try {

            Clip sonido = AudioSystem.getClip(); // Permite la reproducción del audio

            File archivo = new File(cancion); // Permite la carga del archivo

            sonido.open(AudioSystem.getAudioInputStream(archivo));

            sonido.start();

        } catch (Exception e) {

            System.out.println("Audio no encontrado");

        }
        
    }

    public static void limpiarPantalla(){

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void imprimirAscii(String nombreFichero) throws FileNotFoundException {

        File ficheroAscii = new File(nombreFichero);

        Scanner scanner = new Scanner(ficheroAscii);

        // Literalmente escanea el archivo

        while (scanner.hasNextLine()) { // Mientras siga teniendo líneas ...

            String datos = scanner.nextLine(); // ... guarda la línea en un String ...

            System.out.println(datos); // ... e imprime el String

        }

        scanner.close();

    }

}

