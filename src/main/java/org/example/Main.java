package org.example;

// Importiamo ObjectMapper dalla libreria Jackson Databind.
// ObjectMapper è la classe principale che useremo per:
// - trasformare un oggetto Java in JSON;
// - trasformare un JSON in un oggetto Java.
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    // Metodo principale da cui parte l'esecuzione del programma.
    // "throws Exception" permette, per questa semplice prova, di propagare eventuali errori prodotti da Jackson senza dover ancora utilizzare try-catch.
    static void main() throws Exception {

        // Creiamo un oggetto ObjectMapper.
        // ObjectMapper è l'oggetto che Jackson utilizza per leggere e scrivere dati JSON.
        ObjectMapper mapper = new ObjectMapper();

        // 1. DA OGGETTO JAVA A JSON: SERIALIZZAZIONE
        // Creiamo normalmente un oggetto della classe Pilota.
        Pilota pilota = new Pilota(
                "Charles Leclerc",
                "Ferrari",
                16
        );

        // writeValueAsString() prende un oggetto Java e restituisce una String contenente il JSON corrispondente.
        // Quindi: Pilota Java -> JSON
        // Questa operazione prende il nome di SERIALIZZAZIONE.
        String json = mapper.writeValueAsString(pilota);

        // Stampiamo il JSON ottenuto.
        System.out.println("JAVA -> JSON");
        System.out.println(json);

        // 2. DA JSON A OGGETTO JAVA: DESERIALIZZAZIONE
        // Creiamo una String contenente un JSON.
        // Le triple virgolette """ permettono di creare una stringa su più righe (text block).
        String jsonRicevuto =
                """
                {
                    "nome": "Lewis Hamilton",
                    "squadra": "Ferrari",
                    "numero": 44
                }
                """;

        // readValue() esegue l'operazione inversa.
        // Il primo parametro è il JSON da leggere.
        // Pilota.class indica a Jackson il tipo di oggetto Java che vogliamo ottenere.
        // Quindi:
        // JSON -> oggetto Pilota
        // Questa operazione prende il nome di DESERIALIZZAZIONE.
        Pilota pilotaRicevuto =
                mapper.readValue(jsonRicevuto, Pilota.class);

        System.out.println();
        System.out.println("JSON -> JAVA");

        // Stampiamo i valori dell'oggetto che Jackson ha creato leggendo il JSON.
        System.out.println("Nome: " + pilotaRicevuto.nome);
        System.out.println("Squadra: " + pilotaRicevuto.squadra);
        System.out.println("Numero: " + pilotaRicevuto.numero);
    }
}