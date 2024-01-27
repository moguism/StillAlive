import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class StillAliveWindows {

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
            1500,
            200, // my satisfaction
            3200,
            3000,
            300, // because we can
            1500,
            400, // except the ones who are dead
            80,
            80, // over every mistake
            80,
            80,
            80,
            80,
            80,
            0,
            6500, // FIN PRIMERA ESTROFA

            // I'm not even angry...(el descanso es el siguiente)
            3000,
            3100,
            250,
            3000,
            3000,
            3000,
            500,
            500,
            20,
            20,
            20,
            7000, // FIN SEGUNDA ESTROFA
            
            // Go ahead and leave me
            2200,
            2200,
            2200,
            2500,
            2500,
            2500, // That was a joke...(y este es el descanso)
            250,
            250,
            250,
            80,
            300, // FIN TERCERA ESTROFA

            1250,
            1500,
            1500,
            1200,
            1200,
            500,
            700,
            1000
            
        };        

        int pausa = 95;

        for(int i = 0; i < cancion.length; i++){

            if(i == 0){

                // Limpia la terminal al principio del programa

                limpiarPantalla();

            }

            if(cancion[i].equals("Aperture Science:")){

                imprimirAscii("aperture.txt");

            } else if(cancion[i].equals("And the science gets done.")){

                imprimirAscii("atomo.txt");

            } else if(cancion[i].equals("Even though you broke my heart")){

                imprimirAscii("corazon.txt");

            } else if(cancion[i].equals("And tore me to pieces")){

                imprimirAscii("explosion.txt");

            } else if(cancion[i].equals("And threw every piece into a fire")){

                imprimirAscii("fuego.txt");

            } else if(cancion[i].equals("I was so happy for you")){

                imprimirAscii("tick.txt");

            } else if(cancion[i].equals("So I'm GLaD I got burned, think of all the things we learned.")){

                imprimirAscii("atomo.txt");

            } else if(cancion[i].equals("For the people who are still alive")){

                imprimirAscii("atomo.txt");

            }  else if(cancion[i].equals("Maybe Black Mesa?")){

                imprimirAscii("blackMesa.txt");

            } else if(cancion[i].equals("Anyway, this cake is great")){

                imprimirAscii("tarta.txt");

            } else if(cancion[i].equals("Look at me, still talking when there's science to do")){

                imprimirAscii("GLaDOS.txt");

            } else if(cancion[i].equals("When I look out there, it makes me GLaD I'm not you")){

                imprimirAscii("radiacion.txt");

            } else if(cancion[i].equals("I've experiments to run, there is research to be done")){

                imprimirAscii("atomo.txt");

            } else if(cancion[i].equals("I've experiments to run, there is research to be done")){

                imprimirAscii("explosion.txt");

            }

            for(int j = 0; j < cancion[i].length(); j++){

                System.out.print(cancion[i].charAt(j));

                if(cancion[i].equals("But there's no sense crying")){ // Acelera con el ritmo

                    pausa = 75;

                }

                try {

                    Thread.sleep(pausa); // Pausa por cada letra
                  
                } catch (Exception e) {

                    System.out.println("Error de velocidad entre letras"); // Necesario para el "Thread.sleep"

                }

            }

            System.out.println("");

            if(cancion[i].equals("Still alive.") || cancion[i].equals("For the people who are still alive") || cancion[i].equals("On the people who are still alive") || (cancion[i].equals("Still alive") && i == cancion.length - 2)){

                // Limpia la terminal al final de cada estrofa y muestra el logo de Aperture

                limpiarPantalla();

                if(i != cancion.length - 2){

                    imprimirAscii("aperture.txt");

                }


            } else if(cancion[i].equals("Still alive") && i == cancion.length - 1){

                imprimirAscii("aperture.txt");

            }

            try {

                Thread.sleep(descansos[i]);
              
            } catch (Exception e) {

                System.out.println("Error de pausa");

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

            System.out.println("Error: audio no encontrado");

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

